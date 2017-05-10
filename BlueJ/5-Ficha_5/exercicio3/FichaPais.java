
/**
 *Uma fichea de informação de um pais, FichaPais, contem 3 atributos: nome do pais, continente
 * e população(real, em milhoes). Criar uma classe ListaPaises que permita criar listas de
 * FichaPais
 * 
 * @author Rafael Alves
 * @version 12-04-2017
 */
public class FichaPais
{
    /*
     * Variaveis de instancia
     */
    private String pais;
    private String continente;
    private double populacao;
    
    
    /*
     * Construtor parametrizado
     */
    public FichaPais(String nome,String nome2, double valor){
        this.pais = nome;
        this.continente = nome2;
        this.populacao = valor;
    }    
    
    
    
    
    /*
     * Construtor vazio
     */
    public FichaPais(){
        this("Na","Na",0);
    }
    
    
    
    
    /*
     * Contrutor por copia
     */
    public FichaPais(FichaPais fp){
        this(fp.getPais(),fp.getContinente(),fp.getPopulacao());
    }
    
    
    
    
    /*
     * Get's
     */
    public String getPais(){
        return this.pais;
    }
    public String getContinente(){
        return this.continente;
    }
    public double getPopulacao(){
        return this.populacao;
    }
    
    
    
    
    /*
     * Set's
     */
    public void setPais(String nome){
        this.pais = nome;
    }
    public void setContinente(String nome){
        this.continente = nome;
    }
    public void setPopulacao(double valor){
        this.populacao = valor;
    }
    
    
    
    
    /*
     * Metodos complementares
     */
    public FichaPais clone(){
        return new FichaPais(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Pais: " + this.pais + "\n");
        sb.append("Continente " + this.continente + "\n");
        sb.append("População: " + this.populacao + "\n");
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null) return false;
        if(!(o instanceof FichaPais)){
            return false;
        }else{
            FichaPais fp = (FichaPais) o;
            
            return ((fp.getPais().equals(this.pais)) && 
                    (fp.getContinente().equals(this.continente)) && 
                    (fp.getPopulacao() == this.populacao));
        }
    }
        
}
