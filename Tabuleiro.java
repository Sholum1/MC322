import java.util.ArrayList;
import java.util.Stack;

/**
 * Tabuleiro: Classe responsável por simular um tabuleiro
 */
public class Tabuleiro implements Salvavel{

    private ArrayList<Jogador> jogadores;
    private ArrayList<Propriedade> propriedades;
    private Stack<CartaSorte> cartasSorte = new Stack<CartaSorte>();

    // Construtor da classe Tabuleiro
    public Tabuleiro(ArrayList<Jogador> jogadores,
		     ArrayList<Propriedade> propriedades) {
	this.jogadores = jogadores;
	this.propriedades = propriedades;
    }

    // Métodos para adicionar e remover Jogadores ou Cartas
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

    public boolean addCartaSorte(CartaSorte cartaSorte) {
	return cartasSorte.add(cartaSorte);
    }
    public boolean removeCartaSorte(CartaSorte cartaSorte) {
	return cartasSorte.remove(cartaSorte);
    }
    public int getIndexCartaSorte(CartaSorte cartaSorte) {
	return cartasSorte.indexOf(cartaSorte);
    }

    // Comprar uma propriedade
    public boolean compraPropriedade(Jogador jogador) {
	int pos = jogador.getPeca().getPosicaoAtual();
	Propriedade prop = propriedades.get(pos);
	if (prop instanceof Terreno) {
	    Terreno terr = (Terreno)prop;
	    if (terr.getDono().equals(jogador)) return terr.comprarCasa();
	}
	if (prop instanceof Propriedade) {
	    if (prop.getDono() == null) {
		try {
		    prop.executaAcao(jogador);
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    return false;
		}
		System.out.printf("O Jogador "+jogador.getNome()+" comprou "
				  +prop.getNome()+" por $%.2f\n", prop.getValor());
		prop.setDono(jogador);
		jogador.addCarta(prop);
		return true;
	    }
	    System.out.println("O Jogador "+prop.getDono().getNome()+
			       " já é dono desta Propriedade\n");
	    return false;
	}
	System.out.println("A casa de número "+pos+" não é uma Propriedade\n");
	return false;
    }

    // Distribui as cartas
    public boolean distribuiCartas(Jogador jogador) {
	int pos = jogador.getPeca().getPosicaoAtual();
	Propriedade prop = propriedades.get(pos);
	int dinheiro = jogador.getDinheiro();
	if (prop == null) {
	    CartaSorte carta = cartasSorte.pop();
	    int efeito = carta.getEfeito(),
		valor = (int)Math.round(carta.getValor());
	    if (efeito == 0) {
		System.out.println("O Jogador "+jogador.getNome()+
				   " foi para a prisão por "+carta.getTempo()
				   +" turnos\n");
		return true;
	    }
	    jogador.setDinheiro(dinheiro + efeito*valor );
	    System.out.printf("O Jogador "+jogador.getNome()+
			      ((efeito == -1) ? "perdeu " : "ganhou ")+
			      "$%.2f\n", valor);
	    return false;
	}
	return false;
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

    public void setCartasSorte(Stack<CartaSorte> cartasSorte) {
	this.cartasSorte = cartasSorte;
    }
    public Stack<CartaSorte> getCartasSorte() {
	return cartasSorte;
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
	    Propriedade prop = propriedades.get(i);
	    if (prop != null)
	    out += "\tNome: "+prop.getNome()+((i + 1 < propriedades.size())
					      ? "\n" : "");
	}
	return out;
    }
}
