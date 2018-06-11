
/**
 * Write a description of class TiempoReal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiempoReal implements Tiempo
{
    int _tiempo_;
    public TiempoReal()
    {
        _tiempo_=0;
    }
    public void contarMinutos(int minutos){
        pasarTiempo(1);
        //hasta minutos
        
    }
    public void alPasar(int tiempoAPasarEnMinutos , int cambiarEsto, int aEsto){
        int trigger = _tiempo_ + tiempoAPasarEnMinutos;
        if( _tiempo_ == trigger){
            cambiarEsto = aEsto;
        }
    }
    public void pasarTiempo(int segundos){
        _tiempo_ += segundos;
    }
}
