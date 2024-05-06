/** Peca: Classe responsável por determinar a cor e a posição atual da peça
 * de um jogador
 */
public class Peca {
    String cor;
    int posicao;

    // Construtor da Classe Peca
    public Peca(String cor, int posicao) {
	this.cor = cor;
	this.posicao = posicao;
    }

    // Inicio dos Getter e Setters
    public String getCor() {
	return cor;
    }
    public void setCor(String cor) {
	this.cor = cor;
    }

    public int getPosicao() {
	return posicao;
    }
    public void setPosicao(int posicao) {
	this.posicao = posicao;
    }
    // Fim dos Getter e Setters

    // Transforma as informações da Classe em uma String
    @Override
    public String toString() {
	String out = "cor: "+getCor()+"\n";
	out += "posicao: "+getPosicao();
	return out;
    }
}
