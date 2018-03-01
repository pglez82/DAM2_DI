/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

import junit.framework.TestCase;

/**
 *
 * @author usuario
 */
public class CalculandoTest extends TestCase {
    
    private Calculando calculando;
    
    //Este método se ejecuta al principio
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculando = new Calculando();
    }

    //Este método se ejecuta al final
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of add method, of class Calculando.
     */
    public void testAdd() {
        System.out.println("add");
        double number1 = 0.0;
        double number2 = 0.0;
        double expResult = 0.0;
        double result = calculando.add(number1, number2);
        assertEquals("La suma no devuelve el resultado correcto",expResult, result);
        
        //assertEquals(5,calculando.add(3,2));
    }

    /**
     * Test of subtract method, of class Calculando.
     */
    public void testSubtract() {
        System.out.println("subtract");
        double number1 = 5.0;
        double number2 = 2.0;
        double expResult = 3.0;
        double result = calculando.subtract(number1, number2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of multiply method, of class Calculando.
     */
    public void testMultiply() {
        System.out.println("multiply");
        double number1 = 0.0;
        double number2 = 0.0;
        double expResult = 0.0;
        double result = calculando.multiply(number1, number2);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class Calculando.
     */
    public void testDivide() {
        System.out.println("divide");
        double number1 = 5.0;
        double number2 = 1.0;
        double expResult = 5.0;
        double result = calculando.divide(number1, number2);
        assertEquals(expResult, result);
        
    }

}
