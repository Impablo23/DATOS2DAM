palabra=input("Introduce una palabra: ")
letra=input("Introduce la letra que deseas buscar: ")
i=0
cont=0
for i in range(i,len(palabra),1):
    if(palabra[i]==letra):
        cont=cont+1

if cont!=0:
    print("Si se ha encontrado la letra",letra,"en la palabra y un total de",cont,"veces")
else:
    print("No se ha encontrado la letra",letra)

