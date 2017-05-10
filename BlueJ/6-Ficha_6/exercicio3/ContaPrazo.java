import java.util.GregorianCalendar;
/**
 * Escreva a descrição da classe ContaPrazo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ContaPrazo
{

    private String codigo;
    private String titular;
    private GregorianCalendar dataCriacao = new GregorianCalendar();
    private GregorianCalendar dataAtual = new GregorianCalendar();
    private GregorianCalendar dataCapitalizacao = new GregorianCalendar();    
    private double capital;
    private double taxa;
    
    
    public ContaPrazo(){
        this.codigo = "Na";
        this.titular = "Na";
        this.dataCriacao = new GregorianCalendar();
        this.capital = 0;
        this.dataCapitalizacao = new GregorianCalendar(1900, GregorianCalendar.JANUARY, 01);
        this.taxa = 0;
    }
    
    public ContaPrazo(String cod, String nome,/* int dia, int mes, int ano,*/ double quantia,int dd, int mm, int aa, double tx){
        this.codigo = cod;
        this.titular = nome;
        /*
         * Não faz sentido ser possivel aquando a criação de uma conta definir a dua data de criação, pois esta deve ser inserida automaticamente.
         * Dai as linhas a baixo estarem comentadas 
        /*    
        this.dataCriacao.set(GregorianCalendar.YEAR, ano);
        this.dataCriacao.set(GregorianCalendar.MONTH, mes);
        this.dataCriacao.set(GregorianCalendar.DAY_OF_MONTH, dia);
        */
        this.capital = quantia;
        this.dataCapitalizacao.set(aa,mm-1,dd);
        /*
         * As duas linhas de codigo a baixo fazem o mesmo que a 1º linha descomentada imediatamente acima.
         */
        //this.dataCapitalizacao.set(GregorianCalendar.MONTH, (mm-1));
        //this.dataCapitalizacao.set(GregorianCalendar.DAY_OF_MONTH, dd);
        this.taxa = tx;
    }
    
    public ContaPrazo(ContaPrazo conta){
        this.codigo = conta.getCodigo();
        this.titular = conta.getTitular();
        this.capital = conta.getCapital();
        this.dataCriacao = conta.getDataCriacao();
        this.dataCapitalizacao = conta.getPrzCapit();
        this.taxa = conta.getTaxa();
    }
    
    
    
    public String getCodigo(){
        return this.codigo;
    }
    public String getTitular(){
        return this.titular;
    }
    public GregorianCalendar getDataCriacao(){
        return this.dataCriacao;
    }
    public double getCapital(){
        return this.capital;
    }
    public GregorianCalendar getPrzCapit(){
        return this.dataCapitalizacao;
    }
    public double getTaxa(){
        return this.taxa;
    }
    
    
    
    public void setCodigo(String x){
        this.codigo = x;
    }
    public void setNome(String x){
        this.titular = x;
    }
    public void setDataCriacao(int dd,int mm,int aa){
        this.dataCriacao.set(GregorianCalendar.DAY_OF_MONTH, dd);
        this.dataCriacao.set(GregorianCalendar.MONTH, (mm-1));
        this.dataCriacao.set(GregorianCalendar.YEAR, aa);
    }
    public void setCapital(double x){
        this.capital = x;
    }
    public void setPrzCapit(int aa, int mm, int dd){
        this.dataCapitalizacao.set(GregorianCalendar.YEAR, aa);
        this.dataCapitalizacao.set(GregorianCalendar.MONTH, (mm-1));
        this.dataCapitalizacao.set(GregorianCalendar.DAY_OF_MONTH, dd);
    }
    public void setTaxa(double x){
        this.taxa = x;
    }
    
    
    
    public ContaPrazo clone(){  // -------------------------------------------------------------------?????O CLONE NAO FUNCIONA NAO SEI PORQUÊ??????
        return new ContaPrazo(this);
    }
    
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        
        if (o == null || o instanceof ContaPrazo){
            ContaPrazo conta = (ContaPrazo) o;
            return (this.getCodigo().equals(conta.getCodigo()) &&
                    this.getTitular() == conta.getTitular() &&
                    this.getDataCriacao().equals(conta.getDataCriacao()) &&
                    this.getCapital() == conta.getCapital() &&
                    this.getPrzCapit() == conta.getPrzCapit() &&
                    this.getTaxa() == conta.getTaxa());
        
        }else{
            return false;
        }
    }
      
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nCodigo de conta: " + this.getCodigo() + "\n");
        sb.append("Titular de conta: " + this.getTitular() + "\n");
        sb.append("Data de criação da conta: " + this.dataCriacao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (1 + this.dataCriacao.get(GregorianCalendar.MONTH)) + "/" + this.dataCriacao.get(GregorianCalendar.YEAR) + "\n");
        sb.append("Capital existente: " + this.getCapital() + "\n");
        sb.append("Prazo de capitalização: " + this.dataCapitalizacao.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (1 + this.dataCapitalizacao.get(GregorianCalendar.MONTH)) + "/" + this.dataCapitalizacao.get(GregorianCalendar.YEAR) + "\n");
        sb.append("Taxa de capitalização: " + this.getTaxa() + "\n");
        
        return sb.toString();
    }
    
    public int diasPassados(){
       int diaAtual = dataAtual.get(GregorianCalendar.DAY_OF_MONTH);
       int mesAtual = 1 + dataAtual.get(GregorianCalendar.MONTH);
       int anoAtual = dataAtual.get(GregorianCalendar.YEAR);
       System.out.println("Data atual: " + diaAtual + "/" + mesAtual + "/" + anoAtual);

       int diaCapitalizacao = dataCapitalizacao.get(GregorianCalendar.DAY_OF_MONTH);
       int mesCapitalizacao = 1 + dataCapitalizacao.get(GregorianCalendar.MONTH);
       int anoCapitalizacao = dataCapitalizacao.get(GregorianCalendar.YEAR);
       System.out.println("Data a capitalizar: " + diaCapitalizacao + "/" + mesCapitalizacao + "/" + anoCapitalizacao + "\n\n");
       
       
       int anos = dataCapitalizacao.get(GregorianCalendar.YEAR) - dataCriacao.get(GregorianCalendar.YEAR);
       int meses = dataCapitalizacao.get(GregorianCalendar.MONTH) - dataCriacao.get(GregorianCalendar.MONTH);
       int dias = dataCapitalizacao.get(GregorianCalendar.DAY_OF_MONTH) - dataCriacao.get(GregorianCalendar.DAY_OF_MONTH);
       System.out.println("Faltam " + anos + " anos, " + meses + " meses e " + dias + " dias, para capitalizar o montante investido!\n---Ou " + ((anos * 365) + (meses * 31) + dias) + "dias!");//não tem em consideração anos bisextos
      
       return (anos * 365) + (meses * 31) + dias; //não tem em consideração anos bisextos
    }
    
    
    
    public void alterarTitular(String nome){
        this.setNome(nome);
    }    
    
    public void alterarTaxa(double taxa){
        this.setTaxa(taxa);
    }


    public void actualizarJuros(GregorianCalendar novaData){
        
        int dia = novaData.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = novaData.get(GregorianCalendar.MONTH);
        int ano = novaData.get(GregorianCalendar.YEAR);
        
        this.dataCapitalizacao.set(GregorianCalendar.DAY_OF_MONTH, dia);
        this.dataCapitalizacao.set(GregorianCalendar.MONTH, mes);
        this.dataCapitalizacao.set(GregorianCalendar.YEAR, ano);
                
    }
   
    
    
    public boolean verificarDiaJuros(){
       int diaAtual = dataAtual.get(GregorianCalendar.DAY_OF_MONTH);
       int mesAtual = 1 + dataAtual.get(GregorianCalendar.MONTH);
       int anoAtual = dataAtual.get(GregorianCalendar.YEAR);

       int diaCapitalizacao = dataCapitalizacao.get(GregorianCalendar.DAY_OF_MONTH);
       int mesCapitalizacao = 1 + dataCapitalizacao.get(GregorianCalendar.MONTH);
       int anoCapitalizacao = dataCapitalizacao.get(GregorianCalendar.YEAR);
        
       return (anoAtual == anoCapitalizacao) && (mesAtual == mesCapitalizacao) && (diaAtual == diaCapitalizacao);   
    }
    
    
    public double fecharConta(){
        if (verificarDiaJuros()){
            this.capital *=((this.taxa*0.01)+1);
            this.taxa = 0;
            return this.capital;
        }else{
            return this.capital;
        }
    }
    
}