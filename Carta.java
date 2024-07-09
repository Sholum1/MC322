/**
 * Carta: Classe mãe de todas as classes que são cartas no jogo Monopoly
 */
public class Carta {
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

