import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/models/produit';
import { ProduitService } from 'src/services/produit.service';

@Component({
  selector: 'app-ajoute-produit',
  templateUrl: './ajoute-produit.component.html',
  styleUrls: ['./ajoute-produit.component.sass']
})
export class AjouteProduitComponent implements OnInit {

  produit:Produit=new Produit();
  constructor(private router: Router,private http: HttpClient,private produitService: ProduitService) { }

  ngOnInit(): void {
  }
  saveProduit(){
    console.log(this.produit);
    this.produitService.saveProduit(this.produit).subscribe(data=>{
      console.log(data)
    },error=>{
      console.log(error);
    });
    console.log("1");
    }



}
