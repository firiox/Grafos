

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FOOGRAF.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FOOGRAF
{
    /**
     * Default constructor for test class FOOGRAF
     */
    public FOOGRAF()
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
    public void hIPERMAXI()
    {
        //INICIA LA CREACION DE LOS VERTICES
        Vertice A = new Vertice();
        Vertice B = new Vertice();
        Vertice C = new Vertice();
        Vertice D = new Vertice();
        Vertice E = new Vertice();
        Vertice F = new Vertice();
        Vertice G = new Vertice();
        Vertice H = new Vertice();
        Vertice I = new Vertice();
        Vertice J = new Vertice();
        Vertice K = new Vertice();
        Vertice L = new Vertice();
        Vertice M = new Vertice();
        //INICIA LA CREACION DE LAS ARISTAS
        Arista bc = new Arista(B, C);
        Arista bc2 = new Arista(B, C);
        Arista cb = new Arista(C, B);
        Arista cb2 = new Arista(C, B);
        Arista cf = new Arista(C, F);
        Arista cf2 = new Arista(C, F);
        Arista fc = new Arista(F, C);
        Arista fc2 = new Arista(F, C);
        Arista fm = new Arista(F, M);
        Arista fm2 = new Arista(F, M);
        Arista mf = new Arista(M, F);
        Arista mf2 = new Arista(M, F);
        Arista bc3 = new Arista(B, C);
        Arista cb3 = new Arista(C, B);
        Arista cf3 = new Arista(C, F);
        Arista fc3 = new Arista(F, C);
        Arista fm3 = new Arista(F, M);
        Arista mf3 = new Arista(M, F);
        Arista jk = new Arista(J, K);
        Arista jk2 = new Arista(J, K);
        Arista ml = new Arista(M, L);
        Arista ml2 = new Arista(M, L);
        Arista lk = new Arista(L, K);
        Arista lk2 = new Arista(L, K);
        Arista bg = new Arista(B, G);
        Arista bg2 = new Arista(B, G);
        Arista gb = new Arista(G, B);
        Arista gb2 = new Arista(G, B);
        Arista gi = new Arista(G, I);
        Arista gi2 = new Arista(G, I);
        Arista ig = new Arista(I, G);
        Arista ig2 = new Arista(I, G);
        Arista ef = new Arista(E, F);
        Arista fh = new Arista(F, H);
        Arista hi = new Arista(H, I);
        Arista ij = new Arista(I, J);
        Arista ji = new Arista(J, I);
        Arista ih = new Arista(I, H);
        Arista hf = new Arista(H, F);
        Arista fe = new Arista(F, E);
        Arista dc = new Arista(D, C);
        Arista ef2 = new Arista(E, F);
        Arista fh2 = new Arista(F, H);
        Arista hi2 = new Arista(H, I);
        Arista ij2 = new Arista(I, J);
        Arista ji2 = new Arista(J, I);
        Arista ih2 = new Arista(I, H);
        Arista hf2 = new Arista(H, F);
        Arista fe2 = new Arista(F, E);
        Arista cd2 = new Arista(C, D);
        Arista dc2 = new Arista(D, C);
        Arista ad3 = new Arista(A, D);
        Arista de3 = new Arista(D, E);
        Arista ad = new Arista(A, D);
        Arista ad2 = new Arista(A, D);
        Arista de = new Arista(D, E);
        Arista de2 = new Arista(D, E);
        Arista hl = new Arista(H, L);
        Arista hl2 = new Arista(H, L);
        /*Primer grafo de prueba */
        Grafo grafoADE = new Grafo(3, 8);
        grafoADE.setVertice(A);
        grafoADE.setVertice(D);
        grafoADE.setVertice(E);
        grafoADE.setArista(ad3);
        grafoADE.setArista(de3);        
        grafoADE.setArista(de);
        grafoADE.setArista(de2);
        grafoADE.setArista(ad);
        grafoADE.setArista(ad2);        
        ad.setCapacidadDeFlujoNormal(4);
        ad2.setCapacidadDeFlujoNormal(4);
        de.setCapacidadDeFlujoNormal(4);
        de2.setCapacidadDeFlujoNormal(4);        
        /*Segundo grafo de prueba*/
        Grafo grafoBCFEHM = new Grafo(6, 26);
        grafoBCFEHM.setVertice(B);
        grafoBCFEHM.setVertice(C);
        grafoBCFEHM.setVertice(F);
        grafoBCFEHM.setVertice(E);
        grafoBCFEHM.setVertice(H);
        grafoBCFEHM.setVertice(M);
        grafoBCFEHM.setArista(bc);
        grafoBCFEHM.setArista(cf);
        grafoBCFEHM.setArista(fm);
        grafoBCFEHM.setArista(cf2);
        grafoBCFEHM.setArista(fm2);        
        grafoBCFEHM.setArista(bc2);
        grafoBCFEHM.setArista(bc3);
        grafoBCFEHM.setArista(cf3);
        grafoBCFEHM.setArista(fm3);
        grafoBCFEHM.setArista(fe);
        grafoBCFEHM.setArista(fe2);
        grafoBCFEHM.setArista(fh2);
        grafoBCFEHM.setArista(fh);
        /*Tercer grafo de prueba*/
        Grafo grafoGIJKLH = new Grafo(6, 20);
        grafoGIJKLH.setVertice(G);
        grafoGIJKLH.setVertice(I);
        grafoGIJKLH.setVertice(J);
        grafoGIJKLH.setVertice(K);
        grafoGIJKLH.setVertice(L);
        grafoGIJKLH.setVertice(H);
        grafoGIJKLH.setArista(gi);
        grafoGIJKLH.setArista(gi2);
        grafoGIJKLH.setArista(ih);
        grafoGIJKLH.setArista(ih2);
        grafoGIJKLH.setArista(hi);
        grafoGIJKLH.setArista(hi2);        
        grafoGIJKLH.setArista(hl);
        grafoGIJKLH.setArista(hl2);
        grafoGIJKLH.setArista(lk);
        grafoGIJKLH.setArista(lk2);
        grafoGIJKLH.setArista(jk);
        grafoGIJKLH.setArista(jk2);
        grafoGIJKLH.setArista(ij);
        grafoGIJKLH.setArista(ij2);
        /*Cuarto grafo de prueba*/
        Grafo grafoADEC = new Grafo(4, 4);
        grafoADEC.setVertice(A);
        grafoADEC.setVertice(D);
        grafoADEC.setVertice(E);
        grafoADEC.setVertice(C);
        grafoADEC.setArista(ad);
        grafoADEC.setArista(ad2);
        grafoADEC.setArista(dc);
        grafoADEC.setArista(de);
    }

    @Test
    public void fuenteSumideroT()
    {
        Vertice A = new Vertice();
        Vertice B = new Vertice();
        Vertice C = new Vertice();
        Arista arista3 = new Arista(A, B);
        Arista arista4 = new Arista(A, C);
        Vertice D = new Vertice();
        Arista arista5 = new Arista(B, D);
        Arista arista6 = new Arista(C, D);
        Grafo grafo3 = new Grafo(4, 4);
        grafo3.setVertice(A);
        grafo3.setVertice(B);
        grafo3.setVertice(C);
        grafo3.setVertice(D);
        grafo3.setArista(arista3);
        grafo3.setArista(arista4);
        grafo3.setArista(arista5);
        grafo3.setArista(arista6);
        arista3.setCapacidadDeFlujoNormal(2);
        arista4.setCapacidadDeFlujoNormal(2);
        arista5.setCapacidadDeFlujoNormal(2);
        arista6.setCapacidadDeFlujoNormal(2);
        grafo3.setFuente(A, 4);
        String obtenido = grafo3.setSumidero(D);
        assertEquals("Hay un flujo de 4", obtenido);
    }
}


