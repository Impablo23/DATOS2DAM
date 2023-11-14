export interface Producto {
	descripcion: string;
	precio: number;
}

const telefono: Producto = {
	descripcion: 'iPhone 15 Pro',
	precio: 1000
}

const tablet: Producto = {
	descripcion: 'iPad Air 3',
	precio: 500
}

interface CalculaImpuestoOpciones {
	impuesto: number;
	productos: Producto[];
}

// colocamos despues del nombre de la funcion en vez de una variable de tipo calcularimpuestoopciones en las variables impuesto y productos para obtener exactamente eso
export function calculaImpuesto ({impuesto,productos}: CalculaImpuestoOpciones):[number,number] {
	let total = 0;
	productos.forEach(producto => {
		const {precio}=producto
        total += precio;
	});
	return [total, total * impuesto];
}

const carritoCompra = [telefono, tablet];
const impuesto = 0.21;

const   [compraTotal,impuestoTotal] = calculaImpuesto({
	productos: carritoCompra,
	impuesto: impuesto
	// también podemos poner por la línea anterior, ya que se llaman iguales:
	// impuesto
})

//Añadimos los resultados a la consola mostrando las variables de la constante anterior
console.log('Total',compraTotal);
console.log('Impuesto',impuestoTotal);

export {};
