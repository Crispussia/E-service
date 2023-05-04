package fr.eilco.services;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.eilco.ejb.ClientsBeanLocal;

import fr.eilco.entities.FacadeClient;

@Stateless
@WebService
public class ClientService {
	//injection des interfaces
	@EJB
	private ClientsBeanLocal metier;
	@WebMethod
	public ArrayList<FacadeClient> getListClient() {
		
		return metier.getListClient();
	}
	@WebMethod
	public FacadeClient getClient(@WebParam(name="idclient")int id) {
		
		//on envoie à la base de donnée en passant par la couche métier
		return metier.getClient(id);
	}
	
	@WebMethod
	public void addCategorie(@WebParam(name="nom")String nom,@WebParam(name="email")String email,
			@WebParam(name="telephone")String telephone,@WebParam(name="adresse")String adress) {
		//on envoie à la base de donnée en passant par la couche métier
		FacadeClient cl=new FacadeClient(nom,email,telephone,adress);
		metier.addClient(cl);
	}
}
