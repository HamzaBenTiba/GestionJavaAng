package com.example.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
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

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private LocalDate date;
	private BigDecimal prixTotal;
	private long etat;
	@ManyToOne
	@JoinColumn(name="ID_CLT")
	private Client client;
	
	  @OneToMany(mappedBy = "commande",cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	  private Set<LigneCommande> ligneCommande; 
	  public Commande() {
	 
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande( BigDecimal prixTotal, long etat) {
		super();
		this.prixTotal = prixTotal;
		this.etat = etat;
	}
	
	
	
	public Commande(String code, BigDecimal prixTotal, long etat) {
		super();
		this.code = code;
		this.prixTotal = prixTotal;
		this.etat = etat;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public BigDecimal getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}
	public long getEtat() {
		return etat;
	}
	public void setEtat(long etat) {
		this.etat = etat;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(Set<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	
}
