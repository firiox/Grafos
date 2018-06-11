import java.util.ArrayList;
/**
 * LEER README.TXT
 * 
 * @author CRISTHIAN ZENTENO BRAÑEZ 
 * @version (a version number or a date)
 */
public class MatrizPermutacion
{
    public ArrayList<int[][]> matrizPermutacion(int tam){
        ArrayList<int[][]> matrices = new ArrayList<int[][]>();
        int[][] identidad = identidad(tam);
        int[][] matriz = new int[tam][tam];
        ArrayList<Integer> lista = new ArrayList<Integer>();
        permutar(0,lista,matriz,identidad,matrices);
        return matrices;
    }
    
    private void permutar(int n, ArrayList<Integer> lista,int[][] matriz, int[][] ident,ArrayList<int[][]> matrices){
        if(n < matriz.length){
            for(int j = 0; j < ident.length;j++){
                if(!lista.contains(j)){
                    lista.add(j);
                    matriz[n]=ident[j];
                    permutar(n+1,lista,matriz,ident,matrices);
                    lista.remove(new Integer(j));
                }
            }
        }else{
            matrices.add(clonar(matriz));
        }
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
    
    
    private int[][] identidad(int tam){
        int[][] identidad = new int[tam][tam];
        for(int i = 0; i < tam; i++){
            identidad[i][i]=1;
        }
        return identidad;
    }
}
