

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Verificador3Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Verificador3Test
{
    @Test
    public void testEsAutomorfoSugerencia(){
        int [][] matriz = {{0,1,0,0,0},
                           {1,0,1,0,0},
                           {0,1,0,1,0},
                           {0,0,1,0,1},
                           {0,0,0,1,0}};
        Grafo grafo = new Grafo(matriz);
        Verificador3 verificador= new Verificador3();
        System.out.println(verificador.esAutomorfoSugerencia(grafo));
        assertEquals("",verificador.esAutomorfoSugerencia(grafo));
    }
}
