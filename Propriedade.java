/**
 * Propriedade: Classe que serve de base para as diversas
 * propriedades do jogo
 */
public class Propriedade {

    private int id, preco;
    private float aluguel;
    private String nome, proprietario;
    private static int count = 0;

    public Propriedade(int preco, float aluguel, String nome,
		       String proprietario) {
	this.preco = preco;
	this.aluguel = aluguel;
	this.nome = nome;
	this.proprietario = proprietario;
	id = count++;
    }

    // Inicio dos getters e setters
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }

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

    public String getProprietario() {
	return proprietario;
    }
    public void setProprietario(String proprietario) {
	this.proprietario = proprietario;
    }
    // FIm dos getters e setters

    public int calcularAluguel() {
	return (int)aluguel;
    }

    @Override
    public String toString() {
	String out = "Preço: "+getPreco()+"\n";
	out += "Aluguel: "+getAluguel()+"\n";
	out += "Nome: "+getNome()+"\n";
	out += "Proprietário: "+getProprietario()+"\n";
	out += "Id: "+getId();
	return out;
    }
}
