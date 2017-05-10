import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
/**
 *Uma ficha de informação de um pais, FichaPais, contem 3 atributos: nome do país, continente e 
 *população (real, em milhões). Crie uma classe ListaPaises que permita criar listas de FichaPais 
 *, por uma ordem qualquer, e implemente os seguintes métodos:
 * 
 * @author Rafael Alves
 * @version 13-04-2017
 */
public class ListaPaises
{
    private List<FichaPais> Lista;
    private List<String> ListaPaises = new ArrayList<String>(); //lista necessária para criar uma lista de paises para implementação dos metodos remove, removeF, atualiza e atualizaF
    private String nome; //nome da lista de paises
    
    /*
     * Contrutor parametrizado
     */
    public ListaPaises(String nome, List<FichaPais> lista){
        List<FichaPais> novaLista = new ArrayList<FichaPais>();
        this.nome = nome;
        lista.forEach(f -> novaLista.add(f.clone()));
        this.Lista = novaLista;
    }
        
    /*
     * Construtor vazio
     */
    public ListaPaises(){
        this("Na",new ArrayList<FichaPais>());
    }
    
    /*
     * Construtor por copia
     */
    public ListaPaises(ListaPaises p){
        this(p.getNome(),p.getListaPaises());
    }
         
    
    /*
     * Get's
     */
    public String getNome(){
        return this.nome;
    }
    public List<FichaPais> getListaPaises(){
        List<FichaPais> newLista = new ArrayList<FichaPais>();
        
        this.Lista.forEach(m -> newLista.add(m.clone()));
        
        return newLista; 
    }
    
    /*
     * Set's
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    
    /*
     * Metodos complementares
     */
    public ListaPaises clone(){
        return new ListaPaises(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Nome: " + this.nome + "\n");
        for(FichaPais x : Lista){
            sb.append("Pais: " + x.getPais() + "\n");
            sb.append("Continente: " + x.getContinente() + "\n");
            sb.append("População: " + x.getPopulacao() + "\n");
        }
        return sb.toString();
    }
    
    public String toString2(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Nome: " + this.nome + "\n");
        sb.append(Arrays.toString(Lista.toArray())); //alternativa usada ao for do metodo toString acima
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null) return false;
        if(o instanceof ListaPaises){
            ListaPaises Lst = (ListaPaises) o;
            
            if(Lst.getListaPaises().size()!=this.Lista.size()){                
                return false;
            }else{        
                for(FichaPais x : Lst.getListaPaises()){
                    if(!(Lista.contains(x))){
                        return false;
                    }
                }
                return true;
            }
        }else{
            return false;
        }
    }
    
    
    /*
     * Adicionar um novo pais
     */
    public void adicionar(String nome, String continente, double populacao){
        
        FichaPais fp = new FichaPais(nome, continente, populacao);
        
        /*
         * Alternativa a passar os argumentos logo na criação da ficha pais, tal como na linha de 
         * codigo acima
         */
        /*
            FichaPais fp = new FichaPais();
            
            fp.setPais(nome);
            fp.setContinente(continente);
            fp.setPopulacao(populacao);
        */
        Lista.add(fp);
        
    }
    
    /*
     * Determinar o numero total de paises
     */
    public int numPaises(){
        return Lista.size();
    }
    
    /*
     * Determinar o numero de paises de um continente dado.
     */
    /*
     * Implementar com iterador externo
     */
    public int numPaises(String continente){
        int x=0;
        Iterator<FichaPais> it = Lista.iterator();
    
        while(it.hasNext()){
           if(it.next().getContinente().equals(continente)){
               x++;
            }
        }
        return x;
    }
    
    /*
     * Implementar com iterador interno
     */
    public int numPaisesF(String continente){
        return (int) Lista.stream().filter(fp -> fp.getContinente().equals(continente)).count();
    }
    
    /*
     * Dado o nome de m pais, devolver a sua ficha completa, caso exista.
     */
    /*
     * Imlementar com iterador externo
     */
    public FichaPais getFicha(String nome){
        Iterator<FichaPais> it = Lista.iterator();
        
        while(it.hasNext()){
            FichaPais x = it.next();
            if(x.getPais().equals(nome)){       
                return x;
            }
        }
        return null;
    }

    /*
     * Implementar com iterador interno
     */
    public FichaPais getFichaF(String nome){
        return Lista.stream()
                  .filter(fp -> fp.getPais().equals(nome))
                  .findFirst()
                  .get();
                  /*
                   * Alternativa ao "findFirst().get();" acima usado:
                   * 
                   * .collect(Collectors.toList())
                   * .get(0);
                   */ 
                   
    }
        
