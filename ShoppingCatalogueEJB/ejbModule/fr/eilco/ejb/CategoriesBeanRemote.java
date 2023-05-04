package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.eilco.entities.FacadeCategorie;

@Remote
public interface CategoriesBeanRemote {
	//ajouter une catégorie
	public void addCategorie(String nom);
	
	//récupérer la liste des catégorie
	public ArrayList<FacadeCategorie> getListeCategories();
	
	//récuperer une categorie
	public FacadeCategorie getCategorie(int id);

	//mettre à jour une catégorie
	public void updateCategorie(FacadeCategorie c);
	
	//Supprimer une categorie
	public void deleteCategorie(int id);
}
