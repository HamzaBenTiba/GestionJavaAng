import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProduitsComponent } from './produits/produits.component';
import { CommandesComponent } from './commandes/commandes.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AjouteProduitComponent } from './ajoute-produit/ajoute-produit.component';
import { AjouteCommandeComponent } from './ajoute-commande/ajoute-commande.component';
import { EditProduitComponent } from './edit-produit/edit-produit.component';

@NgModule({
  declarations: [
    AppComponent,
    ProduitsComponent,
    CommandesComponent,
    AjouteProduitComponent,
    AjouteCommandeComponent,
    EditProduitComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
