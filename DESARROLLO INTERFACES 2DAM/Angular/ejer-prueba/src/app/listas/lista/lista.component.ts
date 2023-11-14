import { Component } from '@angular/core';

@Component({
  selector: 'app-lista-heroes',
  templateUrl:'./lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent {
  private nombre:string="Spider-Man";
  private edad:number=23;

  public get getNombre():string{
    return this.nombre;
  }
  public set setNombre(nombre:string){
    this.nombre=nombre;
  }
  public get getEdad():number{
    return this.edad;
  }
  public set setEdad(edad:number){
    this.edad=edad;
  }


  public get getNombreCapitalizado():string{
    return this.getNombre.toUpperCase();
  }

  public descripcion():string{
    return `${this.getNombre} con ${this.getEdad} años `;
  }

  public cambiaNombre(){
    this.setNombre="Venom";
  }
  public cambiaEdad(){
    this.setEdad=40;
  }
}

