/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import logic.LogicaAplicacion;
import beans.Partido;

/**
 *
 * @author alumno
 */
public class Partidos {

    private static void menu() {
        System.out.println("------------ MENU ---------------");
        System.out.println("1- Dar de alta un nuevo partido.");
        System.out.println("2- Mostar listado.");
        System.out.println("3- Borrado de un partido.");
        System.out.println("4- Mostrar los partidos ordenados.");
        System.out.println("5- Mostrar partidos de una división.");
        System.out.println("6- Salir y guardar.");
        System.out.println("");
    }

    public static void mostrarListadoPartidos(List<Partido> lista) {
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.print(i + "\t");
                System.out.println(lista.get(i));
            }
        } else {
            System.out.println("Listado vacio.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Scanner t = new Scanner(System.in);
        logic.LogicaAplicacion l = new LogicaAplicacion();
        boolean salir = false;
        int opc;

        String eqLocal, eqVisitante, resultado;
        Date fecha = null;
        int division;
        Partido.Divisiones d = null;
        do {
            menu();
            opc = Integer.parseInt(t.nextLine());
            switch (opc) {
                case 1:
                    System.out.println("Introduce el nombre del equipo local:");
                    eqLocal = t.nextLine();
                    System.out.println("Introduce el nombre del equipo visitante:");
                    eqVisitante = t.nextLine();
                    System.out.println("Introduce el resultado:");
                    resultado = t.nextLine();
                    System.out.println("DIVISIONES A ELEGIR:\n1- PRIMERA \n2- SEGUNDA \n3- TERCERA");
                    System.out.println("Introduce la Division");
                    division = Integer.parseInt(t.nextLine());

                    switch (division) {
                        case 1:
                            d = Partido.Divisiones.PRIMERA;
                            break;
                        case 2:
                            d = Partido.Divisiones.SEGUNDA;
                            break;
                        case 3:
                            d = Partido.Divisiones.TERCERA;
                            break;
                    }
                    System.out.println("Introduce una fecha... FORMARO dd/mm/yyyy");
                    String f = t.nextLine();
                     {
                        try {
                            fecha = sdf.parse(f);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                    Partido p = new Partido(eqLocal, eqVisitante, resultado, d, fecha);
                    System.out.println(p.toString());
                    l.altaNuevoPartido(p);
                    break;
                case 2:
                    mostrarListadoPartidos(l.getPartidos());
                    break;
                case 3:
                    System.out.println("Introduce el numero de partido");
                    int num = Integer.parseInt(t.nextLine());
                    try {
                        l.borradoPartido(num);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("ascendente o descendente??");
                    String orden = t.nextLine();
                    mostrarListadoPartidos(l.listaPartidosOrdenados(orden));
                    break;

                case 5:
                    System.out.println("Introduce la Division... 1 , 2 o 3");
                    division = Integer.parseInt(t.nextLine());

                    switch (division) {
                        case 1:
                            d = Partido.Divisiones.PRIMERA;
                            break;
                        case 2:
                            d = Partido.Divisiones.SEGUNDA;
                            break;
                        case 3:
                            d = Partido.Divisiones.TERCERA;
                            break;
                    }
                    mostrarListadoPartidos(l.listaPartidosDivision(d));
                    break;

                case 6:
                    salir = true;
                    l.guardarEnFichero();
                    break;
            }
        } while (!salir);
    }

}
