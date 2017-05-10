import java.time.LocalDateTime;
/**
 * Write a description of class MainTestes here.
 * 
 * @author Rafael Alves
 * @version 03-05-2017
 */
public class MainTestes
{
   public static void main(String[] args){
        Mail ml1 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,01,12,00,00,01),LocalDateTime.of(2017,01,12,00,00,01),"Assunto 1","Texto de email - 1");
        Mail ml2 = new Mail("alvespap@gmail.com", LocalDateTime.of(2017,02,13,14,14,01),LocalDateTime.of(2017,01,12,00,00,01),"Assunto 2","Texto de email - 2");
        Mail ml3 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,03,14,5,45,01),LocalDateTime.of(2017,01,12,00,00,01),"Assunto 3","Texto de email - 3");
        Mail ml4 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,03,14,07,20,02),LocalDateTime.of(2017,01,12,00,00,01),"Assunto 4","Texto de email - 4");
        Mail ml5 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,03,17,15,30,01),LocalDateTime.of(2017,01,12,00,00,01),"Assunto 5","Texto de email - 5");
        Mail ml6 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,03,21,01,23,01), LocalDateTime.of(2017,01,12,00,00,01),"Assunto 6","Texto de email - 6");
        Mail ml7 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,03,28,12,50,01), LocalDateTime.of(2017,01,12,00,00,01),"Assunto 7","Texto de email - 7");
        Mail ml8 = new Mail("alvespap@gmail.com", LocalDateTime.of(2017,01,12,00,00,01), LocalDateTime.of(2017,01,12,00,00,01),"Assunto 8","Texto de email - 8");
        Mail ml9 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,01,12,00,50,23), LocalDateTime.of(2017,01,12,00,00,01),"Assunto 9","Texto de email - 9");
        Mail ml10 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,04,12,13,43,51), LocalDateTime.of(2017,01,12,00,00,01),"Assunto 10","Texto de email - 10");       
        Mail ml11 = new Mail("rales@hotmail.com", LocalDateTime.of(2017,04,22,17,32,21), LocalDateTime.of(2017,01,12,00,00,01),"Assunto 11","Texto de email - 11");

        Map<String,Mail> eMails = new TreeMap<>( MeuComparator());
     
       
       
       /**não foram concluidos os teste nem feitas as classes porque existe uma gralha no enunciado*/
       
    }
}
