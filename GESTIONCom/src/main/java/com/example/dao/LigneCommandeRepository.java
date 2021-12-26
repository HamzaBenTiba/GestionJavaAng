package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{

}
