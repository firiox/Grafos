
/**
 * Write a description of class Grafo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Grafo
{
    // instance variables - replace the example below with your own
    private Vertice[] vs;
    private Arista[] as ;
    private int numeroDeVertices,numeroDeAristas;
    /////////////////////
    private int pv, pa;
    private boolean configuracionEstandarSemaforos;
    /**
     * Constructor for objects of class Grafo
     */
    public Grafo(int numeroDeVertices, int numeroDeAristas)
    {
        vs = new Vertice[numeroDeVertices];
        as = new Arista[numeroDeAristas];
        pv = 0;
        pa = 0;
        this.numeroDeVertices = numeroDeVertices;
        this.numeroDeAristas = numeroDeAristas;
        configuracionEstandarSemaforos = false;
    }
    protected void setConfiguracionEstandar(boolean esta){  configuracionEstandarSemaforos = esta ;}
    public boolean estaConConfiguracionEstandar(){  return configuracionEstandarSemaforos; }
    public Vertice[] getVertices(){ return vs;}
    public Arista[] getAristas(){   return as;}
    public boolean setVertice(Vertice v){
        boolean res;
        if( pv < vs.length ){
        vs[pv] = v;
        ++pv;
        res = true;
      }else{ res =false;}        
      return res;
    }
    public boolean setArista(Arista a){
        boolean res;
        if( pa < as.length ){
        as[pa] = a;
        ++pa;
        res = true;
      }else{ res =false;}        
      return res;
    }
    
    public void setFuente(Vertice v, int flujoVehicular, int semaforo){
        v.setFlujo(flujoVehicular, semaforo);    
    }
    
    public void setFuente(Vertice v, int flujoVehicular ){
        v.setFlujo(flujoVehicular, 0);    
    }
    public String setSumidero(Vertice v){
        int nV = vs.length;
        int nA = as.length;
        for(int i=0; i < nV; i++){
            if(vs[i] != v){
                while( ! vs[i].getFlujo().equals("Hay un flujo de 0")  )
                for(int i2=0; i2 < nA; i2++){
                    as[i2].fluir();
                }
            }
            
        }
        String res = v.getFlujo();
        return res;
    }

    /*
    *   Para convertir el grafo a una matris de adyacencia 
    *
    */
    
    HashMap<Vertice,Integer> mapita = new HashMap<>();
    private void mapearVertices(){       
        for(int i=0; i<numeroDeVertices; i++){
            mapita.put(vs[i], (Integer)i );            
        }
    }
    
    public int getMapeoDelVertice(Vertice v){
        Integer i = mapita.get(v);
        return (int)i;
    }
    
    public int[][] getMatrizDelGrafo(){
        int[][] matriz = new int[numeroDeVertices][numeroDeVertices];
        for(int i=0;i<numeroDeVertices; i++){
            for(int j=0; j<numeroDeVertices; j++){
                matriz[i][j] = 0;
            }
        }
        for(int i=0; i<numeroDeAristas; i++){
            Vertice o = as[i].getOrigen();
            Vertice d = as[i].getDestino();
            int capacidad = as[i].getCapacidad();
            int om = getMapeoDelVertice(o);
            int dm = getMapeoDelVertice(d);
            matriz[om][dm] = capacidad;
            
        }
        return matriz;
    }
}
