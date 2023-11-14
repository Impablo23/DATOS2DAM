import { Producto, calculaImpuesto  } from "./argumentos";

const carritoCompra: Producto[]= [
    {
        descripcion: "iPhone 11",
        precio: 2000

    },
    {
        descripcion: "Airpods Pro",
        precio: 1000
    }
]

const [total,impuesto]= calculaImpuesto({
    impuesto:0.21,
    productos:carritoCompra
});

console.log(carritoCompra);
console.log("Total:",total);
console.log("Impuesto:",impuesto);
