import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

/**
 * Cada e-mail recebido numa dada conta de mail é guardado contendo o endereço de quem o enviou, a data de envio, a data de recepção, o 
 * assunto e o texto do mail (não se consideram anexos, etc.). Crie a classe Mail que represente cada um dos mails recebidos. Em seguida 
 * crie uma classe designada MailList que permita guardar todos os actuais e-mails existentes numa dada conta.
 * 
 * @author Rafael Alves
 * @version 22-04-2017
 */

public class MailList
{
    /*
    * Variaveis de instancia
    */ 
    private String proprietario;
    private String endereco;
    private List<Mail> caixaCorreio;
    
    /*
    * Construtor parametrizado
    */
    public MailList(String nome, String mail, List<Mail> emails){
       this.proprietario = nome;
       this.endereco = mail;
       
       this.caixaCorreio = new ArrayList<>();
       emails.forEach(email -> caixaCorreio.add(email));
    }
    
    /*
    * Contrutor vazio
    */
    public MailList(){
       this("Na","Na",new ArrayList<Mail>()); 
    }
       
    /*
    * Construtor por copia
    */
    public MailList(MailList mail){
       this(mail.getProprietario(),mail.getEndereco(),mail.getEmails());
    }
    
    /*
    * Get's
    */
    public String getProprietario(){
       return this.proprietario;
    }
    public String getEndereco(){
       return this.endereco;
    }
    public List<Mail> getEmails(){
        List<Mail> lstMails = new ArrayList<>();
        Iterator<Mail> it = caixaCorreio.iterator();
        
        Mail x = it.next();
        while(it.hasNext()){
            lstMails.add(x);
            x = it.next();
        }
        
        return lstMails;
    }
    
    
    /*
    * Set's
    */
    public void setProprietario(String nome){
       this.proprietario = nome;
    }
    public void setEndereco(String endereco){
       this.endereco = endereco;
    }
    
    
    public MailList clone(){
       return new MailList(this);
    }
    
    
    public boolean equals(Object o){
        
        if(o==null) return false;
        if(o==this) return true;
        
        if(o instanceof MailList){
            MailList p = (MailList) o;
            
            if(p.getEmails().size() != this.getEmails().size()){
                return false;
            }else{
                Iterator<Mail> it = p.getEmails().iterator(); 
                Mail x = it.next();
                
                while(it.hasNext()){
                    if(!(this.getEmails().contains(x))){
                        return false;
                    }
                    x = it.next();
                }
                
                return (p.getProprietario().equals(this.proprietario)) &&
                       (p.getEndereco().equals(this.endereco));
            }
        }else{
            return false;
        }
    }

    public String toString(){
       StringBuilder sb = new StringBuilder();
       
       sb.append("Nome de utilizador: " + this.getProprietario() + "\n");
       sb.append("Endereço: " + this.getEndereco() + "\n");
       
       caixaCorreio.forEach(mail -> sb.append(mail.toString())); 
       
       return sb.toString();
    }
       
    
    /*
     * Determinar o total de emails guardados
     */
    public int totalEmails(){
        return caixaCorreio.size();       
    }
  
    
    
    /*
     * Guardar um novo email recebido
     */
    public void adicionarEmail(Mail m){
        caixaCorreio.add(m);
    }
    
    
    
    /*
     * Determinar quantos emails tem por origem um dado endereço
     */
    /*
     * Implementar com iterador externo
     */
    public int from(String endereco){
        int count = 0;
        Iterator<Mail> it = caixaCorreio.iterator();
        Mail x = it.next();
        
        while(it.hasNext()){
            if(x.getEndereco().equals(endereco)){
                count++;
            }
            x = it.next();
        }
        return count;
    }
    
    /*
     * Implementar com iterador interno
     */
    public int fromF(String endereco){ //----------------------CONFIRMAR SE O METODO ESTÁ A CONTAR DIREITO
        return (int) caixaCorreio.stream().filter(mail -> mail.getEndereco().equals(endereco)).map(Mail::clone).count();
    }
    
    
    
