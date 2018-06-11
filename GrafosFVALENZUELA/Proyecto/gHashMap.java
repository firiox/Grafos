
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
public class gHashMap implements Grafo 
{

    private HashMap<Integer, ArrayList<Integer> > grafo;
    private ArrayList<Integer> posiblesAristas;
    /**
     * Constructor for objects of class gHashMap
     */
    public gHashMap()
    {
        grafo = new HashMap();
        posiblesAristas = new ArrayList<>();
    }

    public void anadir(int verticeA, int verticeB ){

        anadir2(verticeA,verticeB);
        anadir2(verticeB,verticeA);
    }

    public void anadir2(int verticeA, int verticeB){

        if( !grafo.containsKey( verticeA )){
            grafo.put( verticeA , new ArrayList() );

        }
        ArrayList< Integer > relacionesA = grafo.get( verticeA );
        relacionesA.add( verticeB );      
    }

    private int getNumeroDeAristas(){
        int numeroDeAristas = 0;
        Set<Integer> vertices = grafo.keySet();

        for(Integer vertice : vertices){
            numeroDeAristas += ( getGrado(vertice) );
        }
        return numeroDeAristas/2;
    } 

    public boolean esNumeroDeAristasPar(){

        int numeroDeAristas = getNumeroDeAristas();
        return ( (numeroDeAristas)%2 ) == 0;
    }

    public boolean esNumeroDeVerticesPar(){

        int numeroDeVertices = grafo.size();       
        return numeroDeVertices%2 == 0;
    }

    public boolean esIsomorfo(){
        boolean res = esNumeroDeVerticesPar() && esNumeroDeAristasPar() ;
        return res;
    }

    public gHashMap getComplemento(){
        gHashMap complemento = new gHashMap();
        Set<Integer> vertices = grafo.keySet();
        int gOrden = grafo.size();
        for(Integer vertice : vertices){
            ArrayList<Integer> aristasC = new ArrayList<>();
            ArrayList<Integer> aristas = grafo.get(vertice);
            aristasC = getPosiblesAristas();
            aristasC.removeAll(aristas);
            aristasC.remove(vertice);
            for(Integer arista : aristasC)
                complemento.anadir2( vertice , arista);
        }
        return complemento;
    }

    private ArrayList getPosiblesAristas(){
        posiblesAristas.clear();
        int gOrden = grafo.size();
        for(int i=0;i<gOrden;i++){
            posiblesAristas.add(i);
        }
        return posiblesAristas;
    }

    public boolean esIsomorfoCON(gHashMap ofarg){
        boolean res = true;
        boolean res2=false;
        ArrayList< HashMap<Integer,Integer> >ini = new ArrayList<>();
        Set<Integer> syek = grafo.keySet();
        if( esIniciable(ofarg) ){

            ini=iniciar(0 , ofarg);
            
            for(HashMap<Integer, Integer> sexy : ini){
                
                for(Integer v : syek ){
                    res = res && sexy.containsKey(v);
                }
                res2 = res || res2 ;
            }
            
        }{
            res2=false;
        }
        return res2;
    }
    
    public ArrayList<HashMap<Integer,Integer> > esIsomorfoCONGG(gHashMap ofarg){
        boolean res = true;
        boolean res2=false;
        ArrayList< HashMap<Integer,Integer> >ini = new ArrayList<>();
        Set<Integer> syek = grafo.keySet();
        if( esIniciable(ofarg) ){

            ini=iniciar(0 , ofarg);
            /*
            for(HashMap<Integer, Integer> sexy : ini){
                
                for(Integer v : syek ){
                    res = res && sexy.containsKey(v);
                }
                res2 = res || res2 ;
            }*/
            
        }{
            res=false;
        }
        return ini;
    }

    private ArrayList< HashMap<Integer,Integer> >iniciar(int vertice, gHashMap ofarg){
        Set<Integer> candidatos = ofarg.getGrafo().keySet();
        
        ArrayList< HashMap<Integer,Integer> > inicios = new ArrayList<>();
        for(Integer candidato : candidatos){
            if(getGrado(vertice) == ofarg.getGrado(candidato) ){
                HashMap<Integer,Integer> gg = new HashMap<>();
                ArrayList<Integer> sigCandidatos = ofarg.getGrafo().get(candidato);
                ArrayList<Integer> sigVertices   = grafo.get(vertice); 
                mover(vertice, sigVertices , candidato, sigCandidatos, ofarg, new ArrayList<Integer>(), gg);
                inicios.add(gg);
                //backTraking( vertice , candidato );
            }

        }
        return inicios;
    }

    private void mover(int vertice , ArrayList<Integer> sigVertices, int candidato
                                            , ArrayList<Integer> sigCandidatos, gHashMap ofarg, ArrayList<Integer> candidats
                                            , HashMap<Integer,Integer> mapeo
                                            ){
  
        mapeo.put(vertice,candidato );        
        candidats.add(candidato);
                
        
        for(Integer vertex : sigVertices){
            if(!mapeo.containsKey(vertex)){
                for(Integer candidat : sigCandidatos){
                    if(getGrado(vertex) == ofarg.getGrado(candidat)){
                        
                    if(!candidats.contains(candidat)){
                    ArrayList<Integer> sigSigVertices = grafo.get(vertex);
                    ArrayList<Integer> sigSigCandidatos = ofarg.getGrafo().get(candidat);
                    mover(vertex, sigSigVertices,candidat, sigSigCandidatos, ofarg ,candidats, mapeo);
                }
                }
            }
            
        }
        }

    }
    public int getGrado(int vertice){
        return grafo.get(vertice).size();
    }

    public boolean esIniciable(gHashMap ofarg){
        boolean omaigad = false;
        HashMap<Integer,Integer> gradosGRAFO = new HashMap();
        HashMap<Integer,Integer> gradosOFARG = new HashMap();
        gradosGRAFO = calcularGrados();
        gradosOFARG = ofarg.calcularGrados(); 
        omaigad = gradosGRAFO.equals( gradosOFARG );
        return omaigad;
    }
    
    private HashMap<Integer,Integer> calcularGrados(){
        HashMap<Integer,Integer> grados = new HashMap<>();
        Set<Integer> vertices = grafo.keySet();
        for(Integer vertice : vertices){
            int gradov = getGrado(vertice);
            if(!grados.containsKey(gradov)){
                grados.put(gradov,1);

            }
            else{
                int contador = grados.get(gradov);
                grados.put(gradov,contador+1);
            }

        }
        return grados;
    }

    public HashMap<Integer,ArrayList<Integer> > getGrafo(){
        return grafo;
    }

    public boolean esAutomorfo(){
        boolean res = false;
        if(esIsomorfo()){
            gHashMap complemento = getComplemento();
            res = esIsomorfoCON(complemento); 
        }
        else{}
        return res;
    }
}
