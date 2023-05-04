package fr.eilco.services;

import java.util.ArrayList;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.eilco.ejb.CategoriesBeanLocal;
import fr.eilco.entities.FacadeCategorie;


@Stateless
@WebService
public class CategorieService {
	//On fait appel à l'ejb session via l'interface locale
	
	//injection des interfaces
	@EJB
	private CategoriesBeanLocal metier;
	
	@WebMethod
	public void addCategorie(@WebParam(name="nomCategorie")String nom) {
		//on envoie à la base de donnée en passant par la couche métier
		metier.addCategorie(nom);
	}
	
	@WebMethod
	public ArrayList<FacadeCategorie> getListCategorie() {
		
		return metier.getListeCategories();
	}
	
	@WebMethod
	public FacadeCategorie getCategorie(@WebParam(name="categorieId")int id) {
		
		//on envoie à la base de donnée en passant par la couche métier
		return metier.getCategorie(id);
	}
	
}
