/*Este instalador va a extraer un archivo test.txt al escritorio*/

# nombre del instalador
outfile "prueba3.exe"
 
# define el directorio donde se va a instalar. Cogemos la ruta del Escritorio
installDir $DESKTOP
 
# Seccion por defecto
section
 
	# Definimos la ruta en la que vamos a escribir el archivo
	setOutPath $INSTDIR
	 
	# Escribimos el archivo en la ruta de salida
	File test.txt
sectionEnd
