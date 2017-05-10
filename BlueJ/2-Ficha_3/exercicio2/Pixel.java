
/**
 * Escreva a descrição da classe Pixel aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Pixel
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int cor;
    private int cordX, cordY;
    
    public Pixel(){
        cor = 0;
        cordX = 0;
        cordY = 0;
    }
    
    public Pixel (int cor, int x, int y){
        this.cor = cor;
        this.cordX = x;
        this.cordY = y;
    }
    
    public Pixel(Pixel p){
        this.cor = p.getCor();
        this.cordX = p.getCordX();
        this.cordY = p.getCordY();
    }
    
    
    public int getCor(){
        return cor;
    }
    public int getCordX(){
        return cordX;
    }
    public int getCordY(){
        return cordY;
    }

    public void setCor(int x){
        this.cor=x;
    }
    public void setCordX (int x){
        this.cordX = x;
    }
    public void setCordY(int x){
        this.cordY = x;
    }
    
    
    public Pixel clone(){
        return new Pixel(this);
    }
        
    
    public boolean equals(Object o){
        if(this==o) return true;
        
        if(o==null || o.getClass()!=this.getClass()){
            return false;
        }else{
            Pixel c = (Pixel) o;
            return (this.cor == c.getCor()) &&
                   (this.cordX == c.getCordX()) &&
                   (this.cordY == c.getCordY());
        }
    }
    
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
            sb.append("Cor: " + this.cor);
            sb.append("X: " + this.cordX);
            sb.append("Y: " + this.cordY);
        return sb.toString();
    }
    
    
    public void desloca(double x, double y){
        this.cordX +=x;
        this.cordY +=y;
    }

    
    public void mudarCor(int cor){
        if(cor>=0 && cor<=15){
            setCor(cor);
        }
    }

    
    public String nomeCor(){
         String nome;
         
         switch(this.cor){
             case 0: nome = "Preto";
                     break;
             case 1: nome = "Azul marinho";
                     break;
             case 2: nome = "Verde Escuro";
                     break;
             case 3: nome = "Azul petróleo";
                     break;
             case 4: nome = "Castanho";
                     break;
             case 5: nome = "Púrpura";
                     break;
             case 6: nome = "Verde oliva";
                     break;
             case 7: nome = "Cinza claro";
                     break;
             case 8: nome = "Cinza escuro";
                     break;
             case 9: nome = "Azul";
                     break;
             case 10: nome = "Verde";
                      break;
             case 11: nome = "Azul turquesa";
                      break;
             case 12: nome = "Vermelho";
                      break;
             case 13: nome = "Fúcsia";
                      break;
             case 14: nome = "Amarelo";
                      break;
             case 15: nome = "Branco";
                      break;
             default: nome = "Cor Inválida";
                      break;
         }
         
         return nome;
     }
}
