    /*
     * Criar uma lista contendo os indices  dos emails que no assunto contêm uma palavra dada como parametro
     * (Qualquer que seja a posição desta)
     */
    /*
     * Implementar com iterador externo
     */
    public List<Integer> comAssunto(String s){
        List<Integer> lista = new ArrayList<Integer>();
        int index = 0;
        
        Iterator<Mail> it = caixaCorreio.iterator();
        Mail x = it.next();
        
        while(it.hasNext()){
            if(x.getAssunto().contains(s)){ 
                lista.add(index);
            }
            x = it.next();
            index++;
        }
        return lista;
    }
            
    
    /*
     * Implementar com iterador interno
     */
    public List<Integer> comAssuntoF(String s){
        List<Integer> lista = new ArrayList<Integer>();
        
        caixaCorreio.forEach(mail -> {
                                        if(mail.getAssunto().contains(s)){
                                            lista.add(caixaCorreio.indexOf(mail)); 
                                        }
                                    }
                             );
     
        return lista;
    }
    
    
    
    /*
     * O mesmo que a questao anterior, mas criando uma lista conteudo tais emails
     */
    /*
     * Implementar com iterador externo
     */
    public List<Mail> comAssuntoL(String s){ //-------------------------------------------ESTE METODO FALHA NOS TESTES
        List<Mail> lista = new ArrayList<>();
        
        Iterator<Mail> it = caixaCorreio.iterator();
        Mail x = it.next();
        
        while(it.hasNext()){
            if(x.getAssunto().contains(s)){
                lista.add(x);
            }
            x = it.next();
    
        }
        
        return lista;
    }
    
    
    /*
     * Implementar com iterador interno
     */
    public List<Mail> comAssuntoLF(String s){ //-------------------------------------------ESTE METODO FALHA NOS TESTES
        List<Mail> lista = new ArrayList<Mail>();
        
        caixaCorreio.forEach(mail -> {
                                        if(mail.getAssunto().contains(s)){
                                            lista.add(mail); 
                                        }
                                    }
                             );
     
        return lista;
    }
    
    
    
    /*
     * Eliminiar  todos os emails recebidos antes de uma data que é dada como parametro.
     */
    /*
     * Implementar com iterador externo
     */
    public void eliminarRecebidos(GregorianCalendar data){//------------------CONFIRMAR SE ESTE METDO ELIMINA CORRETAMENTE OS EMAILS
        
        Iterator<Mail> it = caixaCorreio.iterator();
        Mail email = it.next();

        while(it.hasNext()){
            if(comparaDatas(email.getDataRecepcao(),data)){
                it.remove();
            }
            email =it.next();
        }
    }

    
    
