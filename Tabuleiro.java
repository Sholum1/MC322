import java.util.ArrayList;

/**
 * Tabuleiro: Classe responsável por simular um tabuleiro
 */
public class Tabuleiro {

    private ArrayList<Jogador> jogadores;
    private ArrayList<Propriedade> propriedades;

    // Construtor da classe Tabuleiro
    public Tabuleiro(ArrayList<Jogador> jogadores,
		     ArrayList<Propriedade> propriedades) {
	this.jogadores = jogadores;
	this.propriedades = propriedades;
    }

    // Métodos para adicionar e remover Jogadores ou Propriedades
    public boolean addJogador(Jogador jogador) {
	return jogadores.add(jogador);
    }
    public boolean removeJogador(Jogador jogador) {
	return jogadores.remove(jogador);
    }
    public int getIndexJogador(Jogador jogador) {
	return jogadores.indexOf(jogador);
    }

    public boolean addPropriedade(Propriedade propriedade) {
	return propriedades.add(propriedade);
    }
    public boolean removePropriedade(Propriedade propriedade) {
	return propriedades.remove(propriedade);
    }
    public int getIndexPropriedade(Propriedade propriedade) {
	return propriedades.indexOf(propriedade);
    }

    // Inicio dos Getters e Setters
    public ArrayList<Jogador> getJogadores() {
	return jogadores;
    }
    public void setJogadores(ArrayList<Jogador> jogadores) {
	this.jogadores = jogadores;
    }

    public ArrayList<Propriedade> getPropriedades() {
	return propriedades;
    }
    public void setPropriedades(ArrayList<Propriedade> propriedades) {
	this.propriedades = propriedades;
    }
    // Fim dos Getters e Setters

    // Transforma as informações da classe Tabuleiro em uma única String
    @Override
    public String toString() {
	String out = "Jogadores:\n";
	for (int i = 0; i < jogadores.size(); i++) {
	    out += "\tNome: "+jogadores.get(i).getNome()+
		((i < jogadores.size()) ? "\n" : "");
	}
	out += "Propriedades:\n";
	for (int i = 0; i < propriedades.size(); i++) {
	    out += "\tNome: "+propriedades.get(i).getNome()+
		((i + 1 < propriedades.size()) ? "\n" : "");
	}
	return out;
    }
}
