using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Bindings.dto
{
    public class Persona : INotifyPropertyChanged
    {
        private String nombre;
        public String Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                this.nombre = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Nombre"));
            }
        }
        private String apellidos;
        public String Apellidos
        {
            get
            {
                return apellidos;
            }
            set
            {
                this.apellidos = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Apellidos"));
            }
        }

        public Persona(String nombre, String apellidos)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        public override string ToString()
        {
            return nombre + " " + apellidos;
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
