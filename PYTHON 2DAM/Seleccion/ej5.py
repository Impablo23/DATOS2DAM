edad=int(input("¡Hola!, introduzca su edad para darle la entrada correcta:"))
if edad<5:
    print("Su entrada es gratuita :)")
elif edad>5 and edad<18:
    print("Su entrada cuesta 3€ :)")
elif edad>18 and edad<65:
    print("Su entrada cuesta 6€ :)")
else:
    print("Su entrada es gratuita :)")