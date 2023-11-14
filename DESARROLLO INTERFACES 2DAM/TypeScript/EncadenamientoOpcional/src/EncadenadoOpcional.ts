//Creamos una clase Persona con sus respectivos atributos
export class Persona{
    constructor(
        public apellidos:string,
        public genero:string,
        public telefono:string,
        public nombre?:string,
        public direccion?:Direccion, //Aplicamos a la direccion en ? para que sea opcional
    ){

    };
}
//Creamos una interfaz de Direccion con sus respectivos atributos para usarla en la clase Persona
export interface Direccion{
    calle:string;
    cp:number;
    localidad:string;
    provincia:string;
}

//Creamos una direccion que usaran en todas las personas
const direccionGeneral:Direccion={
    calle:"playamar",
    cp:29620,
    localidad:"torremolinos",
    provincia:"malaga"
}

//Creamos una clase Jugador con sus respectivos atributos
export class Jugador{
    constructor(
        public categoria:1 | 2 | 3 | 4 | 5 | 6,
        public persona:Persona,
    ){
        
    };
}
//Creamos una clase Arbitro con sus respectivos atributos
export class Arbitro{
    constructor(
        public numeroColegiado:number,
        public persona:Persona,
    ){
        
    };
}
//Creamos una interfaz Equipo con sus respectivos atributos
export interface Equipo{
    jugador1:Jugador;  //Le aplicamos a los jugadores de que puedan ser opcionales
    jugador2:Jugador;
}
//Creamos una interfaz partido con sus respectivos atributos
export interface Partido{
    equipoLocal?:Equipo,
    equipoVisitante?:Equipo,
    fecha:number,
    hora:string,
    recinto:string,
    numPista:number,
    arbitro?:Arbitro
}
//Creamos una interfaz Calendario con sus respectivos atributos
export interface Calendario{
    partido1:Partido,
    partido2:Partido,
    partido3:Partido
}


