package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import fr.eilco.entities.FacadeClient;

@Local
public interface ClientsBeanLocal {
	public void addClient(FacadeClient cl);
	
	//récupérer la liste des produits par catégorie
	public ArrayList<FacadeClient> getListClient();
	
	//récuperer une categorie
	public FacadeClient getClient(int id);
	
	//
	public FacadeClient getClientByEmail(String email, String nom);
	//mettre à jour un produit
	public void updateClient(FacadeClient cl);
	
	//Supprimer un produit
	public void deleteClient(int id);
	public FacadeClient getClientEmail(String email);

}
