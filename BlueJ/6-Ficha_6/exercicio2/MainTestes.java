import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * Classe responsavel pelos testes no programa
 * 
 * @author Rafael Alves 
 * @version 01-05-2017
 */
public class MainTestes
{
    public static void main(String[] args){
  
    Map<String,FichaDeCapital> Lista = new HashMap<String,FichaDeCapital>();
    
    FichaDeCapital a = new FichaDeCapital("Lisboa",1900098,4000000,1200,1000);
    FichaDeCapital b = new FichaDeCapital("Paris",4000000,8700000,1800,1700);
    FichaDeCapital c = new FichaDeCapital("Madrid",2300098,1200000,2300,2000);
    FichaDeCapital d = new FichaDeCapital("Berlim",4500098,6800000,3200,3000);
    FichaDeCapital e = new FichaDeCapital("Moscou",2500098,5600000,1800,1000);
    FichaDeCapital f = new FichaDeCapital("Roma",4300098,7000000,5200,4000);
    
    Lista.put("Portugal",a);
    Lista.put("França",b);
    Lista.put("Espanha",c);
    Lista.put("Alemanha",d);
    Lista.put("Russia",e);
    Lista.put("Italia",f);   
    
    Paises p = new Paises("Lista de 2017",Lista);
    
    System.out.println("Impressão da lista de paises e suas respetivas ficha de capital");
    System.out.println(p.toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    
    System.out.println("numTotalPaises - Determinar numero total de paises - tem de dar 6");
    System.out.println(p.numTotalPaises());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
  
    
    System.out.println("PiasesComPopAcimaDeF(2500000) - Devolver os nomes de paises com \ncapitais com população acima de um valor dado.");
    System.out.println(p.PiasesComPopAcimaDeF(2500000));
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    
    System.out.println("PiasesComPopAcimaDe(2500000) - Devolver os nomes de paises com \ncapitais com população acima de um valor dado.\nTem de dar 4");
    System.out.println(p.PiasesComPopAcimaDe(2500000));
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    
    System.out.println("getFichaCapital(Russia) - Dado o nome de um pais, devolver a ficha \nda sua capital.");
    System.out.println(p.getFichaCapital("Russia").toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    
    System.out.println("alterarPopulacao(Portugal,300000000) - Altera a população da \ncapital de um dado pais");
    p.alterarPopulacao("Portugal",300000000);
    System.out.println("|*-----------------------------------*|");
    System.out.println("Impressão da lista após editar população de portugal");
    System.out.println(p.toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    
    FichaDeCapital g = new FichaDeCapital("Leon",439000,604098,4609,4600);
    System.out.println("inserePais(Suiça) - Dado o nome de um pais, devolver a ficha \nda sua capital.");
    p.inserePais("Suiça",g);
    System.out.println("|*-----------------------------------*|");
    System.out.println("Impressão da lista após inserir o pais Suiça e respetiva ficha \nde capital");
    System.out.println(p.toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
        
    System.out.println("listaCapitaisF() - Criar uma listagem com os nomes de todas as \ncapitais registadas.");
    System.out.println(p.listaCapitaisF());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    
    System.out.println("listaCapitais() - Criar uma listagem com os nomes de todas as \ncapitais registadas.");
    System.out.println(p.listaCapitais());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
        
    System.out.println("somaPopulacoesF() - Determinar o somatorio de todas as populações das capitais.");
    System.out.println(p.somaPopulacoesF());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
      
    System.out.println("somaPopulacoes() - Determinar o somatorio de todas as populações das capitais.");
    System.out.println(p.somaPopulacoes());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
      
    List<String> listagem = new ArrayList<>();
    listagem.add("Suiça");  
    listagem.add("Portugal");
    listagem.add("Espanha");
    listagem.add("Alemanha");

    
    System.out.println("removeFichas(listagem) - Dado um conjunto de nomes de paises , remover  \nas suas fichas de capital");
    p.removeFichas(listagem);
    System.out.println("|*-----------------------------------*|");
    System.out.println("Impressão da lista após remover Portugal, espanha, suiça e alemanha");
    System.out.println(p.toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
 
   }
}