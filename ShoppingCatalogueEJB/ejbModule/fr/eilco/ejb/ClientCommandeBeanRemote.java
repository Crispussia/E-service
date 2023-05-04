package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;

@Remote
public interface ClientCommandeBeanRemote {
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
