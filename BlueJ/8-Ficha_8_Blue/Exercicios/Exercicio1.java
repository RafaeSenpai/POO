import java.util.Scanner;
/**
 * Write a description of class Exercicio1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exercicio1
{
    /**Variaveis de instancia*/
   private int x=1;
   private int countP = -1;
   private int countI = 0;
   private int total = 0;
  
   
   
   public void contaPares(){
       System.out.println("Insira os valores inteiros:\n");
        Scanner sc = new Scanner(System.in);
        while(x != 0){
            x = sc.nextInt();
             
            if((x%2) == 0){
                countP++;
                total+=x;
            }else {
                countI++;
            }
        }
           
        try{
               System.out.println("Pares: " + countP + "\n Impares: " + countI + "Media dos pares: " + (total/countP));  
        }catch(ArithmeticException e) {
            System.out.println("Minha mensagem de erro! " + "Erro de maquina: " + e.getMessage());
        }
   }
}