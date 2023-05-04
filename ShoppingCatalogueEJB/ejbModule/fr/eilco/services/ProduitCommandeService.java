package fr.eilco.services;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.eilco.ejb.ProduitCommandeBeanLocal;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduitCommande;

@Stateless
@WebService
public class ProduitCommandeService {
	//injection des interfaces
		@EJB
		private ProduitCommandeBeanLocal metier;
		@WebMethod
		public void addProduitACommande(@WebParam(name="id_com") int id_com,@WebParam(name="id_prod") int id_prod,@WebParam(name="quantite")int quantite) {
			
			metier.addProduitACommande(id_com,id_prod, quantite);
		}
		@WebMethod
		public ArrayList<FacadeProduitCommande> getListProduitDeCommande(@WebParam(name="id_com")int no_commande) {
			return metier.getListProduitDeCommande(no_commande);
		}

}
