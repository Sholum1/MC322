/**
 * ServicoPublico
 */
public class ServicoPublico extends Propriedade{

    private int dados;

    public ServicoPublico(int preco, float aluguel, String nome,
			  String proprietario, int dados) {
	super(preco, aluguel, nome, proprietario);
	this.dados = dados;
    }

    public int calcularAluguel(int dados) {
	int aluguel = 0;
	for(int i = 0; i < dados; i++) {
	    aluguel += super.calcularAluguel() * Math.random();
	}
	return aluguel;
    }
}
