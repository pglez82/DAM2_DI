#Crea un fichero de texto en el Escritorio y escribe dentro hola mundo

# nombre del instalador
outfile "prueba2.exe"
 
# abrimos la seccion principal
section
 
	#Informamos al usuario
	messageBox MB_OK "Ahora creamos hola_mundo.txt en el Escritorio!"
	 
	/* Creamos el archivo. $DESKTOP contiene la ruta de nuestro escritorio */
	 
	fileOpen $0 "$DESKTOP\Hola_mundo.txt" w
	 
	# escribimos en el archivo
	fileWrite $0 "Hola mundo!"
	 
	# cerramos el archivo
	fileClose $0
	# Informamos al usuario
	messageBox MB_OK "Hola_mundo.txt ha sido creado en tu escritorio!"
 
 
# fin de la seccion
sectionEnd
