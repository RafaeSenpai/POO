import java.util.List;
import java.util.ArrayList;
/**
 * Classe de testes de todos os metodos existentes na classe ListaPaises
 * 
 * @author Rafael Alves
 * @version 20-04-2017
 */
public class MeusTestes
{

    
    
    public static void main(String[] args){
        
        List<FichaPais> paises = new ArrayList<>();
        
        paises.add(new FichaPais("Portugal", "Europa", 1000000));
        paises.add(new FichaPais("França", "Europa", 2000000));
        paises.add(new FichaPais("Alemanha", "Europa", 3000000));
        paises.add(new FichaPais("Suiça", "Europa", 50000));
        paises.add(new FichaPais("Luxembrugo", "Europa", 20000));
        paises.add(new FichaPais("Espanha", "Europa", 300000));
        paises.add(new FichaPais("China", "Asia", 1000000));
        paises.add(new FichaPais("Tibete", "Asia", 2000000));
        paises.add(new FichaPais("Malasia", "Asia", 3000000));
        paises.add(new FichaPais("Mexico", "America", 100000));
        paises.add(new FichaPais("EUA", "America", 9800000));

        
        ListaPaises lista = new ListaPaises("Paises", paises);
        
        
        
        //ListaNomesPaises - Lista de paises a ser usada na classe "remove" - Lista de paises a serem eliminados da lista de fichas de paises
        ArrayList<String> ListaNomesPaises = new ArrayList<String>();

        ListaNomesPaises.add("Portugal");
        ListaNomesPaises.add("Mexico");
        ListaNomesPaises.add("Suiça");
        ListaNomesPaises.add("China");
        
        /* LstPaises - Lista passada como parametro no metodo "atualiza". 
         * 
         * Nota: Contem paises que não existem na lista "Mae",i.e, lista "paises", para se poder confirmar que 
         * esses mesmos paises são adicionados á lista mae
         */
        ArrayList<FichaPais> LstPaises = new ArrayList<FichaPais>();
        LstPaises.add(new FichaPais("Portugal", "Europa", 999999));
        LstPaises.add(new FichaPais("Italia", "Europa", 99999));
        LstPaises.add(new FichaPais("Mexico", "America", 1000009));
        LstPaises.add(new FichaPais("Colombia", "America", 100999));
        LstPaises.add(new FichaPais("Nepal", "Asia", 500999));      
        
        
        
        System.out.println("Lista de Paises em memória:");         
        System.out.println(lista.toString());
        
        System.out.println("\n\nAdicionar: p1-c1-99");        
        lista.adicionar("p1","c1",99);
        System.out.println(lista.toString());
        
        System.out.println("\n\n\nPaises com mais que 1400000 - Iterador externo");
        System.out.println(lista.nomesPaises(1400000).toString());        
                
        System.out.println("\n\n\nPaises com mais que 1400000 - Iterador interno - STREAM");
        System.out.println(lista.nomesPaisesF(1400000).toString());        
        
        System.out.println("\n\n\nPaises com mais que 1400000 - Iterador interno - forEach");
        System.out.println(lista.nomePaisesF2(1400000).toString());        

        
        System.out.println("\n\n\nContinentes com mais que 9000000 - Iterador interno - Iterador externo");
        System.out.println(lista.nomesContinentes(9000000).toString());
        
        System.out.println("\n\n\nContinentes com mais que 9000000 - Iterador interno - Iterador interno - forEach");
        System.out.println(lista.nomesContinentes(9000000).toString());
        
        
        
        System.out.println("\n\n\nSomatorio das populações de um dado continente. Ex: Europa-America-Asia - Iterador externo");        
        System.out.println("Europa: " + lista.somatorio("Europa") + "\n" + "America: " + lista.somatorio("America") + "\n" + "Asia: " + lista.somatorio("Asia"));

        System.out.println("\n\n\nSomatorio das populações de um dado continente. Ex: Europa-America-Asia - Iterador Interno - STREAM");
        System.out.println("Europa: " + lista.somatorioF("Europa") + "\n" + "America: " + lista.somatorioF("America") + "\n" + "Asia: " + lista.somatorioF("Asia"));
        
        
        System.out.println("\n\n\nPara cada pais existente na lista de paises, alterar o valor da sua população com o valor da ficha passada por parametro, caso nao exista adiciona á lista a ficha do pais - Iterador externo");
        System.out.println("Lista de paises a alterar: \n" + "--------------------------- \n" + LstPaises.toString() + "\n" + "--------------------------- \n");
        lista.actualiza(LstPaises);
        System.out.println(lista.toString());
        
        System.out.println("\n\n\nPara cada pais existente na lista de paises, alterar o valor da sua população com o valor da ficha passada por parametro, caso nao exista adiciona á lista a ficha do pais - Iterador Interno - forEach");
        System.out.println("Lista de paises a alterar: \n" + "--------------------------- \n" + LstPaises.toString() + "\n" + "--------------------------- \n");
        lista.actualizaF(LstPaises);
        System.out.println(lista.toString());
     
       
        System.out.println("\n\n\nDada uma lista de nome de paises, remover as suas fichas - Iterador externo");
        System.out.println("Paises a eliminar: " + ListaNomesPaises.toString() + "\n");
        lista.remove(ListaNomesPaises);
        System.out.println(lista.toString());
        
        
        System.out.println("\n\n\nDada uma lista de nome de paises, remover as suas fichas - Iterador interno - forEach");
        System.out.println("Paises a eliminar: " + ListaNomesPaises.toString() + "\n");
        lista.removeF(ListaNomesPaises);
        System.out.println(lista.toString());
        
    }
}
