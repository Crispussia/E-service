package fr.eilco.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="CatalogueDS", name="Produit_Commande")
public class FacadeProduitCommande implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id",nullable = false)
	private int id;	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "produit_id",nullable = false)
	private FacadeProduit produitID;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "commande_client_id",nullable = false)
	private FacadeCommandeClient commandeClientID;
	@Column(name="quantite",nullable = true)
	private int quantite;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FacadeProduit getProduitID() {
		return produitID;
	}
	public void setProduitID(FacadeProduit produitID) {
		this.produitID = produitID;
	}
	public FacadeCommandeClient getCommandeClientID() {
		return commandeClientID;
	}
	public void setCommandeClientID(FacadeCommandeClient commandeClientID) {
		this.commandeClientID = commandeClientID;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite += quantite;
	}
	public FacadeProduitCommande(FacadeProduit produitID, FacadeCommandeClient commandeClientID, int quantite) {
		super();
		this.produitID = produitID;
		this.commandeClientID = commandeClientID;
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "FacadeProduitCommande [id=" + id + ", produitID=" + produitID + ", commandeClientID=" + commandeClientID
				+ ", quantite=" + quantite + "]";
	}
	public FacadeProduitCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
