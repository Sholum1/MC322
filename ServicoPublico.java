/**
 * ServicoPublico: Classe filha da classe Propriedade, possui os
 * mesmos parâmetros, mas o metodo para se calcular o aluguel
 * depende do resultado do rolamento de um número de dados
 */
public class ServicoPublico extends Propriedade{

    private int dados;

    public ServicoPublico(int preco, float aluguel, String nome,
			  String proprietario, int dados) {
	super(preco, aluguel, nome, proprietario);
	this.dados = dados;
    }

    // Randomiza o calculo do aluguel com base no número de dados
    public int calcularAluguel(int dados) {
	int aluguel = 0;
	for(int i = 0; i < dados; i++) {
	    aluguel += super.calcularAluguel() * Math.random();
	}
	return aluguel;
    }

    public void setDados(int dados) {
	this.dados = dados;
    }
    public int getDados() {
	return dados;
    }

    @Override
    public String toString() {
	return super.toString();
    }
}
