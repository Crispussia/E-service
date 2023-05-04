package fr.eilco.info;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eilco.ejb.AccesCatalogueBeanLocal;
import fr.eilco.ejb.AccesCatalogueBeanRemote;
import fr.eilco.ejb.ClientCommandeBeanRemote;
import fr.eilco.ejb.ClientsBeanRemote;
import fr.eilco.ejb.GestionCommandeBeanRemote;
import fr.eilco.entities.Commandes;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduit;
import fr.eilco.entities.FacadeProduitCommande;
import fr.eilco.model.Cart;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/Catalogue")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private AccesCatalogueBeanRemote metier;
	@EJB
	private ClientsBeanRemote metierClient;
	@EJB
	private ClientCommandeBeanRemote metierClientCommande;
	@EJB
	private GestionCommandeBeanRemote metierGc;
	
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On crée une session
		HttpSession session = request.getSession();
		Random random = new Random();
		int min = 10000000;
		int max = 99999999;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDateTime = dateFormat.format(date);
		
		//On récupère un objet de type FacadeCommandeClient qu'on initialise
		FacadeCommandeClient comClient=new FacadeCommandeClient();
		comClient.setMontant(0.0);
		comClient.setNoConfirmation(0);

		try {
		    Date dateCreation = dateFormat.parse(currentDateTime);
		    comClient.setDateCreation(dateCreation);
		    comClient.setDernierMaj(dateCreation);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		comClient.setDernierMaj(new Date());
		
		session.setAttribute("comClient", comClient);
		
		//On initialise la valeur de l'attribut du prix total à 0
		double total=0;
		int shippingOpt=0;
		session.setAttribute("totalMontantTotal", 0.0 );
		session.setAttribute("NumConfirmation", 0 );
		
		//On crée un panier vide
		Cart currentCart=(Cart) session.getAttribute("cart");	
		
		if (currentCart==null) {
			
			Cart cart=new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("previouscart", cart);
			session.setAttribute("total", total);
			session.setAttribute("shipping", shippingOpt);
		}
		
		
		//On recupère l'url de la servlet qu'on passe dans chaque page
		String url=request.getServletPath();
		
		//On initialise le titre de la page à vide au départ
		String titre="";
		
		//Si la servlet qu'on appel est /accueil.do on affiche notre page template.jsp
		
		if(url.equals("/accueil.do")) {
	
			titre="contenuIndex.jsp";
			request.setAttribute("titre", titre);
			//On recupère l'action effectuée
			String action= request.getParameter("action");
			
			if(action!=null){
			
				//Si on choisit d'annuler la commande elle n'est pas enregistrer
				if (action.equals("deconnexion")) {
					session.invalidate();
					response.sendRedirect("/ShoppingCatalogue/accueil.do");
				}
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		//Si la servlet qu'on appel est /categories.do on affiche notre page /categories.jsp
		
		else if(url.equals("/categories.do")) {
			
			titre="contenuCategories.jsp";
			request.setAttribute("titre", titre);
			session.setAttribute("categories", metier.getListCategories());
			String id_cat = request.getParameter("cat");
			request.setAttribute("cat", id_cat);
			String cat_nom="";
			request.setAttribute("cat_nom", cat_nom);
			
			if (id_cat!= null && !id_cat.equals("")) {
				session.setAttribute("produits", metier.getListProduits(Integer.parseInt(id_cat)));
				request.setAttribute("cat_nom", metier.getCategorie(Integer.parseInt(id_cat)).getNom());
				
			}
			String id_prod = request.getParameter("produit");
			
			if (id_prod!= null && !id_prod.equals("")) {
				FacadeProduit produitID=metier.getProduit(Integer.parseInt(id_prod));
				
				FacadeProduitCommande produitCommande=new FacadeProduitCommande(produitID,comClient,1) ;
				//Cart currentCart=(Cart) session.getAttribute("cart");
				currentCart.addToCart(produitCommande);
				session.setAttribute("cart", currentCart);
				
			}

			request.getRequestDispatcher("/categories.jsp").forward(request, response);
		
		
		}
		
		//Si la servlet qu'on appel est /panier.do on affiche notre page /panier.jsp
		
		else if(url.equals("/panier.do")) {
			titre="contenuPanier.jsp";
			request.setAttribute("titre", titre);
			if(currentCart==null) {
				currentCart=new Cart();	
			}
			request.setAttribute("cart",currentCart.getCart());
			
			//On met à jour notre panier et le prix total
			total = currentCart.getTotalCartPrice(currentCart.getCart());
			session.setAttribute("total", total);
			
			//On recupère l'action effectuée
			String action= request.getParameter("action");
			if(action!=null){
				
				//Si on choisit d'augmenter la  quantité
				if (action.equals("inc")) {
					
					String nom_prod = request.getParameter("nom_prod");
					
					//On recupère le nom du produit et on met à jour
					if (nom_prod!= null && !nom_prod.equals("")) {
						
						currentCart.addQuantiteToProduit(nom_prod);
						session.setAttribute("cart", currentCart);
						request.setAttribute("cart",currentCart.getCart());
						total = currentCart.getTotalCartPrice(currentCart.getCart());
						session.setAttribute("total", total);
						}
					}
				
				//Si on choisit de diminuer la  quantité
				else if(action.equals("dec")) {
					String nom_prod = request.getParameter("nom_prod");
					
					if (nom_prod!= null && !nom_prod.equals("")) {
						
						currentCart.reduceQuantiteToProduit(nom_prod);
						session.setAttribute("cart", currentCart);
						request.setAttribute("cart",currentCart.getCart());
						total = currentCart.getTotalCartPrice(currentCart.getCart());
						session.setAttribute("total", total);
					
					}
				}
				
				// Si on choisit de supprimer le produit
				else if(action.equals("remove")){
					String nom_prod = request.getParameter("nom_prod");
					
					if (nom_prod!= null && !nom_prod.equals("")) {
						currentCart.removeToCart(nom_prod);
						session.setAttribute("cart", currentCart);
						request.setAttribute("cart",currentCart.getCart());
						total = currentCart.getTotalCartPrice(currentCart.getCart());
						session.setAttribute("total", total);
					
					}
					
			    }
				//Si on choisit de vider le panier
				else if(action.equals("vider")){
					
						currentCart=new Cart();
						session.setAttribute("cart", currentCart);
						request.setAttribute("cart",currentCart.getCart());
						total = 0;
						session.setAttribute("total", total);
						
			    }
			}
		
			request.getRequestDispatcher("/panier.jsp").forward(request, response);
			
		}
		
		//Si la servlet qu'on appel est /connexion.do on affiche notre page /login.jsp
		
		else if(url.equals("/connexion.do")) {
			titre="contenuLogin.jsp";
			request.setAttribute("titre", titre);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		//Si la servlet qu'on appel est /connexion.do on affiche notre page /register.do
		else if(url.equals("/register.do")) {
			titre="contenuRegister.jsp";
			request.setAttribute("titre", titre);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		else if(url.equals("/confirmation.do")) {
			titre="contenuConfirmation.jsp";
			request.setAttribute("titre", titre);
			total= (double) session.getAttribute("total");
			shippingOpt=(int) session.getAttribute("shipping");
			double montant=0;
			int random_val=random.nextInt(max - min + 1) + min;
			
			FacadeCommandeClient comClientQuery=metierGc.getCommandeClient(random_val);
			
			while (comClientQuery!=null) {
				random_val=random.nextInt(max - min + 1) + min;
			}
			
			session.setAttribute("NumConfirmation", random_val );
			
			FacadeClient client= (FacadeClient) session.getAttribute("client");
			session.setAttribute("client", client);
			
			//ArrayList<Commandes>allcomClient=metierGc.getCommandesParClient(client);
			//System.out.println("=============================="+allcomClient.toString());
			
			session.setAttribute("total", total);
			
			FacadeCommandeClient c_new= comClient;
			comClient=metierGc.createCommande(random_val, client,total,c_new);
			
			session.setAttribute("comClient", comClient);
			
			// Récupération de l'option de livraison choisie par l'utilisateur
			String shippingOption = request.getParameter("shippingOption");

			if(shippingOption == null) {
				
				// Si aucune option de livraison n'a été choisie, on initialise l'option de livraison à 0 et on met à jour le montant total de la commande
			    session.setAttribute("shipping", 0);
			    montant=total+0;
			    comClient.setMontant(montant);
			    session.setAttribute("totalMontantTotal", montant );
			    // Mise à jour de la date de dernière modification de la commande
				
			    try {
					date = new Date();
					currentDateTime = dateFormat.format(date);
				    Date dateCreation = dateFormat.parse(currentDateTime);
				    comClient.setDernierMaj(dateCreation);
				} catch (ParseException e) {
				    e.printStackTrace();
				}
				session.setAttribute("comClient", comClient);
				
			}else {
				// Si une option de livraison a été choisie, on met à jour l'option de livraison et le montant total de la commande en fonction de cette option
			    shippingOpt= (int) session.getAttribute("shipping");
				
				if("shippingOption1".equals(shippingOption)){
					
					shippingOpt=0;
					montant=total+0;
					comClient.setMontant(montant);
					session.setAttribute("totalMontantTotal", montant );
					
					// Mise à jour de la date de dernière modification de la commande
					try {
						date = new Date();
						currentDateTime = dateFormat.format(date);
					    Date dateCreation = dateFormat.parse(currentDateTime);
					    comClient.setDernierMaj(dateCreation);
					} catch (ParseException e) {
					    e.printStackTrace();
					}
					session.setAttribute("comClient", comClient);
					
				}else if("shippingOption2".equals(shippingOption)){
					
					shippingOpt=10;
					montant=total+10;
					comClient.setMontant(montant);
					session.setAttribute("totalMontantTotal", montant );
					
					// Mise à jour de la date de dernière modification de la commande
					try {
						date = new Date();
						currentDateTime = dateFormat.format(date);
					    Date dateCreation = dateFormat.parse(currentDateTime);
					    comClient.setDernierMaj(dateCreation);
					
					} catch (ParseException e) {
					    e.printStackTrace();
					}
					session.setAttribute("comClient", comClient);
					
				}else if("shippingOption3".equals(shippingOption)){
					shippingOpt=20;	
					montant=total+20;
					comClient.setMontant(montant);
					session.setAttribute("totalMontantTotal", montant );
					
					// Mise à jour de la date de dernière modification de la commande
					try {
						date = new Date();
						currentDateTime = dateFormat.format(date);
					    Date dateCreation = dateFormat.parse(currentDateTime);
					    comClient.setDernierMaj(dateCreation);
					} catch (ParseException e) {
					    e.printStackTrace();
					}
					session.setAttribute("comClient", comClient);
					
				}
			}
			
			// Récupération du panier de l'utilisateur et association des produits à la commande
			Cart cart = (Cart) session.getAttribute("cart");
			for (FacadeProduitCommande pc : cart.getCart()) {
				pc.setCommandeClientID(comClient);
				
			}
			session.setAttribute("cart", cart);
			
			// Gestion des actions de l'utilisateur
			String action= request.getParameter("action");
			if(action!=null){
				
				// Si l'utilisateur choisit d'annuler la commande, on le redirige
				if (action.equals("annuler")) {
					response.sendRedirect("/ShoppingCatalogue/accueil.do");
				}
			}
			request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
		}
		else if (url.equals("/enregistrement.do")) {
		    // on définit le titre de la page à afficher
		    titre = "contenuEnregistrement.jsp";
		    request.setAttribute("titre", titre);
		    
		    // on récupère le client connecté à partir de la session
		    FacadeClient client = (FacadeClient) session.getAttribute("client");
		    
		    // on récupère le panier de la session
		    Cart cart = (Cart) session.getAttribute("cart");
		    
		    // on récupère le numéro de confirmation de commande et le total de la commande de la session
		    int numConf = (int) session.getAttribute("NumConfirmation");
		    double totalcommande = (double) session.getAttribute("totalMontantTotal");
		    
		    // on récupère la commande client actuelle à partir du panier
		    FacadeCommandeClient currentcomclient = (FacadeCommandeClient) cart.getCart().get(0).getCommandeClientID();
		    
		    // on valide la commande client actuelle en utilisant la couche métier
		    metierGc.validerCommande(currentcomclient, cart.getCart());
		    
		    // on enregistre le panier précédent dans la session
		    session.setAttribute("previouscart", cart);
		    
		    // on enregistre le montant total de la commande, le numéro de confirmation et la date de création de la commande client actuelle dans la session
		    session.setAttribute("totalMontantTotal", currentcomclient.getMontant());
		    session.setAttribute("NumConfirmation", currentcomclient.getNoConfirmation());
		    session.setAttribute("dateCreation", currentcomclient.getDernierMaj());
		    
		    // on crée un nouveau panier et on l'enregistre dans la session
		    currentCart = new Cart();
		    session.setAttribute("cart", currentCart);
		    
		    // on redirige la requête vers la page d'enregistrement
		    request.getRequestDispatcher("/enregistrement.jsp").forward(request, response);
		}
		// Si l'URL appelée n'a aucun lien, on renvoie une erreur 404
		else {
		    response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//On recupère l'url de la servlet qu'on passe dans chaque page
		String url=request.getServletPath();
		/*HttpSession session = request.getSession(true);
		*/
		HttpSession session = request.getSession(true);
		if(url.equals("/accueil.do")) {
			
			String email=request.getParameter("email");
			String nom=request.getParameter("nom");
			
            if (email==null || nom==null) {    

            	 request.setAttribute("errorMessage", "Email ou nom sont nulls.");
            	 response.sendRedirect("/ShoppingCatalogue/connexion.do");
            }
            
            else if(email!=null && nom!=null) {
            	
            	
            	if(email.isBlank() || nom.isBlank()) {
            		 String errorMessage= "Email ou nom incorrect.";
	       			 session.setAttribute("errorMessage", errorMessage);
	       			 
            		 response.sendRedirect("/ShoppingCatalogue/connexion.do");
            	}
            	
            	else if(!email.isBlank() && !nom.isBlank()) {
            		
            		FacadeClient client = metierClient.getClientByEmail(email,nom);
            		if(client==null) {
            			 String errorMessage= "L'utilisateur n'existe pas.";
            			 session.setAttribute("errorMessage", errorMessage);
            			 response.sendRedirect("/ShoppingCatalogue/connexion.do");
            		}else {
            			
            			session.setAttribute("client", client);
            			//ArrayList<Commandes>allcomClient=metierGc.getCommandesParClient(client);
            			//System.out.println("=============================="+allcomClient.toString());
            			
            		}
            		
            	}
            
            	
            }
			
			
		}
		
		if(url.equals("/connexion.do")) {
			
			String email=request.getParameter("email");
			String nom=request.getParameter("name");
			String adress=request.getParameter("adress");
			String phone=request.getParameter("phone");
			
			if(email.isBlank() || nom.isBlank() || adress.isBlank() || phone.isBlank()) {
       		 	 String errorMessage= "Tous les champs doivent être rempli";
      			 session.setAttribute("errorMessage", errorMessage);
      			 response.sendRedirect("/ShoppingCatalogue/register.do");
			}
       	
	       	else if(!email.isBlank() && !nom.isBlank() && !adress.isBlank() && !phone.isBlank()) {
	       		FacadeClient client = metierClient.getClientEmail(email);
	       		if(client!=null) {
	       			 String errorMessage= "Cet email existe déjà pour un utilisateur.";
	       			 session.setAttribute("errorMessage", errorMessage);
	       			
	       			 response.sendRedirect("/ShoppingCatalogue/register.do");
	       		}else {
	       			
	       			client=new FacadeClient();
	       			client.setAdresse(adress);
	       			client.setEmail(email);
	       			client.setNom(nom);
	       			client.setTelephone(phone);
	       			metierClient.addClient( client);
	       		
	       		}
	       		
	       	}
		}
		doGet(request, response);
	}

}
