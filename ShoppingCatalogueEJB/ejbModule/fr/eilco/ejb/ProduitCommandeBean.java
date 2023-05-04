package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduit;
import fr.eilco.entities.FacadeProduitCommande;

/**
 * Session Bean implementation class ProduitCommandeBean
 */
@Stateless(name = "ProduitCommandeJNDI")
public class ProduitCommandeBean implements ProduitCommandeBeanRemote, ProduitCommandeBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="managerCatalogue")
	EntityManager em;
    public ProduitCommandeBean() {
        // TODO Auto-generated constructor stub
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FacadeProduitCommande> getListProduitDeCommande(int no_commande) {
		
		Query q_prod = em.createQuery("select c from FacadeProduitCommande c where c.commandeClientID.id = :id_com").setParameter("id_com", no_commande);
		ArrayList<FacadeProduitCommande> pc = new ArrayList<FacadeProduitCommande>();
		pc = (ArrayList<FacadeProduitCommande>) q_prod.getResultList();		
		System.out.println("client ================: " + pc );
		/*try {
			   
			
			System.out.println("client ================: ");
				
		} catch (NoResultException e) {
		    // handle the exception here
			
			System.out.println("Aucun produit associé à cette commande==========================================");			
			throw new RuntimeException("Aucun produit associe à cette commande");
		}*/
		
		return pc;
	}


	@Override
	public void addProduitACommande(int id_com, int id_prod, int quantite) {
		// TODO Auto-generated method stub
		Query q_numCommande = em.createQuery("select c from FacadeProduitCommande c where c.commandeClientID.id = :id_com AND c.produitID.id = :id_prod");
		q_numCommande.setParameter("id_com",id_com);
		q_numCommande.setParameter("id_prod", id_prod);
		ArrayList<FacadeProduitCommande> listNumCommande = new ArrayList<FacadeProduitCommande>();
		listNumCommande = (ArrayList<FacadeProduitCommande>) q_numCommande.getResultList();		
		if (listNumCommande.size()==0) {
			System.out.println("Aucune commande enregistre==========================================");		
			FacadeProduitCommande pc=new FacadeProduitCommande();
			FacadeProduit p=em.find(FacadeProduit.class, id_prod);
			FacadeCommandeClient c=em.find(FacadeCommandeClient.class, id_com);
			pc.setQuantite(quantite);
			pc.setProduitID(p);
			pc.setCommandeClientID(c);
			em.persist(pc);
		}

	
	}


}
