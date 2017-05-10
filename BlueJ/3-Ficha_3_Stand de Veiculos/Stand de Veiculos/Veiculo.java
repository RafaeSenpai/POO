import java.util.Scanner;



/**
 * Escreva a descrição da classe Veiculo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Veiculo
{

    private String matricula;
    private double kmT;
    private double kmP;
    private double capParcial;
    private double capTotal;
    private double consumoMedio;
    
    public Veiculo(){
        matricula = "xx-xx-xx";
        kmT = 0;
        kmP = 0;
        capParcial = 0;
        capTotal = 0;
        consumoMedio = 0;
    }
    
    public Veiculo(String matricula, double kmt, double kmp, double parcial, double total, double consMed){
        this.matricula = matricula;
        this.kmT=kmt;
        this.kmP=kmp;
        this.capParcial = parcial;
        this.capTotal = total;
        this.consumoMedio = consMed;
    }
    
    public Veiculo(Veiculo v){
        this.matricula = v.getMat();
        this.kmT = v.getKMT();
        this.kmP = v.getKMP();
        this.capParcial = v.getCapP();
        this.capTotal = v.getCapT();
    }
    
    public String getMat(){
        return matricula;
    }
    public double getKMT(){
        return kmT;
    }
    public double getKMP(){
        return kmP;
    }
    public double getCapP(){
        return capParcial;
    }
    public double getCapT(){
        return capTotal;
    }
    public double getConsMed(){
        return consumoMedio;
    }
    
    public void setMat(String x){
        this.matricula = x;
    }
    public void setKmT(double x){
        this.kmT = x;
    }
    public void setKmP(double x){
        this.kmP = x;
    }
    public void setCapP(double x){
        this.capParcial = x;
    }
    public void setCapT(double x){
        this.capTotal = x;
    }
    public void setConsMed(double x){
        this.consumoMedio = x;
    }

    
    public boolean equals(Object o){
        if(this==o) {
            return true;//se os dois apontarem para o mesmo sitio entao sao iguais
        }
        
        if(o == null || o.getClass()!=this.getClass()){
            return false;
        }else{
            Veiculo c = (Veiculo) o;
            return ( (this.matricula==c.getMat()) &&
                     (this.kmT==c.getKMT()) &&
                     (this.kmP == c.getKMP()) &&
                     (this.capParcial == c.getCapP()) &&
                     (this.capTotal == c.getCapT()) &&
                     (this.consumoMedio == c.getConsMed()));
        }
    }
       
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Matricula: " + this.matricula + "\n");
        sb.append("Km Totais: " + this.kmT + "\n");
        sb.append("Km Parciais" + this.kmP + "\n");
        sb.append("Capacidade Parcial: " + this.capParcial + "\n");
        sb.append("Capacidade Total: " + this.capTotal + "\n");
        sb.append("Consumo médio: " + this.consumoMedio + "\n");
        
        return new String("N" + matricula + " " + kmT + kmP);
    }

    
    public Veiculo clone(){
        return new Veiculo(this);
    }
      
    
    public void abastecer(int litros){ //NUNCA SE FAZEM RINTS EM VOID!!!
          
        if(litros<(capTotal-capParcial)){
            this.capParcial +=litros; 
        }
    }
    
    
    public void resetKms(){
        kmT+=kmP;
        kmP=0.0; 
    }
    
    
    public double autonomia(){
           return (capParcial*kmT)/(capTotal - capParcial);
    }
    
    
    public void registarViagem(int kms, double consumo){
        
        this.kmP +=kms;  
        
        if((this.capParcial -=consumo)<=0){
            this.capParcial = capParcial-(consumo + capTotal); //supondo que o deposito é sempre abastecido até ao máximo
        }
    }
    
    
    public boolean naReserva(){
        return (this.capParcial<=10);

    }
    
    
    public double totalCombustivel(double custoLitro){
        return custoLitro*(capTotal-capParcial);
    }
    
    
    public double custoMedioKm(double custoLitro){
        return (consumoMedio/100)*kmT*custoLitro/kmT;
    }
        
}
    
    
