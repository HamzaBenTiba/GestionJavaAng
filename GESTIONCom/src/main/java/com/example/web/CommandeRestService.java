package com.example.web;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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

import com.example.dao.CommandeRepository;
import com.example.dao.LigneCommandeRepository;
import com.example.entities.Commande;
import com.example.entities.LigneCommande;

@RestController
@CrossOrigin("*")
public class CommandeRestService {
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository LcommandeRepository;
	@RequestMapping(value="/commande",method = RequestMethod.GET)
	public List<Commande> getCommandes(){
		
		return commandeRepository.findAll();
	}
	@RequestMapping(value="/commandes/{code}",method = RequestMethod.GET)
    public Commande getCommande(@PathVariable Long code){
		
		return commandeRepository.findById(code).get();
	}
	@RequestMapping(value="/commandes",method = RequestMethod.POST)
    public Commande save(@RequestBody Commande cmd){
		
	 commandeRepository.save(cmd);
	 Collection<LigneCommande> lcomms = cmd.getLigneCommande();
	    for (LigneCommande lc : lcomms) {
	        lc.setId(cmd.getId());
	        LcommandeRepository.save(lc);
	       }	
	    return cmd;
	}
	
	@RequestMapping(value="/commandes/{code}",method = RequestMethod.DELETE)
    public boolean supprimer(@PathVariable Long code){
		commandeRepository.deleteById(code);
		return true;
	}
	
	@RequestMapping(value="/commandes/{code}",method = RequestMethod.PUT)
    public Commande save(@RequestBody Commande cmd,@PathVariable long code){
		cmd.setId(code);
		return commandeRepository.save(cmd);
	}
	
	@RequestMapping(value="/chercherCommande",method = RequestMethod.GET)
	public Page<Commande> chercher(
			@RequestParam(name="mc",defaultValue = "") String mc,
			@RequestParam(name="page",defaultValue = "0")int page,
			@RequestParam(name="size",defaultValue = "5")int size){
		
		return commandeRepository.chercherCle("%"+mc.toUpperCase()+"%",PageRequest.of(page,size));
	}
}
