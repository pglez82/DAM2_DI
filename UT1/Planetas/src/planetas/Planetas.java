/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas;

import planetas.dto.Planeta;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Planetas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            CSVReader reader = new CSVReader(new FileReader("exoplanetas.csv"),',');
            String [] nextLine;
            List<Planeta> listaPlanetas = new ArrayList<Planeta>();
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) 
            {
               double eje=-1;
               if (!"".equals(nextLine[1]))
                   eje = Double.parseDouble(nextLine[1]);
               
               double dias=-1;
               if (!"".equals(nextLine[2]))
                   dias = Double.parseDouble(nextLine[2]);
               
               double excentricidad=-1;
               if (!"".equals(nextLine[3]))
                   excentricidad = Double.parseDouble(nextLine[3]);
               
               listaPlanetas.add(new Planeta(nextLine[0],eje,dias,excentricidad));
            }
            //System.out.println(listaPlanetas);
            
            double mediaeje=0;
            int contador=0;
            int mayores30=0;
            int excentricidadnula=0;
            int kepler=0;
            for (Planeta planeta : listaPlanetas)
            {
                if (planeta.getEje()>=0)
                {
                    mediaeje+=planeta.getEje();
                    contador++;
                }
                if (planeta.getPeriodo()>30)
                    mayores30++;
                if (planeta.getExcentricidad()==-1)
                    excentricidadnula++;
                if (planeta.getNombre().startsWith("Kepler"))
                    kepler++;
            }
            mediaeje/=contador;
            System.out.println("La media del eje es: "+mediaeje);
            System.out.println("Mayores de 30: "+mayores30);
            System.out.println("Excentricidad nula: "+excentricidadnula);
            System.out.println("Kepler:"+kepler);
            
            //Ordenamos la lista
            listaPlanetas.sort(new Comparator<Planeta>() {
                @Override
                public int compare(Planeta o1, Planeta o2) {
                    return Double.compare(o1.getEje(),o2.getEje());
                }
            });
            
            
            CSVWriter writer = new CSVWriter(new FileWriter("exoplanetasordenados.csv"),',',CSVWriter.NO_QUOTE_CHARACTER);
            for (Planeta planeta : listaPlanetas)
                writer.writeNext(planeta.toStringArray());
            
            
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    
    
    }
    
}
