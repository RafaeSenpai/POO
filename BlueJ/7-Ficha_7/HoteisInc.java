import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
/**
 * Um Hotel é a entidade base da aplicação, que contém um codigo de identi-
 * cação, um nome , uma localidade , uma categoria (normalmente expressa
 * em estrelas), um número de quartos disponíveis e um preço por quarto.
 * Actualmente a cadeia de hotéis faz equipamentos homogéneos a nível de quarto,
 * pelo que todos os quartos de um hotel são do mesmo tipo (previsivelmente esta
 * situação mudará num futuro próximo).
 * 
 * @author Rafael Alves 
 * @version 05-05-2017
 */
public class HoteisInc
{

    /*
     * Variaveis de instancia
     */
    private Map<String, Hotel> empresaIncBD = new HashMap<>();
    
    /** Fase 1 */
    /*
     * Verifica a existencia de um hotel, dado o seu codigo
     */
    public boolean existeHotel(String cod){
        return empresaIncBD.containsKey(cod);
    }
    
    
    /*
     * Devolve a quantidade de hoteis existentes na cadeia
     */
    public int quantos(){
        return empresaIncBD.keySet().size();
    }       
    
    
    /*
     * Devolver o numero total de hoteis de uma dada localidade
     */
    public int qantos(String loc){
        return (int) empresaIncBD.values()
                                 .stream()
                                 .filter(hotel -> hotel.getLocalidade().equals(loc))
                                 .count();
    }
    
    public int quantoT(String tipo){
        
        return (int) empresaIncBD.values().stream().filter(hotel -> hotel.getClass().getSimpleName().equals(tipo)).count(); 
        
    }
    
    /*
     * Devolver a ficha de um hotel, dado o seu codigo
     */
    public Hotel getHotel(String cod){
        return empresaIncBD.get(cod);
    }
    
    /*
     * Adiciona a informação de um novo hotel
     */
    public void adiciona(Hotel h){
        empresaIncBD.put(h.getCodigo(),h.clone());
    }
    
    /*
     * Devolver uma lista contendo a copia de todos os hoteis 
     */
    public List<Hotel> getHoteis(){
        return empresaIncBD.values().stream().map(Hotel::clone).collect(Collectors.toList());
    }
    
    
    /*
     * Adicionar a informação de um conjunto de hoteis
     */
    public void adiciona(Set<Hotel> hs){
        hs.stream().forEach(hotel -> empresaIncBD.put(hotel.getCodigo(),hotel.clone()));
    }
    
    /*
     * Alterar os estado da epoca de todos os hoteis
     * NOTA: no enunciado o parametro passado ao metodo e de uma string, 
     *       mas como inicialmente foi definido como sendo bool, fez-se 
     *       essa alteraçao aqui no tipo do parametro a passar ao metodo
     */
    public void mudaPara(boolean epoca){ //--------------------------------------------------------------CONFIRMAR!!!!
        empresaIncBD.values().forEach(hotel -> hotel.setEpoca(epoca));
    }
    
    
}
