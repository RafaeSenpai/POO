
/**
 * Escreva a descrição da classe TesteParque aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TesteParque
{
    public static void main(){
        Lugar l1, l2, l3, l4, l5;
        Parque p1, p2;
        
        l1 = new Lugar("CD-23-45", "Zé",60, false);
        l2 = new Lugar("CD-24-45", "TóZé",30, false);
        l3 = new Lugar("CD-25-45", "Tó",25, false);
        l4 = new Lugar("CD-26-45", "Mendes",20, true);
        l5 = new Lugar("CD-27-45", "Freitas",10, true);
        
        p1 = new Parque();
        p1.setNome("Braga Parque");
        p1.novoLugar(l1);
        p1.novoLugar(l2);
        p1.novoLugar(l3);
        p1.novoLugar(l4);
        p1.novoLugar(l5);
        
        System.out.println(p1.toString());
        
        System.out.println(p1.matriculas());
        
        
        System.out.println("Quantidade de minutos: " + p1.quantidadeMinutos());
        
        System.out.println("Ordenado por tempo: \n");
        System.out.println(p1.lugaresOrdenadosPorTempo().toString());
        
        
    }
}
