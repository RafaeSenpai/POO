
/**
 * Desenvolva uma classe Lugar que represente a informação básica de um
 * lugar de estacionamento, existente num dado parque. Sobre cada lugar
 * pretende ter-se a seguinte informação:
 * 
 * @author Rafael ALves
 * @version 26-04-2017
 */
public class Lugar
{

    /*
     * Variaveis de instancia
     */
    private String matricula;/*Matricula do carro alocado*/
    private String nome;/*Nome do proprietario*/
    private int minutos;/*Tempo atribuido ao lugar, me minutos*/
    private boolean permanente;/*Indica se lugar é permanente, ou aluguer*/
    
    /*
     * Construtor paramatrizado
     */
    public Lugar(String matricula, String nome, int tempo, boolean estado){
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = tempo;
        this.permanente = estado;
    }
    
    
    /*
     * Construtor vazio
     */
    public Lugar(){
        this("Na","Na",0,false);
    }
    
    
    /*
     * Construtor por copia
     */
    public Lugar(Lugar x){
        this(x.getMatricula(),x.getNome(),x.getMinutos(),x.getPermanente());
    }
    
    
    /*
     * Gets
     */
    public String getMatricula(){
        return this.matricula;
    }
    public String getNome(){
        return this.nome;
    }
    public int getMinutos(){
        return this.minutos;
    }
    public boolean getPermanente(){
        return this.permanente;
    }
    
    
    /*
     * Set's
     */
    public void setMatricula(String matr){
        this.matricula=matr;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMinutos(int x){
        this.minutos = x;
    }
    public void setPermanente(boolean val){
        this.permanente = val;
    }
    
    
    public Lugar clone(){
        return new Lugar(this);
    }
    
    
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj instanceof Lugar){
            Lugar lugar = (Lugar) obj;
            
            return ((lugar.getMatricula().equals(this.matricula)) &&
                    (lugar.getNome().equals(this.nome)) &&
                    (lugar.getMinutos() == this.minutos) &&
                    (lugar.getPermanente() == this.permanente)); //boolean e tipo primitivo, logo é imotavel, logo compara-se com "=="
        }else{
            return false;
        }
    }
    
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Matricula: " + this.getMatricula() + "\n");
        sb.append("Proprietário: " + this.getNome() + "\n");
        sb.append("Tempo: " + this.getMinutos() + "\n");
        sb.append("Permanente: " + this.getPermanente() + "\n");
        
        return sb.toString();
    }
    
    }
