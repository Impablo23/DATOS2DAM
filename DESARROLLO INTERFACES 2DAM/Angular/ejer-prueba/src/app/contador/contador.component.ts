import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contador',
  template: `

    <body>
    <h1>{{title}}</h1>
    <hr>
    <p>Contador Principal = {{contadorInicial}}</p>
    <hr>
    <button (click)="incrementaCantidad(incremento)">+{{incremento}}</button>
    <br>
    <br>
    <button (click)="incrementaCantidad(decremento)">{{decremento}}</button>
    <br>
    <br>
    <button (click)="reseteo()">Reseteo al valor del Contador Principal</button>
    <br>
    <br>
    <hr>
    <p>Valor del Nuevo Contador: {{contador}}</p>
    <p>Valor de Incremento: {{incremento}}</p>
    <p>Valor de Decremento: {{decremento}}</p>
    </body>
  `




})

export class ContadorComponent {
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
