function decoradorClase(constructor: any){
    return class extends constructor{
        nuevaPropiedad="Nueva Propiedad";
        hola="Adios";
    }

}

@decoradorClase
export class SuperClase{
    public miPropiedad:string= "Patata";

    imprime(){
        console.log("Hola Mundo");
    }
}

console.log(SuperClase);

const superClase= new SuperClase();
console.log(superClase);