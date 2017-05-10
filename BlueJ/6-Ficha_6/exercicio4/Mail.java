import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cada e-mail recebido numa dada conta de mail é guardado contendo o
 * endereço de quem o enviou, a data de envio, a data de recepção, o assunto
 * e o texto do mail (não se consideram anexos, etc.). Crie uma classe
 * MailMap que associe a cada endereço de envio todos os mails recebidos (cf. classe Mail )
 * @author Rafael Alves
 * @version 4-05-2017
 */

public class Mail
{
    /*
     * Variaveis de instancia
     */
    private String endereco;
    private GregorianCalendar dataEnvio = new GregorianCalendar();
    private GregorianCalendar dataRecepcao = new GregorianCalendar();
    private String assunto;
    private String textoEmail;
    
    /*
     * Contrutor parametrizado
     */
    public Mail(String endereco, GregorianCalendar x, GregorianCalendar y, String assunto, String textoEmail){
        this.endereco = endereco;
        this.dataEnvio = x;
        this.dataRecepcao = y;
        this.assunto = assunto;
        this.textoEmail = textoEmail;
    }
    
    
    /*
     * Contrutor vazio
     */
    public Mail(){
        this("Na",new GregorianCalendar(1970,1,1),new GregorianCalendar(1970,1,1),"Na","Na");
    }
    
    
    /*
     * Contrutor por copia
     */
    public Mail(Mail email){
        this(email.getEndereco(),
             email.getDataEnvio(),
             email.getDataRecepcao(),
             email.getAssunto(),
             email.getTextoEmail());
    }
    
    
    
    
    /*
     * Gets
     */
    public String getEndereco(){
        return this.endereco;
    }
    public GregorianCalendar getDataEnvio(){ 
        return (GregorianCalendar) this.dataEnvio.clone(); // como o gregriaCalendar nao tem o clone definido, para nao ter que fazer um clone na integra do Gcalendar, faz-se simplesmente o cast e de seguida o tipico clone
    }
    public GregorianCalendar getDataRecepcao(){ // como o gregriaCalendar nao tem o clone definido, para nao ter que fazer um clone na integra do Gcalendar, faz-se simplesmente o cast e de seguida o tipico clone
        return (GregorianCalendar) this.dataRecepcao.clone();
    }
    public String getAssunto(){
        return this.assunto;
    }
    public String getTextoEmail(){
        return this.textoEmail;
    }
    
    
    
    
    
    /*
     * Sets
     */
    public void setEndereco(String x){
        this.endereco = x;
    }
    public void setDataEnvio(GregorianCalendar data){ 
        this.dataEnvio.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH));
        this.dataEnvio.set(Calendar.MONTH, data.get(Calendar.MONTH));
        this.dataEnvio.set(Calendar.YEAR, data.get(Calendar.YEAR));
        this.dataEnvio.set(Calendar.HOUR_OF_DAY, data.get(Calendar.HOUR_OF_DAY));//relogio de 24 horas
        this.dataEnvio.set(Calendar.MINUTE, data.get(Calendar.MINUTE));
        this.dataEnvio.set(Calendar.SECOND, data.get(Calendar.SECOND));
        this.dataEnvio.set(Calendar.MILLISECOND, data.get(Calendar.MILLISECOND));
    }
    public void setDataRecepcao(GregorianCalendar data){ 
        this.dataRecepcao.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH));
        this.dataRecepcao.set(Calendar.MONTH, data.get(Calendar.MONTH));
        this.dataRecepcao.set(Calendar.YEAR, data.get(Calendar.YEAR));
        this.dataRecepcao.set(Calendar.HOUR_OF_DAY, data.get(Calendar.HOUR_OF_DAY));//relogio de 24 horas
        this.dataRecepcao.set(Calendar.MINUTE, data.get(Calendar.MINUTE));
        this.dataRecepcao.set(Calendar.SECOND, data.get(Calendar.SECOND));
        this.dataRecepcao.set(Calendar.MILLISECOND, data.get(Calendar.MILLISECOND));
    }  
    public void setAssunto(String x){
        this.assunto = x;
    }
    public void setTextoEmail(String x){
        this.textoEmail = x;
    }
    
    
    
    
    public Mail clone(){
        return new Mail(this);
    }
    
    
    
    
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null) return false;
        if(o instanceof Mail){
            Mail email = (Mail) o;
            return (this.endereco.equals(email.getEndereco()) &&
                   this.dataEnvio.equals(email.getDataEnvio()) &&
                   this.dataRecepcao.equals(email.getDataRecepcao()) &&
                   this.assunto.equals(email.getAssunto()) &&
                   this.textoEmail.equals(email.getTextoEmail()));
        }else{
            return false;
        }
    }
    
    
    
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Endereço: " + this.getEndereco() + "\n\n");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy MMM dd HH:mm:ss"); // confirmar se funciona a formatação das datas e a exibição das mesmas(2 linhas a baixo)
        sb.append("Data de Envio: " + formato.format(dataEnvio.getTime()) + "----->");
        sb.append("Data de Recepção: " + formato.format(dataRecepcao.getTime()) + "\n");
        
        sb.append("Assunto: " + this.getAssunto() + "\n");
        sb.append("Email: " + this.getTextoEmail() + "\n");
        
        return sb.toString();
    }
}
