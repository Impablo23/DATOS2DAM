num=1
cont=0
suma=0
mayor=-1000000
menor=1000000
while num!=0:
    num=int(input("Introduce un numero(0 para salir)"))
    if menor>num and num!=0:
        menor=num
    if mayor<num and num!=0:
        mayor=num
    
    suma=suma+num
    cont=cont+1

print("Numeros introducidos:",cont-1)
print("Suma de los numeros:",suma)
print("Numero menor introducido:",menor)
print("Numero mayor introducido:",mayor)
print("Media de los numeros:",suma/cont)


