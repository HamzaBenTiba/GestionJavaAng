package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Commande;
import com.example.entities.Produit;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	@Query("select c from Commande c where c.code like :x")
	public Page<Commande> chercherCle(@Param("x")String mc,Pageable pageable);
}
