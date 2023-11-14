#Inicializamos la variables que vayamos a usar
i=1
lista=[]
char="*"

#While hasta que introduzca un valor vacío
while char!="":
    char=input("Introduce un texto: ")
    lista.insert(i,char+";")
    i=i+1

print(" ")
#Mostramos la lista
lista.remove(";")
print("Lista de caracteres: ")
print(lista)
#La ordenamos de menor a mayor y la mostramos
lista.sort()
print("Lista de caracteres ordenados de mayor a menor: ")
print("")
print(lista)
#La ordenamos de mayor a menor y la mostramos
lista.sort(reverse=True)
print("Lista de caracteres ordenados de menor a mayor: ")
print(lista)