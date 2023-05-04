package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.FacadeCategorie;

import fr.eilco.entities.FacadeProduit;

/**
 * Session Bean implementation class AccesCatalogueBean
 */
@Stateless(name = "accesCatalogueJNDI")
public class AccesCatalogueBean implements AccesCatalogueBeanRemote, AccesCatalogueBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="managerCatalogue")
	EntityManager em;
    public AccesCatalogueBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public ArrayList<FacadeCategorie> getListCategories() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select cat from FacadeCategorie cat");
		return (ArrayList<FacadeCategorie>) q.getResultList();
	}
	@Override
	public ArrayList<FacadeProduit> getListProduits(int numCat) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select p from FacadeProduit p where p.categorieID.id = :numCat").setParameter("numCat", numCat);
		return (ArrayList<FacadeProduit>) q.getResultList();
	}
	@Override
	public FacadeProduit getProduit(int id) {
		FacadeProduit p=em.find(FacadeProduit.class, id);
		if(p==null)throw new RuntimeException("Produit introuvable");
		
		return p;
	}
	@Override
	public FacadeCategorie getCategorie(int id) {
		// TODO Auto-generated method stub
		
		FacadeCategorie cat=em.find(FacadeCategorie.class, id);
		
		if(cat==null)throw new RuntimeException("Categorie introuvable");
		
		return cat;
	}

	
}
