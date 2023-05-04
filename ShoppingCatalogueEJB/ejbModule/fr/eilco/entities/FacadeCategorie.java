package fr.eilco.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="CatalogueDS", name="Categorie")
public class FacadeCategorie implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="nom",length = 45,nullable = false)
	private String nom;
	
	public FacadeCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacadeCategorie(String nom) {
		super();
		this.nom = nom;
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

	@Override
	public String toString() {
		return "FacadeCategorie [id=" + id + ", nom=" + nom + "]";
	}
	
}
