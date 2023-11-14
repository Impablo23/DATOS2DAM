//Empezamos a hacer las funciones de operaciones basicas de la calculadora.


/**
 * Funcion que devuelve la suma de dos numeros.
 * @param num1 
 * @param num2 
 * @returns num1+num2
 */
function sumarNumeros(num1:number, num2:number = num1){
    return num1+num2;
}
//Creamos un variable con la suma y lo mostramos en la consola
const suma:number= sumarNumeros(3);
console.log("La suma de los numeros es:",suma)

/**
 * Funcion que devuelve la resta de dos numeros.
 * @param num1 
 * @param num2 
 * @returns num1-num2
 */
function restarNumeros(num1:number, num2:number = num1){
    return num1-num2;
}
//Creamos un variable con la resta y lo mostramos en la consola
const resta:number= restarNumeros(3,4);
console.log("La resta de los numeros es:",resta)

/**
 * Funcion que devuelve la multiplicacion de dos numeros.
 * @param num1 
 * @param num2 
 * @returns num1*num2
 */
function multiplicaNumeros(num1:number, num2:number = num1){
    return num1*num2;
}
//Creamos un variable con la multiplicacion y lo mostramos en la consola
const multi:number= multiplicaNumeros(4);
console.log("La multiplicacion de los numeros es:",multi)

/**
 * Funcion que devuelve la division de dos numeros.
 * @param num1 
 * @param num2 
 * @returns 
 */
function divideNumeros(num1:number, num2:number = num1){
    return num1/num2;
}
//Creamos un variable con la division y lo mostramos en la consola
const div:number= divideNumeros(9,3);
console.log("La division de los numeros es:",div)

const sumarConFlecha= (a:number, b:number):number =>{
    return a+b;
}
let resultado:number= sumarConFlecha(2,4);
console.log(resultado);