/**
 * Carta: Classe mãe de todas as classes que são cartas no jogo Monopoly
 */
public class Carta {
    public class RecursoInsuficienteException extends Exception {
	public RecursoInsuficienteException(Jogador jogador, Carta carta) {
	    super(mensgaem(jogador, carta));
	}

	private static String mensgaem(Jogador jogador, Carta carta) {
	    String out = "O Jogador "+jogador.getNome()+" não possui dinheiro o"+
		" suficiente para pagar";
	    if (carta instanceof CartaSorte) {
		String tipo = carta.getTipo().name();
		out += "pela Carta do tipo "+(tipo.charAt(1) + tipo.substring(1)
					     .toLowerCase());
	    } else if (carta instanceof Propriedade) {
		out += "pela Propriedade "+((Propriedade)carta).getNome();
	    }
	    return out+"\n";
	}
    }

    protected enum TipoCarta {
	SORTE, REVES;
    }
    private int id;
    protected float valor;
    private String descricao;
    private TipoCarta tipo;

    // Construtor da Classe Carta
    public Carta(int id, String descricao, float valor) {
	this.id = id;
	this.descricao = descricao;
	this.valor = valor;
    }

    public Carta(int id, String descricao, float valor, TipoCarta tipo) {
	this(id, descricao, valor);
	this.tipo = tipo;
    }

    // Inicio dos Getters e Setters
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }

    public String getDescricao() {
	return descricao;
    }
    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public TipoCarta getTipo() {
	return tipo;
    }
    public void setTipo(TipoCarta tipo) {
	this.tipo = tipo;
    }

    public float getValor() {
	return valor;
    }
    public void setValor(float valor) {
	this.valor = valor;
    }

    protected void executaAcao(Jogador jogador)
	throws RecursoInsuficienteException{
	int dinheiro = jogador.getDinheiro(),
	    valor = (int)Math.round(this.getValor());
	if (dinheiro < valor) {
	    throw new RecursoInsuficienteException(jogador, this);
	} else {
	    jogador.setDinheiro(dinheiro - valor);
	}
    }
    // Fim dos Getters e Setters

    // Transforma as informações da classe em uma unica String
    @Override
    public String toString() {
	String out = "Id: "+getId()+"\n";
	out += "Tipo: "+getTipo()+"\n";
	out += "Descricao: "+getDescricao()+"\n";
	out += "Valor: " +getValor();
	return out;
    }
}

