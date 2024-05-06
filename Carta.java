/**
 * Carta: Classe mãe de todas as classes que são cartas no jogo Monopoly
 */
public class Carta {
    int id;
    String descricao;
    Jogador dono;

    // Construtor da Classe Carta
    public Carta(int id, String descricao, Jogador dono) {
	this.id = id;
	this.descricao = descricao;
	this.dono = dono;
    }

    // Inicio dos Getters e Setters
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }

    public Jogador getDono() {
	return dono;
    }
    public void setDono(Jogador dono) {
	this.dono = dono;
    }

    public String getDescricao() {
	return descricao;
    }
    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }
    // Fim dos Getters e Setters

    // Transforma as informações da classe em uma unica String
    @Override
    public String toString() {
	String out = "Id: "+getId()+"\n";
	out += "Descricao: "+getDescricao()+"\n";
	out += "Dono: "+getDono().getNome();
	return out;
    }
}
