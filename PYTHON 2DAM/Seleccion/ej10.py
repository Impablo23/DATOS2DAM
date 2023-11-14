print("Datos del paciente:")
ayunas=bool(input("¿Esta en ayunas?"))
edad=int(input("Edad:"))
peso=int(input("Peso:"))
sexo=input("Sexo (hombre o mujer):")
tipoTension=input("Tipo de tension (diastolica o sistolica):")
mm=int(input("Cantidad de mm Hg:"))
pulsaciones=int(input("Numero de pulsaciones:"))
gl=float(input("Numero de gramos/litro:"))
plaquetas=int(input("Numero de plaquetas:"))
proteinas=int(input("Numero de proteinas:"))

if ayunas==False:
    if edad>=18 and edad<=65:
        if peso>50:
            if (tipoTension=="diastolica" and (mm>50 and mm<180)) or(tipoTension=="sistolica" and (mm>90 and mm<180)):
                if pulsaciones>50 and pulsaciones<100:
                    if (sexo=="hombre" and (gl>13.5)) or (sexo=="mujer" and (gl>12.5)):
                        if plaquetas>150000:
                            if proteinas>6:
                                print("El paciente cumple con todos los requisitos")
                            else:
                                print("El paciente NO cumple con todos los requisitos")
                        else:
                                print("El paciente NO cumple con todos los requisitos")
                    else:
                                print("El paciente NO cumple con todos los requisitos")
                else:
                                print("El paciente NO cumple con todos los requisitos")
            else:
                                print("El paciente NO cumple con todos los requisitos")
        else:
                                print("El paciente NO cumple con todos los requisitos")
    else:
                                print("El paciente NO cumple con todos los requisitos")
else:
                                print("El paciente NO cumple con todos los requisitos")

