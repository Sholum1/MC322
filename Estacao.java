/**
 * Estacao: Classe filha da classe Propriedade, possui os mesmos
 * paramentos, mas a forma de calcular o aluguel é diferente
 */

public class Estacao extends Propriedade {
    private int tarifa = 0;
    // Construtor da Classe Estacao
    public Estacao(int id, String descricao,
		   int preco, float aluguel, String nome) {
	super(id, descricao, preco, aluguel, nome);
    }

    @Override
    public int calcularAluguel() {
	for(Carta carta : this.getDono().getCartas())
	    if (carta instanceof Estacao)
		tarifa++;
	return tarifa * super.calcularAluguel();
    }
}
