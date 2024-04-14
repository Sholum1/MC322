/**
 * Estacao: Classe filha da classe Propriedade, possui os mesmos
 * paramentos, mas a forma de calcular o aluguel é diferente
 */

public class Estacao extends Propriedade {

    public Estacao(int preco, float aluguel, String nome,
		   String proprietario) {
	super(preco, aluguel, nome, proprietario);
    }

    @Override
    public int calcularAluguel() {
	return super.calcularAluguel();
    }

    @Override
    public String toString() {
	return super.toString();
    }
}