     /*
      * Criar uma lista com o nome dos paises com uma população superior a um valor indicado.
      */
     /*
      * Implementar com iterador externo
      */
     public List<String> nomesPaises(double valor){
     List<String> listagem = new ArrayList<String>();
    
     Iterator<FichaPais> it = Lista.iterator();
     FichaPais x;     
     
     while(it.hasNext()){
         x=it.next();
         if(x.getPopulacao()>valor){
             listagem.add(x.getPais());
         }
     }
     return listagem;
    }
    
    
    /*
     * Implementar com iterador Interno
     */
    public List<String> nomesPaisesF(double valor){
        return Lista.stream()
                    .filter(fp -> fp.getPopulacao()>valor)
                    .map(FichaPais::getPais)
                    .collect(Collectors.toList());
    }
    /*
     * Implementar com iterador interno
     */
    public List<String> nomePaisesF2(double valor){
        List<String> listagem = new ArrayList<String>();
        
        Lista.forEach(fp -> {
                                if(fp.getPopulacao()>valor){
                                    listagem.add(fp.getPais());
                                }
                            }
                      );
        return listagem;
    }
    
    
    /*
     * Determinar a lista com os nomes dos continentes dos paises com população superior a um dado valor
     */
    /*
     * Implementar com iterador Externo
     */
    public List<String> nomesContinentes(double valor){
        List<String> listagem = new ArrayList<String>();
        
        Iterator<FichaPais> it = Lista.iterator();
        FichaPais x;
        while(it.hasNext()){
            x = it.next();
            if(x.getPopulacao()>valor && (!(listagem.contains(x.getContinente())))){
                listagem.add(x.getContinente());
            }
        }
        return listagem;
    }
    /*
     * Implementar com iterador Interno
     */
    public List<String> nomesContinentesF(double valor){
    List<String> listagem = new ArrayList<String>();
    
    Lista.forEach((FichaPais fp) -> {
                                        if(fp.getPopulacao()>valor && (!(listagem.contains(fp.getContinente())))){
                                            listagem.add(fp.getContinente());
                                        } 
                                    }
                  );
    return listagem;
    }
    
    /*
     * Determinar o sumatorio das populações de dado continente.
     */
    /*
     * Implementar com iterador Externo
     */
    public double somatorio(String continente){
        Iterator<FichaPais> it = Lista.iterator();
        double quantidade;
        double total=0;
        FichaPais x;
        
        while(it.hasNext()){
            x=it.next();
            if(x.getContinente().equals(continente)){
                quantidade = x.getPopulacao();
                total+=quantidade;
            }
        }
        
        return total;
    }
    /*
     * Implementar com iterador Interno
     */
    public double somatorioF(String continente){
        return Lista.stream()
                    .filter(fp -> fp.getContinente().equals(continente))
                    .mapToDouble(FichaPais::getPopulacao)
                    .sum();   
    }
    
    /*
     * Dada uma lista de FichaPais, para cada pais que exista na lista de paises(comparando paises com base no nome)
     * alterar a sua população com o valor na ficha; caso não exista inserir a ficha na lista.
     */
    
    /*
     * Metodo auxiliar que devolve uma lista apenas com os nomes dos paises. 
     * Este metodo auxiliar é usado nos metodos "atualiza" e "atualizaF".
     * Para que nos metodos "atualiza", primeiramente, se verifique na lista devolvida por este metodo, ListagemPaises, se o
     * pais passado corrente nos metodos "atualiza" existe ou nao nesta lista devolvida por ListagemPais.
     */
    public ArrayList<String> ListagemPaises(){
        ArrayList<String> LstNomePaises = new ArrayList<String>();
        
        Lista.forEach(fp -> LstNomePaises.add(fp.getPais()));
        
        return LstNomePaises;
    }
    
    /*
     * Implementar iterador externo
     */
    public void actualiza(ArrayList<FichaPais> fichas){
        Iterator<FichaPais> it2 = fichas.iterator();
        
        while (it2.hasNext()){
            Iterator<FichaPais> it = Lista.iterator();
            FichaPais x = it.next();
            FichaPais y = it2.next();
            
            if(!(ListagemPaises().contains(y.getPais()))){
                Lista.add(y);
            }else{
                while(it.hasNext()){
                    if(y.getPais().equals(x.getPais())){
                        x.setPopulacao(y.getPopulacao());
                    }
                    x = it.next();
                }
            }
        }
    }

    
    /*
     * Implementando iterador interno
     */
    public void actualizaF(ArrayList<FichaPais> fichas){
        
        fichas.forEach(fp -> { 
                                if(!(ListagemPaises().contains(fp.getPais()))){
                                    Lista.add(fp);
                                }else{
                                    Iterator<FichaPais> it2 = fichas.iterator();
                                    while(it2.hasNext()){
                                        Iterator<FichaPais> it = Lista.iterator();
                                        FichaPais x = it.next();
                                        FichaPais y = it2.next();
                                        
                                        if(y.getPais().equals(x.getPais())){
                                            x.setPopulacao(y.getPopulacao());
                                        }
                                        
                                    }
                                }
                            }
                       );
    }
                                            
   /*
    * Dada uma lista de nomes de paises, remover as suas fichas.
    */
   /*
    * Implementar com iterador externo.
    */
   public void remove(ArrayList<String> paises){

       Iterator<String> it2 = paises.iterator();
       
       while(it2.hasNext()){
           Iterator<FichaPais> it = Lista.iterator();
           String x = it2.next();
           while(it.hasNext()){
               FichaPais p = it.next();
               if(p.getPais().equals(x)){
                   it.remove();
                }
           }
       }
    }
    
    /*
     * Implementar com iterador interno
     */
   public void removeF(ArrayList<String> paises){
       paises.forEach(p -> {
                                Iterator<FichaPais> it = Lista.iterator();
                                while(it.hasNext()){
                                    String x = it.next().getPais();
                                    if(p.equals(x)){
                                        it.remove();
                                    }
                                }
                            }
                      );
                    }   
}