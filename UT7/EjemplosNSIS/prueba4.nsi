# nombre del instalador
outFile "prueba4.exe"
 
# establecemos el escritorio como directorio de instalacion
InstallDir $DESKTOP
 
# seccion del instalador
section
 
	# definimos el directorio a donde vamos a extraer el test.txt
	setOutPath $INSTDIR
	 
	# especificamos el archivo
	File test.txt
	 
	# definimos el desinstalador y su nombre
	writeUninstaller $INSTDIR\uninstaller.exe
	 
	# fin de la seccion con el instalador
sectionEnd
 
# Creamos una seccion para definir el comportamiento del desinstalador
# siempre se va a llamar uninstall
section "Uninstall"
	 
	# Borramos primero el desinstalador
	delete $INSTDIR\uninstaller.exe
	 
	# borramos el archivo que habiamos instalado
	delete $INSTDIR\test.txt
 
sectionEnd
