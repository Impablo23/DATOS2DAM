numero = input("Ingrese un número: ")

# Verificamos si el número es un entero positivo
if numero.isdigit():
    num = int(numero)
    if num <= 1:
        es_primo = False
    elif num <= 3:
        es_primo = True
    elif num % 2 == 0 or num % 3 == 0:
        es_primo = False
    else:
        i = 5
        while i * i <= num:
            if num % i == 0 or num % (i + 2) == 0:
                es_primo = False
                break
            i += 6
        else:
            es_primo = True
else:
    es_primo = False

if es_primo:
    print(f"{num} es un número primo.")
else:
    print(f"{num} no es un número primo.")
