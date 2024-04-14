package Validadores;

/**
 * ValidaCPF: Classe parte do pacote de Validadores, responsável
 * pelo algoritmo que valida a existência de um CPF.
 */
public class ValidaCPF {

    // Função que valida o CPF
    public static boolean validarCpf(String cpf) {
	cpf = cpf.replaceAll("[^0-9]", ""); // Elimina qualquer valor não númerido
	if (cpf.length() != 11) return false; // Confere se possui 11 números

	// Confere se não são todos algoritmos repetidos
	char first = cpf.charAt(0);
	char[] firstRepeated = new char[11];
	for(int i = 0; i < 11; i++) firstRepeated[i] = first;
	String firstRepeatedString = new String(firstRepeated);
	if (firstRepeatedString.contentEquals(cpf)) return false;

	// Calcula e confere os dígitos verificadores
	char fDigit, sDigit;
	int fNum, fSum = 0, fMult = 10;
	for (int i = 0; i < 9; i++) {
	    fNum = (int)(cpf.charAt(i)) - 48;
	    fSum += fNum*(fMult--);
	}
	int fMod = 11 - fSum % 11;
	fDigit = (fMod == 10 || fMod == 11) ? '0' : (char)(fMod + 48);

	int sNum, sSum = 0, sMult = 11;
	for (int i = 0; i < 10; i++) {
	    sNum = (int)(cpf.charAt(i)) - 48;
	    sSum += sNum*(sMult--);
	}
	int sMod = 11 - sSum % 11;
	sDigit = (sMod == 10 || sMod == 11) ? '0' : (char)(sMod + 48);

	if (fDigit != cpf.charAt(9) || sDigit != cpf.charAt(10)) return false;

	return true;
    }
}
