import java.util.Arrays;
import java.util.Scanner;
 
/**
 * Escreva a descrição da classe exercicio1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */


public class Exercicios1_5
{
    private int[] lista = {12,2,45,66,7,23,99};
   
    public Exercicios1_5(){ 
    
        /*
         * 
         * Com recurso ao foreach
         *  for (int x :lista){ 
         *    System.out.println(x);
         *  }
         *  
        */
        //metodo mais recomendado
        System.out.println(Arrays.toString(lista));
     }
    
    //EXERCICIO 2
    public static int[] lerArrayInt(int n){
        int[] novoArray = new int[n];
        int[] lista = {12,2,45,66,7,23,99};       
        System.arraycopy(lista, 0, novoArray, 0, n); //system.arraycopy(array_fonte,indice_inicial_da_fonte, array_destino, inidice_inicial_destino, numero_de_elementos_a_passar);
        
        System.out.println(Arrays.toString(novoArray)); //imprime todos os elementos do array;
        return novoArray;
    }
    
    
    public static int minPos(int[] arr){
        int[] temp = new int[arr.length];
        int menor=0;
        
        /*
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        */
       
        //alternativa ao for acima
        System.arraycopy(arr, 0,temp,0,arr.length); //copia os elementos para uma array auxiliar, neste caso o array auxiliar chama-se temp
        
        Arrays.sort(temp); //ordena-se por ordem crescente o array copia
        menor = temp[0]; //captura-se o primeiro elemento, pois diz respeito ao menor elemento da lista
        
        
        System.out.println("O array ARR inserido já ordenado!");
        System.out.println(Arrays.toString(arr));
        
        System.out.println("O array TEMP inserido já ordenado!");
        System.out.println(Arrays.toString(temp));
        
        System.out.println("O menor elemento da lista é "+menor);
        System.out.println(Arrays.binarySearch(arr,menor));//_-----------------------------?????????????PORQUÊ QUE DÁ -1(valor devolvido caso nao exista) EM LISTAS QUE CONTÊM O VALOR QUE PROCURO?????????
        
        return 0;//Arrays.binarySearch(arr,menor);
    }
    
    //EXERCICIO 3
    public static int[] lerArrayInt2(int n){ //não está funcional, verificar o funcionamento do insertionsort
        int[] novoArray = new int[n];
        /*
        int aux;
        Scanner valor = new Scanner(System.in);
        
        System.out.println("Insira os" + n + " valores no array!");
        
        for(int i=0;i<=n;i++){
             aux = valor.nextInt();
             for(int x=0; x>=novoArray.length;x++){
                 if(aux<=novoArray[x]){
                   //  x++;
                 }else{
                     novoArray[x]=aux;
                 }
            }
        }*/
        return novoArray;
    }
    
    //EXERCICIO 4
    public static int[] subArray(int[] arr,int i, int f){
        int[] novoArray = new int[f-i+1];
        
        System.arraycopy(arr,i,novoArray,0,f-i+1);
        
        System.out.println(Arrays.toString(novoArray));
        return novoArray;
    
    }
    
    
    //EXERCICIO 5
    public static int[] arrayConcat(int[] arr1, int[] arr2){       
        int i,j;
        int[] array = new int[(arr1.length)+(arr2.length)];
        
        System.arraycopy(arr1,0,array,0,arr1.length);
        System.arraycopy(arr2,0,array,arr1.length,arr2.length);
        
        /* -----------------------------------------------------------------------------------------------------------------------------?????????PORQUÊ QUE MESMO ADICIONANDO A BIBLIOTECA INDICADA, CONTINUA A NÃO ACEITAR A FUNÇÃO????????
        * Caso coloque no inicio do codigo: "package org.apache.commons.lang3;", pode-se recorrer á concatenação do codigo atravez de:
        * 
        *        array = ArrayUtils.addAll(arr1,arr2);
        */
        
        Arrays.sort(array);
        
        System.out.println(Arrays.toString(array));
        return array;
    }
    
}