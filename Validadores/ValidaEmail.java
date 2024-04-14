package Validadores;

/**
 * ValidaEmail: Classe parte do pacote de Validadores, responsável
 * pelo algoritmo que valida a existência de um email.
 */
public class ValidaEmail {

    public static boolean validarEmail(String email) {
	// Confere se o email possui espaço, não possui arroba ou não possui
	// ponto final, caso sim, retorna falso
	if (email.contains(" ") || email.indexOf('@') <= 0 ||
	    email.indexOf('.') <= 0) return false;
	return true;
    }
}
