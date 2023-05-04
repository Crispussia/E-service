package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import fr.eilco.entities.FacadeCommandeClient;

@Local
public interface ClientCommandeBeanLocal {
	public void addCommande(FacadeCommandeClient cc);
	
	//récupérer la liste des produits par catégorie
	public ArrayList<FacadeCommandeClient> getListCommandeClient(int id_client);
	
	//récuperer une categorie
	public FacadeCommandeClient getCommandeClient(int noConfirmation);
	
	//mettre à jour un produit
	public void updateCommandeClient(int noConfirmation);
	
	//Supprimer un produit
	public void deleteCommandeClient(int noConfirmation);
}
