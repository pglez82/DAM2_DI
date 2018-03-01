package festexample2;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase encapsula la lista de vehículos. Solo va a haber una instancia de
 * esta clase y tendrán acceso a ella desde el frame y desde el diálogo de altas.
 * Si tuviesemos más de una instancia de esta clase sería un problema ya que implicaría
 * que tendríamos más de una lista de vehículos. 
 * @author pablo
 */
public class Metodos 
{
    private List<Vehiculo> listaVehiculos=new ArrayList<>();
    
    public void addVehiculo(Vehiculo vehiculo)
    {
        listaVehiculos.add(vehiculo);
    }
    
    public List<Vehiculo> getListaVehiculos()
    {
        return listaVehiculos;
    }
    
}
