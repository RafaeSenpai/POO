import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Considerando a classe ContaPrazo anteriormente desenvolvida, crie agora
 * uma classe Banco que associe a cada código de conta uma ContaPrazo .
 * 
 * @author Rafael Alves
 * @version 02-05-2017
 */
public class Banco
{
   /**Variaveis de instancia*/
   private String nomeDoBanco;
   private Map<String,ContaPrazo> bancoDB = new HashMap<>();
   
    /*
     * Construtor parametrizado
     */
    public Banco(String nome, Map<String,ContaPrazo> db){
       this.nomeDoBanco = nome;
           
        /**
        * Set < Map.Entry < K , V >>
        *      entrySet() - Retorna uma vista Set dos mapeamentos (chave->valor) contidos neste mapa.
        *      
        * get(K) - Retorna o valor correspondente á chave passada     
        * getKey() - Retorna a chave correspondente a essa entrada.
        * getValue() - Retorna o valor correspondente a essa entrada.
        */
        Map<String,ContaPrazo> novaDB = new HashMap<>();
         
         for(Map.Entry<String,ContaPrazo> x : db.entrySet()){
           novaDB.put(x.getKey(),x.getValue().clone());
        }
        
        this.bancoDB = novaDB;
    }
    
    /*
     * Construtor vazio
     */
    public Banco(){
        this.nomeDoBanco = "Na";
        this.bancoDB = new HashMap<>();
    }
    
    /*
     * Construtor por copia
     */
    public Banco(Banco bc){
        this(bc.getNome(),bc.getBancoDB());
    }
    
    
    /*
     * GET's
     */
    public String getNome(){
        return this.nomeDoBanco;
    }
    
