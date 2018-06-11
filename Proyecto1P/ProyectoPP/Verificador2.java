import java.util.ArrayList;
import java.util.Collections;

/**
 * LEER README.TXT
 * 
 * @author CRISTHIAN ZENTENO BRAÑEZ 
 * @version (a version number or a date)
 */
public class Verificador2
{
    public String sonIsomorfosSugerencia(Grafo a, Grafo b){
        String reporte="";
        if(a.orden()!=b.orden()){
            if(a.orden()>b.orden()){
                reporte = "aumentar: " + (a.orden()-b.orden())+" vertices\n" +
                           sonIsomorfosSugerencia(a,aumentarVertices(b,a.orden()-b.orden()));
            }else{
                reporte = "aumentar: " + (b.orden()-a.orden())+" vertices\n" +
                           sonIsomorfosSugerencia(aumentarVertices(a,b.orden()-a.orden()),a);
            }
        }else{
            reporte = reporte + revisarAristas(a,b);
        }
        return reporte;
    }
    
    private String revisarAristas(Grafo a, Grafo b){
        String reporte = "";
        MatrizPermutacion permutacion = new MatrizPermutacion(); 
        ArrayList<int[][]> matrices = permutacion.matrizPermutacion(a.orden());
        ArrayList<Integer> comparaciones = new ArrayList<Integer>();
        for(int i = 0; i < matrices.size();i++){
            comparaciones.add(comparar(a.getMatriz(),multi(matrices.get(i),multi(b.getMatriz(),transpuesta(matrices.get(i))))));
        }
        int indice = menor(comparaciones);
        int[][] isomorfo = multi(matrices.get(indice),multi(b.getMatriz(),transpuesta(matrices.get(indice))));
        reporte = diferencias(isomorfo,a.getMatriz());
        return reporte;
    }
    
    //dadas dos matrices A y B, encontrar las diferencias para que B se parezca a A
    private String diferencias(int[][] a, int[][] b){
        String reporte = "";
        for(int i = 0; i < a.length;i++){
            for(int j = 0; j < a[0].length;j++){
                if(a[i][j]!=b[i][j]){
                    if(a[i][j]==1){
                        reporte = reporte + "aumentar arista: "+"("+i+","+j+")"+"\n";
                    }else{
                        reporte = reporte + "quitar arista: "+"("+i+","+j+")"+"\n";
                    }
                }
            }
        }
        return reporte;
    }
    
    //Dada una lista devuelve el indice que posee el menor valor
    private int menor(ArrayList<Integer> lista){
        int indice = 0;
        int menor = lista.get(indice);
        for(int i = 0; i < lista.size();i++){
            if(menor>lista.get(i)){
                menor = lista.get(i);
                indice = i;
            }
        }
        return indice;
    }
    
    private Grafo aumentarVertices(Grafo grafo, int num){
        int[][] matriz = new int[grafo.orden()+num][grafo.orden()+num]; 
        for(int i = 0; i < grafo.getMatriz().length; i++){
            for(int j = 0; j < grafo.getMatriz()[0].length; j++){
                grafo.getMatriz()[i][j] = matriz[i][j];
            }
        }
        Grafo nuevo = new Grafo(matriz);
        return nuevo;
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
    
    private int comparar(int[][] a, int[][] b){
        int diferencias = 0;
        if(a.length == b.length && a[0].length == b[0].length ){
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[0].length; j++){
                    if(a[i][j]!=b[i][j]){
                        diferencias++;
                    }
                }
            }
        }else{
            diferencias = -1;
        }
        return diferencias;
    }
    //multiplicacion de matrices
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
    
    public String esAutomorfoSugerencia(Grafo grafo){
        return sonIsomorfosSugerencia(grafo,grafo.getComplemento()); 
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
