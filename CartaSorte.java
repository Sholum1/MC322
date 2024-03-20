public class CartaSorte {
    int id, movimento, efeito, tempo;
    float valor;
    String descricao, acao, restricao;

    // Construtor da classe CartaSorte
    public CartaSorte(int id, int movimento, int efeito, int tempo, float valor,
		      String descricao, String acao, String restricao) {
	this.id = id;
	this.movimento = movimento;
	this.efeito = efeito;
	this.tempo = tempo;
	this.valor = valor;
	this.descricao = descricao;
	this.acao = acao;
	this.restricao = restricao;
    }

    // Inicio dos Getters e Setters
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }

    public int getMovimento() {
	return movimento;
    }
    public void setMovimento(int movimento) {
	this.movimento = movimento;
    }

    public int getEfeito() {
	return efeito;
    }
    public void setEfeito(int efeito) {
	this.efeito = efeito;
    }

    public int getTempo() {
	return tempo;
    }
    public void setTempo(int tempo) {
	this.tempo = tempo;
    }

    public float getValor() {
	return valor;
    }
    public void setValor(float valor) {
	this.valor = valor;
    }

    public String getDescricao() {
	return descricao;
    }
    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getAcao() {
	return acao;
    }
    public void setAcao(String acao) {
	this.acao = acao;
    }

    public String getRestricao() {
	return restricao;
    }
    public void setRestricao(String restricao) {
	this.restricao = restricao;
    }

    // Fim dos Geters e Setters

    // Transforma as informações da classe em uma unica String
    @Override
    public String toString() {
	String out = "ID: "+getId()+"\n";
	out += "Tempo: "+getTempo()+"\n";
	out += "Efeito: "+getEfeito()+"\n";
	out += "Tempo: "+getTempo()+"\n";
	out += "Valor: "+getValor()+"\n";
	out += "Descricao: "+getDescricao()+"\n";
	out += "Acao: "+getAcao()+"\n";
	out += "Restricao: "+getRestricao();
	return out;
    }
}
