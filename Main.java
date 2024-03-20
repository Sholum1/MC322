public class Main {
    public static void main(String[] args) {
	Peca peca1 = new Peca("azul", 2);
	Peca peca2 = new Peca("preta", 0);

	CartaSorte carta1 = new CartaSorte(10, 2, 3, 20, 23, "Uma das cartas já feitas", "Agir", "Restringir");
	CartaSorte carta2 = new CartaSorte(5, 4, 10, 4, 422, "Outra carta", "Age", "Restringe");

	Jogador jogador1 = new Jogador("Jose", "109.343.270-50", "~/images/foto_jose.jpg", "jose123@gmail.com"); // Exemplo que da certo (CPF e Email)
	Jogador jogador2 = new Jogador("Paula", "123.321.456-06", "~/images/foto_paula.jpg", "paula777@hotmailcom"); // Exemplo que da errado (CPF e Email)

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
	System.out.println(jogador1.validarCpf(jogador1.getCpf()));
	System.out.println(jogador1.validarEmail(jogador1.getEmail()));
	System.out.println("\n");
	System.out.println(jogador1.validarCpf(jogador2.getCpf()));
	System.out.println(jogador1.validarEmail(jogador2.getEmail()));
    }
}
