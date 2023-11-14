num1=int(input("Ingrese el primer numero:"))
num2=int(input("Ingrese el segundo numero:"))
num3=int(input("Ingrese el tercer numero:"))

if num1>num2 and num1>num3:
    print("Numero mayor:",num1)
elif num2>num1 and num2>num3:
    print("Numero mayor:",num2)
elif num3>num1 and num3>num2:
    print("Numero mayor:",num3)