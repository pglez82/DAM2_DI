using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SolucionTareaUT6.dto
{
    public class EventoAgenda : ICloneable, IDataErrorInfo
    {
        public EventoAgenda(DateTime fh)
        {
            this.fechaHora = fh;
        }

        public EventoAgenda(DateTime fh, string texto, string lugar)
        {
            this.fechaHora = fh;
            this.texto = texto;
            this.lugar = lugar;
        }
        private string texto;
        public string Texto
        {
            get
            {
                return this.texto;
            }
            set
            {
                this.texto = value;
            }
        }

        private string lugar;
        public string Lugar
        {
            get
            {
                return this.lugar;
            }
            set
            {
                this.lugar = value;
            }
        }

        private DateTime fechaHora;
        public DateTime FechaHora
        {
            get
            {
                return fechaHora;
            }
            set
            {
                this.fechaHora = value;
            }
        }

        public int Horas
        {
            get
            {
                return fechaHora.Hour;
            }
            set
            {
                fechaHora = new DateTime(fechaHora.Year,fechaHora.Month,fechaHora.Day,value,fechaHora.Minute,0);
            }
        }
        public int Minutos
        {
            get
            {
                return fechaHora.Minute;
            }
            set
            {
                fechaHora = new DateTime(fechaHora.Year, fechaHora.Month, fechaHora.Day, fechaHora.Hour, value, 0);
            }
        }

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
            //Incluyo un par de validaciones para ejemplicar como se hace.
            get 
            {
                string error = "";
                if (columnName == "Texto" && string.IsNullOrEmpty(texto))
                    error = "Debe rellenar el texto del evento";
                else if (columnName == "Lugar"&& string.IsNullOrEmpty(lugar))
                    error = "Debe rellenar el lugar del evento";
                return error;
            }
        }
    }
}
