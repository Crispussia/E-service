package fr.eilco.ejb;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeProduit;

@Remote
public interface ProduitBeanRemote {
	//ajouter un produit
		public void addProduit(String nom,double prix,String description,Date dernierMaj,int id);
		
		//récupérer la liste des produits par catégorie
		public ArrayList<FacadeProduit> getListeProduits(int numCat);
		
		//récuperer une categorie
		public FacadeProduit getProduit(int id);
		
		//mettre à jour un produit
		public void updateProduit(FacadeProduit p);
		
		//Supprimer un produit
		public void deleteProduit(int id);

}
