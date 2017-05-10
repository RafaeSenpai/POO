import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Crie em seguida uma classe Parque contendo o nome do parque em questão 
 * e uma representação dos lugares do parque, associando a cada matricula, 
 * a informação do lugar associado.
 * Para além dos construtores e métodos usuais, a classe Parque deverá
 * definir ainda os seguintes métodos de instância:
 * 
 * @author Rafael Alves
 * @version 26-04-2017
 */
public class Parque_HashMap
{

    /*
     * Variaveis de instancia
     */
    private String nome;
    private Map<String, Lugar> lugares; //a string é a matricula em questão
    
    /*
     * Construtor parametrizado
     */
    public Parque_HashMap(String nome, Map<String, Lugar> posicoes){
        this.nome = nome;
        this.lugares = new HashMap<>();    
        /*recorrendo a iteradores externos*/
        for(Lugar x :posicoes.values()){
            this.lugares.put(x.getMatricula(),x.clone());
        }
    }
    /*
     * Construtor vazio
     */
    public Parque_HashMap(){
        this.nome = "Na";
        this.lugares = new HashMap<>();
    }
    /*
     * Construtor por copia
     */
    public Parque_HashMap(Parque_HashMap umParque){
        this.nome = umParque.getNome();
        this.lugares = umParque.getLugares();
    }
    
    
    
    /*
     * Gets
     */
    public String getNome(){
        return this.nome;
    }
    
    
    
    /*
     * Método que devolve uma cópia do Map de lugares.
     * Tem de ser criada uma cópia dos objectos do tipo Lugar.
     */
    /*
     * Iterador externo
     */
    public Map<String, Lugar> getLugares(){ 
        Map<String, Lugar> parque = new HashMap<>();
        
        for(Lugar x : lugares.values()){
            parque.put(x.getMatricula(),x.clone());
        }
        
        return parque;
    }
    /*
     * Iterador interno - forEach
     */
    public Map<String,Lugar> getLugaresF2() {
        Map<String, Lugar> copia = new HashMap<>();
        this.lugares.forEach((k,v) -> copia.put(k,v.clone()));//a key, dentro do put, não precisa de clone pois trata-se de uma string e as strings são imotaveis, logo nao necessita de clone 
        
        return copia;
    }
    /*
     * Iterador interno - stream
    */
    public Map<String,Lugar> getLugaresF() {
        Map<String,Lugar> res = new HashMap<>();        
        res = this.lugares.values().stream()
                                   .collect(Collectors.toMap(lugar -> lugar.getMatricula(),
                                                             lugar -> lugar.clone())); 
        return res;                   
    }
    
    
    
    
    /*
     * Sets
     */
    public void setNome(String x){
        this.nome = x;
    }
    
    
    
    
    /*
     * Metodo que devolve todas as matriculas dos lugares ocupados
     */
    public List<String> getMatrLugOcupados(){ 
       List<String> listaMatriculas = new ArrayList<>();
       
        for(Lugar x :this.lugares.values()){
            listaMatriculas.add(x.getMatricula());
        }
        
        return listaMatriculas;
        
        /*abaixo mais simples e indicado talvez*/
        
        // return lugares.keySet(); 
        /* keyset() - devolve as chaves e como as chaves são as matriculas entao keyset faz o k é pedido neste metodo*/
    }
    
    
    
    
    /*
     * Metodo que regista um novo lugar
     */
    public void registaLugar(Lugar l){ 
        this.lugares.put(l.getMatricula(),l.clone());
    }
    
    
    
    
    /*
     * Metodo que altera o tempo disponivel de um lugar, para uma dada matricula
     */
    public void alteraTempo(String matricula, int tempo){ 
        this.lugares.get(matricula).setMinutos(tempo); 
        // get(chave) - Retorna o valor ao qual a chave especificada é mapeada, ou null se este mapa não contém mapeamento para a chave.
    }
    
    
    
    
    /*
     * Metodo que devolve a quantidade tota de minutos atribuidos
     */
    /*
     * Implementação com iterador externo
     */
    public int totalMinutos(){ 
        int total=0;
        
        for(Lugar x : this.lugares.values()){
            total+=x.getMinutos();
        }
        return total;        
    }
    /*
     * Implementacao com iterador interno
     */
    public int totalMinutosF(){ 
        return this.lugares.values().stream().mapToInt(Lugar::getMinutos).sum();
    }
    /*
     * Metodo que verifica se existe lugar atribuido a uma dada matricula
     */
    public boolean existe(String mat){ 
        return this.lugares.containsKey(mat);
    }
    
    
    
    
    /*
     * Metodo que cria uma lista com as matriculas com tempo atribuido menor que x, em que o lugar seja permanente.
     */
    /*
     * Implementação com iterador externo
     */
    public List<String> getMatriculasTempo(int tempo){ 
        List<String> listagem = new ArrayList<>();
        
        for(Lugar x : this.lugares.values()){
            if(x.getMinutos()<tempo){
                listagem.add(x.getMatricula());
            }
        }
        return listagem;
    }
    /*
     * Implementação com iterador interno
     */
    public List<String> getMatriculasTempoF(int tempo){ 
        
        return this.lugares.values()
                           .stream()
                           .filter(lugar -> lugar.getMinutos()<tempo)
                           .map(Lugar::getMatricula)
                           .collect(Collectors.toList());
        
    }
    
    
    
    
    /*
     * Metodo que devolve uma copia dos lugares
     */
    /*
     * Implementação com iterador interno
     */
    public List<Lugar> getCopiaLugaresF(){
        return this.lugares.values()
                           .stream()
                           .map(Lugar::clone)
                           .collect(Collectors.toList());
    }
    /*
     * Implementação com iterador externo
     */
    public List<Lugar> getCopiaLugares(){ 
        List<Lugar> listagem = new ArrayList<>();
        
        for(Lugar x : lugares.values()){
            listagem.add(x);
        }
        return listagem;
    }
  
    
    
    
    /*
     * Metodo que devolve a informação de um lugar para uma dada matricula
     */
    public Lugar getInformacao(String matricula){ 
        return this.lugares.get(matricula);
    }
}