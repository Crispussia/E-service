package fr.eilco.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="CatalogueDS", name="Commande_Client")
public class FacadeCommandeClient implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable = false)
	private int id;
	@Column(name="montant",nullable = false)
	private Double montant;
	@Column(name="date_creation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Column(name="no_confirmation")
	private int noConfirmation;
	@Column(name="dernier_maj")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernierMaj;
	//plusieurs commande peuvent être passé par un client
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id",nullable = true)
	private FacadeClient clientID;
	
	public FacadeCommandeClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FacadeCommandeClient(Double montant, Date dateCreation, int noConfirmation, Date dernierMaj,
			FacadeClient clientID) {
		super();
		
		this.montant = montant;
		this.dateCreation = dateCreation;
		this.noConfirmation = noConfirmation;
		this.dernierMaj = dernierMaj;
		this.clientID = clientID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getNoConfirmation() {
		return noConfirmation;
	}
	public void setNoConfirmation(int noConfirmation) {
		this.noConfirmation = noConfirmation;
	}
	public Date getDernierMaj() {
		return dernierMaj;
	}
	public void setDernierMaj(Date dernierMaj) {
		this.dernierMaj = dernierMaj;
	}
	public FacadeClient getClientID() {
		return clientID;
	}
	public void setClientID(FacadeClient clientID) {
		this.clientID = clientID;
	}
	@Override
	public String toString() {
		return "FacadeCommandeClient [id=" + id + ", montant=" + montant + ", dateCreation=" + dateCreation
				+ ", noConfirmation=" + noConfirmation + ", dernierMaj=" + dernierMaj + ", clientID=" + clientID + "]";
	}


}
