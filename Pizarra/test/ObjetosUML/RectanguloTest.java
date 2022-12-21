/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ObjetosUML;

import Interfaz.PizarraVista;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author catal
 */
public class RectanguloTest {
    
    public RectanguloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of OtraPizarra method, of class Rectangulo.
     */
    @Test
    public void testOtraPizarra() {
        System.out.println("OtraPizarra");
        PizarraVista p = null;
        Rectangulo instance = null;
        instance.OtraPizarra(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of status method, of class Rectangulo.
     */
    @Test
    public void testStatus() {
        System.out.println("status");
        boolean b = false;
        Rectangulo instance = null;
        instance.status(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
