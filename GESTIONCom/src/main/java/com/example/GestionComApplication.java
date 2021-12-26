package com.example;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CategorieRepository;
import com.example.dao.CommandeRepository;
import com.example.dao.LigneCommandeRepository;
import com.example.dao.ProduitRepository;
import com.example.entities.Categorie;
import com.example.entities.Commande;
import com.example.entities.LigneCommande;
import com.example.entities.Produit;

@SpringBootApplication
public class GestionComApplication implements CommandLineRunner{

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionComApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorie c1=new Categorie("TV");
		Categorie c2=new Categorie("FRG");
		Categorie c3=new Categorie("MAL");
		categorieRepository.save(c1);
		categorieRepository.save(c2);
		categorieRepository.save(c3);
		Produit p1;
		Produit p2;
		Produit p3;
		Produit prod1= new Produit("MH15","LG","L505","FRG NonFrost",new BigDecimal("1950.35"),5L,c2);
		Produit prod2= new Produit("MH17","LG","L505","FRG NonFrost",new BigDecimal("1950.35"),5L,c2);
		Produit prod3= new Produit("RB20","LG","L505","FRG NonFrost",new BigDecimal("1950.35"),5L,c2);
		p1=produitRepository.save(prod1);
		p2=produitRepository.save(prod2);
		p3=produitRepository.save(prod3);
		produitRepository.save(new Produit("FH15","LG","L505","FRG NonFrost",new BigDecimal("1950.35"),5L,c2));
		produitRepository.save(new Produit("FH16","LG","TV55","TV 55 LED",new BigDecimal("1750.35"),5L,c1));
			
		Commande cmd= new Commande("hf45",new BigDecimal("1950.35"),5L );
		cmd=commandeRepository.save(cmd);
		 LigneCommande lc1= new LigneCommande(p3,cmd);
		ligneCommandeRepository.save(lc1);
		
		  
		
		 
		
	}

}
