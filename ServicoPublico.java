/**
 * ServicoPublico: Classe filha da classe Propriedade, possui os
 * mesmos parâmetros, mas o metodo para se calcular o aluguel
 * depende do resultado do rolamento dos dados
 */
public class ServicoPublico extends Propriedade {

    private int dados;

    // Construtor da classe ServicoPublico
    public ServicoPublico(int dados, int id, String descricao, Jogador dono,
			  int preco, float aluguel, String nome) {
	super(id, descricao, preco, aluguel, nome);
	this.dados = dados;
    }

    // Randomiza o calculo do aluguel com base no número de dados
    public int calcularAluguel(int dados) {
	return dados * super.calcularAluguel();
    }

    // Inicio dos Getter e Setters
    public void setDados(int dados) {
	this.dados = dados;
    }
    public int getDados() {
	return dados;
    }
    // Fim dos Getter e Setters

    // Transforma as informações da Classe em uma String
    @Override
    public String toString() {
	return "Dados: "+getDados()+"\n"+super.toString();
    }
}
