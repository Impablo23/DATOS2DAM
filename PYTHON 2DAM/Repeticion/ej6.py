filas = int(input("Ingrese el número de filas: "))
columnas = int(input("Ingrese el número de columnas: "))

# Inicializamos el contador
contador = 1

# Iteramos sobre las filas
for fila in range(filas):
    # Inicializamos una fila vacía
    fila_actual = ""
    
    # Iteramos sobre las columnas en esta fila
    for columna in range(columnas):
        # Agregamos el valor del contador a la fila actual
        fila_actual += str(contador) + "\t"
        
        # Incrementamos el contador
        contador += 1
    
    # Imprimimos la fila actual
    print(fila_actual)

