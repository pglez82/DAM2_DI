using GestionTareas.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionTareas.logica
{
    public class LogicaNegocio
    {
        public ObservableCollection<Tarea> listaTareas{get;set;}

        public LogicaNegocio()
        {
            listaTareas = new ObservableCollection<Tarea>();
            listaTareas.Add(new Tarea("Primera tarea",DateTime.Now,false,"Descripción primera tarea"));
            listaTareas.Add(new Tarea("Segunda tarea", DateTime.Now, true, "Descripción segunda tarea"));
        }

        public void aniadirTarea(Tarea tarea)
        {
            listaTareas.Add(tarea);
        }

        public void modificarTarea(Tarea tarea, int posicion)
        {
            listaTareas[posicion] = tarea;
        }

    }
}
