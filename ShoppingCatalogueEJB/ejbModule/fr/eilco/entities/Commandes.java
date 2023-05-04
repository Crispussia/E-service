package fr.eilco.entities;

import java.util.Date;
import java.util.List;

import fr.eilco.entities.FacadeProduit;

public class Commandes {
  
  private Date dateCreation;
  private Date dernierMaj;
  private double montantTotal;
  private int noConfirmation;
  private List<FacadeProduitCommande> produits;

   
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDernierMaj() {
		return dernierMaj;
	}
	public void setDernierMaj(Date dernierMaj) {
		this.dernierMaj = dernierMaj;
	}
	public double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	public int getNoConfirmation() {
		return noConfirmation;
	}
	public void setNoConfirmation(int i) {
		this.noConfirmation = i;
	}
	public List<FacadeProduitCommande> getProduits() {
		return produits;
	}
	public void setProduits(List<FacadeProduitCommande> produits) {
		this.produits = produits;
	}

}
