import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main
{
    public static void Main(String[] args)
    {
        Faixa musica1, musica2, musica3, musica4, musica5, musica6, musica7, musica8, musica9,
              musica10, musica11;
        
        Playlist House, POP;
        

        
        musica1 = new Faixa("lenny kravitz","Flay Away",127,8);
        musica2 = new Faixa("Shakira","La Bicicleta",109,6);
        musica3 = new Faixa("U2","One",163,7);
        musica4 = new Faixa("Scorpions","Still loving you",214,9);
        musica5 = new Faixa("Carl Cox","Fantasse",357,5);
        musica6 = new Faixa("DJ Vibe","Solid Textures",453,4);
        musica7 = new Faixa("Armin Van Buuren","Another You",227,7);
        musica8 = new Faixa("Tiesto","Adagio for Strings",322,10);
        musica9 = new Faixa("Amor Eletro","A Maquina",131,3);
        musica10 = new Faixa("Jeff Milles","The Bells",371,7);
        musica11 = new Faixa("Steve Aoki","Just Hold On",138,2);
        
        
                
        House = new Playlist();               
        
        House.addFaixa(musica8);
        House.addFaixa(musica5);
        House.addFaixa(musica6);
        House.addFaixa(musica7);
        House.addFaixa(musica10);
        House.addFaixa(musica11);
       
        
        
        POP = new Playlist();
        
        POP.addFaixa(musica1);
        POP.addFaixa(musica2);
        POP.addFaixa(musica3);
        POP.addFaixa(musica4);
        POP.addFaixa(musica9);
        
       
    }
    
}
