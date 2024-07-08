import Validadores.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import java.io.*;

/** Main: Classe responsável por de fato rodar o jogo
 */
public class Main {
    // Função que joga um erro caso o usuário insira uma opção inválida
    private static void err() {
	System.err.println("Opção inválida, por favor tente novamente");
    }

    private static Tabuleiro criaJogo(Scanner scanner) {
	ArrayList<String> cores = new ArrayList<String>();
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
	    Boolean corExiste = true;
	    Peca peca = null;
	    String cor = null;
	    while(corExiste) {
		cor = scanner.nextLine();
		if (cores.contains(cor.toLowerCase())) {
		    System.out.println("Esta cor já foi selecionada"+
				       " por outro jogador, "+
				       "por favor selecione outra!");
		    corExiste = true;
		} else {
		    corExiste = false;
		}
		if (!corExiste) {
		    // Cria a peça na posição inicial
		    cores.add(cor);
		    peca = new Peca(cor, 0);
		}
	    }
	    // Cria o jogador
	    Jogador jogador = new Jogador(nome, cpf, foto, email, peca,
					  new ArrayList<Carta>());
	    peca.setDono(jogador);
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
		    infoCorretas = true;
		} else if (resp.equalsIgnoreCase("Não") || resp.equalsIgnoreCase("N")) {
		    System.out.println("Por favor reinsira as informações");
		    cores.remove(cor);
		    break;
		} else {
		    err();
		}
	    }
	}
	return tabuleiro;
    }

    private static ArrayList<Propriedade> criaPropriedades() {
	ArrayList<Propriedade> listaProprieades = new ArrayList<Propriedade>();
	Propriedade inicio = new Propriedade(0, "Inicio do jogo", 1000000000,
					     // Torna impossível comprar o inicio
					     0, "Inicio");
	Terreno ibirapuera = new Terreno(0, "Avenida Ibirapuera", 220000, 10000,
					 "Ibirapuera", 80000, 100000);
	Terreno oscarFreire = new Terreno(0, "Rua Oscar Freire", 220000, 10000,
					 "Oscar Freire", 80000, 100000);
	Terreno juscelinoKubitschek = new Terreno(0,
						  "Avenida Juscelino Kubitschek",
						  240000, 11000,
					 "Ibirapuera", 84000, 120000);
	Terreno beiraMar = new Terreno(0, "Avenida Beira Mar", 60000, 4000,
					 "Beira Mar", 15000, 16000);
	ServicoPublico petrolifera = new ServicoPublico(0,
							"Companhia Petrolífera",
							200000, 8000,
							"Companhia Petrolífera");
	Terreno niemeyer = new Terreno(0, "Avenida Niemeyer", 75000, 6500,
					 "Niemeyer", 18000, 20000);
	Propriedade botanico = new Propriedade(0, "Jardim Botânico", 100000,
					       10000, "Jardim Botânico");
	Propriedade prisao = new Propriedade(0, "Prisão", 1000000000,
					     // Torna impossível comprar a prisão
					     0, "Prisão");
	Terreno se = new Terreno(0, "Praça da Sé", 200000, 80000,
					 "Beira Mar", 70000, 90000);
	Terreno consolidacao = new Terreno(0, "Rua da Consolidação", 180000,
					   70000, "Rua da Consolidação", 50000,
					   75000);
	ServicoPublico forcaLuz = new ServicoPublico(0, "Central de Força e Luz",
						     200000, 8000,
						     "Central de Força e Luz");
	Estacao viadutoCha = new Estacao(0, "Viaduto do cha", 180000, 8000,
					 "Viaduto do cha");
	Terreno higienopolis = new Terreno(0, "Higienópolis", 400000,
					   35000, "Higienópolis", 120000,
					   150000);
	Terreno jardins = new Terreno(0, "Jardins", 350000,
					   25000, "Jardins", 100000,
					   120000);
	Terreno saoJoao = new Terreno(0, "Avenida São João", 120000,
				      7000, "Avenida São João", 30000,
					   34000);
	Estacao rioNiteroi = new Estacao(0, "Ponte Rio-Niterói", 280000, 14000,
					 "Ponte Rio-Niterói");
	Propriedade tresPoderes = new Propriedade(0, "Praça dos Três Poderes",
						  320000,
					       34000, "Jardim Botânico");
	Propriedade tijuca = new Propriedade(0, "Barra da Tijuca", 260000,
					       270000, "Barra da Tijuca");
	Propriedade[] arrayPropriedades =  {inicio, botanico, niemeyer, petrolifera, beiraMar,
					    juscelinoKubitschek, null, oscarFreire, null,
					    ibirapuera, prisao, null, se, consolidacao,
					    forcaLuz, viadutoCha, null, higienopolis,
					    jardins, saoJoao, null, rioNiteroi,
					    tresPoderes, null, tijuca};
	listaProprieades.addAll(Arrays.asList(arrayPropriedades));
	int count = 0;
	for (Propriedade prop : listaProprieades)
	    if (prop != null) prop.setId(count++);

	return listaProprieades;
    }

    private static Stack<CartaSorte> criaCartasSorte() {
	Stack<CartaSorte> pilhaCartaSorte = new Stack<CartaSorte>();
	CartaSorte carta1 = new CartaSorte(0, 0, -1, 0, 20000, "Perca 20000",
					   "Pague 20000 ao banco", "", TipoCarta.REVES);
	CartaSorte carta2 = new CartaSorte(1, 0, 1, 0, 20000, "Ganhe 20000",
					   "Peça ao bancário 20000", "", TipoCarta.SORTE);
	CartaSorte carta3 = new CartaSorte(2, 0, 0, 2, 0,
					   "Vá para a prisão por 2 turnos",
					   "Fique preso por 2 turnos", "", TipoCarta.REVES);
	pilhaCartaSorte.add(carta1);
	pilhaCartaSorte.add(carta2);
	pilhaCartaSorte.add(carta3);
	return pilhaCartaSorte;
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
		Tabuleiro tabuleiro = criaJogo(scanner);
		tabuleiro.setPropriedades(criaPropriedades());
		tabuleiro.setCartasSorte(criaCartasSorte());
		// Inicia o jogo
		boolean vencedor = false;
		while (!vencedor) {
		    for (Jogador jogador : tabuleiro.getJogadores()) {
			int dado = (int)Math.random();
			System.out.println("");
		    }
		}
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
