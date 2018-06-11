
/**
 * Write a description of class Arista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arista
{
    //TiempoReal tiempo = new TiempoReal();
    private Vertice origen,destino;
    private int capacidadDeFlujoActual, capacidadDeFlujoNormal; // ASDASDASDA
    private int flujoVehicular;
    private boolean dobleSentido;
    private static int semaforo;
    public boolean getDobleSentido(){   return dobleSentido;}
    public Vertice getOrigen(){ return origen;}
    public Vertice getDestino(){ return destino;}
    public int getCapacidad(){  return capacidadDeFlujoActual;}
    public int getSemaforo(){   return semaforo;}
   
    /**
		Metodo Constructor util en el caso de que no exista un semaforo
	*/
    public Arista(Vertice origen, Vertice destino )
    {        
        this.origen = origen;
        this.destino = destino;
        dobleSentido = false;
        semaforo = 0;
    }
	/**
		Metodo constructor util en el cao de que exista un semaforo
	*/
    public Arista(Vertice origen, Vertice destino, int semaforo)
    {        
        this.origen = origen;
        this.destino = destino;
        dobleSentido = false;
        semaforo = semaforo;
    }
    public void fluir(){
        flujoVehicular = origen.getFlujo2(capacidadDeFlujoActual) ;        
        flujoVehicular -= destino.setFlujo(flujoVehicular, semaforo);
    }
    public int getFlujoVehicular(){
        return flujoVehicular;
    }

    /*AUTOMATICAMENTE cambia el doble sentido a su opuesto*/
    public void setDobleSentido(){
        dobleSentido = !dobleSentido;
    }
    /*cambia la capacidad de flujo por un tiempo luego vuelve a su antiguo capacidad de flujo */
    public void trabajoNoPredefinido(int tiempoDelTrabajo, int capacidadDeFlujo){
        capacidadDeFlujoActual = capacidadDeFlujo;
    }
    public void setCapacidadDeFlujoNormal(int capa){    capacidadDeFlujoNormal = capacidadDeFlujoActual = capa;}
    public void retornarALaCapacidadNormal(){ capacidadDeFlujoActual = capacidadDeFlujoNormal;}
    public void bloquear(){ capacidadDeFlujoActual = 0;}
    public String toString(){
        return "Arista de " + origen + " A " + destino + "con capacidad de flujo " + capacidadDeFlujoActual 
                + " y con un flujo vehicular de " + flujoVehicular;
    }
    public String toString2(){
        return "Arista de " + origen + " A " + destino;
    }
    
}
