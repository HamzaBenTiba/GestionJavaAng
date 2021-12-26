import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouteCommandeComponent } from './ajoute-commande/ajoute-commande.component';
import { AjouteProduitComponent } from './ajoute-produit/ajoute-produit.component';
import { CommandesComponent } from './commandes/commandes.component';
import { ProduitsComponent } from './produits/produits.component';

const routes: Routes = [
  {
    path: "produits",
    component: ProduitsComponent
  },
  {
    path:"commandes",
    component:CommandesComponent
  },
  {
    path:"ajouterProduit",
    component:AjouteProduitComponent
  },
  {
    path:"ajouterCommande",
    component:AjouteCommandeComponent
  },

  {
    path:"",
    redirectTo:"/produits", pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
