import java.util.HashMap;
import java.util.Map;


public class MeusTestes {

    public static void main(String[] args) {

        
        Lugar a = new Lugar ("00-aa-00","Tiago",150,true);
        Lugar b = new Lugar ("01-bb-01","Luis",250,true);
        Lugar c = new Lugar ("02-cc-02","Filipe",320,true);
        Lugar d = new Lugar ("03-dd-03","Hugo",190,false);
        Lugar e = new Lugar ("11-rr-40","Marta",130,false);
        Lugar f = new Lugar ("21-gg-51","João",450,true);
        Lugar g = new Lugar ("32-hh-72","Batoca",160,false);
        Lugar h = new Lugar ("43-dk-83","Andre",190,true);
        
        Map<String,Lugar> lugares = new HashMap<String,Lugar>(); 
        
        lugares.put("00-aa-00", a);
        lugares.put("01-bb-01", b);
        lugares.put("02-cc-02", c);
        lugares.put("03-dd-03", d);
		lugares.put("11-rr-40", e);
		lugares.put("21-gg-51", f);
		lugares.put("32-hh-72", g);
		lugares.put("43-dk-83", h);
		
		Parque_HashMap p = new Parque_HashMap("parque", lugares);


    
		System.out.println("getLugares() - Método que devolve uma cópia do Map de lugares.\n");
		p.getLugares();
		/*Imprimir a copia*/
		for(Lugar x : p.getLugares().values()){
		    System.out.println(x.toString());
		}
		System.out.println("******************************************" + "\n\n\n");
		
		
		System.out.println("getLugaresF() - Método que devolve uma cópia do Map de lugares.\n");
		p.getLugaresF();
		for(Lugar x : p.getLugaresF().values()){
		    System.out.println(x.toString());
		}
		System.out.println(p.getLugares().equals(p.getLugaresF())); //------------------------NÃO TENHO CERTEZA DE SE ESTE equals ESTÁ A FUNCIONAR CORRETAMENTE
		System.out.println("******************************************" + "\n\n\n");
		
		
		System.out.println("getMatrLugOcupados() - Metodo que devolve \ntodas as matriculas dos lugares ocupados - Tem que dar 8 matriculas\n");
		p.getMatrLugOcupados();
		for(String x : p.getMatrLugOcupados()){
		    System.out.println(x.toString());
		}
		System.out.println("******************************************" + "\n\n\n");
		
		
		System.out.println("registarLugar(Lugar l) - Metodo que regista um novo lugar");
        System.out.println("Listagem antes da inserção de Carlão:\n");
        for(String x : p.getMatrLugOcupados()){
		    System.out.println(x.toString());
		}
        System.out.println("_________________________________________");
        System.out.println("Listagem depois da inserção de Carlão com matricula 63-zz-93:\n");
        Lugar i = new Lugar ("63-zz-93","Carlão",300,true);
        p.registaLugar(i);
        for(String x : p.getMatrLugOcupados()){
		    System.out.println(x.toString());
		}
        System.out.println("******************************************" + "\n\n\n");
        
        
        System.out.println("alteraTempo(String matricula, int tempo) - Metodo que altera \no tempo disponivel de um lugar, para uma dada matricula");
        System.out.println("Listagem dos lugares antes da alteração do tempo da matricula 43-dk-83 para 1 do ANDRE:\n");
        for(Lugar x : p.getLugares().values()){
		    System.out.println(x.toString());
		}
		System.out.println("_________________________________________");
        p.alteraTempo("43-dk-83",1); /*é alterado o tempo do lugar 'h'*/
        System.out.println("Listagem dos lugares depois da alteração:\n");
        for(Lugar x : p.getLugares().values()){
		    System.out.println(x.toString());
		}
        System.out.println("******************************************" + "\n\n\n");

        
        System.out.println("totalMinutos() - Metodo que devolve a quantidade tota de minutos atribuidos\n");
        System.out.println(p.totalMinutos());
        System.out.println("******************************************" + "\n\n\n");
        
        
        System.out.println("totalMinutosF() - Metodo que devolve a quantidade tota de minutos atribuidos\n");
        System.out.println(p.totalMinutosF());
        System.out.println("******************************************" + "\n\n\n");
    
        
        System.out.println("existe(String mat) - Metodo que verifica se existe lugar atribuido a uma dada \nmatricula - obs: tem de dar true\n");
        System.out.println(p.existe("03-dd-03"));
        System.out.println("******************************************" + "\n\n\n");
                
        
        System.out.println("getMatriculasTempo(int tempo) - Metodo que cria uma lista com as matriculas \ncom tempo atribuido menor que x, em que o lugar seja permanente.");
        System.out.println("Tempo menor que 200\n");
        for(String x : p.getMatriculasTempo(200)){
            System.out.println(x);
        }
        System.out.println("******************************************" + "\n\n\n");   
    
        
        System.out.println("getMatriculasTempoF(int tempo) - Metodo que cria uma lista com as matriculas \ncom tempo atribuido menor que x, em que o lugar seja permanente.");
        System.out.println("Tempo menor que 200\n");
        for(String x : p.getMatriculasTempoF(200)){
            System.out.println(x);
        }
        System.out.println("******************************************" + "\n\n\n");   
    
        
        System.out.println("getCopiaLugares() - Metodo que devolve uma copia dos lugares");
        System.out.println("Listagem da copia dos lugares\n");
        for(Lugar x : p.getCopiaLugares()){
            System.out.println(x);
        }
        System.out.println("******************************************" + "\n\n\n");   
        
        
        System.out.println("getCopiaLugaresF() - Metodo que devolve uma copia dos lugares");
        System.out.println("Listagem da copia dos lugares\n");
        p.getCopiaLugaresF();
        for(Lugar x : p.getCopiaLugaresF()){
            System.out.println(x);
        }
        System.out.println("******************************************" + "\n\n\n");   
           
        
        System.out.println("getInformacao(String matricula) - Metodo que \ndevolve a informação de um lugar para uma dada matricula");
        System.out.println("Informação relativa á matricula: 00-aa-00\n");
        System.out.println(p.getInformacao("00-aa-00").toString()); 
        System.out.println("******************************************" + "\n\n\n");   
           
    }
}