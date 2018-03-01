/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package festexample2;

import java.util.Calendar;
import org.fest.swing.core.Robot;
import org.fest.swing.data.TableCell;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;

/**
 *
 * @author pablo
 */
public class PrincipalTest extends FestSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        Principal frame = GuiActionRunner.execute(new GuiQuery<Principal>() {
            @Override
            protected Principal executeInEDT() {
                return new Principal();
            }
        });
        
        Robot robot = robot();
        //robot.settings().delayBetweenEvents(100);
        window = new FrameFixture(robot, frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void testAlta() {
        window.button("buttonNuevo").click();
        Calendar fechaAlta = Calendar.getInstance();
        fechaAlta.set(Calendar.DAY_OF_MONTH, 15);
        //Cuidado con esto porque el primer mes es el cero
        fechaAlta.set(Calendar.MONTH,10);
        fechaAlta.set(Calendar.YEAR, 2010);
        String matriculaAlta = "6666FHH";
        String modeloAlta = "Renault 5";
        
        //Obtenemos el diálogo de alta y rellenamos sus datos
        DialogFixture altaDialog = window.dialog("altaDialog");
        altaDialog.textBox("editMatricula").setText(matriculaAlta);
        altaDialog.textBox("editModelo").setText(modeloAlta);
        altaDialog.spinner().select(fechaAlta.getTime());
        altaDialog.button("botonAceptar").click();
        
        //Una vez que hemos dado el alta, pasamos a verificar que se ha dado de alta en la tabla
        window.table("tablaVehiculos").requireRowCount(1);
        window.table("tablaVehiculos").requireCellValue(TableCell.row(0).column(0), matriculaAlta);
        window.table("tablaVehiculos").requireCellValue(TableCell.row(0).column(1), modeloAlta);
        window.table("tablaVehiculos").requireCellValue(TableCell.row(0).column(2), "15/11/2010");
        //assertTrue("Deberíamos tener una fila y tenemos otro número",window.table("tablaVehiculos").rowCount()==1);
        //String[][] contenidos = window.table("tablaVehiculos").contents();
        //assertTrue("Comprobamos la matricula",contenidos[0][0].equals(matriculaAlta));
        //assertTrue("Comprobamos el modelo",contenidos[0][1].equals(modeloAlta));
        //assertTrue("Comprobamos la fecha",contenidos[0][2].equals("15/11/2010"));
    }
}
