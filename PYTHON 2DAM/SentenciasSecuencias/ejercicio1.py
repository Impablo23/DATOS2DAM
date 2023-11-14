#Inicializamos la variables que vamos a usar
num=1
i=1
lista=[]
#While para pedir numeros distintos de 0 y almacenarlos en una lista
while(num!=0):
    num=(int(input("Ingrese un numero distinto de 0: ")))
    lista.insert(i,num)
    i=i+1
print(" ")
#Eliminamos el valor 0 (Clean Code :) ) y mostramos la lista con el orden de numeros introducidos
lista.remove(0)
print("Lista de numeros introducidos:")
print(lista)
#La ordenamos de menor a mayor y la mostramos
print("Lista de numeros introducidos de menor a mayor:")
lista.sort()
print(lista)
#La ordenamos de mayor a menor y la mostramos
print("Lista de numeros introducidos de mayor a menor:")
lista.sort(reverse=True)
print(lista)