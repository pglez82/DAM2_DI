using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AltaModificacion.dto
{
    public class Persona : INotifyPropertyChanged,ICloneable,IDataErrorInfo
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

        public Persona()
        {
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

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get 
            {
                string resultado = "";
                if (columnName == "Nombre")
                {
                    if (string.IsNullOrEmpty(Nombre))
                        resultado = "Error: El nombre no puede ser vacío";
                }
                else if (columnName == "Apellidos")
                {
                    if (string.IsNullOrEmpty(Apellidos))
                        resultado = "Error: Los apellidos no pueden estar vacíos";
                }

                return resultado;
            }
        }
    }

}
