
/**
 * Write a description of class TiemposSemaforo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiemposSemaforo
{
    // instance variables - replace the example below with your own
    private double tiempoDeVerde;
    private double tiempoDeAmarillo;
    private double tiempoDeRojo;
    /**
     * poner los tiempos de verde, amarillo y rojo en milisegundos
     */
    public TiemposSemaforo(double tV,double tA,double tR)
    {
        // initialise instance variables
        tiempoDeVerde = tV;
        tiempoDeAmarillo = tA;
        tiempoDeRojo = tR;
    }
    public double getTV(){ return tiempoDeVerde;}
    public double getTA(){ return tiempoDeAmarillo;}
    public double getTR(){ return tiempoDeRojo;}
    public void setTV(double tiempoDeVerde){ this.tiempoDeVerde = tiempoDeVerde;}
    public void setTA(double tiempoDeAmarillo){ this.tiempoDeAmarillo = tiempoDeAmarillo;}
    public void setTR(double tiempoDeRojo){ this.tiempoDeRojo = tiempoDeRojo;}
    /**
     *  indica el tiempo de pase y el tiempo de espera en segundos 
    */
    public String toString(){
        double tiempoP = (tiempoDeVerde + tiempoDeAmarillo ) / 1000;
        double tiempoE = tiempoDeRojo / 1000;
        return "Tiempo de pase " + tiempoP + " tiempo de espera " + tiempoE;
    }
    public double[] getTiemposDeCambio(){  
        double tEspera = ( ( tiempoDeRojo / 1000) );
        double tPase = ( ( tiempoDeAmarillo + tiempoDeVerde ) / 1000) ;
        double[] tiempos = {tEspera, tPase};
        return tiempos;
    }
}
