//Creamos la interfaz de centro con sus respectivos atributos
interface CentroE{
    centro:string;
    localidad:string;
    codCentro:string;
    tlf:number
}
//Creamos la interfaz de la matricula con sus respectivos atributos
interface Matricula{
    modulos:string[];
    ciclo:string;
    centro:CentroE
}
//Creamos la interfaz del alumno con sus respectivos atributos
interface Alumnado{
    nombre:string;
    apellidos:string;
    annoNac:number;
    nacionalidad:string;
    matricula:Matricula
}

//Creamos el alumno "guai" y le damos valores a sus atributos
const guai:Alumnado= {
    nombre: "Ale ",
    apellidos: "Guaperas",
    annoNac: 2004,
    nacionalidad: "Israel",
    matricula: {
        modulos: ["F1","Niñas","Barcelo"],
        ciclo: "Its Take Two",
        centro: {
            centro: "Picadero Ale",
            localidad: "Malaga",
            codCentro: "22334455SX",
            tlf: 112233445
        }
    }
}
//Creamos el alumno "colin" y le damos valores a sus atributos
const colin:Alumnado= {
    nombre: "Colin",
    apellidos: "Niñas",
    annoNac: 2004,
    nacionalidad: "Alemania",
    matricula: {
        modulos: ["Niñas1","Niñas2","Niñas3"],
        ciclo: "Niñas4",
        centro: {
            centro: "IES Las niñas",
            localidad: "Casa Melanie",
            codCentro: "69696969SX",
            tlf: 696969696
        }
    }
}

//Mostramos la informacion introducida de los alumnos en una tabla
console.table(guai)
console.table(colin)

//Creamos constantes con los datos especificos que os pide el enunciado para mostrarlos a la consola
const { nombre, apellidos } = guai;
const { ciclo } = guai.matricula;
const { centro } = guai.matricula.centro;


//Imprimimos los datos anteriores por la consola
console.log("Nombre y apellidos:",nombre,apellidos);
console.log("Ciclo que cursa:",ciclo);
console.log("Centro en el que estudia:",centro);
