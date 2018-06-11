import java.util.ArrayList;
import java.util.Collections;

/**
 * LEER README.TXT
 * 
 * @author CRISTHIAN ZENTENO BRAÑEZ 
 * @version (a version number or a date)
 */
public class Verificador
{
    public boolean sonIsomorfos(Grafo a, Grafo b){
        boolean resp = true;
        if(a.orden()!=b.orden()){
            resp = false;
        }else{
            if(a.tamano()!=b.tamano()){
                resp = false;
            }else{
                ArrayList<Integer> x,y;
                x = a.getGradosVertices();
                y = b.getGradosVertices();
                Collections.sort(x);
                Collections.sort(y);
                if(x.equals(y)){
                    resp = revisarFunciones(a,b);
                }else{
                    resp = false;
                }
            }
        }
        return resp;
    }
    
    private boolean revisarFunciones(Grafo a, Grafo b){
        boolean resp = false;
        MatrizPermutacion permutacion = new MatrizPermutacion(); 
        ArrayList<int[][]> matrices = permutacion.matrizPermutacion(a.orden());
        for(int i = 0; i < matrices.size()&& !resp ;i++){
            resp = resp || esIgual(a.getMatriz(),multi(matrices.get(i),multi(b.getMatriz(),transpuesta(matrices.get(i)))));
        }
        return resp;
    }
    
    private int[][] transpuesta(int[][] matriz){
        int[][] transpuesta = new int[matriz[0].length][matriz.length];
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }
    
    private boolean esIgual(int[][] a, int[][] b){
        boolean resp = true;
        if(a.length == b.length && a[0].length == b[0].length ){
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[0].length; j++){
                    resp = resp && a[i][j]==b[i][j];
                }
            }
        }else{
            resp = false;
        }
        return resp;
    }
    
    private int[][] multi(int[][] a, int[][] b){
        int[][] multi = new int[a.length][b[0].length];
        if(a[0].length == b.length){
            for(int i = 0; i < a.length; i++){
                for(int k = 0; k < b[0].length; k++){
                    for(int j = 0; j < a[0].length; j++){
                        multi[i][k] +=  a[i][j]*b[j][k];
                    }
                }
            }
        }        
        return multi; 
    }
    
    
    
    
    public boolean esAutomorfo(Grafo grafo){
        return sonIsomorfos(grafo,grafo.getComplemento()); 
    }
    
    public String imprimir(int[][] matriz){
        String resp = "";
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                resp = resp + matriz[i][j] + " ";
            }
            resp = resp +"\n";
        }
        return resp;
    }
    
}
