num=int(input("Ingrese el numero del dia de la semana:"))
match num:
    case 1:
        dia="Lunes"
        print(dia)
    case 2:
        dia="martes"
        print(dia)
    case 3:
        dia="Miercoles"
        print(dia)
    case 4:
        dia="Jueves"
        print(dia)
    case 5:
        dia="Viernes"
        print(dia)
    case 6:
        dia="Sabado"
        print(dia)
    case 7:
        dia="Domingo"
        print(dia)
    case _:
        print("Dia de la semana incorrecto")