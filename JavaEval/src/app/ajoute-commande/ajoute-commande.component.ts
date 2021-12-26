import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/models/produit';
import { ProduitService } from 'src/services/produit.service';

@Component({
  selector: 'app-ajoute-commande',
  templateUrl: './ajoute-commande.component.html',
  styleUrls: ['./ajoute-commande.component.sass']
})
export class AjouteCommandeComponent implements OnInit {
  ProduitList: Produit[] | undefined;
  pageCommande:any;
  keyword:String="";
  currentPage:number=0;
  size:number=5;
  pages:any;
  tmp:any= [{ id: 21, code: "test", qte: 5 }, { id: 54, code: 'test3', qte: 7 }];

  constructor(private produitService: ProduitService) { }

  ngOnInit(): void {
    this.getProduits();
    console.log(this.tmp[1].id);
  }

  getProduits(){
    this.produitService.getProduitsAll().subscribe(data =>{
      this.pageCommande=data;

      this.pages=new Array(this.pageCommande.totalPages);
      console.log(data);
      console.log(this.keyword);
    },error=>{
        console.log(error);
      })
  }

addProduct(){

}
}
