
/**
 * Write a description of class Discount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Discount extends Hotel
{

    public Discount (String codigo, String nome, String localidade, double precoBaseQuarto, int numQuartos, int estrelas, boolean epoca){
        super(codigo, nome, localidade, precoBaseQuarto, numQuartos, estrelas, epoca);
    }
    
    public Discount(){
        super();
    }
    
    public Discount(Discount hd){
        super();
    }
    
    public double getPrecoNoite(){
        if(getEpoca() == true){
            return 20 + getPrecoBaseQuarto();
        }else{
            return getPrecoBaseQuarto();
        }
    }
    
    public Discount clone(){
        return new Discount(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
    
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
