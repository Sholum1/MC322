/**
 * ServicoPublico: Classe filha da classe Propriedade, possui os
 * mesmos parâmetros, mas o metodo para se calcular o aluguel
 * depende do resultado do rolamento dos dados
 */
public class ServicoPublico extends Propriedade {

    // Construtor da classe ServicoPublico
    public ServicoPublico(int id, String descricao, int preco,
			  float aluguel, String nome) {
	super(id, descricao, preco, aluguel, nome);
    }

    // Randomiza o calculo do aluguel com base no número de dados
    public int calcularAluguel(int dados) {
	return dados * super.calcularAluguel();
    }
}
