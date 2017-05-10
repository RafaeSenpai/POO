
/**
 * Classe que representa um Stand de automóveis
 * 
 * @author Rafael Alves
 * @version 2014.03.16  
 * @version 2017.03.03
 */

public class Stand {
  /*
   * variáveis de instância
   */
  private String nomeStand;
  //vetor onde serao guardados os veiculos
  private Veiculo[] carros;
  //número veículos no stand
  private int nveiculos; 
  //capacidade do stand (em número de veículos)
  private int capacidade; 
  //capacidade inicial do Stand: valor por omissão
  public static final int capacidade_inicial = 10;
   
  //construtores
  public Stand() {
    this.nomeStand = new String();
    this.carros = new Veiculo[capacidade_inicial];
    this.capacidade = capacidade_inicial;
    this.nveiculos = 0;
  }
  
  public Stand(String nome, int capacidade) {
    this.nomeStand = nome;
    this.carros = new Veiculo[capacidade];
    this.capacidade = capacidade;
    this.nveiculos = 0;
  }
  
  public Stand(Stand umStand) {
    this.nomeStand  = umStand.getNomeStand();
  //this.carros     = umStand.getCarros();     //------------------------------------------NÃO SEI O QUE PEDE!
    this.capacidade = umStand.getCapacidade();
    this.nveiculos  = umStand.getNVeiculos();
  }
  
  //métodos de instância
  public String getNomeStand(){
      return this.nomeStand;
  }
  /*
  public Veiculo getCarros(){
    //------------------------------------------NÃO SEI O QUE PEDE!
    }
  */
  public int getCapacidade(){
      return this.capacidade;
  }
  public int getNVeiculos(){
      return this.nveiculos;
  }
  
  public void setNomeStand(String x){
      this.nomeStand=x;
  }
  public void setCapacidade(int x){
      this.capacidade=x;
  }
  /*
  public void setCarros(Veiculo x){
          //------------------------------------------NÃO SEI O QUE PEDE!
  }
  */
  /*
   * nao faz grande nexo a existencia do metodo abaixo, pois a umero de veiculos incrementa ou 
   * decrementa automaticamente consoante a inserção ou eliminação de veiculos
   */
  public void setNVeiculos(int x){
      this.nveiculos=x;
  }
  //outros métodos
  
  /**
   * Método que insere um veículo no stand
   * 
   */
   public void insereVeiculo(Veiculo v) {
    carros[nveiculos]=v;
    nveiculos++;
    }
   
   
   /**
    * Método que verifica se um determinado veículo está no
    * stand.
    */
    public boolean existeVeiculo(Veiculo v) {
           for(int i=0; i<=nveiculos; i++){
            if(carros[i]==v){
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * Método que verifica se um veículo, cuja matrícula é conhecida, 
     * está no stand.
     */
    public boolean existeVeiculoPorMatricula(String matricula) {
        for(int i = 0; i<=nveiculos; i++){
            if(carros[i].getMat().equals(matricula)){
                return true;
            }
        }
        return false;
    }
    
    
    /** 
     * Método que devolve o veículo com mais kms.
     * 
     */
    public Veiculo veiculoComMaisKms() {
        double km=0.0;
        int indice=0;
        for(int i = 0; i<=nveiculos; i++){
            if(carros[i].getKMT()>km){
                km=carros[i].getKMT();
                indice = i;
            }
        }
        
        
        return carros[indice];
    }
    
    /**
     * Método que devolve o veículo mais gastador (em termos de
     * combustível).
     */
    public Veiculo veiculoMaisGastador() {
  
        double consumoMed=0.0;
        int indice=0;
        for(int i = 0; i<=nveiculos; i++){
            if(carros[i].getKMT()>consumoMed){
                consumoMed=carros[i].getConsMed();
                indice = i;
            }
        }
        
        
        return carros[indice];
    }
    
    /**
     * Método que determina o número de kms de todos os veículos
     * da garagem.
     * 
     */
    public double totalKmsTodosVeiculos() {
        int kmTOTAL=0;
        for(int i=0; i<=nveiculos; i++){
            kmTOTAL +=carros[i].getKMT();
        }
        return kmTOTAL;
    }
    
    
    
  
    //capacidade do stand (em número de veículos)
    private int capacidade(){
        return this.capacidade;
    }
    
    /**
     * equals
     * 
     */
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
    
        if(this==null | o.getClass()!=this.getClass()){
            return false;
        }else{
            Stand c = (Stand) o;
            return ( (this.nomeStand == c.getNomeStand()) &&
                     (this.nveiculos == c.getNVeiculos()) &&
                     (this.capacidade == c.getCapacidade()));    
        }
    }
            
            
            
            
            
    /**
     * toString
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Nome do stand" + nomeStand + "\n");
        for(Veiculo x: carros){        
            sb.append("Ficha do veiculo:\n" + x);       //confirmar se imprime corretamente a ficha de cada veiculo existente no stand
        }
        return sb.toString();
    }
    
    /**
     * clone
     */
    public Stand clone() {
        return new Stand(this);
    }
    
}
