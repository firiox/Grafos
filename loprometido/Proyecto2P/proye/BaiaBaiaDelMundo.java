

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BaiaBaiaDelMundo.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BaiaBaiaDelMundo
{
    /**
     * Default constructor for test class BaiaBaiaDelMundo
     */
    public BaiaBaiaDelMundo()
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
    public void delMundo()
    {
        SincronizadorDeSemaforos sincroni1 = new SincronizadorDeSemaforos();
        Grafo grafo1 = new Grafo(3, 0);
        Vertice vertice1 = new Vertice();
        Vertice vertice2 = new Vertice();
        Vertice vertice3 = new Vertice();
        Semaforo semaforo1 = new Semaforo(60000, 6000, 60000, "Semaforo1");
        Semaforo semaforo2 = new Semaforo(70000, 7000, 70000, "Semaforo2");
        Semaforo semaforo3 = new Semaforo(10000, 4000, 20000, "Semaforo3");
        Semaforo semaforo4 = new Semaforo(10000, 6000, 90000, "Semaforo4");
        vertice1.setSemaforo(semaforo1);
        vertice1.setSemaforo(semaforo2);
        vertice2.setSemaforo(semaforo3);
        vertice3.setSemaforo(semaforo4);
        grafo1.setVertice(vertice1);
        grafo1.setVertice(vertice2);
        grafo1.setVertice(vertice3);
        java.lang.String string1 = sincroni1.getReporteSemaforos(grafo1);
        assertEquals(": Semaforo1 tiempo de pase 66.0 tiempo de espera 60.0 Semaforo2 tiempo de pase 77.0 tiempo de espera 70.0 Semaforo3 tiempo de pase 24.0 tiempo de espera 10.0 Semaforo4 tiempo de pase 96.0 tiempo de espera 10.0", string1);
    }
}

