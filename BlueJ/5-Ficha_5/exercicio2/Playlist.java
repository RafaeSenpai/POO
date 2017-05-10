import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.Collectors;
/**
 * Desenvolva uma classe Playlist que represente uma lista de músicas a
 * serem reproduzidas, representadas como um ArrayList<Faixa>. Desenvolva,
 * para além dos construtores e métodos usuais (get, set), métodos
 * que implementem as seguintes funcionalidades:
 * 
 * @author Rafael Alves
 * @version 1-04-2017
 */
public class Playlist 
{
     /*
      * Variaveis de instancia
      */
     private List<Faixa> Lista;
     private String nome; //Nome da playlist
     /*
      * Contrutor vazio
      */
     public Playlist(){
         this("Na",new ArrayList<Faixa>());
     }
     /*
      * Contrutor por copia
      */
     public Playlist(Playlist x){ 
         this(x.getNome(),x.getLista());
     }
     /*
      * Construtor parametrizado
      */
     public Playlist(String nome, List<Faixa> listagem){
         this.nome=nome;
         this.Lista = listagem;
     }
     
     public void setNome(String nome){
         this.nome = nome;
     }
     
     public String getNome(){
         return this.nome;
     }
     public List<Faixa> getLista(){
        //Deve-se garantir que não se consegue aceder aos dados originais, para isso:
         
        //Criar uma nova lista para onde será copiado todos os elementos existentes na lista original
        List<Faixa> copia = new ArrayList<>();
        
        //copiar todo o conteudo da lista original para a nova lista criada, "copia"
        for(Faixa x : Lista){
            copia.add(x.clone());//alem de fazer a copia de cada elemento para a nova lista, a sua copia é feita com recurso ao clone
        }
        
        /* ALTERNATIVA
         * 
         * this.Lista.forEach(f -> copia.add(f.clone()));
         */       
        return copia;
     }
        
     public String toString(){
         StringBuilder sb = new StringBuilder();
         
         sb.append("Nome da playlist: " + this.nome + "\n");
         
         sb.append(Arrays.toString(Lista.toArray()));
        
         return sb.toString();
     }
     
	
     public boolean equals(Object o) {
    	if (this == o) 
    		return true;
    
    	if (o == null || this.getClass() != o.getClass()){
    		return false;
    	}
    	Playlist p = (Playlist) o;	
    	
    	if (p.getLista().size() != this.Lista.size()){
    		return false; //se o tamanho for diferente da logo falso
    	}
    	//se tamanho igual, ver se todos os elementos estão na outra
    	for (Faixa f : p.getLista()){
    		if (!(this.Lista.contains(f))){
    			return false;
    		}
    	}
    	
    	//se sim, retornar o valor de comparação dos nomes. 
    	return this.nome.equals(p.getNome());
	 }
     
     
     
     public Playlist clone(){
         return new Playlist(this);
     }
     
     public int numFaixas(){
         return Lista.size();
     }
        
     public void addFaixa(Faixa x){ 
         /*
          * DUVIDA: Não percebi o porquê de ter que usar neste caso o clone,sendo apenas para 
          * inserir e não para consultar dados, não vejo a necessidade de usar a segurança do 
          * clone, pela mesma logica entao teria tambem que aplicar o clone no parametro que 
          * passo no removeFaixa
          * 
          * RESPOSTA: Se a Faixa x deixar de existir no sistema, como é que ela passa a ser 
          * representada no arraylist? Por NULL? Daí a necessidade do clone. Garantir que o 
          * que é adicionado à playlist é uma cópia do argumento de entrada, na maior parte 
          * das vezes criado em pura execução e por isso destruído pelo garbage collector quando
          * terminas o programa. O clone neste caso serve para garantir a persistência fora de 
          * execução, como será preciso quando deres IO.
          */
         Lista.add(x.clone());
     }
     
     public void removeFaixa(Faixa m){
         Lista.remove(m);
     }
        
     
     
     
     
     
     
     /*
      * Usando iterador externo
      */
     public void adicionar(List<Faixa> faixas){
         Iterator<Faixa> it = faixas.iterator();
         Faixa m;
         
         while(it.hasNext()){
             m = it.next();
             if(!( Lista.contains(m))){
                 Lista.add(m.clone());
                 //this.addFaixa(m);
                }
         }   
     
     }    
     /*
     * Usando iterador interno - Java 8 - forEach()
     */
     public void adicionarF(List<Faixa> faixas){ 
        faixas.forEach((Faixa m)-> {
                                        if(!(Lista.contains(m))){
                                            Lista.add(m);
                                        }
                                   }
                                   );
     }
     /*
     * Usando iterador interno - Java 8 - Stream
     */
     public void adicionarF2(List<Faixa> faixas){
      // 	this.Lista = Stream.concat(this.Lista.stream(), 	----1º Para quê que colocas-te este codigo?!
        faixas.stream()
              .filter(musica -> (!(Lista.contains(musica.clone()))))//porquê que o contains leva com um clone de musica (musica.clone())
              .map(Faixa::clone)//-------2º porquê que em vez de usar clone, não posso usar o addFaixa?--Não percebi bem ainda como funciona o map
              .collect(Collectors.toList());
     }
        
