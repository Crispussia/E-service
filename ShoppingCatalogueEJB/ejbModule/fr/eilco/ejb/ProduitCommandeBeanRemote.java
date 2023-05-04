package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.eilco.entities.FacadeProduit;
import fr.eilco.entities.FacadeProduitCommande;

@Remote
public interface ProduitCommandeBeanRemote {
	public void addProduitACommande(int id_com,int id_prod,int quantite);
	
	//récupérer la liste des produits par numero commande
	public ArrayList<FacadeProduitCommande> getListProduitDeCommande(int no_commande);
}