    /*
     * Metodo auxiliar para compara datas. É private, logo "nao pode ser invocado nas instancias"
     */
    private boolean comparaDatas(Calendar x, Calendar y){
        long parametro1 = x.getTimeInMillis();/*conversão do tempo passado por parametro em milisegundos*/
        long parametro2 = y.getTimeInMillis();
        
            if(parametro1 < parametro2){
                return true;
            }else{
                return false;
            }
    }
            
    
    /*
     * Implementar com iterador interno - forEach
     */
    public void eliminarRecebidosF(GregorianCalendar data){//------------------CONFIRMAR SE ESTE METDO ELIMINA CORRETAMENTE OS EMAILS
        /*        caixaCorreio.forEach(mail -> {
                                        if(comparaDatas(mail.getDataRecepcao(),data)){
                                            caixaCorreio.remove(mail);
                                        }
                                    }
                              );
                              */
                             caixaCorreio.removeIf(mail -> comparaDatas(mail.getDataRecepcao(),data));
    }
    
                            
    /*
     * Implementar com iterador interno - Stream
     */
    public void eliminarRecebidosF2(GregorianCalendar data){
        /*
         * Observação:.
         * Ia para fazer este metodo com recurso a streams, mas pelo que entendo ao aplicar stream eu nao tenho a possibilidade de realmente eliminar os emails
         * que devo na lista de emails, "caixaCorreio". Mas sim e apenas criar uma nova lista em que apenas contenha os emails com data superior á passada por parametro
         * e retornar essa nova lista.  A minha questao aqui é se é logico aplicar streams para este metodo uma vez que quero que a literal eliminação dos emails seja
         * feita na "caixaCorreio";
         */   
        caixaCorreio.stream().filter(mail -> (!(comparaDatas(mail.getDataRecepcao(),data)))).map(Mail::clone); // mesmo tendo feito a observação acima, resolvi tentar fazer e cheguei a isto! será que funcina e está correto?!
    
    	//mas normalmente isso não é muito expedito. O que está em cima funcionaria de reatribuisses caixaCorreio.
    	//se queres entrar lá dentro e remover sem reatribuir usa o método removeIf. Search that.
    }
    
    
    
    
    /*
     * Criar uma lista dos emails do dia.
     */
    /*
     * Implementar com iterador externo
     */
    public List<Mail> emailsDoDia(){
        List<Mail> listagem = new ArrayList<Mail>();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy MMM dd"); //recorri á aplicação de um formato para a data, para que seja apenas tido em atenção o dia o mes e o ano quando for feita a comparação de datas, abaixo.
       
        Calendar data = new GregorianCalendar();
        
        Iterator<Mail> it = caixaCorreio.iterator();
        
        Mail x = it.next();

        while(it.hasNext()){
            if(formato.format(x.getDataRecepcao()).equals(formato.format(data.getTime()))){ //getTime() - data atual; /// o formato.format é para aplicar ás datas a formatação que criei acima
                listagem.add(x);
            }
            x=it.next();
        }       
        return listagem;
    }
    
    
    /*
     * Implementar com iterador externo
     */
    public List<Mail> emailsDoDiaF(){
        List<Mail> listagem = new ArrayList<Mail>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy MMM dd"); //recorri á aplicação de um formato para a data, para que seja apenas tido em atenção o dia o mes e o ano quando for feita a comparação de datas, abaixo.
        Calendar data = new GregorianCalendar();
        
        caixaCorreio.forEach(mail -> {
                                        if(formato.format(mail.getDataRecepcao()).equals(formato.format(data.getTime()))){
                                            listagem.add(mail);
                                        }
                                    }
                             );                          
        return listagem;                   
    }
        
    
    
    /*
     * Dada uma lista de palavras,eliminar todos os emails que  no seu assunto contenham qualquer uma destas palavras(anti-spam). 
     */
    /*
     * Implementar com iterador externo:
     */
    public void antiSpam(List<String> palavras){
        Iterator<Mail> it = caixaCorreio.iterator();
        
        Mail x = it.next();
        
        while(it.hasNext()){
            if(contemPalavras(x, palavras)){
                it.remove();
            }
            x = it.next();
        }
       
    }
    
    /*
     * Metodo privado auxiliar dos metodos antiSpam e antiSpamF
     * - recurso a iterador externo
     */
    private boolean contemPalavras(Mail x, List<String> palavras){
        Iterator<String> it = palavras.iterator();
        String xpto = it.next();
        
        while(it.hasNext()){
            if(x.getAssunto().contains(xpto)){
                return true;
            }
            xpto = it.next();
        }
        return false;
    }
    
    /*
     * Implementar com iterador interno:
     */
    public void antiSpamF(List<String> palavras){
        caixaCorreio.forEach(mail -> {
                                        if(contemPalavras(mail, palavras)){
                                            caixaCorreio.remove(mail);
                                        }
                                    }
                             );
    }
    
    
    
