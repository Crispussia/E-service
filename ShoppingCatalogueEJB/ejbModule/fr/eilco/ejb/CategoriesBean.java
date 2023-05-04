package fr.eilco.ejb;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.FacadeCategorie;


/**
 * Session Bean implementation class CategoriesBean
 */
//Il n'a pas d'état il n'y a que des méthodes j'appelle la méthode il fait le traitement et me donne le résultat
@Stateless(name = "CategoriesJNDI")
public class CategoriesBean implements CategoriesBeanRemote, CategoriesBeanLocal {

	/**
     * Default constructor. 
     */
	//Pour l'entité manager on injecte les outils de persistence 
	@PersistenceContext(unitName="managerCatalogue")
	EntityManager em;
    public CategoriesBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public  void addCategorie(String nom) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("FROM FacadeCategorie cat Where cat.nom = :nom").setParameter("nom", nom);
		FacadeCategorie cat = new FacadeCategorie();
		
		
		System.out.println("catégorie=============================== : "+ cat);
		
		
		try {
		   
			cat = (FacadeCategorie) q.getSingleResult();
			
			System.out.println("catégorie===================== : "+ cat);
			
		} catch (NoResultException e) {
		    // handle the exception here
			
			System.out.println("categorie inexistante==========================================");
			//throw new RuntimeException("categorie inexistante");
			
		}
		
		if(cat.getNom()==null) {
			System.out.println("nom : "+ nom);
			FacadeCategorie categorie_new=new FacadeCategorie(nom);
			em.persist(categorie_new);
		}
		else {
			throw new RuntimeException("Nom Categorie existe");
		}
		
		
		
        
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FacadeCategorie> getListeCategories() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select cat from FacadeCategorie cat");
		return (ArrayList<FacadeCategorie>) q.getResultList();
	}

	@Override
	public FacadeCategorie getCategorie(int id) {
		// TODO Auto-generated method stub
		
		FacadeCategorie cat=em.find(FacadeCategorie.class, id);
		
		if(cat==null)throw new RuntimeException("Categorie introuvable");
		
		return cat;
	}

	@Override
	public void updateCategorie(FacadeCategorie c) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//la methode merge permet de faire un update
		em.merge(c);
	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub
		FacadeCategorie cat=getCategorie(id);
		em.remove(cat);
	}

}
