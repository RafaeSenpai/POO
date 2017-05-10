
/**
 * Escreva a descrição da classe CartaoCliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CartaoCliente
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String titular;
    private String codigo;
    private int pontos;
    private double totalCompras;
    private int valorBonus;
    
    //CONSTRUTORES:
    /*Construtor vazio*/
    public CartaoCliente(){
        this.titular = "xxx";
        this.codigo = "xxx";
        this.pontos = 0;
        this.totalCompras = 0.0;
        this.valorBonus = 0;
    }
    /*COnstrutor parametrizado*/
    public CartaoCliente(String nome, String cod, int numero, double total, int valBonus){
        this.titular = nome;
        this.codigo = cod;
        this.pontos = numero;
        this.totalCompras = total;
        this.valorBonus = valBonus;
    }
    /*Construtor por copia*/
    public CartaoCliente(CartaoCliente x){
        this.titular = x.getTitular();
        this.codigo = x.getCodigo();
        this.pontos = x.getPontos();
        this.totalCompras = x.getTotalC();
        this.valorBonus = x.getValorB();
    }
    
    
    //GETS
    public String getTitular(){
        return this.titular;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public int getPontos(){
        return this.pontos;
    }
    public double getTotalC(){
        return this.totalCompras;
    }
    public int getValorBonus(){
        return this.valorBonus;
    }
    public int getValorB(){
        return this.valorBonus;
    }
    
    //SETS
    public void setTitular(String x){
        this.titular = x;
    }
    public void setCodigo(String x){
        this.codigo = x;
    }
    public void setPontos(int x){
        this.pontos = x;
    }
    public void setTotalC(double x){
        this.totalCompras = x;
    }
    public void setValBonus(int x){
        this.valorBonus = x;
    }
    
    
    //Metodos padrão, i,é, por norma devem sempre existir em todas as classes
    public boolean equals(Object o){
        if(this==o) {
            return true;//se os dois apontarem para o mesmo sitio entao sao iguais
        }
        
        if(o == null || o.getClass()!=this.getClass()){
            return false;
        }else{
            CartaoCliente c = (CartaoCliente) o;
            return ( (this.titular==c.getTitular()) &&
                     (this.codigo==c.getCodigo()) &&
                     (this.pontos == c.getPontos()) &&
                     (this.totalCompras == c.getTotalC()) &&
                     (this.valorBonus == c.getValorB()));
        }
    }
    
        public String toString (){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Codigo do cartao: " + this.codigo + "\n");
        sb.append("Titular: " + this.titular + "\n" );
        sb.append("Numero de pontos: " + this.pontos + "\n");
        sb.append("Valor total em compras: " + this.totalCompras + "\n");
        
        return sb.toString();
    }
    
    public CartaoCliente clone(){
        return new CartaoCliente(this);
    }
    
    
    
    //Metodos pedidos na ficha
    /*
     * Este metodo pedido na ficha já se encontra feito na parte dos construtores
     * 
     * public CartaoCliente(int pontos, int valor, String codigo, String nome, int valorBonus)
     */
    
    
    public void descontar(int menu){
        if (menu==1){
            pontos-=10;
        }else if (menu==2){
            pontos -=20;
        }
    }
    
    //public void setNome(String nome); --- É igual ao setTitular ja feito acima 
    
    //public void setValorBonus(int valorBonus) --- É igual a setValBonus ja feito acima

    public void descarregarPontos(CartaoCliente cartao){
        this.pontos = cartao.getPontos();
        cartao.setPontos(0);
    }
    
    public void efetuarCompra(double valor){
        this.totalCompras += valor;
        
        if(valor<5){
            this.pontos+=1;
        }else{
            this.pontos+=2;
        }
        
    }
    
}

