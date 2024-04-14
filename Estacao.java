/**
 * Estacao
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
}
