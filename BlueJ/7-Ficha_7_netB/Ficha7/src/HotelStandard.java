
/**
 * Crie agora uma nova classe de hotéis, o HotelStandard em que o preço dos quartos é ainda igual em todo o hotel, mas varia com a época (que
 * pode ser alta ou baixa), sendo que na época alta acrescem 20 euros ao preço. Refaça a classe HoteisInc para que possa passar a gerir além dos
 * hotéis normais este novo tipo de equipamentos
 * 
 * @author Rafael Alves
 * @version 06-05-2017
 */
public class HotelStandard extends Hotel{
        
        /**Variaveis de instancia*/
    private boolean epocaAlta;
       
        /** Construtor vazio*/
        public HotelStandard(){
            super();
            this.epocaAlta = false;
        }
        
        /**Construtor por copi
     * @param h*/
        public HotelStandard(HotelStandard h){
            super(h);
        }
        
        /**Construtor parametrizad
     * @param codigo
     * @param nome
     * @param localidade
     * @param precoBaseQuarto
     * @param numQuartos
     * @param estrelas*/
        public HotelStandard(String codigo, String nome, String localidade, double precoBaseQuarto, int numQuartos, int estrelas, boolean epoca){
                super(codigo, nome, localidade, precoBaseQuarto, numQuartos, estrelas, epoca);

        }
        
        /**
         * Como explicado na classe Hotel, aqui está o "verdadeiro clone",
         * pois esta classe, HoteilStandard, não é asbtrata, logo é colonavel 
         * e sendo colonavel deve-se declarar o clone conforme está a baixo
         */
        public HotelStandard clone() {
            return new HotelStandard(this);
        }
        
        
        public boolean equals(Object obj) {
            return super.equals(obj);
            
        }

}
    