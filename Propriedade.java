/**
 * Propriedade
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

    public int calcularAluguel() {
	return (int)aluguel;
    }
}
