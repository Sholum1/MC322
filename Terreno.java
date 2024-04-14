/**
 * Terreno: classe filha das classe Propriedade, possui os mesmos
 * paramentos, com adição de alguns.
 */
public class Terreno extends Propriedade {

    private int numeroCasas = 0, valorCasa = 0, valorHotel = 0;
    private Boolean hotel;

    public Terreno(int preco, float aluguel, String nome,
		   String proprietario, int numeroCasas,
		   int valorCasa, int valorHotel, Boolean hotel) {
	super(preco, aluguel, nome, proprietario);
	this.hotel = hotel;
	if(hotel) {
	    this.valorHotel = valorHotel;
	} else
	    this.valorCasa = valorCasa;
	    this.numeroCasas = numeroCasas;
    };

    // Inicio dos getters e setters
    public int getNumeroCasas() {
	return numeroCasas;
    }
    public void setNumeroCasas(int numeroCasas) {
	this.numeroCasas = numeroCasas;
    }

    public int getValorCasa() {
	return valorCasa;
    }
    public void setValorCasa(int valorCasa) {
	this.valorCasa = valorCasa;
    }

    public int getValorHotel() {
	return valorHotel;
    }
    public void setValorHotel(int valorHotel) {
	this.valorHotel = valorHotel;
    }

    public Boolean getHotel() {
	return hotel;
    }
    public void setHotel(Boolean hotel) {
	this.hotel = hotel;
    }
    // Fim dos getters e setters

    // Como estamos simplesmente armazenando o nome do proprietário
    // é impossível, sem acesso a instância, subtrair dinheiro do comprador
    public Boolean comprarCasa() {
	if(!hotel && numeroCasas < 5) {
	    numeroCasas++;
	    return true;
	}
	return false;
    }

    public Boolean comprarHotel() {
	if(hotel && numeroCasas == 0) return true;
	return false;
    }

    // Imaginei valores para esse momento visto que
    // Em um futuro lab esse código será refatorado
    @Override
    public int calcularAluguel() {
	return super.calcularAluguel() + (hotel ? 700 : numeroCasas * 200);
    }

    @Override
    public String toString() {
	String out = "";
	if (hotel) {
	    out += "Valor Hotel: "+getValorHotel();
	} else {
	    out += "Número de Casas: "+getNumeroCasas()+"\n";
	    out += "Valor Casa: "+getValorCasa();
	}
	return super.toString() + "\n" + out;
    }
}
