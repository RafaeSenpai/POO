import java.util.Arrays;
/**
 * Construa uma classe, GrowingArray, que permita gerir uma coleção de Veí-
 * culo, que seja internamente assegurada por um array. A classe GrowingArray
 * deverá providenciar uma série de métodos que permite ao programador a
 * sua utilização e internamente deverá garantir que o array onde os veículos
 * são guardados tem sempre espaço disponível para tal.
 * 
 * @author Rafael Alves
 * @version 31.03.2017
 */
public class GrowingArray
{
    /*
     * Variaveis de instancia
     */
    private Veiculo[] elementos;
    private int tamanho;
    private static final int capacidade_inicial = 3; //optou-se por um numero baixo para verificar rapidamente a alocação automatica de memoria
     
    /*
     * Construtor por omissão
     */
    public GrowingArray(){
        this(capacidade_inicial);
    }
    
    /*
     * Construtor que aceita um tamanho inicial para o array interno
     */
    public GrowingArray(int capacidade){
        this.elementos = new Veiculo[capacidade];
        this.tamanho=0;
    }
    
    /*
     * metodo complemtentar que aumenta automaticamente a capacidade do array caso necessário 
     */
    private void aumentaArray(){

            int nova_capacidade = 2*this.elementos.length;
            this.elementos = Arrays.copyOf(this.elementos,nova_capacidade);
       
    }
    
    /*
     * Metodo que devolve o veiculo que se encontra no array no indice indicado pelo utilizador
     */
    public Veiculo get(int indice){         
     if(indice<=tamanho){
        int i=0;
        for(int x=0; x<=tamanho; x++){
            if(i==indice){
                return elementos[x];
            }else{
                i++;
            }
        }
     }
     return null;
    }
    
    /*
     * Metodo que adiciona um veiculo á colecção
     */
    public void add(Veiculo v){        
        elementos[tamanho]=v;
        tamanho++;
        if(tamanho>=0.8*capacidade_inicial){
            aumentaArray();
        }
    }
    
    /*
     * Metodo que adiciona um veiculo á coleção numa determinada posição do array
     */
    public void add(int indice,Veiculo v){   
        if(indice<=tamanho){
         int i;
         tamanho++;  
            for(i=tamanho; i>indice; i--){
                elementos[i]=elementos[i-1];
            } 
         elementos[indice]=v;
        }
    }
    
    /*
     * Metodo que atualiza o valor de determinada posição do array interno
     */
    public void set(int indice, Veiculo v){
        if(indice<=tamanho){
            elementos[indice] = v;
        }
    }
    
    /*
     * Metodo que remove do array interno o veiculo existente na posição indicada
     */
    public Veiculo remove(int indice){
        if(indice<=tamanho){
            int x = indice+1;
            int i;
                for(i=indice; i<tamanho;i++,x++){
                    elementos[i]=elementos[x];
                }
                
            tamanho--;
        } 
        return elementos[indice];
    }
    
    /*
     * Metodo que remove do array interno o veiculo indicado como parametro
     */
    public boolean remove(Veiculo x){       
        for(int i=0; i<=tamanho; i++){

            if(elementos[i]==x){
                int j=i+1;
                for(; i<tamanho;i++,j++){
                    elementos[i]=elementos[j];
                }
                tamanho--;
                
                return true;
            }
        }              
        return false;
    }
        
    /*
     * Metodo que determina o tamanho da colecção
     */
    public int size(){
        return tamanho;
    }
    
    /*
     * Metodo que determina a primeira posição em que ocorre no array o Veiculo inidicado como parametro
     */
    public int indexOf(Veiculo v){
        for(int i=0;i<=tamanho; i++){
            if(elementos[i]==v){
                return i;
            }
        }
        return -1;
    }
    
    /*
     * Metodo que determina se um dado veiculo está presente na colecção
     */
    public boolean contains(Veiculo v){
        for(int i=0; i<=tamanho; i++){
            if(elementos[i]==v){
                return true;
            }
        }
        return false;
    }
    
    /*
     * Metodo que determina se a colecção tem elementos
     */
    public boolean isEmpty(){
        return (tamanho==0);
    }
    
    /*
     * equals
     * 
     */
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
    
        if(this==null | o.getClass()!=this.getClass()){
            return false;
        }else{
            GrowingArray c = (GrowingArray) o;
            return (this.tamanho == c.size());    
        }
    }
            
    /*
     * toString
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Tamanho alocado para o Array: " + elementos.length + " elementos\n");
        sb.append("Numero de carros no Array: " + tamanho + "\n");
        sb.append("Ficha dos veiculos:\n" );
        for(int i=0; elementos[i]!=null; i++){            
            sb.append("|---> "+ elementos[i] + "\n");       //confirmar se imprime corretamente a ficha de cada veiculo existente no stand
        }
        return sb.toString();
    }
    
    /*
     * clone
     */
    //public GrowingArray clone() {   //NAO PERCEBO O QUE ESTA ERRADO!
    //    return new GrowingArray(this);
    //}
    
}