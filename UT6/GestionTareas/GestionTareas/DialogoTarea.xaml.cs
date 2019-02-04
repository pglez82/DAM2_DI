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
using System.Windows.Shapes;

namespace GestionTareas
{
    /// <summary>
    /// Lógica de interacción para DialogoTarea.xaml
    /// </summary>
    public partial class DialogoTarea : Window
    {
        private LogicaNegocio logicaNegocio;
        public Tarea tarea { get; set; }
        //Indica si el formulario se va a utilizar para modificación o para alta
        private Boolean modificar = false;
        //En el caso de modificar, almacenamos que elemento estamos modificando (su orden en el datagrid y en la lista)
        private int indice;
        //Número de errores qu ehay en el formulario
        private int errores = 0;

        //Constructor para el caso de utilizar el formulario como alta
        public DialogoTarea(LogicaNegocio logicaNegocio)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            tarea = new Tarea();
            this.DataContext = this.tarea;
        }

        //Constructor para modificación
        public DialogoTarea(LogicaNegocio logicaNegocio, int indice,Tarea tarea)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            this.tarea = (Tarea)tarea.Clone();
            modificar = true;
            this.indice = indice;
            this.DataContext = this.tarea;
        }

        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (modificar)
                logicaNegocio.modificarTarea(tarea, indice);
            else
                logicaNegocio.aniadirTarea(tarea);
            this.Close();
        }

        /*
         * Manejador de los errores
         */
        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else
                errores--;

            if (errores == 0)
                ButtonAceptar.IsEnabled = true;
            else
                ButtonAceptar.IsEnabled = false;
        }
    }
}
