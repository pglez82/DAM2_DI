outfile "prueba8.exe"

Var JavaInstallationPath
Section "Encontrar Java"   
    DetectTry1:
    StrCpy $1 "SOFTWARE\JavaSoft\Java Runtime Environment"  
    StrCpy $2 0  
    ReadRegStr $2 HKLM "$1" "CurrentVersion"  
    StrCmp $2 "" DetectTry2 JRE 
    JRE:
    ReadRegStr $5 HKLM "$1\$2" "JavaHome"  
    StrCmp $5 "" DetectTry2 GetValue    

    DetectTry2:  
    ReadRegStr $2 HKLM "SOFTWARE\JavaSoft\Java Development Kit" "CurrentVersion"  
    StrCmp $2 "" NoJava JDK 
    JDK:
    ReadRegStr $5 HKLM "SOFTWARE\JavaSoft\Java Development Kit\$2" "JavaHome"  
    StrCmp $5 "" NoJava GetValue

    GetValue:
    StrCpy $JavaInstallationPath $5
    Messagebox MB_OK "Java esta instalado. Su directorio es: $JavaInstallationPath"
    Goto done

    NoJava:  
    Messagebox MB_OK "No se ha encontrado java. Instalando."  
    # Install Java
    ExecWait "$INSTDIR\java\instalador_java.exe"
    Goto DetectTry1

    done:   
    #$JavaInstallationPath esta la ruta a java
SectionEnd  
