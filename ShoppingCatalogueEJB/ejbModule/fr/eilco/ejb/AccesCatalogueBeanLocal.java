package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeProduit;

@Local
public interface AccesCatalogueBeanLocal {
	//récupérer la liste des catégorie
	public ArrayList<FacadeCategorie> getListCategories();
	//récupérer la liste des produits par catégorie
	public ArrayList<FacadeProduit> getListProduits(int numCat);
	public FacadeProduit getProduit(int id);
	public FacadeCategorie getCategorie(int id);
}
