/**
 * Propriedade: Classe que serve de base para as diversas
 * propriedades do jogo
 */
public class Propriedade extends Carta {

    private int preco;
    private float aluguel;
    private String nome;

    // Construtor da classe Propriedade
    public Propriedade(int id, String descricao, Jogador dono,
		       int preco, float aluguel, String nome) {

	super(id, descricao, dono);
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
    // Fim dos getters e setters

    // Calcula o aluguel da Propriedade
    public int calcularAluguel() {
	return (int)aluguel;
    }

    // Transforma as informações da propriedade em uma única String
    @Override
    public String toString() {
	String out = "Preço: "+getPreco()+"\n";
	out += "Aluguel: "+getAluguel()+"\n";
	out += "Nome: "+getNome()+"\n";
	return super.toString()+"\n"+out;
    }
}
