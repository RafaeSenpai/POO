
/**
 * Classe de teste das classes Stand e Veículo.
 * 
 * Neste exercício faça:
 * 
 * 1a) forneça o código necessário (nas classes Stand e TesteStand) para que 
 *    código funcione correctamente
 * 1b) compile, execute e coloque mais testes no método main
 * 
 * 2) Crie, no método main, um sistema de menus, por forma a que seja
 *    o utilizador a inserir os dados que pretende testar.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TesteStand {

  public static void main(String[] args) {
    Veiculo v1, v2, v3, v4, v5;
    Veiculo d1, d2, d3, d4, d5;
    Stand veiculos_utilitarios;
    Stand veiculos_desportivos;
    
    //chamar os construtores (completar!)
    v1 = new Veiculo("01-01-AA",230000,234,34,60,4.3);
    v2 = new Veiculo("05-05-ZZ",5800,300,12,55,6.4);
    v3 = new Veiculo("81-61-VF",64900,654,37,50,8.4);
    v4 = new Veiculo("76-33-GT",97865,234,45,45,3.1);
    v5 = new Veiculo("41-24-OP",948576,345,75,57,9.8);
    
    d1 = new Veiculo("55-GT-33",45000,123,54,60,6.4);
    d2 = new Veiculo("66-HJ-44",12000,432,56,65,8.5);
    d3 = new Veiculo("77-KL-55",23543,678,34,60,4.7);
    d4 = new Veiculo("88-RH-66",76333,123,22,55,6.7);
    d5 = new Veiculo("99-EL-77",8790,124,15,60,7.0);
    
    veiculos_utilitarios = new Stand("Garagem Veiculos Baratos", 10);
    
    veiculos_utilitarios.insereVeiculo(v1);
    veiculos_utilitarios.insereVeiculo(v2);
    veiculos_utilitarios.insereVeiculo(v3);
    veiculos_utilitarios.insereVeiculo(v4);
    veiculos_utilitarios.insereVeiculo(v5);
    
    veiculos_desportivos = new Stand("Garagem Auto Luxo", 10);
    
    veiculos_desportivos.insereVeiculo(v1);
    veiculos_desportivos.insereVeiculo(v2);
    veiculos_desportivos.insereVeiculo(v3);
    veiculos_desportivos.insereVeiculo(v4);
    veiculos_desportivos.insereVeiculo(v5);

    
    System.out.println("Informações do Stand " + veiculos_utilitarios.getNomeStand());
    System.out.println("--------------------------");
    System.out.println("Número de veículos: " + veiculos_utilitarios.getNVeiculos());
    System.out.println("Veículos: ");
    System.out.println(veiculos_utilitarios.toString());
    
    System.out.println("Informações do Stand " + veiculos_desportivos.getNomeStand());
    System.out.println("--------------------------");
    System.out.println("Número de veículos: " + veiculos_desportivos.getNVeiculos());
    System.out.println("Veículos: ");
    System.out.println(veiculos_desportivos.toString());

    
    //o v1 está no stand?
    
    System.out.println("v1 está no stand? " + veiculos_utilitarios.existeVeiculo(v1));
    
    System.out.print("Veículo com mais kms: ");
    Veiculo vx = veiculos_utilitarios.veiculoComMaisKms();
    System.out.println(vx.toString());
    
    
    //....
    // mais operações
      
    
    
  }    
    
    
}
