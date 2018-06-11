import java.util.ArrayList;
/**
 * LEER README.TXT
 * 
 * @author CRISTHIAN ZENTENO BRAÑEZ
 * @version (a version number or a date)
 */
public class Grafo
{   
    private int[][] grafo;//matriz de adyacencia
    
    public Grafo(int[][] grafo){
        this.grafo = grafo;
    }
    
    public int[][] getMatriz(){
        return grafo; 
    }
    
    public int orden(){
        return grafo.length;
    }
    
    public int tamano(){
        int tam = 0;
        for(int i = 0; i < grafo.length;i++){
            tam = tam + suma(grafo[i]);
        }
        tam = tam/2;
        return tam; 
    }
    
    public ArrayList<Integer> getGradosVertices(){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i = 0; i < grafo.length; i++){
            lista.add(suma(grafo[i]));
        }
        return lista;
    }
    
    private int suma(int[] lista){
        int suma = 0;
        for(int i = 0;i < lista.length ; i++){
            suma = suma + lista[i];
        }
        return suma;
    }
    
    public Grafo getComplemento(){
        Grafo complemento = new Grafo(new int[grafo.length][grafo[0].length]);
        for(int i = 0; i < grafo.length; i++){
            for(int j = 0; j < grafo[0].length; j++){
                if(i!=j){
                    if(grafo[i][j]==0){
                        complemento.grafo[i][j]=1;
                    }
                }
            }
        }
        return complemento;
    }
}
