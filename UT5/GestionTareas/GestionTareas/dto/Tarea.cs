using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionTareas.dto
{
    public class Tarea : ICloneable,INotifyPropertyChanged,IDataErrorInfo
    {
        private string titulo;
        public String Titulo
        {
            get
            {
                return titulo;
            }
            set
            {
                this.titulo = value;
                PropertyChanged(this, new PropertyChangedEventArgs("Titulo"));
            }
        }
        private DateTime fechaLimite;
        public DateTime FechaLimite
        {
            get
            {
                return fechaLimite;
            }
            set
            {
                this.fechaLimite = value;
                PropertyChanged(this, new PropertyChangedEventArgs("FechaLimite"));
            }
        }
        private Boolean finalizada;
        public Boolean Finalizada
        {
            get
            {
                return finalizada;
            }
            set
            {
                this.finalizada = value;
                PropertyChanged(this, new PropertyChangedEventArgs("Finalizada"));
            }
        }
        private string descripcion;
        public string Descripcion
        {
            get
            {
                return descripcion;
            }
            set
            {
                this.descripcion = value;
                PropertyChanged(this, new PropertyChangedEventArgs("Descripcion"));
            }
        }

        public Boolean TareaProxima
        {
            get
            {
                return (FechaLimite - DateTime.Now).TotalDays <= 2;
            }
        }

        public Tarea()
        {
            fechaLimite = DateTime.Now;
        }

        public Tarea(string titulo, DateTime fechaLimite, Boolean finalizada, string descripcion)
        {
            this.titulo = titulo;
            this.fechaLimite = fechaLimite;
            this.finalizada = finalizada;
            this.descripcion = descripcion;
        }

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Error
        {
            get { return ""; }
        }

        /*
         * Método de validación. Verificamos que el título no sea vacío y no tenga más de 50 caracteres.
         */
        public string this[string columnName]
        {
            get
            {
                string result = "";
                if (columnName == "Titulo")
                {
                    if (string.IsNullOrEmpty(titulo) || titulo.Length>50)
                        result = "Debe introducir el título y debe ser menor de 50 caracteres";
                }
                return result;
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        

    }
}
