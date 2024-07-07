/**
 * Propriedade: Classe que serve de base para as diversas
 * propriedades do jogo
 */
public class Propriedade extends Carta {

    private int preco;
    private float aluguel;
    private String nome;
    private Jogador dono = null;

    // Construtor da classe Propriedade
    public Propriedade(int id, String descricao, int preco,
		       float aluguel, String nome) {
	super(id, descricao, (float)preco);
	this.preco = preco;
	this.aluguel = aluguel;
	this.nome = nome;
    }

    // Inicio dos getters e setters
    public int getPreco() {
	return preco;
    }
    public void setPreco(int preco) {
	this.preco = preco;
    }

    public String getNome() {
	return nome;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }

    public float getAluguel() {
	return aluguel;
    }
    public void setAluguel(float aluguel) {
	this.aluguel = aluguel;
    }

    public Jogador getDono() {
	return dono;
    }
    public void setDono(Jogador dono) {
	this.dono = dono;
    }
    // Fim dos getters e setters

    // Calcula o aluguel da Propriedade
    public int calcularAluguel() {
	return (int)Math.round(aluguel);
    }

    // Transforma as informações da propriedade em uma única String
    @Override
    public String toString() {
	String out = "Preço: "+getPreco()+"\n";
	out += "Aluguel: "+getAluguel()+"\n";
	out += "Nome: "+getNome()+"\n";
	out += "Dono: "+getDono()+"\n";
	return super.toString()+"\n"+out;
    }
}
