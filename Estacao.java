/**
 * Estacao: Classe filha da classe Propriedade, possui os mesmos
 * paramentos, mas a forma de calcular o aluguel é diferente
 */

public class Estacao extends Propriedade {

    // Construtor da Classe Estacao
    public Estacao(int id, String descricao, Jogador dono,
		   int preco, float aluguel, String nome) {
	super(id, descricao, dono, preco, aluguel, nome);
    }

    @Override
    public int calcularAluguel() {
	return super.calcularAluguel();
    }

    // Transforma as informações da classe em uma unica String
    @Override
    public String toString() {
	return super.toString();
    }
}
