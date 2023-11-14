import {Jugador, Partido,Persona,Arbitro,Equipo,Direccion } from "./composicion";
function mostrarElementos<T>(array: T[]): void {
    array.forEach((element, index) => {
        console.log(`Lista de Calendario: ${index + 1}:`);
        console.log(element);
        console.log('---');
    });
}

//Creamos una direccion que usaran en todas las personas
const direccionGeneral:Direccion={
    calle:"playamar",
    cp:29620,
    localidad:"torremolinos",
    provincia:"malaga"
}
//Creamos laas personas que haran de jugadores o de arbitros
const pablo=new Persona("pablo","rico","hombre","222333444",direccionGeneral);
const nico=new Persona("nico","rodriguez","hombre","111222333",direccionGeneral);
const juan=new Persona("juan","romero","mujer","444555666",direccionGeneral);
const antonio=new Persona("antonio","lopez","mujer","777888999",direccionGeneral);
const ivan=new Persona("ivan","pesado","hombre","222444666",direccionGeneral);
const adolfo=new Persona("adolfo","sinfrenos","hombre","999000888",direccionGeneral);
const laura=new Persona("laura","kotlin","mujer","000111222",direccionGeneral);
const paco=new Persona("paco","paco","hombre","222333444",direccionGeneral);

//Creamos jugadores
const jugadorPablo= new Jugador(1,pablo);
const jugadorNico= new Jugador(1,nico);
const jugadorJuan=new Jugador(5,juan);
const jugadorAntonio=new Jugador(5,antonio);
const jugadorIvan=new Jugador(2,ivan);
const jugadorAdolfo=new Jugador(2,adolfo);

//Creamos los arbitros
const arbitroLaura=new Arbitro(102131,laura);
const arbitroPaco=new Arbitro(121324,paco);

//Empezamos a crear equipos con los jugadores
const losPamplinas:Equipo={
    jugador1:jugadorPablo,
    jugador2:jugadorNico
}
const losMancos:Equipo={
    jugador1:jugadorIvan,
    jugador2:jugadorAntonio
}
const losExpertos:Equipo={
    jugador1:jugadorJuan,
    jugador2:jugadorAdolfo
}

//Creamos los partidos
const partido1:Partido={
    equipoLocal:losPamplinas,
    equipoVisitante:losMancos,
    fecha:Date.now(),
    hora:"11:00",
    recinto:"IES Playamar",
    numPista:2,
    arbitro:arbitroLaura

}
const partido2:Partido={
    equipoLocal:losPamplinas,
    equipoVisitante:losExpertos,
    fecha:Date.now(),
    hora:"15:00",
    recinto:"IES Playamar",
    numPista:1,
    arbitro:arbitroPaco

}
const partido3:Partido={
    equipoLocal:losMancos,
    equipoVisitante:losExpertos,
    fecha:Date.now(),
    hora:"22:00",
    recinto:"IES Playamar",
    numPista:10,
    arbitro:arbitroLaura

}

// Ejemplo de uso:
const calendarioPartidos: Partido[] = [partido1,partido2,partido3];
const jugadores: Jugador[] = [jugadorAdolfo,jugadorAntonio,jugadorIvan];

mostrarElementos<Partido>(calendarioPartidos);
mostrarElementos(jugadores);
