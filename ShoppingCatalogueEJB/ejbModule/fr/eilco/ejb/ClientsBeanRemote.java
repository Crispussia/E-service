package fr.eilco.ejb;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import fr.eilco.entities.FacadeClient;


@Remote
public interface ClientsBeanRemote {
	public void addClient(FacadeClient cl);
	
	//récupérer la liste des produits par catégorie
	public ArrayList<FacadeClient> getListClient();
	
	//récuperer une categorie
	public FacadeClient getClient(int id);
	
	//mettre à jour un produit
	public void updateClient(FacadeClient cl);
	public FacadeClient getClientByEmail(String email, String nom);
	
	//Supprimer un produit
	public void deleteClient(int id);
	public FacadeClient getClientEmail(String email);
}
