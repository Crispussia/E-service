package fr.eilco.ejb;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeProduit;

/**
 * Session Bean implementation class ProduitBean
 */
@Stateless(name = "ProduitJNDI")
public class ProduitBean implements ProduitBeanRemote, ProduitBeanLocal {
	//Pour l'entité manager on injecte les outils de persistence 
	@PersistenceContext(unitName="managerCatalogue")
	EntityManager mc;
    /**
     * Default constructor. 
     */
    public ProduitBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProduit(String nom,double prix,String description,Date dernierMaj,int id) {
		// TODO Auto-generated method stub
		//on persist la categorie
		Query q_nom_produit = mc.createQuery("select p from FacadeProduit p where p.nom = :nom_produit").setParameter("nom_produit", nom);
		Query q_cat = mc.createQuery("FROM FacadeCategorie cat Where cat.id = :id").setParameter("id", id);
		FacadeCategorie cat = new FacadeCategorie();
		FacadeProduit p = new FacadeProduit();
		
		try {
		   
			p = (FacadeProduit) q_nom_produit.getSingleResult();
			
			System.out.println("produit ================: "+ p);
			
		} catch (NoResultException e) {
		    // handle the exception here
			
			System.out.println("produit inexistant==========================================");
			//throw new RuntimeException("categorie inexistante");
			
		}
		
		if(p.getNom()==null) {
			System.out.println("nom : "+ nom);
			try {
				   
				cat = (FacadeCategorie) q_cat.getSingleResult();
				
				System.out.println("catégorie===================== : "+ cat);
				p.setCategorieID(cat);
				p.setDernierMaj(dernierMaj);
				p.setNom(nom);
				p.setDescription(description);
				p.setPrix(prix);
				mc.persist(p);
				
			} catch (NoResultException e) {
			    // handle the exception here
				System.out.println("categorie inexistante==========================================");
				throw new RuntimeException("Enregistrement non effectué car Categorie inexistante ");
				
			}
		}
		else {
			throw new RuntimeException("Nom produit est nulle ");
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FacadeProduit> getListeProduits(int numCat) {
		//consulter la liste de tous les comptes
		Query q = mc.createQuery("select p from FacadeProduit p where p.categorieID.id = :numCat").setParameter("numCat", numCat);
		return (ArrayList<FacadeProduit>) q.getResultList();
	}

	@Override
	public void updateProduit(FacadeProduit p) {
		// TODO Auto-generated method stub
		mc.merge(p);
	}

	@Override
	public FacadeProduit getProduit(int id) {
		FacadeProduit p=mc.find(FacadeProduit.class, id);
		if(p==null)throw new RuntimeException("Produit introuvable");
		
		return p;
	}
	
	@Override
	public void deleteProduit(int id) {
		// TODO Auto-generated method stub
		FacadeProduit p=getProduit(id);
		mc.remove(p);
	}

	

}
