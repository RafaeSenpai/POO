import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/**
 * Crie uma classe Paises que estabeleça uma correspondência entre o nome
 * de um dado país e a informação sobre a sua capital ( FichaDeCapital ),
 * designadamente: nome da cidade, população, número de veículos, salário
 * médio (real) e custo de vida mensal médio (real).
 * 
 * @author Rafael Alves
 * @version 28-04-2017
 */
public class Paises
{
    private String nomeDaLista;
    private Map<String, FichaDeCapital> Lista = new HashMap<>();
    
    
    
    /*
     * Construtor parametrizado
     */
    public Paises(String nome, Map<String,FichaDeCapital> l){
        this.nomeDaLista = nome; 
        this.Lista = new HashMap<>();
        
        /**
         * Set < Map.Entry < K , V >>
         *      entrySet() - Retorna uma vista Set dos mapeamentos (chave->valor) contidos neste mapa.
         *      
         * getKey() - Retorna a chave correspondente a essa entrada.
         * getValue() - Retorna o valor correspondente a essa entrada.
         */
        for(Map.Entry<String,FichaDeCapital> x : l.entrySet()){
            this.Lista.put(x.getKey(), x.getValue().clone());
        }
    }
    
    
    
    /*
     * Contrutor vazio
     */
    public Paises(){
        this("Na",new HashMap<>());
    }
    
    
    
    
    /*
     * Construtor por copia
     */
    public Paises(Paises p){
        this(p.getNomeDaLista(),p.getFichasDeCapitais());
    }
    
    
    
    /*
     * Gets
     */
    public String getNomeDaLista(){
        return this.nomeDaLista;
    }
    
    
    public Map<String,FichaDeCapital>  getFichasDeCapitais(){
        Map<String,FichaDeCapital> novo = new HashMap<>();
        
        this.Lista.forEach((k,v) -> novo.put(k,v.clone()));
        return novo;
    }
        
        
    
    /*
     * Sets
     */
    public void setNomeDaLista(String nome){
        this.nomeDaLista= nome;
    }
    
    
    /*
     * Clone()
     */
    public Paises clone(){
        return new Paises(this);
    }
    
    
    /*
     * ToString
     */
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("--------------------------------- \n" + this.getNomeDaLista() + "\n\n");
        
        for(FichaDeCapital x : Lista.values()){
            sb.append(x.toString());
        }
        return sb.toString();
    }
        
    /**--------------------FALTA FAZER O EQUALS-!!!*/
    
    /*
     * Determinar o numero total de paises
     */
    public int numTotalPaises(){
        return Lista.values()
                    .stream()
                    .collect(Collectors.toList())
                    .size();
    }   
    
    
    
    
    /*
     * Devolver os nomes de paises com capitais com população acima de um valor dado.
     */
    /*
     * Implementação com iterador interno
     */
    
    public List<String> PiasesComPopAcimaDeF(int x){
        List<String> listagem = new ArrayList<>();
        Lista.forEach( (k,v) -> {
                                    if(v.getPopulacao()>x){
                                        listagem.add(k);
                                    }
                                });
    return listagem;
    }
    
    /*
     * Implementação com iterador externo
     */
    public List<String> PiasesComPopAcimaDe(int x){
     /**
     * Set < Map.Entry < K , V >>
     *      entrySet() - Retorna uma vista Set dos mapeamentos (chave->valor) contidos neste mapa.
     *      
     * getKey() - Retorna a chave correspondente a essa entrada.
     * getValue() - Retorna o valor correspondente a essa entrada.
     */
        List<String> listagem = new ArrayList<>();
        
        Iterator<Map.Entry<String,FichaDeCapital>> it = Lista.entrySet().iterator();
        Map.Entry<String,FichaDeCapital> f;
        
        while(it.hasNext()){
            f = it.next();
            if(f.getValue().getPopulacao()>x){
                listagem.add(f.getKey());
            }
        }
        
        return listagem;
    }
    
    
    
    /*
     * Dado o nome de um pais, devolver a ficha da sua capital
     */
    public FichaDeCapital getFichaCapital(String pais){ 
        return this.Lista.get(pais);
    }
    
    
    
    /*
     * Altera a população da caital de um dado pais
     */
    public void alterarPopulacao(String pais,long x){
        /**
         * get(chave) - devolve o valor correspondente á chave dada
         */
        this.Lista.get(pais).setPopulacao(x);
    }
    
    /*
     * Inserir a informação de um novo pais
     */
    public void inserePais(String pais, FichaDeCapital fc){
        Lista.put(pais,fc.clone());
    }
    
    /*
     * Criar uma listagem com os nomes de todas as capitais registadas.
     */
    /*
     * Implementação com iterador interno
     */
    public List<String> listaCapitaisF(){
        List<String> listagem = new ArrayList<>();
        
        this.Lista.forEach((k,v) -> listagem.add(v.getCidade()));
        return listagem;
    }
    /*
     * Implementação com iterador externo
     */
     public List<String> listaCapitais(){
         List<String> listagem = new ArrayList<>();
         
         for(FichaDeCapital x : Lista.values()){
             listagem.add(x.getCidade());
        }
        
        return listagem;
    }
    
    
    
    
    /*
     * Determinar o somatorio de todas as populações das capitais
     */
    /*
     * Implementação com iterador interno
     */
    public double somaPopulacoesF(){
        return this.Lista.values().stream().mapToDouble(FichaDeCapital::getPopulacao).sum();
    }
    /*
     * Implementação com iterador externo
     */
    public double somaPopulacoes(){
        double total = 0;
        for(FichaDeCapital x : Lista.values()){
            total+=x.getPopulacao();
        }
        return total;
    }
    
    
    
    
    /*
     * Dada um Map de pais para FichaDeCapital, pra cada pais 
     * que exista na lista de paises, alterar a sua ficha de 
     * capital e para cada pais novo ignorar a sua informação
     */
    
    /**------------------------------------------não percebi o que me pedem*/
    
    
    
    
    
    /*
     * Dado um conjunto de nomes de paises , remover  as suas fichas de capital
     */
    public void removeFichas(List<String> listaPaises){ 
                                                        
        Iterator<String> it = listaPaises.iterator();
        
        String x;
        while(it.hasNext()){
            x=it.next();/**Atenção: a primeira consulta do iterador deve ser feita logo em 1ºlugar dentro do while e nunca 'for' do mesmo*/
            if(Lista.containsKey(x)){
                Lista.remove(x);
            }

        }
    }
}
