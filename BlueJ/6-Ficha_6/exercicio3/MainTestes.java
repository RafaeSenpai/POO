import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * Main de testes
 * 
 * @author Rafael Alves
 * @version 03-05-2017
 */
public class MainTestes
{
    public static void main ( String[] args){
    ContaPrazo ct1 = new ContaPrazo("aaa1","Tiago Luis",9876,12,4,2010,15);
    ContaPrazo ct2 = new ContaPrazo("aaa2","Manuel Batoca",8765,8,12,2016,27);
    ContaPrazo ct3 = new ContaPrazo("aaa3","Luis Represas",7654,2,3,2011,13);
    ContaPrazo ct4 = new ContaPrazo("aaa4","Joaquim Tiago",6543,1,5,2012,14);
    ContaPrazo ct5 = new ContaPrazo("aaa5","Hugo Oliveira",5432,16,1,2002,19);
    ContaPrazo ct6 = new ContaPrazo("aaa6","Martins Julio",4321,22,10,2008,23);
    ContaPrazo ct7 = new ContaPrazo("aaa7","Carlos Martins",1234,29,12,2002,9);
    ContaPrazo ct8 = new ContaPrazo("aaa8","Manuel Batoca",2345,7,12,2001,8);
    ContaPrazo ct9 = new ContaPrazo("aaa9","Marta Pereira",3456,9,12,2017,7);
    ContaPrazo ct10 = new ContaPrazo("aa10","Joana Dias",4567,1,1,2015,16);
    ContaPrazo ct11 = new ContaPrazo("CODE_BOT","BOT_BOOL_TEST",9999,1,1,2000,0);

    
    
    Map<String,ContaPrazo> bancoDB = new HashMap<>();
    bancoDB.put(ct1.getCodigo(),ct1.clone());
    bancoDB.put(ct2.getCodigo(),ct2.clone());
    bancoDB.put(ct3.getCodigo(),ct3.clone());
    bancoDB.put(ct4.getCodigo(),ct4.clone());
    bancoDB.put(ct5.getCodigo(),ct5.clone());
    bancoDB.put(ct6.getCodigo(),ct6.clone());
    bancoDB.put(ct7.getCodigo(),ct7.clone());
    bancoDB.put(ct8.getCodigo(),ct8.clone());
    bancoDB.put(ct9.getCodigo(),ct9.clone());
    bancoDB.put(ct10.getCodigo(),ct10.clone());

    /**O map abaixo é para testar o equals*/
    Map<String, ContaPrazo> bancoDB2 = new HashMap<>();
    bancoDB2.put(ct1.getCodigo(),ct1.clone());
    bancoDB2.put(ct2.getCodigo(),ct2.clone());
    bancoDB2.put(ct3.getCodigo(),ct3.clone());
    bancoDB2.put(ct4.getCodigo(),ct4.clone());
    bancoDB2.put(ct5.getCodigo(),ct5.clone());
    bancoDB2.put(ct6.getCodigo(),ct6.clone());
    bancoDB2.put(ct7.getCodigo(),ct7.clone());
    bancoDB2.put(ct8.getCodigo(),ct8.clone());
    bancoDB2.put(ct9.getCodigo(),ct9.clone());
    bancoDB2.put(ct10.getCodigo(),ct10.clone());
    bancoDB2.put(ct11.getCodigo(),ct11.clone());//conta que diferencia de DB
    
    Banco xpto = new Banco("MeuBanco",bancoDB);
    Banco xpte = new Banco("MeuBanco",bancoDB2);//BANCOS COM NOMEs IGUAIS MAS UMA CONTA A MAIS NESTE BANCO
    
    System.out.println("Nome do banco: " + xpto.getNome());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");

    
    
    System.out.println("getBancoDB() - Impressão das contas (codigo, conta) existentes no banco: " + xpto.toString() + "\n\n\n");
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");
    
    
    
    System.out.println("equals - Testar se existe diferenças entre os dois bancos \ncom o mesmo nome, mas com DB's diferentes (xpto e xpte).\nNota: Os elementos dentro das DB's são exatamente os mesmos\nRSULTADO: FALSE\n");
    System.out.println(xpto.equals(xpte)); 
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");
    
    
    
    System.out.println("Inserir uma nova conta - conta a inserir: proprietario: BOT_BOOL_TEST2");
    ContaPrazo ct12 = new ContaPrazo("CODE_BOT2","BOT_BOOL_TEST2",9999,1,1,2000,50);
    xpto.inserirConta(ct12);//---------------------------------------NÃO ESTÁ A IMPRIMIR DEVIDAMENTE A TAXA DE JURO NEM A DATA DE CAPITALIZAÇÃO
    System.out.println("Lista após a inserção!");
    System.out.println(xpto.toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");


    
    System.out.println("contasPercencentesA(String nome) - Determinar o conjunto de codigos das contas pertencentes a dado titular \nCaso de: Manuel Batoca\n");
    System.out.println("RECURSO A ITERADOR EXTERNO");
    System.out.println(xpto.contasPercencentesA("Manuel Batoca").toString());
    System.out.println("-------------------------------\n");
    System.out.println("RECURSO A ITERADOR INTERNO");
    System.out.println(xpto.contasPercencentesA("Manuel Batoca").toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");

    
    
    System.out.println("contasCapitalSuperior(double valor) - Determinar os codigos das contas com um capital superior a um dado valor\nEXEMPLO: pra cima de 5000\n");
    System.out.println(xpto.contasCapitalSuperior(5000).toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");

    
    
    
    System.out.println("contasTaxaJuroSup(double valor) - Criar um Map de contas com taxas de juro superior a um valor dado \nEXEMPLO: ACIMA DE 20%\n");
    System.out.println("RECURSO A ITERADOR EXTERNO");
    System.out.println(xpto.contasTaxaJuroSup(20).toString());
    System.out.println("-------------------------------\n");
    System.out.println("RECURSO A ITERADOR INTERNO");
    System.out.println(xpto.contasTaxaJuroSupF(20).keySet() .toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");

    
    
    System.out.println("incrementaTaxasJuro(List<String> lista,double incremento) - Dada uma lista de codigos de contas incrementar \nas suas taxas de juro de um valor X\n - CODIGOS A ALTERAR: aaa1,aaa3,aaa6,aaa8\nJURO A APLICAR: 99%\nITERADOR EXTERNO\n");
    List<String> listagem = new ArrayList<>();
    listagem.add("aaa1");
    listagem.add("aaa3");
    listagem.add("aaa6");
    listagem.add("aaa8");

    xpto.incrementaTaxasJuro(listagem,99);
    System.out.println("Listagem das contas após alteração das taxas de juro\n");
    System.out.println(xpto.toString());
    System.out.println("-------------------------------\n");
    System.out.println("RECURSO A ITERADOR INTERNO\n");
    xpte.incrementaTaxasJuroF(listagem,99);//como existem 2 DB's as alterações dos juros foram feitas agora noutra DB, nomeadamente na bancoDB2, já que a DB1 foi anteriormente alterada
    System.out.println("Listagem das contas após alteração das taxas de juro\n");
    System.out.println(xpto.toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");
    
    
    
    
    System.out.println("getTitulares() - Devolver o nome de todos os titulares de contas\n-Com recurso a iterador externo\n");
    System.out.println(xpto.getTitulares().toString());
    System.out.println("-------------------------------\n");
    System.out.println("RECURSO A ITERADOR INTERNO\n");  
    System.out.println(xpto.getTitularesF().toString());
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+"\n\n\n");


}

}
