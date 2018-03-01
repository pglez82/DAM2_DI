#Crea un acceso directo en el menu de inicio

# Nombre del instalador
outFile "prueba5.exe"
 
# seccion por defecto
section
 
    # Se crea un  nuevo acceso directo en el menu de inicio. Como le pasamos
    # en el segundo parametro vacio, no llama a nada de momento
    createShortCut "$SMPROGRAMS\Nuevo acceso directo.lnk" ""
 
 
# fin de la seccion
sectionEnd