/** Peca: Classe responsável por determinar a cor e a posição atual da peça
 * de um jogador
 */
public class Peca {
    private String cor;
    private int posicaoAtual;
    private Jogador dono;

    // Construtor da Classe Peca
    public Peca(String cor, int posicaoAtual, Jogador dono) {
	this.cor = cor;
	this.posicaoAtual = posicaoAtual;
	this.dono = dono;
    }

    // Inicio dos Getter e Setters
    public String getCor() {
	return cor;
    }
    public void setCor(String cor) {
	this.cor = cor;
    }

    public int getPosicaoAtual() {
	return posicaoAtual;
    }
    public void setPosicaoAtual(int posicaoAtual) {
	this.posicaoAtual = posicaoAtual;
    }

    public Jogador getDono() {
	return dono;
    }
    public void setDono(Jogador dono) {
	this.dono = dono;
    }

    public void move(int dados) {
	this.setPosicaoAtual((this.getPosicaoAtual()+dados)%40);
	// Recebimento do salário ao dar a volta no mapa
	if(this.getPosicaoAtual() < dados) {
	    this.getDono().setDinheiro(this.getDono().getDinheiro() + 200000);
	}
    }
    // Fim dos Getter e Setters

    // Transforma as informações da Classe em uma String
    @Override
    public String toString() {
	String out = "cor: "+getCor()+"\n";
	out += "posicao atual: "+getPosicaoAtual();
	return out;
    }
}
