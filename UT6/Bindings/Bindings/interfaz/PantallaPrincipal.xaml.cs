using Bindings.dto;
using Bindings.interfaz;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace Bindings
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> ListaPersonas { get; set; } 

        public MainWindow()
        {
            InitializeComponent();
            ListaPersonas = new ObservableCollection<Persona>();
            ListaPersonas.Add(new Persona("Pablo", "Gonzalez"));
            ListaPersonas.Add(new Persona("Cármen", "Sánchez"));
            this.DataContext = this;
        }

        private void ComboboxPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            Persona p = (Persona)ComboboxPersonas.SelectedItem;
            LabelNombre.Content = p.Nombre;
        }

        private void ButtonAniadir_Click(object sender, RoutedEventArgs e)
        {
            ListaPersonas.Add(new Persona("Juan", "Fernández"));
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            PantallaSecundaria ps = new PantallaSecundaria();
            ps.ShowDialog();
            
        }
    }
}
