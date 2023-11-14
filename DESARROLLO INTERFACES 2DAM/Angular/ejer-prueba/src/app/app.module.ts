import { ContadorComponent } from './contador/contador.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListaComponent } from './listas/lista/lista.component';
import { HeroeComponent } from './heroes/heroe/heroe.component';

@NgModule({
  declarations: [
    AppComponent,ContadorComponent, ListaComponent, HeroeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
