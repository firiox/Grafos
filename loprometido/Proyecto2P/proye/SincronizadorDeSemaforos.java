import java.util.ArrayList;
/**
 * Write a description of class SincronizadorDeSemaforos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SincronizadorDeSemaforos
{
    private final static TiemposSemaforo configuracionEstandar = new TiemposSemaforo(30000, 5000, 30000);
    
    /**
     * Constructor for objects of class SincronizadorDeSemaforos
     */
    public SincronizadorDeSemaforos()
    {
       
    }
    
    public void sincronizar(Grafo g){
    /*  algoritmo para sincronizar los semaforos O_O*/
    g.setConfiguracionEstandar(false);
    Vertice[] v = g.getVertices();
    int nV = v.length;
    Arista[] a = g.getAristas();
    int nA = a.length;
    int _Alto_ = 70 ; // Tiempo, su unidad es segundos
        for(int i = 0; i < nA ; i++){
            Vertice oo = a[i].getOrigen();
            Vertice dd = a[i].getDestino();
            int sema = a[i].getSemaforo();
            int capacidadActual = a[i].getCapacidad();            
            oo.sincronizarSemaforo(capacidadActual, sema);
            dd.sincronizarSemaforo(capacidadActual, sema);
        }
        /*
        for(int i = 0; i < nV; i++){
            if(v[i].hayBloqueo()){
                // avisar a los vertices adyacentes
                for(int ij = 0; ij < nA ; ij++){
                    Vertice oo = a[ij].getOrigen();
                    Vertice dd = a[ij].getDestino();
                    if(v[i].getNombre().equals(oo.getNombre() ) ){
                        dd.setTiempoDeEspera( _Alto_ );
                    }
                }
            }
        }*/
    }
    public void sincronizarEstandar(Grafo g){
        g.setConfiguracionEstandar(true);
        Vertice[] vs = g.getVertices();
        int nV = vs.length;
        for(int i = 0; i < nV ; i++){
            Semaforo[] semaforos = vs[i].getSemaforos();
            int nS = semaforos.length;
            for(int i2 = 0; i2 < nS; i2++){
                
                semaforos[i2].setTiempos(configuracionEstandar.getTV(), configuracionEstandar.getTA(), configuracionEstandar.getTR() );
             }
        }
    }
    
    public String getReporteSemaforos(Grafo g){
        String reporte = ":";
        if( ! g.estaConConfiguracionEstandar() ){
            Vertice[] vs = g.getVertices();
            for(int i = 0; i < vs.length; i++){
                Semaforo[] sema = vs[i].getSemaforos();
                if(sema != null){
                    for(int i2 = 0; i2 < sema.length; i2++){
                        double[] tiempos = sema[i2].getTiemposDeCambio();
                        String n = sema[i2].getNombre();
                        String cambios = n + " tiempo de pase " + tiempos[1] 
                        + " tiempo de espera " + tiempos[0];
                        reporte = reporte + " " + cambios ;
                    }
                }
            }
        }
        else{   reporte = reporte + "Todos los semaforos estan en " + configuracionEstandar.toString() ;}
        return reporte;
    }

    
}
