import java.util.Arrays;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe Stand aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Stand
{
    private ArrayList<Veiculo> listaVeiculos;

    public Stand(){
        listaVeiculos = new ArrayList<Veiculo>();
    }
    
    //adicionar um carro ao final da lista
    public void addVeiculo(Veiculo x){
        listaVeiculos.add(x);
    }
    
    public String imprimeListaV(){
        return Arrays.toString(listaVeiculos.toArray());
    }
    
    //ver o xº carro adicionado
    public Veiculo getCarro(int x){
        return listaVeiculos.get(x);
    }
    
    //Inserir um veiculo numa dada posição da lista
    public void insereVeiculo(int x,Veiculo p){
        listaVeiculos.add(x,p);
    }
    public void insereVeiculo2(Veiculo x, Veiculo y){
        listaVeiculos.add(listaVeiculos.indexOf (x), y);//indexOf retorna o indice onde ocorre neste caso 'x'
    }
    
    
    public int veiculosEmStock(){
        return listaVeiculos.size();
    }
    
    public void removeVeiculo(Veiculo x){
        listaVeiculos.remove(x);
    }
    
    public void limpaLista(){
        listaVeiculos.clear();
    }
}
