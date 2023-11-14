palabra1=input("Ingrese una palabra: ")
palabra2=input("Ingrese una palabra: ")
print("\n")
opcion=(int(input("Deseas comprobar teniendo en cuenta las mayúsculas/minúsculas (1) o no (0): ")))
if opcion==1:
    if palabra1==palabra2[::-1]:
        print("La palabra",palabra1,"es polindroma de la palabra",palabra2,"y viceversa :)")
    else:
        print("La palabra",palabra1,"--NOOOO-- es polindroma de la palabra",palabra2,"y viceversa :)")
elif opcion==0:
    if(palabra1.upper()==palabra2.upper()[::-1]):
        print("La palabra",palabra1.upper(),"es polindroma de la palabra",palabra2.upper(),"y viceversa :)")
    else:
        print("La palabra",palabra1.upper(),"--NOOOO-- es polindroma de la palabra",palabra2.upper(),"y viceversa :)")