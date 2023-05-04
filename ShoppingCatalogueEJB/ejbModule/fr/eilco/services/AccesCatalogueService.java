package fr.eilco.services;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.eilco.ejb.AccesCatalogueBeanLocal;
import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeProduit;


@Stateless
@WebService
public class AccesCatalogueService {
	//injection des interfaces
	@EJB
	private AccesCatalogueBeanLocal metier;

	@WebMethod
	public ArrayList<FacadeCategorie> getListCategorie() {
		
		return metier.getListCategories();
	}
	@WebMethod
	public ArrayList<FacadeProduit> getListProduit(@WebParam(name="categorieId")int id) {
		
		return metier.getListProduits(id);
	}
}
