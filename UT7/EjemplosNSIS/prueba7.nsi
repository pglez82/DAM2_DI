# Instalador que nos pregunta donde queremos instalar

# Nombre del instalador
Name "Instalador de ejemplo"

# The file to write
OutFile "prueba7.exe"

# The default installation directory
InstallDir $DESKTOP\Prueba7

# Pedimos permisos para Windows 7
RequestExecutionLevel user

# Pantallas que hay que mostrar del instalador

Page directory
Page instfiles

#Seccion principal
Section

  # Establecemos el directorio de salida al directorio de instalacion
  SetOutPath $INSTDIR
  
  # Ponemos ahi el archivo test.txt
  File test.txt
  
# Fin de la seccion
SectionEnd