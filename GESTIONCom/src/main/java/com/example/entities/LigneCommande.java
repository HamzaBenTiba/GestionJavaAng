package com.example.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class LigneCommande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long qte;
	private BigDecimal prixUnitaire;
    private BigDecimal prixTotale;
	private long etat;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "commande_id")
	private Commande commande;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "produit_id")
	private Produit produit;
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LigneCommande(Produit produit, Commande commande) {
		super();
		this.produit = produit;
		this.commande = commande;
	}

	public LigneCommande(long qte, long etat, Produit produit, Commande commande) {
		super();
		//this.qte = qte;
		//this.etat = etat;
		this.produit = produit;
		this.commande = commande;
	}

	public LigneCommande(long qte, BigDecimal prixUnitaire, BigDecimal prixTotale, long etat, Produit produit,
			Commande commande) {
		super();
		this.qte = qte;
		this.prixUnitaire = prixUnitaire;
		this.prixTotale = prixTotale;
		this.etat = etat;
		this.produit = produit;
		this.commande = commande;
	}

	public LigneCommande(Produit produit) {
		super();
		this.produit = produit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getQte() {
		return qte;
	}
	public void setQte(long qte) {
		this.qte = qte;
	}
	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public BigDecimal getPrixTotale() {
		return prixTotale;
	}
	public void setPrixTotale(BigDecimal prixTotale) {
		this.prixTotale = prixTotale;
	}
	public long getEtat() {
		return etat;
	}
	public void setEtat(long etat) {
		this.etat = etat;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
}
