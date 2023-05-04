package fr.eilco.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import fr.eilco.entities.Commandes;
import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduitCommande;

@Remote
public interface GestionCommandeBeanRemote {
	public FacadeCommandeClient createCommande(int numero_comfirmation,FacadeClient client,double total,FacadeCommandeClient cc);
	//récuperer une categorie
	public FacadeCommandeClient getCommandeClient(int noConfirmation);
	public ArrayList<FacadeCommandeClient> getPanierCommandeClient(ArrayList<FacadeCommandeClient> lignesCommandes);
	public void validerCommande(FacadeCommandeClient c,ArrayList<FacadeProduitCommande> lignesCommandes);
	public void addCommande(FacadeCommandeClient cc);
	public ArrayList<Commandes> getCommandesParClient(FacadeClient c);
	/*public ArrayList<FacadeCommandeClient> createCommande(int numero_commande,ArrayList<FacadeProduitCommande> lignesCommandes);
	public ArrayList<FacadeCategorie> gererCommande(ArrayList<FacadeProduitCommande> lignesCommandes);
	public void validerCommande(FacadeCommandeClient c);*/
}
