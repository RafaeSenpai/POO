import java.util.Scanner;
import java.util.Arrays;


/**
 * Escreva a descrição da classe Exercicio6 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Exercicio6
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
       private int cont=1;
       private int i,n=0;
       private String[] arrayStrings = new String[100000000]; //Não funiona se colocar o tamanho do array com: Integer.MAX_VALUE  
       private String valor="cenas";
       private String x,y;
       private char opcao;
       
   public String[] lerParaArray(){

       Scanner input = new Scanner(System.in);

       while(!valor.equals("fim")){
           System.out.println("Insira a " + cont + "º string a ser adicionada ao array!");
           valor = input.next();
           arrayStrings[n]=valor;
           cont++;
           n++;      
       }
       
      
       String[] array = new String[n];
       
       System.arraycopy(arrayStrings,0,array,0,n);
      
       //"limpar" o escra       
       for(i=0;i<=20;i++){
           System.out.println("");
        }
       
       System.out.println("Escolha a opção, 's' ou'r'!");
       opcao = input.next().charAt(0); //para ler um só carater!
       
       if(opcao=='r'){
           System.out.println("Insira a string que quer remover do array!");
           y = input.next();
           
           remove(array,y);
           
        }else if (opcao=='s'){
           System.out.println("Insira a string que quer substituir no array!");
           x = input.next();
           System.out.println("Insira a nova string que quer colocar no seu lugar!");
           y = input.next();
           
           substitui(array,x,y);
           
        }else{
            
            System.out.println("Opção invalida!");
        }
       System.out.println(Arrays.toString(array));   
    return array;
   }
   

    
   private static String[] remove(String[] array, String x){
    int j=0;
    int i;
       //"limpar" o escra       
       for(i=0; i<=20; i++){
           System.out.println("");
        }
        
       i=0;
       if((Arrays.binarySearch(array,x)) >0){
           String[] novoArray = new String[array.length-1];
          
           while(i<array.length){ //-----------------------------------ERROOO---------------!?????QUANDO SE TRATA DE ELIMINAR O 1º OU ULTIMO VALOR ESTES NAO SAO ELIMINADOS?????????????
            if(array[i].equals(x)){
                i++;
              }else{
                  novoArray[j]= array[i];
                  j++;
                  i++;
            }
           }
            System.out.println(Arrays.toString(novoArray));
            return novoArray;
        }else{
            System.out.println(Arrays.toString(array));
            return array;

        }
    } 
    
 
   private static String[] substitui(String[] array, String x, String y){
    int i=0;
    
        if (Arrays.binarySearch(array,x) >0){
            System.out.println("A string nao se encontra no array!");
        }else{
           while(i<array.length){
               if(!array[i].equals(x)){
                   i++;
                }else{
                    array[i]=y; //--------------------------------------ERRRRROOOOOOOO-----------------??????NÃO FAZ A SUBSTITUIÇÃO DO VALOR NO ARRAY????????
                   
                }
           }
        }       
        
    System.out.println(Arrays.toString(array));
    return array;
   }
   
  }

