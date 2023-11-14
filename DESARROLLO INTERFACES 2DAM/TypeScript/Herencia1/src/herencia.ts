//Creamos el Objeto Persona con sus respectivos atributos
export class Persona{
    constructor(
        public nombre:string,
        public apellidos:string,
        public edad:number,
        public localidad:string,
        public sexo?:'H'|'M'
    ){

    };
}
//Creamos el Objeto Profesor, que hereda los atributos de Persona, con sus respectivos atributos
export class Profesor extends Persona{
    constructor(
        public nombre:string,
        public apellidos:string,
        public edad:number,
        public localidad:string,
        public centro:string,
        public especialidad:string,
        public departamento:string,
        public sexo?:'H'|'M',
    ){
        super(nombre,apellidos,edad,localidad,sexo);
    };
}
//Creamos el Objeto Alumno, que hereda los atributos de Persona, con sus respectivos atributos
export class Alumno extends Persona{
    constructor(
        public nombre:string,
        public apellidos:string,
        public edad:number,
        public localidad:string,
        public centro:string,
        public curso:"1DAM"|"2DAM",
        public asignaturas:string[],
        public sexo?:'H'|'M',
    ){
        super(nombre,apellidos,edad,localidad,sexo);
    };
}
//Creamos un Profesor y un Alumno y le proporcionamos los datos
const profesoraLaura= new Profesor("Laura","Kotlin",25,"Torremolinos","IES Playamar","Kotlin","Informatica",'M');
const alumnoPablo= new Alumno("Pablo","Rico Machío",19,"Torremolinos","IES Playamar","2DAM",["TypeScript","Java","SQL"],'H');
//Mostramos los datos del Profesor y del Almuno
console.log(profesoraLaura);
console.log(alumnoPablo);