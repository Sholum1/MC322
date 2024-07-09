/**
 * Terreno: classe filha das classe Propriedade, possui os mesmos
 * paramentos, com adição de alguns.
 */
public class Terreno extends Propriedade {

    private int numeroCasas = 1, valorCasa, valorHotel;
    private Boolean hotel = false;

    public Terreno(int id, String descricao, int preco,
		   float aluguel, String nome,
		   int valorCasa, int valorHotel) {
	super(id, descricao, preco, aluguel, nome);
	this.valorHotel = valorHotel;
	this.valorCasa = valorCasa;
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

    public Boolean comprarCasa(Tabuleiro tabuleiro, int jogadas) {
	if(!hotel) {
	    if(numeroCasas < 4) {
		try {
		    executaAcao(this.getDono());
		} catch (RecursoInsuficienteException e) {
		    System.err.println(e.getMessage());
		    tabuleiro.salvaLog(e.getMessage(), jogadas);
		    return false;
		}
		numeroCasas++;
		String out = "Jogador "+getDono().getNome()+
		    " construiu uma casa no terreno "+getNome()+
		    ", totalizando"+numeroCasas+" casas";
		System.out.println(out);
		tabuleiro.salvaLog(out, jogadas);
		return true;
	    } else {
		this.setValor(this.getValorHotel());
	    }
	}
	return false;
    }

    public Boolean comprarHotel(Tabuleiro tabuleiro, int jogadas) {
	if(hotel && numeroCasas == 4) {
	    try {
		executaAcao(this.getDono());
	    } catch (RecursoInsuficienteException e) {
		System.err.println(e.getMessage());
		tabuleiro.salvaLog(e.getMessage(), jogadas);
		return false;
	    }
	    this.setHotel(true);
	    String out = "Jogador "+getDono().getNome()+
		" construiu um hotel no terreno "+getNome();
	    System.out.println(out);
	    tabuleiro.salvaLog(out, jogadas);
	    return true;
	}
	return false;
    }

    @Override
    public int calcularAluguel() {
	int aluguel = (int)Math.round(this.getAluguel());
	return hotel ? 6*aluguel : numeroCasas * aluguel;
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
