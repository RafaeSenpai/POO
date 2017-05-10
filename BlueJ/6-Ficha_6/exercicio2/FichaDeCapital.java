
/**
 * Crie uma classe Paises que estabeleça uma correspondência entre o nome
 * de um dado país e a informação sobre a sua capital ( FichaDeCapital ),
 * designadamente: nome da cidade, população, número de veículos, salário
 * médio (real) e custo de vida mensal médio (real).
 * 
 * @author Rafael Alves
 * @version 28-04-2017
 */
public class FichaDeCapital
{
    /*
     * Variaveis de instancia
     */
    private String nomeCidade;
    private double populacao;
    private double numVeiculos;
    private int salarioMedioMensal;
    private int custoVidaMedioMensal;
    
    /*
     * Construtor parametrizado
     */
    public FichaDeCapital(String cidade,double vl1, double vl2, int smm,int cvmm){
        this.nomeCidade = cidade;
        this.populacao = vl1;
        this.numVeiculos = vl2;
        this.salarioMedioMensal = smm;
        this.custoVidaMedioMensal = cvmm;
    }
    /*
     * Construtor vazio
     */
    public FichaDeCapital(){
        this("Na",0,0,0,0);
    }
    /*
     * Construtor por cópia
     */
    public FichaDeCapital(FichaDeCapital f){
        this(f.getCidade(),
             f.getPopulacao(),
             f.getVeiculos(),
             f.getSalarioMedio(),
             f.getCustoVidaMedio());
    }
    
    
    /*
     * GET's
     */
    public String getCidade(){
        return this.nomeCidade;
    }
    public double getPopulacao(){
        return this.populacao;
    }
    public double getVeiculos(){
        return this.numVeiculos;
    }
    public int getSalarioMedio(){
        return this.salarioMedioMensal;
    }
    public int getCustoVidaMedio(){
        return this.custoVidaMedioMensal;
    }
    
    
    /*
     * SET's
     */
    public void setNomeCidade(String nome){
        this.nomeCidade = nome;
    }
    public void setPopulacao(double val){
        this.populacao = val;
    }
    public void setVeiculos(double val){
        this.numVeiculos = val;
    }
    public void setSalarioMedio(int val){
        this.salarioMedioMensal = val;
    }
    public void setCustoVidaMedio(int val){
        this.custoVidaMedioMensal = val;
    }
    
    /*
     * Clone
     */
    public FichaDeCapital clone(){
        return new FichaDeCapital(this);
    }
    
    
    /*
     * Equals
     */
    public boolean equals (Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof FichaDeCapital){
            FichaDeCapital p = (FichaDeCapital) o;
            
            return (p.getCidade().equals(this.nomeCidade) &&
                    p.getPopulacao() == this.populacao &&
                    p.getVeiculos() == this.numVeiculos &&
                    p.getSalarioMedio() == this.salarioMedioMensal &&
                    p.getCustoVidaMedio() == this.custoVidaMedioMensal);
        }else{
            return false;
        }
    }
    
    
    /*
     * ToString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Capital: " + this.getCidade() + "\n");
        sb.append("População: " + this.getPopulacao() + "\n");
        sb.append("Numero de Veiculos: " + this.getVeiculos() + "\n");
        sb.append("Salario Médio Mensal: " + this.getSalarioMedio() + "\n");
        sb.append("Custo de Vida Medio Mensal: " + this.getCustoVidaMedio() + "\n");
        
        return sb.toString();
    }
}
