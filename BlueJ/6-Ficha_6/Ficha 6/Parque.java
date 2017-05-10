
/**
 * Escreva a descrição da classe Parque aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.TreeSet;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
public class Parque
{
    private String nome;
    private Map<String, Lugar> lugares;
    
    
    public Parque(){
        this.nome = "";
        this.lugares = new TreeMap<>();
    }
    
    
    
    public Parque (String n, Map<String, Lugar> l){
        this.nome = n;
        this.lugares = new TreeMap<>();
        for(Map.Entry<String, Lugar> nm : l.entrySet()){
            this.lugares.put(nm.getKey(), nm.getValue().clone());
        }
    }
    
    
    
    
    public Parque(Parque p){
        this(p.getNome(), p.getLugares());
    }
    
    
    
    
    /** gets e setters*/
    
    public String getNome(){
        return this.nome;
    }
    
    
    
    /** GetLugar com for each*/
    
    public Map<String,Lugar> getLugares()
    {
        Map<String, Lugar> aux = new TreeMap<>();
        
        for(Map.Entry<String, Lugar> nm : lugares.entrySet()){
            aux.put(nm.getKey(), nm.getValue().clone());
        }
        return aux;
    }
    
    
    
   
    /*getLugares com Iterator 
      
     
    public Map<String,Lugar> getLugares(){
        Map<String, Lugar> nl = new TreeMap<>();
        Iterator<Map.Entry<String, Lugar>> it;
        it = this.lugares.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Lugar> l = it.next();
            nl.put(l.getKey(), l.getValue().clone());
        }
        return nl;
    }
    */
   
   
   
    public void setNome(String n)
    {
        this.nome = new String(n);
    }
    public Set<String> matriculas(){
        return this.lugares.keySet();
    }
    
    
    
    public void novoLugar(Lugar l){
        this.lugares.put(l.getMatricula(), l.clone());
    }
    
    
    
    
    public void removeLugar(String m){
        this.lugares.remove(m);
    }
    
    
    
    
    public void alteraTempo(String m, int mins){
        Lugar l = this.lugares.get(m);
        removeLugar(m);
        l.setMinutos(mins);
        novoLugar(l);
    }
    
    
    
    
    /**com iterador interno*/
    public int quantidadeMinutos(){
        return this.lugares.values().stream()
               .mapToInt(l -> l.getMinutos())
               .sum();
    }
    
    
    
    
    /**com iterador externo (INCOMPLETO)*/
    /*
    public int quantidadeMinutosv2(){
        int min=0;
        Iterator<Map.Entry<String, Lugar>> it;
    }
    */
   
   
   
    public boolean existe(String m){
        return lugares.containsKey(m);
    }
    
    
    
    
    
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        
        for (Lugar l : this.lugares.values()){
            str.append(l.toString() + "\n");
        }
        return str.toString();
    }
    
    
    
    
    
    /*
    public Map<String, Lugar> copiaLugares(){
        return this.lugares.getLugares();
    }
    */
    
   
   
   
    public Set<Lugar> lugaresOrdenadosPorTempo()
    {
        TreeSet<Lugar> t = new TreeSet<>(new ComparadorMinutos());
        for(Lugar l: this.lugares.values())
        {
            t.add(l.clone());
        }
        return t;
    }
    
    
    
    
    public Lugar menorTempo()
    { // é necessário fazer um cast à lá C, para converter dum Set generico para TreeSet.
        TreeSet<Lugar> l = (TreeSet<Lugar>) lugaresOrdenadosPorTempo();
        
        return l.first();
    }
    
    
    
    
    
}
