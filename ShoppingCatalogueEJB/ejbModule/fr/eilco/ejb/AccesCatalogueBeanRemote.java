package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeProduit;

@Remote
public interface AccesCatalogueBeanRemote {
	//récupérer la liste des catégorie
	public ArrayList<FacadeCategorie> getListCategories();
	//récupérer la liste des produits par catégorie
	public ArrayList<FacadeProduit> getListProduits(int numCat);
	public FacadeProduit getProduit(int id);
	public FacadeCategorie getCategorie(int id);
}
