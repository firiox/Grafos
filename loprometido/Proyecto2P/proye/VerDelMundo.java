

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VerDelMundo.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VerDelMundo
{
    /**
     * Default constructor for test class VerDelMundo
     */
    public VerDelMundo()
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
        Semaforo semaforo1 = new Semaforo(50000, 5000, 60000, "");
        Vertice vertice1 = new Vertice();
        assertEquals(null, vertice1.getSemaforos());
        assertEquals(true, vertice1.setSemaforo(semaforo1));
        assertNotNull(vertice1.getSemaforos());
        Semaforo semaforo2 = new Semaforo(6, 6, 6, "");
        vertice1.setSemaforo(semaforo2);
        int numeroDeSemaforosObtenido = vertice1.getSemaforos().length;
        assertSame( 2 , numeroDeSemaforosObtenido);
        Semaforo semaforo3 = new Semaforo(7, 7, 7, "");
        vertice1.setSemaforo(semaforo3);
        numeroDeSemaforosObtenido = vertice1.getSemaforos().length;
        assertSame(numeroDeSemaforosObtenido , 3);
    }
}

