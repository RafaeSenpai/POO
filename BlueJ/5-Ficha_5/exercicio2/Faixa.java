
/**
 * Classe que representa uma musica ou faixa existente na playlist
 * 
 * @author Rafael Alves
 * @version 1.04.2017
 */
public class Faixa
{
    /*
     * Variaveis de instancia
     */
    private String autor;
    private String nome;
    private int duracao; //em segundos
    private int classificacao;

    /*
     * Construtor vazio
     */
    public Faixa(){
        this("na","na",0,0);
    }
    
    /*
     * Contrutor por copia
     */
    public Faixa(Faixa x){
       this(x.getAutor(),x.getNome(),x.getDuracao(),x.getClassificacao());
    }
    
    /*
     * Construtor parametrizado
     */
    public Faixa(String autor, String nome, int tempo, int classificacao){    
        this.autor = autor;
        this.nome = nome;
        this.duracao = tempo;
        this.classificacao = classificacao;
    }
    
    /*
     * Gets
     */
    
    public String getAutor(){
        return this.autor;
    }
    public String getNome(){
        return this.nome;
    }
    public int getDuracao(){
        return this.duracao;
    }
    public int getClassificacao(){
        return this.classificacao;
    }
    
    /*
     * Sets
     */
    public void setAutor(String nome){
        this.autor = nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDuracao(int tempo){
        this.duracao = tempo;
    }
    public void setClassificacao(int valor){
        this.classificacao = valor;
    }
    
    
    public boolean equals (Object o){
        if(this==o){
            return true;
        }
        if(o==null){
            return false;
        }
        if(o instanceof Faixa){
         
            Faixa x = (Faixa) o;
            
            return ((x.getAutor().equals(this.autor)) &&
                    (x.getNome().equals(this.nome)) &&
                    (x.getDuracao() == this.duracao) &&
                    (x.getClassificacao() == this.classificacao));
        }else{
            return false;
        }
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Artista: " + this.autor + "\n");
        sb.append("Musica: " + this.nome + "\n");
        sb.append("Duração: " + this.duracao + "n");
        sb.append("Classificação: " + this.classificacao + "\n");
        
        return sb.toString();
    }
    
    public Faixa clone(){
        return new Faixa(this);
    }

}