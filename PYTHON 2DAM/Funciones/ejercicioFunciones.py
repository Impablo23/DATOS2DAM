#Importamos las clases math y random
import math
import random
#Creamos una fucion que muestra el menu de nuestro programa
def menu():
    print("MENU DE OPCIONES:")
    print("1) Mostrar un rombo")
    print("2) Adivinar un número")
    print("3) Resolver una ecuación de segundo grado")
    print("4) Tabla de números")
    print("5) Cálculo del número factorial de un número")
    print("6) Cálculo de un número de la sucesión de Fibonacci")
    print("7) Tabla de multiplicar")
    print("8) Salir")

#Creamos una funcion que le damos por parametros tres numeros y nos devuelve la ecuacion de segundo grado
def ecuacion2Grado(a,b,c):
    #Variable para obtener lo de dentro de la raiz
    dis = b**2 - 4*a*c
    #Comprueba que si es mayor de 0 que saque las soluciones porque si es menor no tiene y si es igual tiene solucion doble
    if dis > 0:
        x1 = (-b + math.sqrt(dis)) / (2*a)
        x2 = (-b - math.sqrt(dis)) / (2*a)
        return(print(f"Las soluciones son x1 = {x1} y x2 = {x2}"))
    elif dis == 0:
        x1 = -b / (2*a)
        return(print(f"La solución doble es x1 = {x1}"))
    else:
        return(print("No hay soluciones reales"))
    
#Creamos la funcion que le damos un numero por parametro y nos va indicando si se esta acercando al numero aleatorio seleccionado
def adivinarNumero(num):
    secreto=random.randint(1,100)
    
    while True:
        num = int(input("Adivina el número entre 1 y 100: "))
        if num == secreto:
            return print("Enorabuena, has acertado, el numero era el",num)
        elif num < secreto:
            print("El número secreto es mayor.")
        else:
            print("El número secreto es menor.")
   
#Creamos una funcion que recoga un numero de filas y columnas para llenar las filas y columnas de numeros
def tabla(filas, columnas):
    tabla = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            numero = random.randint(1, 100)
            fila.append(numero)
        tabla.append(fila)
    return tabla

#Creamos la funcion que muestra los datos de la anterior funcion
def imprimirTabla(tabla):
    for fila in tabla:
        for numero in fila:
            print(numero, end="\t")
        print()  

#Creamos una funcion que recoge un numero y a partir de ese numero devuelve su factorial 
def factorial(fac):
    factorial=1
    i=1
    while i<=fac:
        factorial=factorial*i
        i+=1
    return(print("Su factorial es:",factorial))

#Creamos una funcion que recoge un numero y a partir de ese numero le mostramos la tabla de multiplicar del 1 al 10 de ese numero
def tablaMultiplicar(numero):
    for i in range(1,10,1):
        (print(numero,"x",i,"=",numero*i))

#Creamos la funcion que muestra la suc
def sucesionFibonacci(posicion):
    # sucesion de 24 posiciones
    fibonacci=[0, 1,1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 4636]
    return(print("En la posicion"))

# Función para crear el rombo de asteriscos
def creaRombo(numero):
    for i in range(numero):
        for j in range(numero - i - 1):
            print(" ", end="")
        for k in range(2 * i + 1):
            print("*", end="")
        print()
    for i in range(numero - 2, -1, -1):
        for j in range(numero - i - 1):
            print(" ", end="")
        for k in range(2 * i + 1):
            print("*", end="")
        print()

#---------------------------------------------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------------------------------------
menu()
num=int(input("Ingrese el numero de la accion que desea realizar :)"))
while (num>8 or num<0):
    menu()
    num=int(input("Ingrese el numero de la accion que desea realizar :)"))

match num:
    case 1:
        num=int(input("Ingrese un numero impar: "))
        while(num%2==0):
            num=int(input("Ingrese un numero impar: "))
        creaRombo(num)
    case 2:
       numero=0
       adivinarNumero(numero)
    case 3:
        a=int(input("Ingrese el valor de segundo grado:"))
        b=int(input("Ingrese el valor de primer grado:"))
        c=int(input("Ingrese el valor independiente:"))
        ecuacion2Grado(a,b,c)
    case 4:
        numF=int(input("Ingrese el numero de filas: "))
        numC=int(input("Ingrese el numero de columnas: "))
        tabla = tabla(numF, numC)
        imprimirTabla(tabla)
    case 5:
        numero=int(input("Ingrese un numero cualquiera para hacer su factorial: "))
        factorial(numero)
    case 6:
        pos=int(input("Dime una posicion entre 1 y 24 para decirte que valor de la sucesion de Fibonacci es:"))
        sucesionFibonacci(pos)
    case 7:
        numTabla=int(input("Ingrese un numero para mostrarle su tabla de multiplicar:"))
        tablaMultiplicar(numTabla)
    case 8:
        print("Gracias por usar nuestro menu, que tengas buen dia :)")


   

    




