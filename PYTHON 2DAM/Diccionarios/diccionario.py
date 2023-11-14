# Metodo que muestra el menu de opciones
def menu():
    print("MENÚ DE OPCIONES")
    print("a) Listado de teléfonos, usando el orden por defecto")
    print("b) Listado de teléfonos por orden alfabético.")
    print("c) Añadir un nuevo contacto.")
    print("d) Modificar el teléfono de un contacto.")
    print("e) Buscar un número de teléfono.")
    print("f) Eliminar un contacto.")
    print("g) Borrar el listín telefónico.")
    print("h) Salir")
   
# Metodo  que añade al diccionario claves-valores predeterminados
def listadoDefaul(listado):
    listado["pablo"]=111222333
    listado["nico"]=222333444
    listado["ivan"]=555666777
    listado["paco"]=999000888

# Metodo que lee el diccionario      letra a)
def leerListado(listado):
    for i in listado.items():
        print(i)

# Metodo que lee el diccionario ordenando las claves alfabeticamente     letra b)
def leerListadoAlfabeticamente(listado):
    nombres_ordenados=dict(sorted(listado.items()))
    for i in nombres_ordenados.items():
        print(i)

# Metodo que añade/modifica una clave-valor al diccionario
def annadeModificasPersonaTelefono(nombre,tlf,listado):
    listado[nombre]=tlf

# Metodo que busca un numero de telefono
def buscaTelefono(tlf,listado):
    for i in listado.values():
        if tlf==i:
            print(i)

# Metodo que elimina un nombre y telefono proporcionandole el nombre
def eliminaPersona(nombre,listado):
    del listado[nombre]

# Metodo que elimina los datos de la lista telefonica
def vaciaListado(listado):
    listado.clear()






menu()
letra=input("introduce una letra:")
lista={}
listadoDefaul(lista)
if letra=='a' or letra=='A':
    leerListado(lista)
elif letra=='b' or letra=='B':
    leerListadoAlfabeticamente(lista)
elif letra=='c' or letra=='C':
    nom=input("Dime el nombre que quieres crear: ")
    tlf=int(input("Dime el telefono que quieras añadirle a",nom,": "))
    annadeModificasPersonaTelefono(nom,tlf,lista)
elif letra=='d' or letra=='D':
    nom=input("Dime el nombre que quieres modificar: ")
    tlf=int(input("Dime el nuevo telefono que quieras para actualizarlo a ",nom,": "))
    annadeModificasPersonaTelefono(nom,tlf,lista)
elif letra=='e' or letra=='E':
    tlf=int(input("Dime el nuevo telefono que quieras buscar: "))
    buscaTelefono(tlf,lista)
elif letra=='f' or letra=='F':
    nom=input("Dime el nombre que quieres eliminar: ")
    eliminaPersona(nom,lista)
elif letra=='g' or letra=='G':
    vaciaListado(lista)
    print("Lista de telefonos eliminada correctamente :)")
elif letra=='h' or letra=='H':
    print("Gracias por usar la app :)")