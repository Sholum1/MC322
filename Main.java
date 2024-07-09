import Validadores.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Random;

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
	Propriedade inicio = new Propriedade(0, "Início do jogo", 1000000000,
					     // Torna impossível comprar o inicio
					     0, "Início");
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
	Propriedade ferias = new Propriedade(0, "Férias", 1000000000,
					     // Torna impossível comprar
					     // a região férias
					     0, "Férias");
	Terreno ipiranga = new Terreno(0, "Avenida Ipiranga", 100000,
				       3500, "Avenida Ipiranga", 40000,
				       50000);
	ServicoPublico agua = new ServicoPublico(0,
						 "Companhia de água e saneamento",
						 200000, 8000,
						 "Companhia de água e saneamento");
	ServicoPublico mineracao = new ServicoPublico(0,
						      "Companhia de mineração",
						      200000, 8000,
						      "Companhia de mineração");
	Terreno recife = new Terreno(0, "Avenida Recife", 140000,
				     3800, "Avenida Recife", 42000, 50000);
	Terreno paulista = new Terreno(0, "Avenida Paulista", 160000,
				       4200, "Avenida Paulista", 44000,
				       51000);
	Estacao cuiaba = new Estacao(0, "Ponto do Cuiaba", 140000, 6000,
				     "Viaduto do cha");
	ServicoPublico pontocom = new ServicoPublico(0, "Pontocom", 150000, 10000,
						     "Pontocom");
	Propriedade vaPrisao = new Propriedade(0, "Vá para a prisão por 4 "
					       +"turnos ou pague 50000",
					       50000,
					       // Torna impossível comprar a
					       // região vá para a Prisão
					       0,
					       "Entre no camburão e vá para a"
					       +" Prisão");
	Propriedade tresPoderes = new Propriedade(0, "Praça dos Três Poderes",
						  320000,
						  34000, "Jardim Botânico");
	Propriedade castroAlves = new Propriedade(0, "Praça Castro Alves",
						  300000,
						  33000, "Jardim Botânico");
	Terreno contorno = new Terreno(0, "Avenida Contorno", 280000,
				       8000, "Avenida Contorno", 65000,
				       80000);
	Estacao rioNiteroi = new Estacao(0, "Ponte Rio-Niterói", 280000, 14000,
					 "Ponte Rio-Niterói");
	Propriedade tijuca = new Propriedade(0, "Barra da Tijuca", 260000,
					     270000, "Barra da Tijuca");
	Terreno gloria = new Terreno(0, "Marina da Glória", 260000,
				     7000, "Marina da Glória", 60000,
				     72000);
	Propriedade[] arrayPropriedades =  {inicio, botanico, niemeyer, petrolifera, beiraMar,
					    juscelinoKubitschek, null, oscarFreire, null,
					    ibirapuera, prisao, null, se, consolidacao,
					    forcaLuz, viadutoCha, null, higienopolis,
					    jardins, saoJoao, ferias, ipiranga,
					    agua, mineracao, null, recife,
					    paulista, null, cuiaba, pontocom,
					    vaPrisao, tresPoderes, null,
					    castroAlves, contorno, null,
					    rioNiteroi, tijuca, null, gloria};
	listaProprieades.addAll(Arrays.asList(arrayPropriedades));
	int count = 0;
	for (Propriedade prop : listaProprieades)
	    if (prop != null) prop.setId(count++);

	return listaProprieades;
    }

    private static Stack<CartaSorte> criaCartasSorte() {
	Stack<CartaSorte> pilhaCartaSorte = new Stack<CartaSorte>();
	CartaSorte carta1 = new CartaSorte(0, 0, -1, 0, 20000,
					   "Perca 20000",
					   "Pague 20000 ao banco", "",
					   TipoCarta.REVES);
	CartaSorte carta2 = new CartaSorte(1, 0, 1, 0, -20000,
					   "Ganhe 20000",
					   "Receba 20000 do banco", "",
					   TipoCarta.SORTE);
	CartaSorte carta3 = new CartaSorte(2, 0, 0, 2, 0,
					   "Vá para a prisão por 2 turnos",
					   "Fique preso por 2 turnos", "",
					   TipoCarta.REVES);
	CartaSorte carta4 = new CartaSorte(3, 0, -1, 0, 15000,
					   "Perca 15000",
					   "Pague 15000 ao banco", "",
					   TipoCarta.REVES);
	CartaSorte carta5 = new CartaSorte(4, 0, -1, 0, 10000,
					   "Perca 10000",
					   "Pague 10000 ao banco", "",
					   TipoCarta.REVES);
	CartaSorte carta6 = new CartaSorte(5, 0, -1, 0, 5000,
					   "Perca 5000",
					   "Pague 5000 ao banco", "",
					   TipoCarta.REVES);
	CartaSorte carta7 = new CartaSorte(6, 0, 0, 1, 0,
					   "Vá para a prisão por 1 turno",
					   "Fique preso por 1 turno", "",
					   TipoCarta.REVES);
	CartaSorte carta8 = new CartaSorte(7, 0, 0, 3, 0,
					   "Vá para a prisão por 3 turnos",
					   "Fique preso por 3 turnos", "",
					   TipoCarta.REVES);
	CartaSorte carta9 = new CartaSorte(8, 0, 1, 0, -25000,
					   "Ganhe 25000",
					   "Receba 25000 do banco", "",
					   TipoCarta.SORTE);
	CartaSorte carta10 = new CartaSorte(9, 0, 1, 0, -30000,
					    "Ganhe 30000",
					    "Receba 30000 do banco", "",
					    TipoCarta.SORTE);
	CartaSorte carta11 = new CartaSorte(10, 0, 1, 0, -20000,
					    "Ganhe 20000",
					    "Receba 20000 do banco", "",
					    TipoCarta.SORTE);
	CartaSorte carta12 = new CartaSorte(11, 0, -1, 0, 15000,
					    "Perca 15000",
					    "Pague 15000 ao banco", "",
					    TipoCarta.REVES);
	CartaSorte carta13 = new CartaSorte(12, 0, -1, 0, 10000,
					    "Perca 10000",
					    "Pague 10000 ao banco", "",
					    TipoCarta.REVES);
	CartaSorte carta14 = new CartaSorte(13, 0, -1, 0, 5000,
					    "Perca 5000",
					    "Pague 5000 ao banco", "",
					    TipoCarta.REVES);
	CartaSorte carta15 = new CartaSorte(14, 0, 1, 0, -25000,
					    "Ganhe 25000",
					    "Receba 25000 do banco", "",
					    TipoCarta.SORTE);
	CartaSorte carta16 = new CartaSorte(15, 0, 1, 0, -30000,
					    "Ganhe 30000",
					    "Receba 30000 do banco", "",
					    TipoCarta.SORTE);
	CartaSorte carta17 = new CartaSorte(16, 0, 1, 0, -20000,
					    "Ganhe 20000",
					    "Receba 20000 do banco", "",
					    TipoCarta.SORTE);
	CartaSorte carta18 = new CartaSorte(17, 3, 1, 0, 0,
					    "Avance 3 casas",
					    "Ande 3 casas no tabuleiro", "",
					    TipoCarta.SORTE);
	CartaSorte carta19 = new CartaSorte(18, -2, -1, 0, 0,
					    "Retroceda 2 casas",
					    "Volte 2 casas no tabuleiro", "",
					    TipoCarta.REVES);
	CartaSorte carta20 = new CartaSorte(19, 2, 1, 0, 0,
					    "Avance 2 casas",
					    "Ande 2 casas no tabuleiro", "",
					    TipoCarta.SORTE);
	CartaSorte carta21 = new CartaSorte(20, -1, -1, 0, 0,
					    "Retroceda 1 casa",
					    "Volte 1 casa no tabuleiro", "",
					    TipoCarta.REVES);
	CartaSorte carta22 = new CartaSorte(21, 4, 1, 0, 0,
					    "Avance 4 casas",
					    "Ande 4 casas no tabuleiro", "",
					    TipoCarta.SORTE);
	CartaSorte carta23 = new CartaSorte(22, -3, -1, 0, 0,
					    "Retroceda 3 casas",
					    "Volte 3 casas no tabuleiro", "",
					    TipoCarta.REVES);
	CartaSorte carta24 = new CartaSorte(23, 1, 1, 0, 0,
					    "Avance 1 casa",
					    "Ande 1 casa no tabuleiro", "",
					    TipoCarta.SORTE);
	CartaSorte carta25 = new CartaSorte(24, -4, -1, 0, 0,
					    "Retroceda 4 casas",
					    "Volte 4 casas no tabuleiro", "",
					    TipoCarta.REVES);
	CartaSorte[] arrayCartaSorte =  {carta1, carta2, carta3, carta4, carta5,
					 carta6, carta7, carta8, carta9,
					 carta10, carta11, carta12, carta13,
					 carta14, carta15, carta16, carta17,
					 carta18, carta19, carta20, carta21,
					 carta22, carta23, carta24, carta25};
	pilhaCartaSorte.addAll(Arrays.asList(arrayCartaSorte));
	Collections.shuffle(pilhaCartaSorte);
	return pilhaCartaSorte;
    }

    private static void printSalva(Tabuleiro tabuleiro, String mensagem,
				  int jogadas) {
	System.out.println(mensagem);
	tabuleiro.salvaLog(mensagem, jogadas);
    }

    private static void removeJogador(Jogador jogador, Tabuleiro tabuleiro) {
	for (Carta carta : jogador.getCartas()) {
	    Propriedade propriedade = (Propriedade)carta;
	    propriedade.setDono(null);
	}
	tabuleiro.getJogadores().remove(jogador);
	
    }

    private static void pagarAluguel (Propriedade propriedade, Tabuleiro
				     tabuleiro, int jogadas, Jogador jogador) {
	String out;
	Jogador dono = propriedade.getDono();
	int aluguel = propriedade.calcularAluguel();
	out = "Jogador "+jogador.getNome()+" caiu na Propriedade "
	    +propriedade.getNome()+" e deve pagar $"+aluguel+
	    " para "+dono.getNome();
	printSalva(tabuleiro, out, jogadas);
	if (jogador.getDinheiro() <= aluguel) {
	    out = "O jogador "+jogador.getNome()+
		" faliu e foi removido do jogo";
	    printSalva(tabuleiro, out, jogadas);
	    dono.setDinheiro(dono.getDinheiro()+jogador.getDinheiro());
	    removeJogador(jogador, tabuleiro);
	} else {
	    jogador.setDinheiro(jogador.getDinheiro() - aluguel);
	    dono.setDinheiro(dono.getDinheiro()+aluguel);
	}
    }

    private static void executaCartaSorte(Jogador jogador, CartaSorte carta,
					  Tabuleiro tabuleiro, int jogadas)
    throws RecursoInsuficienteException {
	String tipo = carta.getTipo().name();
	printSalva(tabuleiro, "Jogador "+jogador.getNome()+
		   " pegou a carta do tipo "+
		   (tipo.charAt(0) + tipo.substring(1).toLowerCase()),
		   jogadas);
	if (carta.getEfeito() == 0) {
	    printSalva(tabuleiro, "Jogador "+jogador.getNome()+
		       " foi preso por "+carta.getTempo()+ " turnos", jogadas);
	    jogador.setPreso(carta.getTempo());
	    // Coloca a peça na prisão
	    jogador.getPeca().setPosicaoAtual(10);
	} else if (carta.getMovimento() != 0) {
	    printSalva(tabuleiro, ((carta.getTipo() == TipoCarta.REVES)
				   ? "voltou " : "andou ")+
		       Math.abs(carta.getMovimento())+" casas", jogadas);
	    jogador.getPeca().move(carta.getMovimento());
	} else if (carta.getValor() != 0) {
	    try {
		carta.executaAcao(jogador);
	    } catch (RecursoInsuficienteException e) {
		printSalva(tabuleiro, e.getMessage(), jogadas);
		throw new RecursoInsuficienteException(jogador, carta);
	    }
	    printSalva(tabuleiro, ((carta.getTipo() == TipoCarta.REVES)
				    ? "pagou " : "recebeu ")+"$"+
				   Math.abs(carta.getValor())+"0", jogadas);
	}
    }

    private static void verificaPosicao(Jogador jogador, Tabuleiro tabuleiro,
				       Scanner scanner, int jogadas) {
	Propriedade propriedade = tabuleiro.getPropriedades().
	    get(jogador.getPeca().getPosicaoAtual());
	String resp, out, nome = "";
	if (propriedade != null) nome = propriedade.getNome();
	if (nome.equals("Prisão") || nome.equals("Férias") || nome.equals("Início")) {
	    printSalva(tabuleiro, "Jogador "+jogador.getNome()+" parou na casa "
		       +nome+" e encerrou o turno", jogadas);
	    return;
	} else if (nome.equals("Entre no camburão e vá para a Prisão")) {
	    printSalva(tabuleiro, propriedade.getDescricao(), jogadas);
	    printSalva(tabuleiro, "Deseja pagar?", jogadas);
	    resp = scanner.nextLine();
	    if (resp.equalsIgnoreCase("Sim") || resp.equalsIgnoreCase("s")) {
		try {
		    propriedade.executaAcao(jogador);
		} catch (RecursoInsuficienteException e) {
		    out = "Jogador "+jogador.getNome()+
			" não conseguiu pagar a multa e foi preso";
		    jogador.setPreso(4);
		    jogador.getPeca().setPosicaoAtual(10);
		    printSalva(tabuleiro, out, jogadas);
		}
	    } else {
		out = "Jogador "+jogador.getNome()+
		    " se entregou a polícia e foi preso";
		jogador.setPreso(4);
		jogador.getPeca().setPosicaoAtual(10);
		printSalva(tabuleiro, out, jogadas);
	    }
	} else if (propriedade == null) {
	    CartaSorte carta = tabuleiro.getCartasSorte().pop();
	    try {
		executaCartaSorte(jogador, carta, tabuleiro, jogadas);;
	    } catch (RecursoInsuficienteException e) {
		printSalva(tabuleiro, e.getMessage(), jogadas);
		removeJogador(jogador, tabuleiro);
	    }
	    tabuleiro.getCartasSorte().push(carta);
	    Collections.shuffle(tabuleiro.getCartasSorte());
	    if (carta.getMovimento() != 0)
		verificaPosicao(jogador, tabuleiro, scanner, jogadas);
	} else if (propriedade instanceof Terreno) {
	    if (propriedade.getDono() == null) {
		out = ("Deseja comprar o Terreno "+nome
		       +" por $"+propriedade.getValor()+"0?");
		printSalva(tabuleiro, out, jogadas);
		resp = scanner.nextLine();
		tabuleiro.salvaLog(resp, jogadas);
		if (resp.equalsIgnoreCase("Sim") || resp.equalsIgnoreCase("S")) {
		    try {
			propriedade.executaAcao(jogador);
		    } catch(RecursoInsuficienteException e) {
			printSalva(tabuleiro, e.getMessage(), jogadas);
		    }
		    propriedade.setDono(jogador);
		    jogador.addCarta(propriedade);
		}
	    } else if (propriedade.getDono() == jogador) {
		Terreno terreno = (Terreno)propriedade;
		if (terreno.getNumeroCasas() < 3 && !terreno.getHotel()) {
		    out = "Deseja construir uma nova casa por $"+terreno.
			getValorCasa()+"0?";
		    printSalva(tabuleiro, out, jogadas);
		    resp = scanner.nextLine();
		    tabuleiro.salvaLog(resp, jogadas);
		    if (resp.equalsIgnoreCase("Sim") ||
			resp.equalsIgnoreCase("S"))
			terreno.comprarCasa(tabuleiro, jogadas);
		} else if (!terreno.getHotel()) {
		    System.out.println("Deseja construir um Hotel por $"+
				       terreno.getValorHotel()+"0?");
		    resp = scanner.nextLine();
		    tabuleiro.salvaLog(resp, jogadas);
		    if (resp.equalsIgnoreCase("Sim") ||
			resp.equalsIgnoreCase("S"))
			terreno.comprarHotel(tabuleiro, jogadas);
		}
	    } else pagarAluguel(propriedade, tabuleiro, jogadas, jogador);
	} else {
	    if (propriedade.getDono() == null) {
		out = "Deseja comprar a Propriedade "+nome+
		    " por $"+propriedade.getValor()+"0";
		printSalva(tabuleiro, out, jogadas);
		resp = scanner.nextLine();
		tabuleiro.salvaLog(resp, jogadas);
		if (resp.equalsIgnoreCase("Sim") || resp.equalsIgnoreCase("s")) {
		    try {
			propriedade.executaAcao(jogador);
		    } catch (RecursoInsuficienteException e) {
			printSalva(tabuleiro, e.getMessage(), jogadas);
		    }
		    propriedade.setDono(jogador);
		    jogador.addCarta(propriedade);
		}
	    } else if (!propriedade.getDono().equals(jogador))
		pagarAluguel(propriedade, tabuleiro, jogadas, jogador);
	}
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
		Jogador ganhador = null;
		Random random = new Random();
		int jogadas = 1;
		tabuleiro.salvaLog("", -1);
		while (!vencedor) {
		    Iterator<Jogador> iterator = tabuleiro.getJogadores().iterator();
		    while (iterator.hasNext()) {
			Jogador jogador = iterator.next();
			if (tabuleiro.getJogadores().size() < 2) {
			    vencedor = true;
			    printSalva(tabuleiro, "O jogador "+jogador.getNome()
				       +" foi o único a não falir e venceu o jogo",
				       jogadas);
			    break;
			}
			if (jogadas >= 200) {
			    vencedor = true;
			    int max = -1;
			    for (Jogador possivelVencedor : tabuleiro.getJogadores()) {
				if (possivelVencedor.getDinheiro() > max)
				    ganhador = possivelVencedor;
			    }
			    printSalva(tabuleiro, "O jogador "+ganhador.getNome()
				       +" é o mais rico e venceu o jogo",
				       jogadas);
			    break;
			}
			if (jogador.getPreso() > 0) {
			    printSalva(tabuleiro, "Jogador "+jogador.getNome()+
				       " ficará preso por mais "+jogador
				       .getPreso()+" turnos", jogadas);
			    jogador.setPreso(jogador.getPreso() - 1);
			    continue;
			}
			printSalva(tabuleiro, "Jogador "+jogador.getNome()+
				   " possui $"+jogador.getDinheiro()+".00", jogadas);
			Peca peca = jogador.getPeca();
			int dados = random.nextInt(10) + 2;
			peca.move(dados);
			printSalva(tabuleiro, "Jogador "+jogador.getNome()+
				   " andou "+dados+" casas", jogadas);
			verificaPosicao(jogador, tabuleiro, scanner, jogadas);
			jogadas++;
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
