package fr.eilco.ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.Commandes;
import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduit;
import fr.eilco.entities.FacadeProduitCommande;

/**
 * Session Bean implementation class GestionCommandeBean
 */
@Stateless(name = "gestionCommandeJNDI")
public class GestionCommandeBean implements GestionCommandeBeanRemote, GestionCommandeBeanLocal {

    /**
     * Default constructor. 
     */
	//Pour l'entité manager on injecte les outils de persistence 
		@PersistenceContext(unitName="managerCatalogue")
		EntityManager em;
    public GestionCommandeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public FacadeCommandeClient createCommande(int numero_comfirmation, FacadeClient client, double total,
			FacadeCommandeClient cc) {
		cc.setMontant(total);
		cc.setClientID(client);
		cc.setNoConfirmation(numero_comfirmation);
		// TODO Auto-generated method stub
		return cc;
	}
	
	@Override
	public FacadeCommandeClient getCommandeClient(int noConfirmation) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("FROM FacadeCommandeClient cc Where cc.noConfirmation = :noConfirmation").setParameter("noConfirmation", noConfirmation);
		FacadeCommandeClient cc = new FacadeCommandeClient();
		try {
			   
			cc = (FacadeCommandeClient) q.getSingleResult();
			
			System.out.println("client existe ================: "+ cc);
			return cc;
		} catch (NoResultException e) {
		    // handle the exception here
		    return null;
		}
		
	
	}
	@Override
	public ArrayList<FacadeCommandeClient> getPanierCommandeClient(ArrayList<FacadeCommandeClient> lignesCommandes) {
		ArrayList<FacadeCommandeClient> list_com=lignesCommandes;
		return list_com;
	}
	@Override
	public void validerCommande(FacadeCommandeClient c, ArrayList<FacadeProduitCommande> lignesCommandes) {
		// TODO Auto-generated method stub
		FacadeClient client = em.find(FacadeClient.class, c.getClientID().getId());
	    FacadeCommandeClient cc_new = new FacadeCommandeClient();
	    cc_new.setClientID(client);
	    cc_new.setDateCreation(c.getDateCreation());
	    cc_new.setDernierMaj(c.getDernierMaj());
	    cc_new.setMontant(c.getMontant());
	    cc_new.setNoConfirmation(c.getNoConfirmation());
	    em.persist(cc_new);

	    System.out.println("Aucune commande enregistre==========================================");
	    for (FacadeProduitCommande commande : lignesCommandes) {
	        FacadeProduit p = em.find(FacadeProduit.class, commande.getProduitID().getId());
	        FacadeProduitCommande pc = new FacadeProduitCommande();
	        pc.setQuantite(commande.getQuantite());
	        pc.setProduitID(p);
	        pc.setCommandeClientID(cc_new);
	        em.persist(pc);
	    }
		
	}
	
	@Override
	public void addCommande(FacadeCommandeClient cc) {
		// TODO Auto-generated method stub
		//System.out.println("client ================: "+ cc);
	
		Query q_noConf = em.createQuery("select c from FacadeCommandeClient c where c.noConfirmation = :noConfirmation").setParameter("noConfirmation", cc.getNoConfirmation());
		FacadeCommandeClient numconf = new FacadeCommandeClient();
		//System.out.println("OUI inexistant==========================================");
		try {
		   
			numconf = (FacadeCommandeClient) q_noConf.getSingleResult();
			
			System.out.println("Le numéro de confirmation existe ");
			//throw new RuntimeException("Le numéro de confirmation existe ");
			
			
		} catch (NoResultException e) {
		    // handle the exception here
			
			System.out.println("Le numéro de confirmation n'existe pas");
				try {
					System.out.println("=======================> em.merge(cc) : " + em.merge(cc));
					em.merge(cc);
				
				} catch (NoResultException ne) {
					System.out.println(ne);
					
				}
			
		
			
		}
		
		
		
	}
	public ArrayList<Commandes> getCommandesParClient(FacadeClient c) {
		ArrayList<Commandes> lignesCommandes=new ArrayList<>();
	    try {
	    	FacadeClient client = em.find(FacadeClient.class, c.getId());
	    	Query q_facadecommandeclient = em.createQuery("select comClient from FacadeCommandeClient comClient where comClient.clientID = :clientID").setParameter("clientID", c);
	    	List<FacadeCommandeClient> all_facade_commande_client = q_facadecommandeclient.getResultList();

	    	// Afficher les informations des commandes
	    	for (FacadeCommandeClient commande : all_facade_commande_client) {
	    	    System.out.println("Commande n° " +" passée le " + commande.getDateCreation());
	    	    System.out.println("Montant total : " + commande.getMontant());
	    	    System.out.println("Numéro de confirmation : " + commande.getNoConfirmation());
	    	    System.out.println("Dernière mise à jour : " + commande.getDernierMaj());
	    	    // etc.
	    	    Query q_facadeproduitcommande = em.createQuery("select prodcom from FacadeProduitCommande prodcom where prodcom.commandeClientID = :commandeClientID").setParameter("commandeClientID", commande);
	    	    // Afficher la liste des produits associés à la commande
	    	    // Créer une nouvelle commande et ajouter la liste de produits associés
	    	    List<FacadeProduitCommande> produitsCommande = q_facadeproduitcommande.getResultList();

	    	    Commandes commandes = new Commandes();
	    	    
	            commandes.setProduits(produitsCommande);
	            commandes.setDateCreation( commande.getDateCreation());
	            commandes.setMontantTotal(commande.getMontant());
	            commandes.setNoConfirmation(commande.getNoConfirmation());
	            // Ajouter la commande à la liste de commandes
	            lignesCommandes.add(commandes);
	    	}
	    } catch (NoResultException ne) {
			System.out.println(ne);
			
		}
	    System.out.println("liste lignes : " + lignesCommandes);
	    return lignesCommandes;
	}

}
