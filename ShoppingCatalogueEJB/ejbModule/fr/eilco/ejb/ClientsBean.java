package fr.eilco.ejb;

import java.util.ArrayList;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeClient;

/**
 * Session Bean implementation class ClientsBean
 */
@Stateless(name = "ClientJNDI")
public class ClientsBean implements ClientsBeanRemote, ClientsBeanLocal {

    /**
     * Default constructor. 
     */
	//Pour l'entité manager on injecte les outils de persistence 
	@PersistenceContext(unitName="managerCatalogue")
	EntityManager em;
    public ClientsBean() {
        // TODO Auto-generated constructor stub
    	
    }
	@Override
	public void addClient(FacadeClient cl) {
		// TODO Auto-generated method stub
		if((cl.getNom()==null)|| (cl.getAdresse()==null)||(cl.getEmail()==null)||(cl.getTelephone()==null)) {
			System.out.println("Ajout non rempli : ");
			throw new RuntimeException("Please rempli tous les champs");
		}
		else {
			Query q = em.createQuery("FROM FacadeClient cl Where cl.email = :email").setParameter("email", cl.getEmail());
			FacadeClient temp = new FacadeClient();
			try {
				   
				temp = (FacadeClient) q.getSingleResult();
				
				System.out.println("client===================== : "+ temp);
				throw new RuntimeException("Ce client existe");
				
			} catch (NoResultException e) {
			    // handle the exception here
				
				System.out.println("categorie inexistante==========================================");			
				
			}
			if(temp.getEmail()==null) {
				em.persist(cl);
			}
			else {
				throw new RuntimeException("Email existe");
			}
		}
	}
	@Override
	public ArrayList<FacadeClient> getListClient() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select cl from FacadeClient cl");
		return (ArrayList<FacadeClient>) q.getResultList();
	}
	@Override
	public FacadeClient getClient(int id) {
		// TODO Auto-generated method stub
		FacadeClient cl=em.find(FacadeClient.class, id);
		
		if(cl==null)throw new RuntimeException("Client introuvable");
		
		return cl;
	}
	public FacadeClient getClientByEmail(String email, String nom) {
		// TODO Auto-generated method stub
		
		Query client = em.createQuery("select c from FacadeClient c where c.email = :email AND c.nom = : nom");
		client.setParameter("email", email);
		client.setParameter("nom", nom);
		//FacadeClient cl=(FacadeClient) client.getSingleResult();
		FacadeClient cl = new FacadeClient();
		try {
			   
			cl = (FacadeClient) client.getSingleResult();
			
		} catch (NoResultException e) {
		    // handle the exception here
			cl=null;
			System.out.println("categorie inexistante==========================================");			
			
		}
		
		
		return cl;
	}
	
	public FacadeClient getClientEmail(String email) {
		// TODO Auto-generated method stub
		
		Query client = em.createQuery("select c from FacadeClient c where c.email = :email");
		client.setParameter("email", email);
	
		//FacadeClient cl=(FacadeClient) client.getSingleResult();
		FacadeClient cl = new FacadeClient();
		try {
			   
			cl = (FacadeClient) client.getSingleResult();
			
		} catch (NoResultException e) {
		    // handle the exception here
			cl=null;
			System.out.println("categorie inexistante==========================================");			
			
		}
		
		
		return cl;
	}
	@Override
	public void updateClient(FacadeClient cl) {
		// TODO Auto-generated method stub
		em.merge(cl);
	}
	
	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		FacadeClient cl=getClient(id);
		em.remove(cl);
	}

   

	

}
