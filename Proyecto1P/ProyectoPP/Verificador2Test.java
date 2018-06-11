

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Verificador2Test.
 *
 * @author  CRISTHIAN ZENTENO BRAÑEZ
 * @version (a version number or a date)
 */
public class Verificador2Test
{
    @Test
    public void testReporteIsomorfismo(){
        int[][] matriz ={{0,1,0,0},
                        {1,0,1,0},
                        {0,1,0,1},
                        {0,0,1,0}};
        Grafo a = new Grafo(matriz);            
        int[][] matriz2 ={{0,0,1,1},
                          {0,0,1,1},
                          {1,1,0,0},
                          {1,1,0,0}};
        Grafo b = new Grafo(matriz2); 
        Verificador2 verificador = new Verificador2();            
        System.out.println(verificador.sonIsomorfosSugerencia(a,b));
        assertEquals("aumentar arista: (0,3)\n"+"aumentar arista: (3,0)\n",verificador.sonIsomorfosSugerencia(a,b));
    }
    
    @Test
    public void testReporteAutomorfo(){
        int[][] matriz ={{0,1,0,0,0},
                         {1,0,1,0,0},
                         {0,1,0,1,0},
                         {0,0,1,0,1},
                         {0,0,0,1,0}};
        Grafo a = new Grafo(matriz);
        Verificador2 verificador = new Verificador2();            
        System.out.println(verificador.esAutomorfoSugerencia(a));
        //assertEquals("aumentar arista: (0,3)\n"+"aumentar arista: (3,0)\n",verificador.sonIsomorfosSugerencia(a,b));
    }
    
}
