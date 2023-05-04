package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduit;

/**
 * Session Bean implementation class ClientCommandeBean
 */
@Stateless(name = "clientCommandeJNDI")
public class ClientCommandeBean implements ClientCommandeBeanRemote, ClientCommandeBeanLocal {

    /**
     * Default constructor. 
     */
	//Pour l'entité manager on injecte les outils de persistence 
	@PersistenceContext(unitName="managerCatalogue")
	EntityManager em;
    public ClientCommandeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCommande(FacadeCommandeClient cc) {
		// TODO Auto-generated method stub
		System.out.println("client ================: "+ cc);
	
		Query q_noConf = em.createQuery("select c from FacadeCommandeClient c where c.noConfirmation = :noConfirmation").setParameter("noConfirmation", cc.getNoConfirmation());
		FacadeCommandeClient numconf = new FacadeCommandeClient();
		System.out.println("OUI inexistant==========================================");	
		try {
		   
			numconf = (FacadeCommandeClient) q_noConf.getSingleResult();
			
			System.out.println("Le numéro de confirmation existe ");
			throw new RuntimeException("Le numéro de confirmation existe ");
			
			
		} catch (NoResultException e) {
		    // handle the exception here
			
			System.out.println("Le numéro de confirmation n'existe pas");
			em.persist(cc);
		
			
		}
		
		
		
	}

	@Override
	public ArrayList<FacadeCommandeClient> getListCommandeClient(int id_client) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select cc from FacadeCommandeClient cc where cc.clientID.id = :id_client").setParameter("id_client", id_client);		
		return (ArrayList<FacadeCommandeClient>) q.getResultList();
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
			
			System.out.println("client inexistant==========================================");
			
			return null;
		}
		
	
	}

	@Override
	public void updateCommandeClient(int noConfirmation) {
		// TODO Auto-generated method stub
		FacadeCommandeClient cc=getCommandeClient(noConfirmation);
		em.merge(cc);
	}

	@Override
	public void deleteCommandeClient(int noConfirmation) {
		// TODO Auto-generated method stub
		FacadeCommandeClient cc=getCommandeClient(noConfirmation);
		em.remove(cc);
	}

}