    /*
     * Elimina todos os emails anteriores a uma data dada.
     */
    /*
     * Implementar com iterador externo
     */
    /* //ELIMINAR ESTE "/*" JUNTAMENTE COM ESTA LINHA COMENTADA PARA ACIONAR ESTE METODO, CASO NECESSÁRIO PARA TESTES
    public void eliminar(LocalDate data){
       LocalDate data = LocalDate.of(2014, 1, 15); // data de teste, para nao usar a data que é passada por parametro ao metodo
                                                         
        Iterator<Mail> it = caixaCorreio.iterator();
        Mail x = it.next();      
        
        LocalDate dataRecepcao = LocalDate.of(x.getDataRecepcao().get(Calendar.YEAR),
                                              x.getDataRecepcao().get(Calendar.MONTH),
                                              x.getDataRecepcao().get(Calendar.DAY_OF_MONTH));

        LocalDate dataEnvio = LocalDate.of(x.getDataEnvio().get(Calendar.YEAR),
                                              x.getDataEnvio().get(Calendar.MONTH),
                                              x.getDataEnvio().get(Calendar.DAY_OF_MONTH));
        
        while(it.hasNext()){
            if(dataRecepcao.isBefore(data) && dataEnvio.isBefore(data)){
                it.remove();
            }
            x = it.next();
            dataRecepcao = LocalDate.of(x.getDataRecepcao().get(Calendar.YEAR),
                                      x.getDataRecepcao().get(Calendar.MONTH),
                                      x.getDataRecepcao().get(Calendar.DAY_OF_MONTH));

            dataEnvio = LocalDate.of(x.getDataEnvio().get(Calendar.YEAR),
                                      x.getDataEnvio().get(Calendar.MONTH),
                                      x.getDataEnvio().get(Calendar.DAY_OF_MONTH));

        }
    */ //ELIMINAR ESTE "*/" JUNTAMENTE COM ESTA LINHA COMENTADA PARA ACIONAR ESTE METODO, CASO NECESSÁRIO PARA TESTES
       
       
    public void eliminar(LocalDate data){       
        //LocalDate data = LocalDate.of(2014, 1, 15); // data de teste, para nao usar a data que é passada por parametro ao metodo
                                                         
        Iterator<Mail> it = caixaCorreio.iterator();
        Mail x = it.next();      
        
        LocalDate dataRecepcao = converteToLocalDate(x.getDataRecepcao());

        LocalDate dataEnvio = converteToLocalDate(x.getDataEnvio());
        
        while(it.hasNext()){
            if(dataRecepcao.isBefore(data) && dataEnvio.isBefore(data)){
                it.remove();
            }
            x = it.next();
            dataRecepcao = converteToLocalDate(x.getDataRecepcao());
            dataEnvio = converteToLocalDate(x.getDataEnvio());
        }
    }
    
    
    
    
    /*
     * Implementar com iterador interno - forEach
     */
    public void eliminarF(LocalDate data){
     //   LocalDate data = LocalDate.of(2014, 1, 15); // data de teste, para nao usar a data que é passada por parametro ao metodo
        
       caixaCorreio.forEach(mail -> {
                                        if(converteToLocalDate(mail.getDataRecepcao()).isBefore(data) && //criar metodo que passado como parametro um mail, vai buscar a data e converte-a numa data do tipo LocalDate
                                          (converteToLocalDate(mail.getDataEnvio()).isBefore(data))){
                                                caixaCorreio.remove(mail);
                                        }
                                    }
                             );
    }

    /*
     * Implementar com iterador interno - Stram
     */
    public void eliminarF2(LocalDate data){
        
        caixaCorreio.removeIf(mail -> (converteToLocalDate(mail.getDataRecepcao()).isBefore(data) && 
                                      (converteToLocalDate(mail.getDataEnvio()).isBefore(data))));
                                      
    }
    /*
     * Metodo privado usado para converter datas do tipo GregorianCalendar em LocaDate ou Date. 
     * Usado nos metodos elimina e eliminaF.
     */
    private LocalDate converteToLocalDate(Calendar x){
         LocalDate data = LocalDate.of(x.get(Calendar.YEAR),
                                       x.get(Calendar.MONTH),
                                       x.get(Calendar.DAY_OF_MONTH));

         return data;
    }
}