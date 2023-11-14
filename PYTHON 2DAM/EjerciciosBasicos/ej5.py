nombre=input("Introduzca el nombre del alumno:")
nota1=int(input("Nota 1 Evaluación de "+nombre+":"))
nota2=int(input("Nota 2 Evaluación de "+nombre+":"))
nota3=int(input("Nota 3 Evaluación de "+nombre+":"))
nota1=nota1*0.2
nota2=nota2*0.35
nota3=nota3*0.45
final=nota1+nota2+nota3
redondeo=round(final,2)
print("La nota final de",nombre,"es:",redondeo)