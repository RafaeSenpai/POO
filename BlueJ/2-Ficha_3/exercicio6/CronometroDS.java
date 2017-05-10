import java.lang.*;
/**
 * Escreva a descrição da classe CronometroDS aqui.
 * 
 * Existe uma probabilidade de o problema estar mal resolvido
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CronometroDS
{
    private int minutos;
    private int segundos;
    private int milisegundos;
    private long stop=0;
    private long sndStop;
    private long start;
    private long tempo2;
    private long tempo1;
    
    public CronometroDS(){
       this.minutos = 0;
       this.segundos = 0;
       this.milisegundos = 0;
    }
    
    public CronometroDS(int x, int y, int z){
        this.minutos = x;
        this.segundos = y;
        this.milisegundos = z;
    }
    
    public CronometroDS(CronometroDS p){
        this.minutos = p.getMin();
        this.segundos = p.getSeg();
        this.milisegundos = p.getMiliSeg();
    }
    
    
    public int getMin(){
        return minutos/1000/60;
    }
    public int getSeg(){
        return segundos/1000;
    }
    public int getMiliSeg(){
        return milisegundos;
    }
    
    public void setMinutos(int x){
        this.minutos = x;
    }
    public void setSegundos (int x){
        this.segundos = x;
    }
    public void setMilisegundos(int x){
        this.milisegundos = x;
    }
    
    
    
    public void inicia(){
        start = System.currentTimeMillis();
    }
    public void parar(){
        if (stop!=0){
            sndStop = System.currentTimeMillis();
        }else{
            stop = System.currentTimeMillis();
        }
    }
    
    public long primeiraParagem(){
        
        tempo1 = stop-start;
        System.out.println("PRIMEIRA PARAGEM\nInicio: " + start);
        System.out.println("Fim: " + stop);
        
        System.out.println("Tempo decorrido: " + tempo1/1000/60 + ":" + tempo1/1000 + ":" + tempo1/100 + "\n\n");
        return tempo1;
    }
    
    public long segundaParagem(){
        

        System.out.println("SEGUNDA PARAGEM\nInicio :" + stop);
        System.out.println("Fim :" + sndStop);
        tempo2 = sndStop - stop;
        System.out.println("Tempo decorrido: " + tempo2/1000/60 + ":" + tempo2/1000 + ":" + tempo2/100 + "\n\n");
        
        return tempo2/1000;
    }
    
    public long tempoSplit(){
        
        System.out.println("TEMPO SPLIT\nPrimeiro temo registado: " + tempo1);
        System.out.println("Segundo tempo registado: " + tempo2);   
        System.out.println("Tempo Split decorrido: " + (tempo2-tempo1)/1000/60 + ":" + (tempo2-tempo1)/1000 + ":" + (tempo2-tempo1)/100 + "\n\n");
        return (tempo2-tempo1)/1000;
    }
    
    public long tempoAbsoluto(){//NÃO ESTÁ OPERACIONAL
        System.out.println("TEMPO ABSOLUTO\nInicio: " + start/1000/60 + ":" + start/1000 + ":" + start/100);
        System.out.println("Fim: " + tempo2/1000/60 + ":" + tempo2/1000 + ":" + tempo2/100);
        System.out.println("Tempo Absoluto decorrido: " + ((start - tempo2)/1000/60) + ":" + ((start - tempo2)/1000) + ":" + ((start - tempo2)/100) + "\n\n");

        return (start - tempo2)/1000;
    }
    
    
    public CronometroDS clone(){
        return new CronometroDS (this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.minutos + ":" + this.segundos + ":" + this.milisegundos + "\n");
        
        return sb.toString();
    }
    
    
}
