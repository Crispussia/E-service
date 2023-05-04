package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduit;
import fr.eilco.entities.FacadeProduitCommande;

@Local
public interface ProduitCommandeBeanLocal {
	public void addProduitACommande(int id_com,int id_prod,int quantite);
	
	//récupérer la liste des produits par numero commande
	public ArrayList<FacadeProduitCommande> getListProduitDeCommande(int no_commande);
	
	//récuperer une categorie
	//public FacadeCommandeClient getCommandeClient(int noConfirmation);
	
	//mettre à jour un produit
	//public void deleteProduitCommande(int noConfirmation,int Produit);
}