    public Map<String,ContaPrazo> getBancoDB(){ 
        Map<String,ContaPrazo> novaDB = new HashMap<>();
        
        for(Map.Entry<String,ContaPrazo> x : bancoDB.entrySet()){
            novaDB.put(x.getKey(),x.getValue().clone());
        }
        
        return novaDB;
    }
    
    
    /*
     * SET's
     */
    public void setNome(String nome){
        this.nomeDoBanco = nome;
    }
    
    
    public Banco clone(){
        return new Banco(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();       
        
        for(ContaPrazo x : bancoDB.values()){
        //    sb.append("Codigo de conta: " + x.getKey() + "\n");
            sb.append(x.toString() + "\n");
        }
        return sb.toString();
    }
        
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(o==null){
            return false;
        }
        if(o instanceof Banco){
            Banco p = (Banco) o;
            
            if (this.getNome().equals(p.getNome())){
                for(Map.Entry<String,ContaPrazo> x : p.getBancoDB().entrySet()){
                    if(!(this.bancoDB.containsKey(x.getKey()))){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
            
        }else{
            return false;
        }
    }
    
    
    /*
     * Inserir uma nova conta
     */
    public void inserirConta(ContaPrazo cp){
        this.bancoDB.put(cp.getCodigo(),cp.clone());
    }
    
    /*
     * Determinar o conjunto de codigos das contas pertencentes a dado titular
     */
    /*
     * Implementação de iterador externo
     */
    public List<String> contasPercencentesA(String nome){
        List<String> listagem = new ArrayList<>();
        Iterator<Map.Entry<String,ContaPrazo>> it = bancoDB.entrySet().iterator();
        
        Map.Entry<String,ContaPrazo> cp;
        while(it.hasNext()){
            cp=it.next();
            if(cp.getValue().getTitular().equals(nome)){
                listagem.add(cp.getKey());
            }
        }
        return listagem;
    }
    
    /*
     * Implementação de iterador interno
     */
    public List<String> contasPertencentesA(String nome){
        List<String> listagem = new ArrayList<>();
        
        bancoDB.entrySet().forEach( cp -> { 
                                            if (cp.getValue().getTitular().equals(nome)){
                                                listagem.add(cp.getKey());
                                            }
                                           }
                        );
        return listagem;                                              
     }
     
     /*
      * Determinar os codigos das contas com um capital superior a um dado valor
      */
     public List<String> contasCapitalSuperior(double valor){ //-----PERCEBER PORQUÊ QUE O RETURN QUE ESTÁ COMENTADO NAO FUNCIONA. DÁ ERRO NA APLICAÇÃO DO MAP!
         List<String> listagem = new ArrayList<>();
         
         Iterator<ContaPrazo> it = bancoDB.values().iterator();
         
         ContaPrazo parCV;
         
         while(it.hasNext()){
             parCV = it.next();
             if(parCV.getCapital()>valor){
                 listagem.add(parCV.getCodigo());
             }
         }
        
         return listagem;
           
         //return bancoDB.values().stream().map(ContaPrazo::clone).filter(conta -> conta.getCapital() > valor).map(ContaPrazo::getCodigo).collect(Collectors.toList());
       
    }
        
        
     /*
      * Criar um Map de contas com taxas de juro superior a um valor dado
      */
     /*
      * Aplicação com iterador Externo
      */
     public Map<String,ContaPrazo> contasTaxaJuroSup(double valor){
         Map<String,ContaPrazo> contasTJS = new HashMap<>();
         
         
         Iterator<Map.Entry<String,ContaPrazo>> it = bancoDB.entrySet().iterator();
         Map.Entry<String,ContaPrazo> parCV;
         
         while(it.hasNext()){
             parCV = it.next();
             if(parCV.getValue().getTaxa()>valor){
                 contasTJS.put(parCV./*getValue().getCodigo()*/getKey(),parCV.getValue().clone());
             }
         }
         return contasTJS;
    }
    /*
     * Aplicação com iterador interno
     */
     public Map<String,ContaPrazo> contasTaxaJuroSupF(double valor){
         Map<String,ContaPrazo> contasTJS = new HashMap<>();
         
         bancoDB.entrySet().forEach(parCV -> {
                                                if(parCV.getValue().getTaxa()>valor){
                                                    contasTJS.put(parCV.getKey(),parCV.getValue().clone());
                                                }
                                            }
                                    );
         return contasTJS;
    }
    
    /*
     * Dada uma lista de codigos de contas incrementar as suas taxas de juro de um valor X
     */
    /*
     * Aplicaçao com iterador externo
     */
    public void incrementaTaxasJuro(List<String> lista,double incremento){
        Iterator<String> it = lista.iterator();
        
        String codigo;
        while(it.hasNext()){
            codigo = it.next();
            if(bancoDB.containsKey(codigo)){
                bancoDB.get(codigo).setTaxa(incremento); //não faz o incremento, mas sim altera o valor para o valor passado como parametro
            }
        }
    }
    /*
     * Aplicaçao com iterador interno
     */
    public void incrementaTaxasJuroF(List<String> lista,double incremento){
    
        lista.stream().forEach(codigo -> {
                                           if(bancoDB.containsKey(codigo)){
                                               bancoDB.get(codigo).setTaxa(incremento);
                                            }
                                        });
    }
    
    /*
     * Devolver o nome de todos os titulares de contas
     */
    /*
     * Aplicação de iterador externo
     */
    public List<String> getTitulares(){ 
        List<String> listagem = new ArrayList<>();
        
        
        Iterator<Map.Entry<String,ContaPrazo>> it = bancoDB.entrySet().iterator();
        Map.Entry<String,ContaPrazo> parCV;
        
        while(it.hasNext()){
            parCV = it.next();
            if(!(listagem.contains(parCV.getValue().getTitular()))){ //esta verificação é feita para o caso de haver um titular om varias contas
                listagem.add(parCV.getValue().getTitular());
            }
        }
        return listagem;
    }
    /*
     * Aplicação de iterador interno
     */
        public List<String> getTitularesF(){ 
        List<String> listagem = new ArrayList<>();
        //-------------------------------------------------------------É POSSIVEL FAZER OU ATÉ MESMO ACONSELHAVEL FAZER SEM RECURSO AO USO DO FOREACH?!
        bancoDB.entrySet().forEach(parCV -> {
                                              if(!(listagem.contains(parCV.getValue().getTitular()))){
                                                  listagem.add(parCV.getValue().getTitular());
                                              }
                                            });
        return listagem;
    }
    
    
    /*
     * Crie um map que associe a cada nome de titular existente o valor do capital investido nas suas varias contas(use metodos auxiliares)
     */
    /**NÃO PERCEBI O QUE É PEDIDO*/
}

