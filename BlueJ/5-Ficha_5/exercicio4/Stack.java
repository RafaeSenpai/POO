import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Uma Stack (ou pilha) é uma estrutura linear do tipo LIFO (last in rst
 * out), ou seja, o último elemento a ser inserido é o primeiro a ser removido.
 * Uma stack possui assim apenas um extremo para inserção e para remoção.
 * Implemente uma Stack de nomes, com as usuais operações sobre stacks:
 * 
 * 
 * • String top() : que determina o elemento no topo da stack;
 * • void push(String s) :insere no topo;
 * • void pop() : remove o elemento do topo da stack, se esta não estiver vazia;
 * • boolean empty() : determina se a stack está vazia;
 * • int length() :determina o comprimento da stack;
 * 
 * @author Rafael Alves
 * @version 18-04-2017
 */
public class Stack
{
    /*
     * Variaveis de instancia
     */
    private List<String> pilha;
    
    
    /*
     * Contrutor parametrizado
     */
    public Stack(List<String> stk){
        pilha = new ArrayList<>();
        stk.forEach(nome -> pilha.add(nome));
    }
    
    /*
     * Construtor vazio
     */
    public Stack(){
        //this(new ArrayList<>());
        pilha = new ArrayList<String>();
    }
    
    /*
     * Construtor por copia
     */
    public Stack(Stack stk){
        this(stk.getStack());
    }
    
    /*
     * Gets
     */
    public List<String> getStack(){
        List<String> novo = new ArrayList<>();
        
        pilha.forEach(posicao -> novo.add(posicao));
        return novo; 
    }
  
    public Stack clone(){
         return new Stack(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(Arrays.toString(pilha.toArray()));
     
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o==this){
            return true;
        }
        if(o instanceof Stack){
            Stack p = (Stack) o;
            
            if(pilha.size() == p.getStack().size()){
                
                int index=0;
                for (String posicao : p.getStack()){
                    if(!(pilha.get(index).equals(posicao))){
                        return false;
                    }
                    index++;
                }
             return true;
            }
        }else{
            return false;
        }
        return false;
    }
    
    
    /*
     * Determina o elemento que se encontra no topo da stack
     */
    public String top(){
        if(!(pilha.size() == 0)){
            return pilha.get(pilha.size()-1);
        }else{
            return null;
        }
    }
    
    /*
     * Insere no topo
     */
    public void push(String s){
        pilha.add(s);
    }
    
    /*
     * Remove o elemento do topo da stack, se esta nao estiver vazia
     */
    public void pop(){
        if(!(pilha.isEmpty())){
            pilha.remove(pilha.size()-1);
        }
    }
    
    /*
     * Determina se a stack está vazia
     */
    public boolean empty(){
        return pilha.isEmpty();
    }
    
    /*
     * Determina o comprimento da stack
     */
    public int length(){
        return pilha.size();
    }
    
}
