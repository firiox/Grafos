import java.util.ArrayList;
import java.util.Collections;

/**
 * LEER README.TXT
 * 
 * @author CRISTHIAN ZENTENO BRAÑEZ 
 * @version (a version number or a date)
 */
public class Verificador3
{
    private  ArrayList<int[]> revisarAristas(Grafo a, Grafo b){
        ArrayList<int[]> aristas;
        MatrizPermutacion permutacion = new MatrizPermutacion(); 
        ArrayList<int[][]> matrices = permutacion.matrizPermutacion(a.orden());
        ArrayList<Integer> comparaciones = new ArrayList<Integer>();
        for(int i = 0; i < matrices.size();i++){
            comparaciones.add(comparar(a.getMatriz(),multi(matrices.get(i),multi(b.getMatriz(),transpuesta(matrices.get(i))))));
        }
        int indice = menor(comparaciones);
        int[][] isomorfo = multi(matrices.get(indice),multi(b.getMatriz(),transpuesta(matrices.get(indice))));
        aristas = diferencias(isomorfo,a.getMatriz());
        return aristas;
    }
    
    //dadas dos matrices A y B, encontrar las diferencias para que B se parezca a A
    private ArrayList<int[]> diferencias(int[][] a, int[][] b){
        ArrayList<int[]> aristas = new ArrayList<int[]>();
        for(int i = 0; i < a.length;i++){
            for(int j = 0; j < a[0].length;j++){
                if(a[i][j]!=b[i][j]){
                    int[] arista = {i,j};
                    aristas.add(arista);
                }
            }
        }
        return aristas;
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
        String reporte="";
        ArrayList<Grafo> posibles;
        Grafo resp;
        Grafo nextAutomorfo = nextAutomorfo(grafo);
        if(nextAutomorfo.orden()>grafo.orden()){
            reporte = "aumentar: "+(nextAutomorfo.orden()-grafo.orden()) +" vertices\n";
        }
        ArrayList<int[]> aristas = revisarAristas(nextAutomorfo,nextAutomorfo.getComplemento()); 
        int dif = 0;
        if(nextAutomorfo.tamano()>nextAutomorfo.getComplemento().tamano()){
            dif = nextAutomorfo.tamano()-nextAutomorfo.getComplemento().tamano();
            posibles = posibles(dif,nextAutomorfo.getMatriz(),aristas,new ArrayList<Integer>(),0);  
        }else{
            dif = nextAutomorfo.getComplemento().tamano()-nextAutomorfo.tamano();
            posibles = posibles(dif,nextAutomorfo.getMatriz(),aristas,new ArrayList<Integer>(),1);
        }
        resp = posibleAutomorfo(posibles);
        reporte = reporte + compararMatriz(resp.getMatriz(),nextAutomorfo.getMatriz());
        return reporte; 
    }
    
    private Grafo posibleAutomorfo(ArrayList<Grafo> posibles){
        Grafo posible=null;
        Verificador verificador = new Verificador();
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i < posibles.size()){
            encontrado = verificador.esAutomorfo(posibles.get(i));
            i++;
        }
        posible = posibles.get(i);
        return posible;
    }
    
    
    private Grafo nextAutomorfo(Grafo grafo){
        int n = grafo.orden();
        while((((n-1)*n)/2)%2!=0){
            n++;
        }
        Grafo nextAutomorfo = aumentarVertices(grafo,n-grafo.orden());
        return nextAutomorfo;
    }
    
    private String compararMatriz(int[][] a, int[][] b){
        String reporte="";
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
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
    
    private int[][] modificarArista(int[][] grafo, int[] arista, int valor){
        int[][] nuevo = clonar(grafo);
        nuevo[arista[0]][arista[1]] = valor;
        nuevo[arista[1]][arista[0]] = valor;
        return nuevo;
    }
    
    private int[][] clonar(int[][] original){
        int[][] clon = new int[original.length][original[0].length];
        for(int i = 0; i < original.length; i++){
            for(int j = 0; j < original[0].length; j++){
                clon[i][j]=original[i][j];
            }
        }
        return clon;
    }
    
    private ArrayList<Grafo> posibles(int num, int[][] grafo,ArrayList<int[]> aristas,ArrayList<Integer> usados,int valor){
        ArrayList<Grafo> lista = new ArrayList<Grafo>();
        if(num > 0){
            for(int i = 0; i < aristas.size();i++){
                if(!usados.contains(i)){
                    usados.add(i);
                    lista.add(new Grafo(modificarArista(grafo,aristas.get(i),valor)));
                    lista.addAll(posibles(num-1,grafo,aristas,usados,valor));
                    usados.remove(new Integer(i));
                }
            }
        }
        return lista;
    }
}
