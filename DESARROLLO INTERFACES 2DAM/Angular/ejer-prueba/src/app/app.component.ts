import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public title: string = 'Málaga y Exquisita';
  public contador:number = 20;
  public contadorInicial:number=this.contador
  public incremento:number= 4;
  public decremento:number = -2;

  incrementaCantidad(incremento:number):number{
    return this.contador=this.contador+incremento;
  }
  decrementoCantidad(decremento:number):number{
    return this.contador=this.contador-decremento;
  }
  reseteo():void{
    this.contador=0;
  }

}
