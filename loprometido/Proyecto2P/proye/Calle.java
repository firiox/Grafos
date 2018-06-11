
/**
 * Write a description of class Calle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calle
{
    private int nCarriles;    
    private Arista[] aristas;     
    private boolean dobleSentido;
    public int getNumeroDeCarriles(){   return nCarriles;}
    public boolean getDobleSentido(){   return dobleSentido;}
    /**
     * Constructor for objects of class Arista
     */
    public Calle(int numeroDeCarriles, Vertice origen, Vertice destino, boolean esDobleSentido)
    {
        nCarriles = numeroDeCarriles ;        
        dobleSentido = esDobleSentido;
        if(esDobleSentido){
          aristas = new Arista[numeroDeCarriles*2];
          for(int c=0; c<numeroDeCarriles; c++){
              aristas[c]= new Arista(origen,destino);
           }
          for(int c=numeroDeCarriles; c<numeroDeCarriles*2;c++){
              aristas[c] = new Arista(destino,origen);
           }
         }
         else{
            aristas = new Arista[numeroDeCarriles]; 
            for(int c=0; c<numeroDeCarriles; c++){
            aristas[c] = new Arista(origen, destino);            
            }
          }
    }
    public void setFlujoVehicular(int f){
        //flujoVehicular = f ;
    }
    
    public void trabajoNoPredefinido(int tiempoDelTrabajo, int flujoVehicular){
        /*cambia el flujo vehicular por un tiempo luego vuelve a su antiguo flujo vehicular*/
    }

    public Arista[] getAristas(){   return aristas;}

}
