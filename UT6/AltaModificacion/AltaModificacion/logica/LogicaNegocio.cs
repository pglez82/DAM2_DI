using AltaModificacion.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AltaModificacion.logica
{
    public class LogicaNegocio
    {
        public ObservableCollection<Persona> ListaPersonas { get; set; }

        public LogicaNegocio()
        {
            ListaPersonas = new ObservableCollection<Persona>();
            ListaPersonas.Add(new Persona("Pablo", "Gonzalez"));
            ListaPersonas.Add(new Persona("Cármen", "Sánchez"));
        }
    }
}
