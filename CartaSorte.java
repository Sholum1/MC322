/** CartaStort: classe filha da classe Carta, representa uma carta de sorte do
 * jogo Monopoly
 */
public class CartaSorte extends Carta {
    int movimento, efeito, tempo;
    float valor;
    String acao, restricao;

    // Construtor da classe CartaSorte
    public CartaSorte(int id, int movimento, int efeito, int tempo, float valor,
		      String descricao, String acao, String restricao,
		      Jogador dono) {

	super(id, descricao, dono);
	this.movimento = movimento;
	this.efeito = efeito;
	this.tempo = tempo;
	this.valor = valor;
	this.acao = acao;
	this.restricao = restricao;
    }

    // Inicio dos Getters e Setters
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
	String out = "Tempo: "+getTempo()+"\n";
	out += "Efeito: "+getEfeito()+"\n";
	out += "Tempo: "+getTempo()+"\n";
	out += "Valor: "+getValor()+"\n";
	out += "Acao: "+getAcao()+"\n";
	out += "Restricao: "+getRestricao();
	return super.toString()+"\n"+out;
    }
}
