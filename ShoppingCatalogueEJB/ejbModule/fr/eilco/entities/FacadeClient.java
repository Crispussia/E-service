package fr.eilco.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="CatalogueDS", name="Client")
public class FacadeClient implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="id",nullable = false)
	private int id;
	@Column(name="nom",length = 45,nullable = false)
	private String nom;
	@Column(name="email",nullable = false)
	private  String email;
	@Column(name="telephone",length = 15,nullable = false)
	private String telephone;
	@Column(name="adresse",length =250,nullable = false)
	private String adresse;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public FacadeClient(String nom, String email, String telephone, String adresse) {
		super();
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	public FacadeClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FacadeClient [id=" + id + ", nom=" + nom + ", email=" + email + ", telephone=" + telephone
				+ ", adresse=" + adresse + "]";
	}
	
}
