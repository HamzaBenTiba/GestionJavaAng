import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produit } from 'src/models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type' : 'application/json'
    }),
  };


  getProduits(keyword:String,page:number,size:number){
   return this.http.get("http://localhost:8080/chercherProduit?mc="+keyword+"&page="+page+"&size="+size);
  }
  getProduitsAll(){
    return this.http.get("http://localhost:8080/produits");

}
saveProduit(produit:Produit){
  return this.http.post("http://localhost:8080/produits",produit);
}
suppProduit(id:any){
  return this.http.delete("http://localhost:8080/produits/"+id);
}
}
