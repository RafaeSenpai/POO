import java.util.Scanner;
import java.util.Arrays;
/**
 * Escreva a descrição da classe Exercicio7 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Exercicio7e9
{
    //variaveis de instancia devem ser sempre privadas preferencialmente
 private String[] lstEmpregados = new String[3]; //o tamanho foi reduzido para 3 apenas para facilidade de preencimento de dados
 private String[] lstCargos = new String[3];
 private double[] lstVencimentos = new double[3];
 private double[] lstSalariosT = new double[3];
 private String[] cargos = {"Developer","Gestor","Administrador","CEO"};
 
     public Exercicio7e9(){
        int i;
        Scanner input = new Scanner(System.in);
        String y,x;
        
            System.out.println("Insira os 3 empregados - PRIMA ENTER!");
            for(i=0;i<lstEmpregados.length;i++){
                input.nextLine();//para absorver o '\n' --------------------------------????HA ALGUMA OUTRA FORMA DE CONTORNAR ESTE TIPO DE PROBLEMAS DO '\n'
                            
                System.out.println("Nome:");
                x=input.nextLine();
                lstEmpregados[i]= x;
                
                System.out.println("Cargo:");
                y=input.next();
                    while(!existe(y, cargos)){
                        System.out.println("Cargo inválido!");
                        y=input.next();
                    }
                lstCargos[i]=y;
                      
                System.out.println("Vencimento: ");
                lstVencimentos[i]=input.nextDouble();
                
                System.out.println("\n");
            }
            
            calcSalarios();
            
            System.out.println("\n\n");
            
            listaFuncionarios();
            
            System.out.println("\n\n");            
            
            sumAllVenceBen();
    }
        
    private static boolean existe(String x, String[] array){
        boolean flag=false;
    
            for(int i=0; i<array.length && flag==false;i++){
                if(array[i].equals(x)){
                    flag=true;
                }     
            }
        return flag;
   }
   
   private void calcSalarios(){
       
        for(int i=0;i<lstEmpregados.length;i++){
            if(lstCargos[i].equals("Developer")){
                lstSalariosT[i]=lstVencimentos[i]*1.05;
            }else if(lstCargos[i].equals("Gestor")){
                lstSalariosT[i]=lstVencimentos[i]*1.10;
            }else if(lstCargos[i].equals("Administrador")){
                lstSalariosT[i]=lstVencimentos[i]*1.20;
            }else if(lstCargos[i].equals("CEO")){
                lstSalariosT[i]=lstVencimentos[i]*1.30;
            }
        }
    }
    
    
    private void listaFuncionarios(){
        System.out.println("Listagem dos empregados e seus cargos");
        
        System.out.println("NOME------CARGO------VENCIMENTO------SALARIO TOTAL\n");
        
        for(int i=0; i<lstEmpregados.length; i++){
            System.out.println(lstEmpregados[i] + "------------" + lstCargos[i] + "------------" + lstVencimentos[i] + "------------" + lstSalariosT[i] );
        }        
    }
    
    //Exercicio 9
    private void sumAllVenceBen(){
        double total1=0;
        double total2=0;
        
            for(double x : lstVencimentos){
                total1+=x;
            }
        
            System.out.println("Somatório de todos os valores:");
    
            System.out.println("--> Vencimentos: " + total1);
            
            for(double x : lstSalariosT){
                total2+=x;
            }
            
            System.out.println("--> Beneticios: " + (total2-total1));
        
    }
}
 
