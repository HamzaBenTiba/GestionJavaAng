package com.example.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String marque;
	private String model;
	private String caracteristique;
	private BigDecimal prixUnitaire;
	private long quantite;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CAT")
	private Categorie categorie;
	@JsonIgnore
	@OneToMany(mappedBy = "produit",fetch=FetchType.LAZY)
	private Set<LigneCommande> ligneCommande;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Produit(String code, String marque, String model, String caracteristique, long quantite) {
		super();
		this.code = code;
		this.marque = marque;
		this.model = model;
		this.caracteristique = caracteristique;
		this.quantite = quantite;
	}
	public Produit(String code, String marque, String model, String caracteristique, BigDecimal prixUnitaire,
			long quantite) {
		super();
		this.code = code;
		this.marque = marque;
		this.model = model;
		this.caracteristique = caracteristique;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
	}
	public Produit(String code,String marque, String model, String caracteristique, BigDecimal prixUnitaire,
			long quantite, Categorie categorie) {
		super();
		this.code=code;
		this.marque = marque;
		this.model = model;
		this.caracteristique = caracteristique;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.categorie = categorie;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCaracteristique() {
		return caracteristique;
	}
	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}
	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public long getQuantite() {
		return quantite;
	}
	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Set<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(Set<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	@Override
	public String toString() {
		return "Produit [code=" + code + ", marque=" + marque + ", model=" + model + ", caracteristique="
				+ caracteristique + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite + "]";
	}
	
}
