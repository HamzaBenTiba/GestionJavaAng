import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  constructor(private http: HttpClient) { }

  getCommandes(keyword:String,page:number,size:number){
   return this.http.get("http://localhost:8080/chercherCommande?mc="+keyword+"&page="+page+"&size="+size);
  }
}
