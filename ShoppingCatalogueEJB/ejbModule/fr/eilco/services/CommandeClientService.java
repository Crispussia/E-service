package fr.eilco.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


import fr.eilco.ejb.ClientCommandeBeanLocal;
import fr.eilco.ejb.ClientsBeanLocal;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;



@Stateless
@WebService
public class CommandeClientService {
	//injection des interfaces
	@EJB
	private ClientCommandeBeanLocal metier;
	@EJB
	private ClientsBeanLocal metierClient;
	@WebMethod
	public void addCommande(@WebParam(name="montant")Double montant,@WebParam(name="dateCreation")Date dateCreation,
			@WebParam(name="noConfirmation")int noConfirmation,@WebParam(name="dernierMaj")Date dernierMaj,@WebParam(name="id_client")int id) {
		FacadeClient p=metierClient.getClient(id);
		FacadeCommandeClient clientcom = new FacadeCommandeClient(montant,dateCreation,noConfirmation,dernierMaj,p);
		metier.addCommande(clientcom);
	}
	@WebMethod
	public ArrayList<FacadeCommandeClient> getListCommandeClient(int id_client) {
		// TODO Auto-generated method stub
		return metier.getListCommandeClient(id_client);
	}
	

}
