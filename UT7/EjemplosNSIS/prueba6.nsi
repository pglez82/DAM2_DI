#Crea un acceso directo apuntando a un desinstalador. El desinstalador
#lo que hace es borrar el acceso directo

# nombre del instalador
outFile "prueba6.exe"
 
# Directorio de instalacion
installDir $DESKTOP
 
# Necesario para borrar el acceso directo en Windows 7
RequestExecutionLevel user
 
# seccion por defecto
section
 
    # Directorio de instalacion para las acciones siguientes
    setOutPath $INSTDIR
 
    # Creamos el desinstalador
    writeUninstaller "$INSTDIR\uninstall.exe"
 
    # Creamos un acceso directo apuntando al desinstalador
    createShortCut "$SMPROGRAMS\Desinstalar.lnk" "$INSTDIR\uninstall.exe"
sectionEnd
 
# seccion del desintalador
section "uninstall"
 
    # borramos el desintalador primero
    delete "$INSTDIR\uninstall.exe"
 
    # borramos el acceso directo del menu de inicio
    delete "$SMPROGRAMS\Desinstalar.lnk"
 
# fin de la seccion del desinstalador
sectionEnd