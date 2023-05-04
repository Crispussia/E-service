package fr.eilco.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import fr.eilco.entities.Commandes;
import fr.eilco.entities.FacadeCategorie;
import fr.eilco.entities.FacadeClient;
import fr.eilco.entities.FacadeCommandeClient;
import fr.eilco.entities.FacadeProduitCommande;

@Local
public interface GestionCommandeBeanLocal {
	public FacadeCommandeClient createCommande(int numero_comfirmation,FacadeClient client,double total,FacadeCommandeClient cc);
	//récuperer une categorie
	public FacadeCommandeClient getCommandeClient(int noConfirmation);
	public ArrayList<FacadeCommandeClient> getPanierCommandeClient(ArrayList<FacadeCommandeClient> lignesCommandes);
	public void validerCommande(FacadeCommandeClient c,ArrayList<FacadeProduitCommande> lignesCommandes);
	public void addCommande(FacadeCommandeClient cc);
	public ArrayList<Commandes> getCommandesParClient(FacadeClient c);
	/*public List<FacadeCategorie> gererCommande(ArrayList<FacadeProduitCommande> lignesCommandes);
	public void validerCommande(FacadeCommandeClient c);*/
}
