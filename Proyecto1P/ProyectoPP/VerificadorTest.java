

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VerificadorTest.
 *
 * @author  CRISTHIAN ZENTENO BRAÑEZ
 * @version (a version number or a date)
 */
public class VerificadorTest
{
    @Test
    public void testAutomorfo(){
        int[][] matriz = {{0,1,0,0,1},
                          {1,0,1,0,0},
                          {0,1,0,1,0},
                          {0,0,1,0,1},
                          {1,0,0,1,0}};
        Grafo grafo = new Grafo(matriz);
        Verificador verificador = new Verificador();
        assertTrue(verificador.esAutomorfo(grafo));
    }
    
    @Test
    public void testIsomorfismo(){
        int[][] matriz ={{0,1,0,1},
                         {1,0,1,0},
                         {0,1,0,1},
                         {1,0,1,0}};
        Grafo a = new Grafo(matriz);            
        int[][] matriz2 ={{0,0,1,1},
                          {0,0,1,1},
                          {1,1,0,0},
                          {1,1,0,0}};
        Grafo b = new Grafo(matriz2); 
        Verificador verificador = new Verificador();
        assertTrue(verificador.sonIsomorfos(a,b));
    }
    
    
    
}
