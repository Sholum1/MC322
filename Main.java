import Validadores.*;
import java.util.ArrayList;
import java.util.Scanner;

/** Main: Classe responsável por de fato rodar o jogo
 */
public class Main {
    // Função que joga um erro caso o usuário insira uma opção inválida
    private static void err() {
	System.err.println("Opção inválida, por favor tente novamente");
    }

    public static void main(String[] args) {
	// Booleano que mede se o usuário ainda está em jogo
	Boolean jogando = true;
	Scanner scanner = new Scanner(System.in);
	// Loop para quando o jogo ainda estiver acontecendo
	while (jogando) {
	    System.out.println("Deseja iniciar um novo jogo? [Sim/Não]");
	    // Confere se o usuário que iniciar um novo jogo
	    String jogar = scanner.nextLine();
	    // Caso sim, inicie
	    if (jogar.equalsIgnoreCase("Sim") || jogar.equalsIgnoreCase("S")) {
		Tabuleiro tabuleiro = new Tabuleiro
		    (new ArrayList<Jogador>(),
		     new ArrayList<Propriedade>());
		System.out.println("Certo! Vamos lá:");
		// Captura as informações para o jogo
		System.out.println("Entre com o número de jogadores:");
		int nJogadores = scanner.nextInt();
		scanner.nextLine();
		int count = 0;
		while(count < nJogadores) {
		    System.out.println("Digite o nome do jogador: ");
		    String nome = scanner.nextLine();
		    System.out.println("Digite o CPF do jogador "+nome+": ");
		    String cpf = scanner.nextLine();
		    // Válida o CPF
		    if(!ValidaCPF.validarCpf(cpf)) {
			System.err.println("CPF inválido, por favor "+
					   "tente novamente:");
			continue;
		    }
		    System.out.println("Adicione uma foto do jogador "+nome+
				       ": ");
		    String foto = scanner.nextLine();
		    System.out.println("Adicione o email do jogador "+nome+
				       ": ");
		    // Válida o email
		    String email = scanner.nextLine();
		    if(!ValidaEmail.validarEmail(email)) {
			System.err.println("Email inválido, por favor "+
					   "tente novamente:");
			continue;
		    }
		    System.out.println("Adicione a cor da peça do jogador "
				       +nome+": ");
		    String cor = scanner.nextLine();
		    // Cria a peça na posição inicial
		    Peca peca = new Peca(cor, 0);
		    // Cria o jogador
		    Jogador jogador = new Jogador(nome, cpf, foto, email, peca,
						  new ArrayList<Carta>());
		    System.out.println(jogador);
		    // Confere se as informações do jogador estão corretas
		    boolean infoCorretas = false;
		    while(!infoCorretas) {
			System.out.println("As informações estão corretas? [Sim/Não]");
			String resp = scanner.nextLine();
			if (resp.equalsIgnoreCase("Sim") || resp.equalsIgnoreCase("S")) {
			    tabuleiro.addJogador(jogador);
			    count++;
			    System.out.println("Certo, vamos continuar");
			    infoCorretas = false;
			} else if (resp.equalsIgnoreCase("Não") || resp.equalsIgnoreCase("N")) {
			    System.out.println("Por favor reinsira as informações");
			    break;
			} else {
			    err();
			}
		    }
		}
		// Inicia o jogo
		// Busco mais a frente de fato iniciar algo jogável, onde as
		// peças são movidas e regras do Monopoly são seguidas
		System.out.println(tabuleiro);
	    // Se o usuário não quiser jogar, termine a sessão
	    } else if (jogar.equalsIgnoreCase("Não") || jogar.equalsIgnoreCase("N")) {
		System.out.println("Fim!");
		jogando = false;
		break;
	    } else {
		err();
	    }
	}
	// Fecha o scanner
	scanner.close();
    }
}
