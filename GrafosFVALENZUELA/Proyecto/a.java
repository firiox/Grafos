

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class a.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class a
{
    /**
     * Default constructor for test class a
     */
    public a()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    
    

    

    @Test
    public void TESTesNumeroDeVerticesPar()
    {
        gHashMap g = new gHashMap();
        g.anadir(0 , 1);
        g.anadir(1, 2);
        g.anadir(2, 0);
        assertEquals(false , g.esNumeroDeVerticesPar());
        g.anadir(0, 3);
        assertEquals(true, g.esNumeroDeVerticesPar());
        g.anadir(1, 3);        
        assertEquals(true, g.esNumeroDeVerticesPar());
        g.anadir(4, 0);
        assertEquals(false, g.esNumeroDeVerticesPar());
    }

    @Test
    public void TESTesNumeroDeAristasPar()
    {
        gHashMap gHashMap1 = new gHashMap();
        gHashMap1.anadir(0 , 1);
        assertEquals(false, gHashMap1.esNumeroDeAristasPar());
        gHashMap1.anadir(1, 2);
        assertEquals(true, gHashMap1.esNumeroDeAristasPar());
        gHashMap1.anadir(2 , 0);
        assertEquals(false, gHashMap1.esNumeroDeAristasPar());
        gHashMap1.anadir(2, 3);
        assertEquals(true, gHashMap1.esNumeroDeAristasPar());        
        gHashMap1.anadir(5, 2);
        assertEquals(false, gHashMap1.esNumeroDeAristasPar());
    }

   

    @Test
    public void es_isomorfo()
    {
        gHashMap g = new gHashMap();
        g.anadir(0, 1);
        assertEquals(false, g.esIsomorfo());
        g.anadir(1, 2);
        assertEquals(false, g.esIsomorfo());
        g.anadir(2, 0);
        assertEquals(false, g.esIsomorfo());
        g.anadir(0, 3);
        assertEquals(true, g.esIsomorfo());
        g.anadir(3, 2);
        assertEquals(false, g.esIsomorfo());
    }

    @Test
    public void Testcomplemento()
    {
        gHashMap g = new gHashMap();
        g.anadir(0, 1);
        g.anadir(0, 2);
        //assertEquals(true, g.getComplemento());
    }
    //no importa
    @Test
    public void TestComplemento2()
    {
        //INSPECCIONAR PARA LOS CREAR LOS GRAFOS RESPUESTA Y HACER BIEN EL ASSERT XD
        gHashMap g = new gHashMap();
        g.anadir(0, 1);
        g.anadir(0, 2);
        //assertEquals(true, g.getComplemento());
        g.anadir(1, 3);
        //assertEquals(true, g.getComplemento());
    }

    @Test
    public void TESTINICIABLE()
    {
        gHashMap gHashMap1 = new gHashMap();
        gHashMap1.anadir(0, 1);
        gHashMap1.anadir(1, 2);
        gHashMap1.anadir(1, 3);
        gHashMap1.anadir(2, 3);
        gHashMap gHashMap2 = new gHashMap();
        gHashMap2.anadir(0, 2);
        gHashMap2.anadir(2, 3);
        gHashMap2.anadir(3, 1);
        gHashMap2.anadir(1, 0);
        assertEquals(false, gHashMap1.esIniciable(gHashMap2));
        gHashMap gHashMap3 = new gHashMap();
        gHashMap3.anadir(0, 3);
        gHashMap3.anadir(3, 2);
        gHashMap3.anadir(0, 2);
        gHashMap3.anadir(1, 2);
        assertEquals(true, gHashMap1.esIniciable(gHashMap3));
    }

    @Test
    public void HHHH()
    {
        gHashMap g = new gHashMap();
        g.anadir(0, 1);
        assertEquals(false, g.esNumeroDeAristasPar());
    }

    @Test
    public void TESTINICIABLE2()
    {
        gHashMap g1 = new gHashMap();
        g1.anadir(0, 1);
        g1.anadir(0, 2);
        g1.anadir(2, 1);
        g1.anadir(0, 3);
        g1.anadir(3, 4);
        g1.anadir(3, 5);
        gHashMap g2 = new gHashMap();
        g2.anadir(0, 2);
        g2.anadir(1, 2);
        g2.anadir(2, 3);
        g2.anadir(3, 4);
        g2.anadir(4, 5);
        g2.anadir(3, 5);
        assertEquals(true, g1.esIniciable(g2));
    }

    @Test
    public void TESTINICIABLE3()
    {
        gHashMap g1 = new gHashMap();
        g1.anadir(0, 1);
        g1.anadir(0, 2);
        g1.anadir(2, 1);
        g1.anadir(0, 3);
        g1.anadir(3, 4);
        g1.anadir(3, 5);
        gHashMap g2 = new gHashMap();
        g2.anadir(0, 1);
        g2.anadir(1, 2);
        g2.anadir(2, 5);
        g2.anadir(5, 4);
        g2.anadir(1, 4);
        g2.anadir(3, 4);
        assertEquals(true, g1.esIniciable(g2));
        gHashMap g3 = new gHashMap();
        g3.anadir(0, 1);
        g3.anadir(0, 3);
        g3.anadir(0, 2);
        g3.anadir(0, 4);
        g3.anadir(1, 5);
        g3.anadir(3, 6);
        assertEquals(false, g1.esIniciable(g3));
    }

    @Test
    public void TESTDDD()
    {
    }

    @Test
    public void TESTESISOMORFOCON1()
    {
        gHashMap G1 = new gHashMap();
        G1.anadir(0, 1);
        G1.anadir(1, 2);
        G1.anadir(2, 3);
        G1.anadir(1, 3);
        gHashMap G2 = new gHashMap();
        G2.anadir(0, 3);
        G2.anadir(0, 2);
        G2.anadir(2, 3);
        G2.anadir(1, 2);
        gHashMap G3 = new gHashMap();
        G3.anadir(0, 2);
        G3.anadir(0, 1);
        G3.anadir(1, 2);
        G3.anadir(2, 3);
        assertEquals(true, G1.esIsomorfoCON(G2));
        assertEquals(true, G2.esIsomorfoCON(G1));
        assertEquals(true, G2.esIsomorfoCON(G3));
        assertEquals(true, G3.esIsomorfoCON(G1));
        assertEquals(true, G3.esIsomorfoCON(G2));
        
        
    }

    @Test
    public void TESTISOMORFOCON2()
    {
        gHashMap G1 = new gHashMap();
        G1.anadir(0, 2);
        G1.anadir(1, 2);
        G1.anadir(2, 3);
        G1.anadir(3, 4);
        G1.anadir(4, 5);
        G1.anadir(3, 5);
        gHashMap G2 = new gHashMap();
        G2.anadir(0, 1);
        G2.anadir(1, 2);
        G2.anadir(1, 4);
        G2.anadir(2, 5);
        G2.anadir(4, 5);
        G2.anadir(3, 4);
        assertEquals(false, G1.esIsomorfoCON(G2));
    }
}














