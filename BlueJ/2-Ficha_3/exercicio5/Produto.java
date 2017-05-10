
/**
 * Exercicio 5 - Um Produto de um dado stock de produtos possui as segudoublees características de informação: código, nome, quantidade
 * em stock, quantidade mínima, preço de compra e preço de venda a público. Desenvolva uma classe Produto.
 * 
 * @author Rafael Alves
 * @version 09.02.2017
 */
public class Produto
{
    /**
     * Variaveis de instancia
     * código, nome, quantidade em stock, quantidade mínima, preço de compra e preço de venda a público
     **/
    
    private String codigo;
    private double quantStock;
    private double quantMin;
    private double quant;
    private double precoCompra;
    private double pvp;
    
    /**
     * Construtores
     */
    public Produto (String cod,double qtS, double qtM, double qt, double precC, double precVP){
        this.codigo = cod;
        this.quantStock = qtS;
        this.quantMin = qtM;
        this.quant = qt;
        this.precoCompra = precC;
        this.pvp = precVP;
    }
    
    public Produto(){
        this("----",0,0,0,0,0);        
    }
    
    public Produto (Produto x){
        this(x.getCod(), 
             x.getQtS(), 
             x.getQtMin(), 
             x.getQt(), 
             x.getPComp(), 
             x.getPVP());
    }
    
    
    
    
    
    /**
     * Metodos de instancia
     */
    
    public String getCod(){
        return this.codigo;
    }
    public double getQtS(){
        return this.quantStock;
    }    
    public double getQtMin(){
        return this.quantMin;
    }
    public double getQt(){
        return this.quant;
    }
    public double getPComp(){
        return this.precoCompra;
    }
    public double getPVP(){
        return this.pvp;
    }
   
    
    public void setCod(String x){
        this.codigo = x;
    }
    public void setQtStk(double x){
        this.quantStock = x;
    }
    public void setQtMin(double x){
        this.quantMin = x;
    }
    public void setQt(double x){
        this.quant=x;
    }
    public void setPComp(double x){
        this.precoCompra = x;
    }
    public void setPVP(double x){
        this.pvp=x;
    }
    
    /**
     * Alterar a quantidade de um produto, ou por saída ou por entrada de uma dada quantidade do produto no stock.
     */
    public void modificaStock(double valor){
        this.setQtStk(valor);
    }
    /**
     * Modificar o código do produto, sabendo que tem de possuir no mínimo 8 caracteres.
     */
    public void alteraCodigo(String codigo){
        if (codigo.length()>8){
            this.codigo=codigo;
        }else{
            System.out.println("Codigo inválido!");
        }
    }
    /**
     * Modificar o preço de venda de um dado produto, sendo que o preço de venda nunca poderá ser inferior ao preço de compra.
     */
    public void setPrecoVenda(double preco){
        if(preco>this.precoCompra){
            this.pvp = preco;
        }else{
            System.out.println("PVP inferior ao preço de compra!");
        }
    }
    /**
     * Modificar o preço de compra, dada uma margem de lucro em percentagem.
     */
    public void defineMargemLucro(double percentagem){
        this.precoCompra = this.precoCompra + (0.01*percentagem*this.precoCompra);
    }
    /**
     * Modificar o stock, dado o valor da compra.
     */
    public void efectuaCompra(double valor){
        double unidades = valor/(this.pvp);
        this.quantStock = this.quantStock - unidades;
    }
    /**
     * Determinar o lucro actual de tal stock em caso de venda total.
     */
    public double lucroTotal(){
        double lucroTotal = (this.quantStock * this.pvp) - (this.quantStock * this.precoCompra);
        System.out.println("Determinar o lucro actual de tal stock em caso de venda total: \n");
        
        return lucroTotal;
    }
    /**
     * Dada uma encomenda de X unidades do produto, determinar o preço total de tal encomenda.
     */
    public double precoTotal(int encomenda){
        double total = encomenda * (this.pvp);
        
        return total;
    }
    /**
     * Verificar se um produto está já abaixo do nível mínimo de stock.
     */
    public boolean abaixoValor(){
        return ((this.quantStock < this.quantMin) ? true:false);
    }
    
    
    
    /**
    * Metodos complementares
    **/
    //verifica a igualdade entre dois objetos supostamente do mesmo tipo
    public boolean equals(Object x){
        if (x!=null && (x instanceof Produto)){//instanceof - verifica apenas se o objeto x tem propriedades para ser uma instancia do tipo produto 
            Produto p = (Produto) x;//se se confirmar que x tem condições, entao torna p no produto x
            return ((this.codigo.equals(p.getCod()) && 
                     this.quantStock == p.getQtS() &&
                     this.quantMin == p.getQtMin() &&
                     this.quant == p.getQt() &&
                     this.precoCompra == p.getPComp() &&
                     this.pvp == p.getPVP()));
        }else{
             return false;
        }           
    }        
    
    //imprime a informação da instancia desta classe   ----------------------CONFIRMAR SE É NECESÁRIO COLOCAR O'X' ANTES DO APPEND EM TODAS AS RESTANTES LINHAS QUE NAO A PRIMEIRA
    public String toString(){
        StringBuilder x = new StringBuilder();
            
        x.append("CODIGO: ").append(this.getCod())
         .append("Quantidade em stock: ").append(this.getQtS())
         .append("Quantidade Minima: ").append(this.getQtMin())
         .append("Quantidade: ").append(this.getQt())
         .append("Preço de compra: ").append(this.getPComp())
         .append("Preço de venda ao publico: ").append(this.getPVP());
         
         
        return x.toString();
    }
    
    //clone
    public Produto clone(){
        return new Produto(this);
    }
    
    
}




