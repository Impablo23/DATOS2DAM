/*
    ===== Código de TypeScript =====
*/

//Creamos una interfaz de tipo SuperHero como el tipo de la variable superHero
interface SuperHero{
    name:string;
    age:number;
    address:{
        calle:string;
        pais:string;
        ciudad:string;
    };
    //Añadimos un metodo como la constante y le aplicamos el string para que solo coga valores de ese mismo tipo
    showAddress():string
}


const superHeroe: SuperHero = {
    name: 'Spiderman',
    age: 30,
    address: {
        calle: 'Main St',
        pais: 'USA',
        ciudad: 'NY'
    },
    showAddress() {
        return this.name + ', ' + this.address.ciudad + ', ' + this.address.pais;
    }
}


const address = superHeroe.showAddress();
console.log( address );




