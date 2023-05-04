package fr.eilco.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ForeignKey;
@Entity
@Table(schema="CatalogueDS", name="Produit")
public class FacadeProduit implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="id",nullable = false)
	private int id;
	@Column(name="nom",length = 45,nullable = false)
	private String nom;
	@Column(name="prix",nullable = false)
	private double prix;
	@Column(name="description",length = 1000)
	private String description;
	@Column(name="image",length = 500)
	private String image;
	@Column(name="dernier_maj")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernierMaj;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "categorie_id",nullable = false)
	private FacadeCategorie categorieID ;
	
	
	public FacadeProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacadeProduit(String nom, double prix, String description, Date dernierMaj,
			FacadeCategorie categorieID) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.dernierMaj = dernierMaj;
		this.categorieID = categorieID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDernierMaj() {
		return dernierMaj;
	}

	public void setDernierMaj(Date dernierMaj) {
		this.dernierMaj = dernierMaj;
	}

	public FacadeCategorie getCategorieID() {
		return categorieID;
	}

	public void setCategorieID(FacadeCategorie categorieID) {
		this.categorieID = categorieID;
	}

	@Override
	public String toString() {
		return "FacadeProduit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", description=" + description
				+ ", dernierMaj=" + dernierMaj + "]";
	}
	
	
}