// Función para imprimir el calendario de partidos
function imprimirCalendario(calendario: Calendario) {
    const partido1 = calendario.partido1;
    const partido2 = calendario.partido2;
    const partido3 = calendario.partido3;

    // Función para obtener la dirección del árbitro
    function obtenerDireccionArbitro(arbitro?: Arbitro): string {
        return arbitro?.persona.direccion
            ? `${arbitro.persona.direccion.calle}, ${arbitro.persona.direccion.cp}, ${arbitro.persona.direccion.localidad}, ${arbitro.persona.direccion.provincia}`
            : "Dirección no disponible";
    }

    
    //Mostramos los datos de los partidos por pantalla
    console.log("Partido 1:");
    if((partido1.equipoLocal?.jugador1?.persona.nombre==undefined) || (partido1.equipoLocal?.jugador2?.persona.nombre==undefined)){
        console.log("- Equipo Local: no existen jugadores");
    }else{
        console.log("- Equipo Local: "+partido1.equipoLocal?.jugador1?.persona.nombre+" y "+partido1.equipoLocal?.jugador2?.persona.nombre);
    }
    if((partido1.equipoVisitante?.jugador1?.persona.nombre==undefined) || (partido1.equipoVisitante?.jugador2?.persona.nombre==undefined)){
        console.log("- Equipo Visitante: no existen jugadores");
    }else{
        console.log("- Equipo Visitante: "+partido1.equipoVisitante?.jugador1?.persona.nombre+" y "+partido1.equipoVisitante?.jugador2?.persona.nombre);
    }
    console.log(`- Fecha: ${partido1.fecha}`);
    console.log(`- Árbitro: ${partido1.arbitro?.persona.nombre}`);
    console.log(`- Dirección del Árbitro: ${obtenerDireccionArbitro(partido1.arbitro)}`);
    console.log("\n");

    console.log("Partido 2:");
    if((partido2.equipoLocal?.jugador1?.persona.nombre==undefined) || (partido2.equipoLocal?.jugador2?.persona.nombre==undefined)){
        console.log("- Equipo Local: no existen jugadores");
    }else{
        console.log("- Equipo Local: "+partido2.equipoLocal?.jugador1?.persona.nombre+" y "+partido2.equipoLocal?.jugador2?.persona.nombre);
    }
    if((partido2.equipoVisitante?.jugador1?.persona.nombre==undefined) || (partido2.equipoVisitante?.jugador2?.persona.nombre==undefined)){
        console.log("- Equipo Visitante: no existen jugadores");
    }else{
        console.log("- Equipo Visitante: "+partido2.equipoVisitante?.jugador1?.persona.nombre+" y "+partido2.equipoVisitante?.jugador2?.persona.nombre);
    }
    console.log(`- Fecha: ${partido2.fecha}`);
    console.log(`- Árbitro: ${partido2.arbitro?.persona.nombre}`);
    console.log(`- Dirección del Árbitro: ${obtenerDireccionArbitro(partido2.arbitro)}`);
    console.log("\n");

    console.log("Partido 3:");
    if((partido3.equipoLocal?.jugador1?.persona.nombre==undefined) || (partido3.equipoLocal?.jugador2?.persona.nombre==undefined)){
        console.log("- Equipo Local: no existen jugadores");
    }else{
        console.log("- Equipo Local: "+partido3.equipoLocal?.jugador1?.persona.nombre+" y "+partido3.equipoLocal?.jugador2?.persona.nombre);
    }
    if((partido3.equipoVisitante?.jugador1?.persona.nombre==undefined) || (partido3.equipoVisitante?.jugador2?.persona.nombre==undefined)){
        console.log("- Equipo Visitante: no existen jugadores");
    }else{
        console.log("- Equipo Visitante: "+partido3.equipoVisitante?.jugador1?.persona.nombre+" y "+partido3.equipoVisitante?.jugador2?.persona.nombre);
    }
    console.log(`- Fecha: ${partido3.fecha}`);
    console.log(`- Árbitro: ${partido3.arbitro?.persona.nombre}`);
    console.log(`- Dirección del Árbitro: ${obtenerDireccionArbitro(partido3.arbitro)}`);
}

// Ejemplo de Calendario
const calendario: Calendario = {
    partido1: {
        equipoVisitante: {
            jugador1: {
                categoria: 1,
                persona: {
                    nombre: "Equipo Visitante Jugador 1",
                    apellidos: "Apellidos Jugador 1",
                    genero: "Masculino",
                    telefono: "1234567890",
                },
            },
            jugador2: {
                categoria: 2,
                persona: {
                    nombre: "Equipo Visitante Jugador 2",
                    apellidos: "Apellidos Jugador 2",
                    genero: "Femenino",
                    telefono: "9876543210",
                },
            },
        },
        fecha: 1234567890,
        hora: "12:00 PM",
        recinto: "Recinto 1",
        numPista: 1,
        arbitro: {
            numeroColegiado: 12345,
            persona: {
                nombre: "Árbitro 1",
                apellidos: "Apellidos Árbitro 1",
                genero: "Masculino",
                telefono: "5555555555",
                direccion: direccionGeneral,
            },
        },
    },
    partido2: {
        fecha: 1234567891,
        hora: "1:00 PM",
        recinto: "Recinto 2",
        numPista: 2,
        arbitro: {
            numeroColegiado: 54321,
            persona: {
                nombre: "Árbitro 2",
                apellidos: "Apellidos Árbitro 2",
                genero: "Femenino",
                telefono: "666666666"
            }
        }
    },
    partido3: {
        fecha: 1234567891,
        hora: "1:00 PM",
        recinto: "Recinto 2",
        numPista: 2,
        arbitro: {
            numeroColegiado: 54321,
            persona: {
                nombre: "Árbitro 2",
                apellidos: "Apellidos Árbitro 2",
                genero: "Femenino",
                telefono: "666666666"
            }
        }
    }


}

//Imprimimos el metodo
imprimirCalendario(calendario);
