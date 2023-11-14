//Creamos la clase de Estudiante con sus respectivos atributos
export class Estudiante{
    constructor(
        public nombre:string,
        public apellidos:string,
        public edad:number,
        public localidad:string,
        public expediente:Expediente,
        public sexo?:string,
        
    ){

    };
    
}
//Creamos una interfaz Expediente que se utulizara en la clase de Estudiante
interface Expediente{
    curso:string,
    notaMedia:number;
}
//Creamos dos expedientes para los alumnos
const expediente1:Expediente={
    curso:'2DAM',
    notaMedia:6
};
const expediente2:Expediente={
    curso:'1DAM',
    notaMedia:9
};

//Creamos los dos alumnos con sus respectivos datos en relacion a los atributos de Estudiante
const pablo=new Estudiante('Pablo','Rico',19,'Malaga',expediente1,'Hombre');
const pepe=new Estudiante('Pepe','Carta',29,'Cadiz',expediente2,'Mujer');

//Los mostramos por la consola
console.log(pablo);
console.log(pepe);

//Creamos la clase Instituto con sus respectivos atributos
export class Instituto{
    public estudiantes:Estudiante[]
    constructor(
        public centro:string,
        public localidad:string,
       
    ){
        this.estudiantes=[]
    };

    
}
//Creamos uns instituto
const playamar= new Instituto('IES Playamar','Torremolinos')

//Creamos una funcion que recoge por parametros un estudiante y un instituto para añadir al alumno a ese instituto
function matricularEstudiante(alumno: Estudiante, instituto: Instituto): void {
    instituto.estudiantes.push(alumno);
}

//Matriculamos a los dos alumnos creados anteriormente
matricularEstudiante(pablo,playamar);
matricularEstudiante(pepe,playamar);
//Mostramos los datos del instituto por la consola
console.log(playamar);