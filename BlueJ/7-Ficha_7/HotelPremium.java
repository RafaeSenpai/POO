
/**
 * Considere agora que aos tipos de hotéis já especicados se acrescentam
 * os hotéis Premium , nos quais existe uma taxa de luxo (variável de hotel
 * para hotel), que acresce ao valor do quarto.
 *
 * @author Rafael ALves
 * @version 10-05-2017
 */
public class HotelPremium extends Hotel
{
    /**Variaveis de instancia*/
    private double taxaLuxo;

    /**Construtor parametrizado*/
    public HotelPremium(String codigo, String nome,String localidade,  double precoBQuarto,  int numQuartos, int estrelas,boolean epocaAlta, double taxaLuxo){
        super(codigo,nome,localidade,precoBQuarto,numQuartos,estrelas,epocaAlta);
        this.taxaLuxo = taxaLuxo;
    }

    /**Construtor por copia*/
    public HotelPremium(HotelPremium hp){
        super();
        this.taxaLuxo = hp.getTaxaLuxo();
    }

    public HotelPremium(){
        super();
        this.taxaLuxo = 0;
    }

    public double getTaxaLuxo(){
        return this.taxaLuxo;
    }

    public void setTaxaLuxo(double x){
        this.taxaLuxo = x;
    }

    public HotelPremium clone(){
        return new HotelPremium(this);
    }
    
    public boolean equals(Object o){
        if (super.equals(o)){
            HotelPremium hp = (HotelPremium) o;           
            return hp.getTaxaLuxo()==this.getTaxaLuxo();
        }else{
            return false;
        }    
    }

    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Taxa de Luxo: " + this.getTaxaLuxo());
       
        return sb.toString();
    }
    
    public double getPrecoNoite(){
        if (getEpoca() == true){
            return 20 + getPrecoBaseQuarto();
        }else{
            return getPrecoBaseQuarto();
        }
    }
}
