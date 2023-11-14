#Pedimos una palabra 
palabra=input("Escribe una palabra: ")
#Comprobamos que la cadena normal es iggual a la cadena inversa
if str(palabra)==str(palabra)[::-1]:
    print("La palabra "+palabra+" es políndroma :)")
else:
    print("La palabra "+palabra+" NO es políndroma :)")
