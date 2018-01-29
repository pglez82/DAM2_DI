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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ActividadAgenda
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public LogicaNegocio logicaNegocio { get; set; } 
        public MainWindow()
        {
            InitializeComponent();
            logicaNegocio = new LogicaNegocio();
            this.DataContext = this;
        }

        private void MenuAniadirEvento_Click(object sender, RoutedEventArgs e)
        {
            VentanaEvento ventanaEvento = new VentanaEvento(logicaNegocio, CalendarAgenda.SelectedDate.Value);
            ventanaEvento.ShowDialog();
            filtraEventos();
            repintarSeleccionados();
        }

        private void CalendarAgenda_SelectedDatesChanged(object sender, SelectionChangedEventArgs e)
        {
            filtraEventos();
            //Repintamos los elementos seleccionados en el calendario
            repintarSeleccionados();
        }

        private void DatagridEventos_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            modificarEvento();
        }

        private void filtraEventos()
        {
            if (CalendarAgenda.SelectedDate != null)
            {
                DateTime selectedDate = CalendarAgenda.SelectedDate.Value;
                logicaNegocio.filtraEventos(selectedDate);
            }
        }

        private void repintarSeleccionados()
        {
            //CalendarAgenda.SelectedDates.Clear();
            foreach (DateTime dt in logicaNegocio.getListaFechas())
                CalendarAgenda.SelectedDates.Add(dt);
        }

        private void ButtonEliminar_Click(object sender, RoutedEventArgs e)
        {
            EventoAgenda seleccionado = (EventoAgenda)DatagridEventos.SelectedItem;
            if (seleccionado != null)
                logicaNegocio.borrarEvento(seleccionado);
            else
                MessageBox.Show("Debe seleccionar un evento para borrar");
            filtraEventos();
        }

        private void ButtonModificar_Click(object sender, RoutedEventArgs e)
        {
            modificarEvento();
        }

        //Lo pongo en una función porque lo llamo desde el menú y desde el botón.
        private void modificarEvento()
        {
            EventoAgenda seleccionado = (EventoAgenda)DatagridEventos.SelectedItem;
            if (seleccionado != null)
            {
                VentanaEvento ventanaEvento = new VentanaEvento(logicaNegocio, seleccionado);
                ventanaEvento.ShowDialog();
                filtraEventos();
                repintarSeleccionados();
            }
            else
                MessageBox.Show("Debe seleccionar un evento para modificar");
        }

       
    }
}
