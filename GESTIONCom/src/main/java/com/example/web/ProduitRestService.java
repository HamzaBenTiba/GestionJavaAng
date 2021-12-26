package com.example.web;
import com.example.entities.Produit;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProduitRepository;


@RestController
@CrossOrigin("*")
public class ProduitRestService {
	
	@Autowired
	private ProduitRepository produitRepository;
	@RequestMapping(value="/produits",method = RequestMethod.GET)
	public List<Produit> getProduits(){
		
		return produitRepository.findAll();
	}
	@RequestMapping(value="/produits/{code}",method = RequestMethod.GET)
    public Produit getProduit(@PathVariable long code){
		
		return produitRepository.findById(code).get();
	}
	@RequestMapping(value="/produits",method = RequestMethod.POST)
    public Produit save(@RequestBody Produit prod){
		
		return produitRepository.save(prod);
	}
	
	@RequestMapping(value="/produits/{code}",method = RequestMethod.DELETE)
    public boolean supprimer(@PathVariable long code){
		produitRepository.deleteById(code);
		return true;
	}
	
	@RequestMapping(value="/produits/{code}",method = RequestMethod.PUT)
    public Produit save(@RequestBody Produit prod,@PathVariable long code){
		prod.setId(code);
		return produitRepository.save(prod);
	}
	
	@RequestMapping(value="/chercherProduit",method = RequestMethod.GET)
	public Page<Produit> chercher(
			@RequestParam(name="mc",defaultValue = "") String mc,
			@RequestParam(name="page",defaultValue = "0")int page,
			@RequestParam(name="size",defaultValue = "5")int size){
		
		return produitRepository.chercherCle("%"+mc.toUpperCase()+"%",PageRequest.of(page,size));
	}
	
}
