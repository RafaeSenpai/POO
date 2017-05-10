
/**
 * Escreva a descrição da classe ComparadorMinutos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Comparator;

//return -1
public class ComparadorMinutos implements Comparator<Lugar>
{
    public int compare(Lugar l1, Lugar l2)
    {
        if(l1.getMinutos() > l2.getMinutos())
            return 1;
        else if (l1.getMinutos() == l2.getMinutos())
             {
                 return l1.getMatricula().compareTo(l2.getMatricula());
             }
             return -1;
    }
}
