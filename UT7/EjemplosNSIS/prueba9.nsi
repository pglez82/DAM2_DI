# Instalador que nos pregunta donde queremos instalar
# Ruta por defecto: archivos de programa
# Incluye informacion sobre la desisntalacion

# Nombre del instalador
Name "Instalador de ejemplo"

# The file to write
OutFile "prueba9.exe"

# The default installation directory
InstallDir $PROGRAMFILES\Prueba9

# Pedimos permisos para Windows 7
RequestExecutionLevel admin

# Pantallas que hay que mostrar del instalador

Page directory
Page instfiles

#Seccion principal
Section

  # Establecemos el directorio de salida al directorio de instalacion
  SetOutPath $INSTDIR
  
  # Creamos el desinstalador
  writeUninstaller "$INSTDIR\uninstall.exe"
  
  # Ponemos ahi el archivo test.txt
  File test.txt
  
  #Añadimos información para que salga en el menú de desinstalar de Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Prueba9" \
                 "DisplayName" "Prueba9"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Prueba9" \
                 "Publisher" "Pablo - Desarrollo Interfaces"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Prueba9" \
                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""
  
# Fin de la seccion
SectionEnd

# seccion del desintalador
section "uninstall"
 
    # borramos el desintalador primero
    delete "$INSTDIR\uninstall.exe"
 
    # borramos el acceso directo del menu de inicio
    delete "$INSTDIR\test.txt"
	
	RmDir "$INSTDIR"
	
	#Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Prueba9"
 
# fin de la seccion del desinstalador
sectionEnd