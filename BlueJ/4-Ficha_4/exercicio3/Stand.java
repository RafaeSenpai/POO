import java.util.Arrays;
import java.util.ArrayList;
/**
 * Reescrição da classe Stand já desenvolvida, por forma a
 * que passe a utilizar para guardar a colecção de veículos uma instância de
 * GrowingArray .
 * 
 * Note que esta alteração não deverá trazer nenhuma alteração na classe de
 * teste que desenvolveu na aula anterior.
 * 
 * @author Rafael Alves
 * @version 31-03-2017 -- ???
 */

public class Stand//--------------FALTA CRIAR O TOSTRING DOS ELEMENTEOS DO AARAY, SABER SE SE DEVE CRIAR O CLONE E COMO CRIAR, E COMO SE FAZ O EQUALS???????????????????????????????????????????????!!!!!!!!!!!!!!!!!
{
    private ArrayList<Veiculo> listaVeiculos;
    private String nomeStand;
    
    public Stand(){
        listaVeiculos = new ArrayList<Veiculo>();
        nomeStand = "NA";
    }
    
    public void setNomeStand(String x){
        this.nomeStand = x;
    }
    
    public String getNomeStand(){
        return this.nomeStand;
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
