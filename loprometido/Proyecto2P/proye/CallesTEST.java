

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CallesTEST.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CallesTEST
{
    /**
     * Default constructor for test class CallesTEST
     */
    public CallesTEST()
    {
        setUp();
        asdfgh();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Vertice va = new Vertice();
        Vertice vb = new Vertice();
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
    
        Vertice va = new Vertice();
        Vertice vb = new Vertice();
    @Test
    public void asdfgh(){
        Calle calle0 = new Calle(2, va, vb, true);
        Arista[] aristasEsperado = {new Arista(va,vb), new Arista(va,vb), new Arista(vb,va), new Arista(vb,va)};
        Arista[] aristasObtenido = calle0.getAristas();
		for(int c = 0;c<4;c++){
        	assertEquals(aristasEsperado[c].toString2(), aristasObtenido[c].toString2() );
    	}
    }
}
