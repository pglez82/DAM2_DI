using SolucionTareaUT6.dto;
using SolucionTareaUT6.logica;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace ActividadAgenda
{
    /// <summary>
    /// Lógica de interacción para VentanaEvento.xaml
    /// </summary>
    public partial class VentanaEvento : Window
    {
        private LogicaNegocio logicaNegocio;
        private bool modificar;
        private int errores;

        //Objecto que utilizamos para hacer binding con el formulario
        public EventoAgenda eventoAgenda {get; set;}
        private EventoAgenda original;

        //Constructor para la ventana cuando queremos un evento nuevo. Recibimos la fecha
        //seleccionada para autorellenarla en el formulario
        public VentanaEvento(LogicaNegocio logicaNegocio, DateTime fechaSeleccionada)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            //Si el formulario es de añadir, iniciamos EventoAgenda
            eventoAgenda = new EventoAgenda(fechaSeleccionada);
            this.modificar = false;
            this.DataContext = eventoAgenda;
        }

        public VentanaEvento(LogicaNegocio logicaNegocio, EventoAgenda eventoModificar)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            eventoAgenda = (EventoAgenda)eventoModificar.Clone();
            original = eventoModificar;
            this.modificar = true;
            this.DataContext = eventoAgenda;
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (modificar)
            {
                logicaNegocio.modificarEvento(original, eventoAgenda);
            }
            else
            {
                logicaNegocio.aniadirEvento(eventoAgenda);
            }
            this.Close();
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs args)
        {
            if (args.Action == ValidationErrorEventAction.Added)
                errores++;
            else if (args.Action == ValidationErrorEventAction.Removed)
                errores--;

            if (errores == 0)
                ButtonAceptar.IsEnabled = true;
            else
                ButtonAceptar.IsEnabled = false;
        }
    }

}
