
/**
 * Write a description of class Semaforo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Semaforo
{
    private String luz;
    private Timer t;
    private final static String[] luzDeSemaforo = {"Verde","Amarillo","Rojo"};
    private String nombre;
    private TiemposSemaforo tiemposDeSemaforo;
    /**
     * Constructor for objects of class Semaforo
     *    
     * Ingresar el tiempo en milisegundos
    */
    public Semaforo(double tiempoDeRojo, double tiempoDeAmarillo, double tiempoDeVerde, 
                    String nombre)
    {
        tiemposDeSemaforo = new TiemposSemaforo(tiempoDeVerde, tiempoDeAmarillo, tiempoDeRojo);
        this.nombre = nombre;
        luz = luzDeSemaforo[0];
    }
    public void setNombre(String n){    nombre = n;}
    public String getNombre(){  return nombre;}
    public void setTiempos(double tV, double tA, double tR){ 
        tiemposDeSemaforo.setTV(  tV );
        tiemposDeSemaforo.setTA(  tA );
        tiemposDeSemaforo.setTR(  tR );
    }
    /*
     * Luz representa la luz que estara mostrando el semaforo
    */
    public void prenderSemaforo(){
        /*cambiara el estado de luz a rojo; amarillo o verde en funcion del tiempo*/
        //currentMillis
    }
    private void cambioDeLuz(){
        int c=0;
        while(luz!=luzDeSemaforo[c]){++c;}
        if(c+1==3){c=0;}
        else{c+=1;}
        luz = luzDeSemaforo[c];
    }
    
    public boolean pasanLosAutos(){
        return luz.equals( "Verde" );
    }
    /*retorna el tiempo de <<espera>> y el tiempo de <<pase>> en segundos*/
    public double[] getTiemposDeCambio(){  
        return tiemposDeSemaforo.getTiemposDeCambio() ;
    }
    
    public void setTiempoDeEspera(int miliSegundos){
        tiemposDeSemaforo.setTR(  miliSegundos ); 
    }

    public void setTiempoDePase(int milisegundos){
        int tiempoAmarillo = milisegundos /10; //calculo automatico del amarillo
        tiemposDeSemaforo.setTV(  milisegundos - tiempoAmarillo ); 
        tiemposDeSemaforo.setTA(  tiempoAmarillo );
    }
    public String getTiemposDeCambio2(){
        return tiemposDeSemaforo.toString();
    }
    
    public long  getMillis(){ 
        long milis = System.currentTimeMillis();
        milis = milis - (420285 * 3600000);
        return milis;
    }
}
