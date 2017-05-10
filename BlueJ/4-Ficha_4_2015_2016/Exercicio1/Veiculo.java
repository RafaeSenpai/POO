
/**
 * Escreva a descrição da classe Veiculo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Veiculo
{
    private String matricula;
    private double kmsTotal;
    private double kmsParcial;
    private double consumoMedio;
    private int capacidade;
    private int conteudo;
    private double custoMedio;
   
    
    public Veiculo(){
        this.matricula = "ND";
        this.kmsTotal = 0.0;
        this.kmsParcial = 0.0;
        this.consumoMedio = 0.0;
        this.capacidade = 0;
        this.conteudo = 0;
        this.custoMedio = 0.0;
    }
    
    public Veiculo (String matricula,
                    double kmsTotal, 
                    double kmsParcial,
                    double consumoMedio,
                    int capacidade,
                    int conteudo,
                    double custoMedio){
         
                        this.matricula = matricula;
                        this.kmsTotal = kmsTotal;
                        this.kmsParcial = kmsParcial;
                        this.consumoMedio = consumoMedio;
                        this.capacidade = capacidade;
                        this.conteudo = conteudo;
                        this.custoMedio = custoMedio;
                    }
                    
                    
    public Veiculo (Veiculo x){
        /*
        this.matricula = x.getMatricula();
        this.kmsTotal = x.getKmTotal();
        this.kmsParcial = x.getKmsParcial();
        this.consumoMedio = x.getConsumoMedio();
        this.capacidade = x.getCapacidade();
        this.conteudo = x.getConteudo();
        this.tipCombustivel = x.getCombustivel();
        */
       /*Metodo reutilização de codigo*/
       
        this(x.getMatricula(),
             x.getKmsTotal(),
             x.getKmsParcial(),
             x.getConsumoMedio(),
             x.getCapacidade(),
             x.getConteudo(),
             x.getCustoMedio());
    }
            
            
    public String getMatricula(){
       return this.matricula;
    }
    public double getKmsTotal(){
       return this.kmsTotal;
    }
    public double getKmsParcial(){
        return this.kmsParcial;
    }
    public double getConsumoMedio(){
        return this.consumoMedio;
    }
    public int getCapacidade(){
        return this.capacidade;
    }
    public int getConteudo(){
        return this.conteudo;
    }
    public double getCustoMedio(){
        return this.custoMedio;
    }
    
    public void setMatricula(String x){
        this.matricula = x;
    }
    public void setKmsTotal(double x){
        this.kmsTotal = x;
    }
    public void setKmsParcial(double x){
        this.kmsParcial = x;
    }
    public void setConsumoMedio(double x){
        this.consumoMedio = x;
    }
    public void setCapacidade (int x){
        this.capacidade = x;
    }
    public void setConteudo(int x){
        this.conteudo = x;
    }
    public void setCustoMedio(double x){
        this.custoMedio = x;
    }
    
    public Veiculo clone(){
        return new Veiculo (this);
    }
    
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Matricula: " + this.matricula + "\n");
        sb.append("Kilometros Totais: " + this.kmsTotal + "\n");
        sb.append("Kilometros Parciais: " + this.kmsParcial + "\n");
        sb.append("Consumo médio: " + this.consumoMedio + "\n");
        sb.append("Capacidade do depósito: " + this.capacidade + "\n");
        sb.append("Conteudo em depósito: " + this.conteudo + "\n");
        sb.append("Preço/litro do combustivel: " + this.custoMedio + "\n");
    
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null) return false;
        if(o instanceof Veiculo){
            Veiculo v = (Veiculo) o;
            
            return((v.getMatricula().equals(this.getMatricula()) &&
                   (v.getKmsTotal() == this.getKmsTotal()) &&
                   (v.getKmsParcial() == this.getKmsParcial()) &&
                   (v.getConsumoMedio() == this.getConsumoMedio()) &&
                   (v.getCapacidade() == this.getCapacidade()) &&
                   (v.getConteudo() == this.getConteudo())));
        }else{
            return false;
        }
        
        
        
        
    }
        

        
        
        
        
        
        
        
        
        
        
        
        
        
            
}
