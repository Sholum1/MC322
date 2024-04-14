public class Main {
    public static void main(String[] args) {
	Peca peca1 = new Peca("azul", 2);
	Peca peca2 = new Peca("preta", 0);

	CartaSorte carta1 = new CartaSorte(10, 2, 3, 20, 23,
					   "Uma das cartas já feitas",
					   "Agir", "Restringir");
	CartaSorte carta2 = new CartaSorte(5, 4, 10, 4, 422,
					   "Outra carta", "Age",
					   "Restringe");

	// Exemplo que da certo (CPF e Email)
	Jogador jogador1 = new Jogador("Jose", "109.343.270-50",
				       "~/images/foto_jose.jpg",
				       "jose123@gmail.com");

	// Exemplo que da errado (CPF e Email)
	Jogador jogador2 = new Jogador("Paula", "123.321.456-06",
				       "~/images/foto_paula.jpg",
				       "paula777@hotmailcom");

	Propriedade propriedade1 = new Propriedade(1000, 100,
						   "Propriedade1", "jogador1");

	Estacao estacao1 = new Estacao(2000, 300, "Estacao1", "jogador1");

	Terreno terreno1 = new Terreno(50000, 3000, "Terreno1",
				       "jogador2", 2, 50000, 0, false);
	Terreno terreno2 = new Terreno(30000, 6000, "Terreno2",
				       "jogador1", 0, 0,10000, true);

	ServicoPublico servico1 = new ServicoPublico(2000, 300,
						     "Servico1", "jogador2");
	servico1.calcularAluguel(3);

	System.out.println(peca1.toString());
	System.out.println("\n");
	System.out.println(peca2.toString());
	System.out.println("\n");
	System.out.println(carta1.toString());
	System.out.println("\n");
	System.out.println(carta2.toString());
	System.out.println("\n");
	System.out.println(jogador1.toString());
	System.out.println("\n");
	System.out.println(jogador2.toString());
	System.out.println("\n");
	System.out.println(jogador1.validarCpf());
	System.out.println(jogador1.validarEmail());
	System.out.println("\n");
	System.out.println(jogador2.validarCpf());
	System.out.println(jogador2.validarEmail());
	System.out.println("\n");
	System.out.println(propriedade1.toString());
	System.out.println("\n");
	System.out.println(estacao1.toString());
	System.out.println("\n");
	System.out.println(terreno1.toString());
	System.out.println("\n");
	System.out.println(terreno2.toString());
	System.out.println("\n");
	System.out.println(servico1.toString());
	System.out.println("\n");

	Tabuleiro tabuleiro1 = new Tabuleiro();
	tabuleiro1.addJogador(1);
	tabuleiro1.addJogador(2);
	tabuleiro1.addPropriedade(1);
	tabuleiro1.addPropriedade(2);
	tabuleiro1.addPropriedade(3);
	tabuleiro1.addPropriedade(4);
	tabuleiro1.addPropriedade(5);
	System.out.println(tabuleiro1.toString());

	tabuleiro1.removePropriedade(2);
	tabuleiro1.addPropriedade(6);
	System.out.println(tabuleiro1.toString());
    }
}
