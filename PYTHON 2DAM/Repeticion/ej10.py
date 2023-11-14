num=int(input("Introduce un numero: "))
impar=1
piramide=str(impar)

for num in range(num,0,-1):
    print(piramide)
    impar=impar+2
    piramide= str(impar)+" "+piramide