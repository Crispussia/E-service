package fr.eilco.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.eilco.ejb.ProduitBeanLocal;
import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeProduit;

@Stateless
@WebService
public class ProduitService {
	//On fait appel à l'ejb session via l'interface locale
	
		//injection des interfaces
		@EJB
		private ProduitBeanLocal metier;
		@WebMethod
		public void addProduit(@WebParam(name="nomProduit")String nom,@WebParam(name="prix")double prix, 
				@WebParam(name="description")String description, @WebParam(name="date")Date dernierMaj,
			@WebParam(name="numCategorie")int categorieID) {
			
			//FacadeProduit p=new FacadeProduit(nom,prix,description,dernierMaj,categorieID);
			//on envoie à la base de donnée en passant par la couche métier
			metier.addProduit(nom,prix,description,dernierMaj,categorieID);
		}
		@WebMethod
		public ArrayList<FacadeProduit> getListProduit(@WebParam(name="categorieId")int id) {
			
			return metier.getListeProduits(id);
		}
		
		@WebMethod
		public FacadeProduit getProduit(@WebParam(name="produitId")int id) {
			
			//on envoie à la base de donnée en passant par la couche métier
			return metier.getProduit(id);
		}
}
