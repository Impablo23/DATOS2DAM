anno=(int(input("Introduzca un año:")))

if anno%4==0 or anno%100==0 or anno%400==0:
    print("El año",anno,"es bisiesto :)")
else :
    print("El año",anno,"NO es bisiesto")