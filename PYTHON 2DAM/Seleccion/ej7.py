hora=int(input("Introduzca la hora:"))
if hora>=7 and hora<12:
    print("Buenos dias :)")
elif hora>12 and hora<=20:
    print("Buenas tardes :)")
elif (hora>20 and hora<24) or hora<7:
    print("Buenas noches :)")
else:
    print("Hora mal introducida")