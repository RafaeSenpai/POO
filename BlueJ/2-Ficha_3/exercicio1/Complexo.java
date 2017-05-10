
/**
 * Escreva a descrição da classe Complexo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Complexo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private double a;
    private double b;
    
    public Complexo(){
        a = 0.0;
        b = 0.0;
    }
    
    public Complexo(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    public Complexo(Complexo c){
        a = c.getA();
        b = c.getB();
    }
    
    
    
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    
    public void setA(int x){
        this.a=x;
    }
    public void setB(int x){
        this.b=x;
    }

    
    /*
     * Calcular o conjugado de um complexo
     */
    public Complexo conjugado(){
        return new Complexo(a,-b);
    }
    
    
    /*
     * Soma de dois complexos dado um novo numero complexo como resultado
     */
    public Complexo soma(Complexo c){
        double d = c.getB();//parte imaginaria 
        double cc = c.getA();
        
        return new Complexo(a+cc,b+d);
    }
    
    
    /*
     *Calcular o produto de dois complexos 
     */
    //escrever aqui o metodo


    /*
     * Calcular o reciproco de um complexo
     */
    //escrever aqui o metodo

    
    /*
     * METODOS EXTRA MAS OBRIGATORIOS EM TODAS AS CLASSES
     */
    public boolean equals(Object o){
        if(this==o) {
            return true;//se os dois apontarem para o mesmo sitio entao sao iguais
        }
        
        if(o == null || o.getClass()!=this.getClass()){
            return false;
        }else{
            Complexo c = (Complexo) o;
            return ( (a==c.getA()) &&
                     (b==c.getB()) );
        }
    }
        
    public String toString(){
        return new String("Numero" + a + " " + b + "i");
    }

    public Complexo clone(){
        return new Complexo(this);
    }
}
