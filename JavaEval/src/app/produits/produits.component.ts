import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/services/produit.service';
import {Router} from "@angular/router"
import { Produit } from 'src/models/produit';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.sass']
})
export class ProduitsComponent implements OnInit {

  pageProduit:any;
  keyword:String="";
  currentPage:number=0;
  size:number=5;
  pages:any;
  constructor(private router: Router,private http: HttpClient,private produitService: ProduitService) { }

  ngOnInit(): void {


  }
  doserch(){

    this.produitService.getProduits(this.keyword,this.currentPage,this.size).subscribe(data =>{
      this.pageProduit=data;
      this.pages=new Array(this.pageProduit.totalPages);
      console.log(data);
      console.log(this.keyword);
    },error=>{
        console.log(error);
      })
  }
  chercher(){
    console.log("1");
    this.doserch();
    console.log("2");
  }
  onProductPage(i:number){
    this.currentPage=i;
    this.doserch();
  }
  goTo(){
    console.log("3");
    this.router.navigate(['/ajouterProduit']);
    console.log("4");
  }
  supprimerProduit(p:Produit){

    let confirm=window.confirm('Est vous sure?');
    if(confirm==true){

      this.produitService.suppProduit(p.id).subscribe(data=>{
        this.pageProduit.content.splice(
          this.pageProduit.content.indexOf(p),1
        );
      },error=>{
        console.log(error);
      });

    }

  }
}
