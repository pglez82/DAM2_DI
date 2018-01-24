using GestionTareas.dto;
using GestionTareas.logica;
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

namespace GestionTareas
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private LogicaNegocio logicaNegocio;

        public MainWindow()
        {
            InitializeComponent();
            logicaNegocio = new LogicaNegocio();
            DataGridTareas.DataContext = logicaNegocio;
        }

        private void MenuItemNuevo_Click(object sender, RoutedEventArgs e)
        {
            DialogoTarea dialogoTarea = new DialogoTarea(logicaNegocio);
            dialogoTarea.Show();
        }

        private void DataGridTareas_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            int selectedRow = DataGridTareas.SelectedIndex;
            if (selectedRow >= 0)
            {
                DialogoTarea dialogoTarea = new DialogoTarea(logicaNegocio, selectedRow, (Tarea)DataGridTareas.SelectedItem);
                dialogoTarea.Show();
            }
        }

        private void DataGridTareas_CellEditEnding(object sender, DataGridCellEditEndingEventArgs e)
        {
           
        }

       
    }
}
