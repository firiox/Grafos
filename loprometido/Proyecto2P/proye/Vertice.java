import java.util.Arrays;

/**
 * Write a description of class Vertice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Vertice
{
    private Semaforo[] semaforos;
    private int controlsemaforo;
    private int flujoVehicular;
    private final int maxNumeroDeSemaforos = 8 ;
    private String nombre;    
    private boolean hayUnaCuadraBloqueada; // Entiendase que este vertice puede tener varias cuadras
    /**
     * Constructor for objects of class Vertice
     */
    public Vertice()
    {
        semaforos = new Semaforo[ maxNumeroDeSemaforos];
        controlsemaforo = 0;
        flujoVehicular = 0;
        nombre = null;
    }
    public boolean hayBloqueo(){    return hayUnaCuadraBloqueada;}
    public void setNombre(String n){    nombre = n;}
    public String getNombre(){  return nombre;}
    
    public boolean setSemaforo(Semaforo s){
        boolean res;
        if(controlsemaforo<semaforos.length){
        semaforos[controlsemaforo] = s;
        res = true;
        ++controlsemaforo;
    }else{  res = false; }
        return res;
    }
    public double setFlujo(int f, int semaforo){
        double res = f;
        if(semaforos[semaforo] != null ){
            double[] tiempos = semaforos[semaforo].getTiemposDeCambio();
            /*Nos importa que pase */
            double tiempoDePase = tiempos[1];
            res = tiempoDePase > f ? f : tiempoDePase;
            flujoVehicular += res;
        }
        else{   flujoVehicular += f;    }
        
        return res;
    }
    
    protected int getFlujo2(int capacidadMaxima ){ 
        int res;
        res = flujoVehicular>capacidadMaxima? capacidadMaxima : flujoVehicular;
        flujoVehicular -= res;
        return res;
    }
    
    public String getFlujo(){ return "Hay un flujo de " + flujoVehicular;}
    
    public void sincronizarSemaforo(int capacidadDeFlujoActual, int semaforo){
        if( semaforos[semaforo] != null ){
			if( capacidadDeFlujoActual == 0){
            	int _Alto_ = 85000; //85 segundos
            	int tiempoDeEspera = _Alto_;
            	semaforos[semaforo].setTiempoDeEspera( tiempoDeEspera);
				semaforos[semaforo].setTiempoDePase( 0 );
            	hayUnaCuadraBloqueada = true ;
        	}
			/** raios la capacidad de fllujo actual tendria que ser de autos
		
			*/
    	}
    }
	
    public Semaforo getSemaforo(int semaforo){	return semaforos[semaforo]; }
    public Semaforo[] getSemaforos(){ 
        int i =0;
        while(semaforos[i] != null){
         i++;
        }
        i -= 1;
        if(i == -1){
            return null;
        }
        else { return java.util.Arrays.copyOfRange(semaforos, 0 , i+1); }
     }
	
	
	
	public void setTiempoDeEspera( int miliSegundos){
        Semaforo[] ss = getSemaforos();
        int nS = ss.length;
        for(int i = 0; i < nS; i++){
            ss[i].setTiempoDeEspera( miliSegundos);
        }
    }
}
