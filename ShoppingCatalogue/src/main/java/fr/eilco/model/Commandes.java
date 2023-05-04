package fr.eilco.model;

import java.util.Date;
import java.util.List;

import fr.eilco.entities.FacadeProduit;

public class Commandes {
  private int id;
  private Date dateCreation;
  private Date dernierMaj;
  private double montantTotal;
  private String noConfirmation;
  private List<FacadeProduit> produits;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getNoConfirmation() {
		return noConfirmation;
	}
	public void setNoConfirmation(String noConfirmation) {
		this.noConfirmation = noConfirmation;
	}
	public List<FacadeProduit> getProduits() {
		return produits;
	}
	public void setProduits(List<FacadeProduit> produits) {
		this.produits = produits;
	}

}
