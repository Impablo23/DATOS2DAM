//Aqui creamos la interfaz con los datos correspondientes y dandole al nivel de padel y procedencia valor opcional
interface alumno{
    nombre:string;
    apellidos:string;
    nacionalidad:string;
    annoNac:number;
    tlf:number;
    correo:string;
    modulos:string;
    convalidaFol:boolean;
    nivelPadel?:string;
    procedencia?:string;
}
//Creamos el primer objeto
const pablo: alumno = { 
    nombre:"Pablo",
    apellidos:"Rico Machío",
    nacionalidad:"España",
    annoNac:2004,
    tlf:666666666,
    correo:"pablomanoslargas@pitimail.com",
    modulos:"DAW",
    convalidaFol:true,
    nivelPadel:"Experto",
    procedencia:"Antártida"

}
//Creamos el objeto para el profesor jajajaj :)
const profesor: alumno = { 
    nombre:"Antonio",
    apellidos:"Lopez Camacho",
    nacionalidad:"España",
    annoNac:1000,
    tlf:999999999,
    correo:"tuprofedepadel@mantas.com",
    modulos:"DAM",
    convalidaFol:false,
    nivelPadel:"Mantas",
    procedencia:"Málaga"

}
//Mostramos en una tabla en la consola del inspeccionar de la pagina
console.table(pablo);
console.table(profesor);