import java.util.ArrayList;

/**
 * Tabuleiro
 */
public class Tabuleiro {

    private ArrayList<Integer> jogadores;
    private ArrayList<Integer> propriedades;

    public Tabuleiro() {
	jogadores = new ArrayList<Integer>();
	propriedades = new ArrayList<Integer>();
    }

    public boolean addJogador(int jogador) {
	return jogadores.add(jogador);
    }
    public boolean removeJogador(int jogador) {
	int id = jogadores.remove(jogadores.indexOf(jogador));
	return (id == jogador);
    }
    public int getIndexJogador(int jogador) {
	return jogadores.indexOf(jogador);
    }

    public boolean addPropriedade(int propriedade) {
	return propriedades.add(propriedade);
    }
    public boolean removePropriedade(int propriedade) {
	int id = propriedades.remove(propriedades.indexOf
				     (propriedade));
	return (id == propriedade);
    }
    public int getIndexPropriedade(int propriedade) {
	return propriedades.indexOf(propriedade);
    }
}