     /*
      * Respostas:
      * 1. Como creio que disse, normalmente as streams são usadas para retornar, para fazer cálculos.
      * No caso de utilizares para alterar estruturas, tens de reatribuir, sendo que neste caso é um simples
      * concat, que concatena a lista atual (this.Lista.stream()) com os elementos do argumento "faixas" que não
      * existem ainda em "Lista". No fim é tudo recolhido para uma lista (Collectors), atribuída a this.Lista       
      *                 
      *                 
      *2. podes usar o addFaixa mas para isso tens de fazer uma expressão lamda um pouco menos expedita.
      *Achei que assim era mais conciso, até porque ele chama o clone de uma Faixa, tal como na addFaixa.
      *Mas podes tentar. Um bom exercício, aliás. 
      *
      */ 
    
     
     /*
     * Determinar quantas faixas têm uma classificação superior á faixa passada como parametro.
     */
    
     /*
     * Implementando com iterador externo.
     */
     public int classificacaoSuperior(Faixa f){
        int qt=0;    
        Iterator<Faixa> it = Lista.iterator();
        Faixa m;
        
        while(it.hasNext()){
            m = it.next(); //----------DUVIDA! :aqui sou obrigado a fazer m = (Faixa) it.terator() ????? ou posso fazer sem o cast?!
            if(m.getClassificacao() > f.getClassificacao()){
                qt++;
            }
        }
        return qt;
     }
     /*
     * Usando iterador interno - Java 8 - forEach()
     */
     public int classificacaoSuperiorF1(Faixa f){
        List<Faixa> best = new ArrayList<Faixa>();
        
        Lista.forEach((Faixa m) -> {
                                        if(m.getClassificacao() > f.getClassificacao()){
                                            best.add(m.clone());
                                        }
                                  }
                                  );
                                  return best.size();
     }
     /*
     * Usando iterador interno - Java 8 - stream()
     */
     public int classificacaoSuperiorF2(Faixa f){
       return  (int) Lista.stream() /* como o count devolve Long e a função retorna int, temos que fazer o cast para inteiro, daí o (int) logo no inicio do return*/
                    .filter(musica -> (!(musica.getClassificacao() > f.getClassificacao())))
                    /*.collect(Collectors.toList()) //como so preciso do numero de elementos, não preciso de converte-los numa lista,entao é desnecessária esta linha. Alem de que se o fizesse teria que usar o metodo size e nao count para saber o numero de elementos.*/
                    .count();
                    /*.size();*/
     }
    
    
    
    
     
    /*
     * Determinar se alguma faixa tem duração superior ao valor passado como parametro.
     */
    
    /*
     * Implementação com iterador externo
     */
    public boolean duracaoSuperior(double d){
        Iterator<Faixa> it = Lista.iterator();
        Faixa m;

        while(it.hasNext()){
            m = it.next();
            if(m.getDuracao() > d){
                return true;
            }
        }
        return false;
    }
    /*
     * Implementação com iterador interno - Java 8 - Stream
     * 
     */
    public boolean duracaoSuperiorF(double d){ //--------------------------CONFIRMAR SE FUNCIONA!
        return Lista.stream().anyMatch((Faixa m) -> m.getDuracao()>d);
    }
    
    
    
    /*
     * Devolver uma listagem de musicas, em que o valor da sua classificação seja alterado para o 
     * valor passado como parametro.
     */
    
    /*
     * Implementação com o iterador externo
     */
    public List<Faixa> getCopiaFaixas(int n){//----------------------------CONFIRMAR SE FUNCIONA!
        List<Faixa> novaLista = new ArrayList<Faixa>();
        
        Iterator<Faixa> it = Lista.iterator();
        Faixa m;
        
            while(it.hasNext()){
                m=it.next();
                m.setClassificacao(n);
                novaLista.add(m.clone());
            }
            
        return novaLista;
    }
    /*
     * Implementação com iterador interno - Java 8 - forEach
     */
    public List<Faixa> getCopiaFaixasF1(int n){
        List<Faixa> novaLista = new ArrayList<Faixa>();

        Lista.forEach(m -> {        
                            Faixa tmp;
                            tmp=m.clone();
                            tmp.setClassificacao(n);
                            novaLista.add(tmp);
                           }
                      );
        return novaLista;    
    }
    
    /*
     * Implementação com iterador interno
     */ 
    /*
    public List<Faixa> getCopiaFaixasF2(int n){
        return Lista.stream()
                    .map(Faixa::clone)
                    .map((Faixa a) -> a.setClassificacao(n)) //DUVIDA:---- não percebo porqê que nao funciona? O objetivo é criar 1º uma copia da lista e depois alterar as classificações das musicas existentes nessa copia
                    .collect(Collectors.toList());
        
    } 
    */
   
   
   
   /*
    * Determinar duração total da playlist
    */
   /*
    * Implementação com interador externo
    */
   public double duracaoTotal(){
       double total=0;
       Iterator<Faixa> it = Lista.iterator();
       Faixa m;
       
       while(it.hasNext()){
           m=it.next();
           total+=m.getDuracao();
       }
       return total;
   }
   /*
    * Implementação com iterador interno - Java 8 - Stream
    */
   public double duracaoTotalF1(){
      return Lista.stream()
                  .mapToDouble(Faixa::getDuracao)
                  .sum();
    }


  /*
   * Remover as faixas de um determinado autor.
   */
  
  /*
   * Implementação com iterador externo
   */
  public void removeFaixas(String autor){
      Iterator<Faixa> it = Lista.iterator();
      Faixa m;
      while(it.hasNext()){
          m=it.next();
          if(m.getAutor().equals(autor)){
              it.remove();
          }
    }
  }
  
  
  /*
   * Implementação com iterador interno - Stream
   */
  public void removeFaixasF(String autor){
      Lista = Lista.stream()
                  .filter( m -> m.getAutor().equals(autor))
                  .collect(Collectors.toList());
      }

}
  