import java.util.Arrays;
/**
 * Usando um simples array
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class StandCopia
{
    private Veiculo[] elementos;
    private int tamanho;
    private static final int capacidade_inicial = 10;
    
    public StandCopia(){
        this(capacidade_inicial);
    }
    
    public StandCopia(int capacidade){
        this.elementos = new Veiculo[capacidade];
        this.tamanho=0;
    }
    
    private void aumentaArray(int tamanho){
        if(tamanho>0.8*this.elementos.length){
            int nova_capacidade = 2*this.elementos.length;
            this.elementos = Arrays.copyOf(this.elementos,nova_capacidade);
        }
    }
    
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
    
    public void add(Veiculo v){        
        //System.out.println("tamanho do array: " + elementos.length);
        elementos[tamanho]=v;
        tamanho++;
        //System.out.println("Elemento inserido no array: " + elementos[tamanho-1]);
    }
    
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
    
    public void set(int indice, Veiculo v){
        if(indice<=tamanho){
            elementos[indice] = v;
        }
    }
    
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
        
    public int size(){
        return tamanho;
    }
    
    public int indexOf(Veiculo v){
        for(int i=0;i<=tamanho; i++){
            if(elementos[i]==v){
                return i;
            }
        }
        return -1;
    }
    
    public boolean contains(Veiculo v){
        for(int i=0; i<=tamanho; i++){
            if(elementos[i]==v){
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        return (tamanho==0);
    }
}