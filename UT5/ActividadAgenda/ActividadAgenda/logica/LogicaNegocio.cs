using SolucionTareaUT6.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SolucionTareaUT6.logica
{
    public class LogicaNegocio
    {
        private ObservableCollection<EventoAgenda> ListaEventos;
        public ObservableCollection<EventoAgenda> ListaEventosFiltrada {get;set;}

        public LogicaNegocio()
        {
            ListaEventos = new ObservableCollection<EventoAgenda>();
            ListaEventosFiltrada = new ObservableCollection<EventoAgenda>();
            aniadirEvento(new EventoAgenda(DateTime.Now,"Ir al garaje","Concesionario Opel"));
            aniadirEvento(new EventoAgenda(DateTime.Now,"Ir a clase","Instituto"));
            filtraEventos(DateTime.Today);
        }


        public void aniadirEvento(EventoAgenda eventoAgenda)
        {
            ListaEventos.Add(eventoAgenda);
        }

        public void modificarEvento(EventoAgenda original, EventoAgenda modificado)
        {
            ListaEventos[ListaEventos.IndexOf(original)] = modificado;
        }

        public void filtraEventos(DateTime fecha)
        {
            ListaEventosFiltrada.Clear();
            foreach (EventoAgenda evento in ListaEventos)
            {
                if (evento.FechaHora.DayOfYear == fecha.DayOfYear)
                    ListaEventosFiltrada.Add(evento);
            }
        }

        /**
         * Devuelve la lista de fechas que habría que marcar en el calendario
         * */
        public List<DateTime> getListaFechas()
        {
            List<DateTime> fechas = new List<DateTime>();
            foreach (EventoAgenda evento in ListaEventos)
                fechas.Add(evento.FechaHora);
            return fechas;
        }

        public void borrarEvento(EventoAgenda eventoAgenda)
        {
            ListaEventos.Remove(eventoAgenda);
        }
    }
}
