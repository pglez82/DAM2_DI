/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festexample;

import org.fest.swing.core.Robot;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;

/**
 *
 * @author pablo
 */
public class FrameEjemploTest extends FestSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        FrameEjemplo frame = GuiActionRunner.execute(new GuiQuery<FrameEjemplo>() {
            @Override
            protected FrameEjemplo executeInEDT() {
                return new FrameEjemplo();
            }
        });

        Robot robot = robot();
        robot.settings().delayBetweenEvents(1000);
        window = new FrameFixture(robot, frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void copiaTextoAlPulsarBoton() {
        window.textBox("entradaTextField").setText("Pongo este texto");
        window.button("aceptarButton").click();
        window.label("salidaLabel").requireText("Pongo este texto");
    }
}
