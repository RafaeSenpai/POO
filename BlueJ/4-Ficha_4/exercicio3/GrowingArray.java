import java.util.ArrayList;
import java.util.List;
/**
 * Usando arrayLists
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GrowingArray
{

    private List<Veiculo> ArrayVeiculos;

    
    /*
     * Construtor por omissão.
     */
    public GrowingArray(){
        this.ArrayVeiculos = new ArrayList<Veiculo>();
        
    }
    
    
    /*
     * Construtor que aceita um tamanho inicial para 
     * o array interno
     */
    public GrowingArray(int capacidade){
        this.ArrayVeiculos = new ArrayList<Veiculo>(capacidade);
    }
    
    /*
     * Método que devolve o Veículo que está na posição 
     * indicada
     */
    public Veiculo get(int indice){
        return ArrayVeiculos.get(indice);
    }
    
    /*
     * método que adiciona um Veiculo à colecção
     */
    public void add(Veiculo v){
        ArrayVeiculos.add(v);
    }
    
    /*
     * método que adiciona um Veiculo na posição indicada
     */
    public void add(int indice, Veiculo v){
        ArrayVeiculos.add(indice, v);
    }
    
    /*
     * método que actualiza o valor de determinada 
     * posição do array interno
     */
    public void set(int indice, Veiculo v){
        ArrayVeiculos.add(indice, v);
    }
   
    /*
     * método que remove do array interno o Veiculo 
     * existente na posição indicação
     */
    public Veiculo remove (int indice){ //----------------------VERIFICAR O QUE DEVOLVE CASO TENTE ELIMINAR UM ELEMENTO DO ARRAY QUE NAO EXISTE
        return ArrayVeiculos.remove(indice);
    }
    
    /*
     * método que remove do array o Veiculo indicado como 
     * parâmetro
     */
    public boolean remove(Veiculo v){
        return ArrayVeiculos.remove(v);
    }
    
    /*
     * Metodo que determina o tamanho da coleção
     */
    public int size(){
        return ArrayVeiculos.size();
    }

    /*
     * método que determina a primeira posição em que ocorre 
     * no array o Veiculo indicado como parâmetro
     */
    public int indexOf(Veiculo v){
       return ArrayVeiculos.indexOf(v);
    }
    
    /*
     * método que determina se um Veiculo está presente na 
     * colecção
     */
    public boolean contains(Veiculo v){
        return ArrayVeiculos.contains(v);
    }
    
    /*
     * método que determina se a colecção tem elementos
     */
    public boolean isEmpty(){
        return ArrayVeiculos.isEmpty();
    }
    
}
