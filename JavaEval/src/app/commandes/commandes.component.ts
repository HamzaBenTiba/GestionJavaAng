import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommandeService } from 'src/services/commande.service';
import { ProduitService } from 'src/services/produit.service';

@Component({
  selector: 'app-commandes',
  templateUrl: './commandes.component.html',
  styleUrls: ['./commandes.component.sass']
})
export class CommandesComponent implements OnInit {
  pageCommande:any;
  keyword:String="";
  currentPage:number=0;
  size:number=5;
  pages:any;
  constructor(private router: Router,private http: HttpClient,private commandeService: CommandeService) { }

  ngOnInit(): void {


  }
  doserch(){

    this.commandeService.getCommandes(this.keyword,this.currentPage,this.size).subscribe(data =>{
      this.pageCommande=data;
      this.pages=new Array(this.pageCommande.totalPages);
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
  onCommandePage(i:number){
    this.currentPage=i;
    this.doserch();
  }
  goTo(){
    console.log("3");
    this.router.navigate(['/ajouterCommande']);
    console.log("4");
  }

}
