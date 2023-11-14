
//Creamos una interfaz de Expediente con sus respectivos atributos
interface Expediente{
    curso:string,
    notaMedia:number;
}
//Creamos una interfaz de AlumnoFP con sus respectivos atributos
interface AlmunoFP{
    nombre:String,
    apellidos:string;
    modulosProfesionales:string[],
    expediente:Expediente[];
}
//Creamos expedientes con valores para aplicarlos a los alumnos
const expediente1={
    curso:"2DAM",
    notaMedia:4
}
const expediente2={
    curso:"2DAM",
    notaMedia:5
}
const expediente3={
    curso:"2DAM",
    notaMedia:6
}
const expediente4={
    curso:"2DAM",
    notaMedia:7
}
//Creamos los alumnos con sus atributos y datos
const alumno1:AlmunoFP={
    nombre:"Nicolas",
    apellidos:"Rodriguez Martin",
    modulosProfesionales:["FOL","DI"],
    expediente:[expediente1,expediente2]
    
}
const alumno2:AlmunoFP={
    nombre:"Ivan",
    apellidos:"Hernandez Castillo",
    modulosProfesionales:["PSP","DI"],
    expediente:[expediente2,expediente3]
}
const alumno3:AlmunoFP={
    nombre:"Francisco",
    apellidos:"Jimenez Jimenez",
    modulosProfesionales:["PM","FOL"],
    expediente:[expediente4,expediente1]
    
}
//Creamos una constantes que muestra el nombre y los apellidos del alumno 2
const NombreApellidos={
    nombre:alumno2.nombre,
    apellidos:alumno2.apellidos
}
//Creamos una constante que muestra el primer modulo profesional del alumno 2
const PrimerModuloProfesional={
    modulosProfesionales:alumno2.modulosProfesionales[0]
}
//Creamos una constante que muestra el segundo expediente del alumno 2
const CursoNotaSegundoExpediente={
    expediente:alumno2.expediente[1]
}
//Mostramos por la consola las anteriores constantes
console.log("Nombre y Apellidos del alumno 2:",NombreApellidos);
console.log("Primer Modulo Profesional del alumno 2:",PrimerModuloProfesional);
console.log("Segundo Expediente del alumno 2:",CursoNotaSegundoExpediente);