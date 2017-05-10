
/**
 * Escreva a descrição da classe Lugar aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Lugar
{
    /* * Matricula do veiculo alocado */
    private String matricula;
    /* * Nome do proprietario */
    private String nome;
    /* * Tempo atribuido ao lugar , em minutos */
    private int minutos;
    /* * Indica se lugar é permanente , ou de aluguer
    */
    private boolean permanente;


    /**Construtores*/
    public Lugar(String matricula, String nome, 
                 int minutos, boolean permanente){
        this.matricula = new String(matricula);
        this.nome = new String(nome);
        this.minutos = minutos;
        this.permanente = permanente;

    }
    public Lugar(){
        this("", "", 0, false);
    }

    public Lugar(Lugar l){
        setMatricula(l.getMatricula());
        setNome(l.getNome());
        setMinutos(l.getMinutos());
        setPermanente(l.getPermanente());
    }

    /**Getters e Setters*/

    public String getMatricula(){
        return matricula;
    }
    public String getNome(){
        return nome;
    }
    public int getMinutos(){
        return minutos;
    }
    public boolean getPermanente(){
        return permanente;
    }
    void setMatricula(String m){
        this.matricula = new String(m);
    }
    void setNome(String n){
        this.nome = new String(n);
    }
    void setMinutos(int mn){
        this.minutos = mn;
    }
    void setPermanente(boolean b){
        this.permanente = b;
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(getMatricula() + "; ");
        s.append(getNome() + "; ");
        s.append(getMinutos() + "; ");
        s.append(getPermanente() + "; ");
        return s.toString();
    }
    
    public Lugar clone(){
        return new Lugar (this);
    }
    
    
    
    
}
