import java.util.ArrayList;
import Validadores.*;

/**
 * Jogador: Classe responsável por construir instâncias de jogadores
 */
public class Jogador {
    private String nome, cpf, foto, email;
    private int dinheiro, id;
    private static int count = 0;
    private final Peca peca;
    private ArrayList<Carta> cartas;

    // Construtor da Classe Jogador
    public Jogador(String nome, String cpf, String foto, String email,
		   Peca peca, ArrayList<Carta> cartas) {
	this.nome = nome;
	this.cpf = cpf;
	this.foto = foto;
	this.email = email;
	this.dinheiro = 2558000;
	this.peca = peca;
	this.cartas = cartas;
	this.id = count++;
    }

    // Inicio dos Getter e Setters
    public Peca getPeca() {
	return peca;
    }

    public ArrayList<Carta> getCartas() {
	return cartas;
    }
    public void setCartas(ArrayList<Carta> cartas) {
	this.cartas = cartas;
    }

    public String getNome() {
	return nome;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCpf() {
	return cpf;
    }
    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getFoto() {
	return foto;
    }
    public void setFoto(String foto) {
	this.foto = foto;
    }

    public String getEmail() {
	return email;
    }
    public void setEmail(String email) {
	this.email = email;
    }

    public void setDinheiro(int dinheiro) {
	this.dinheiro = dinheiro;
    }
    public int getDinheiro() {
	return dinheiro;
    }

    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }
    // Fim dos Getter e Setters

    // Validadores
    public boolean validarCpf() {
	return ValidaCPF.validarCpf(cpf);
    }
    public boolean validarEmail() {
	return ValidaEmail.validarEmail(email);
    }
    // Fim dos validadores

    // Adicionar e remover cartas
    public Boolean addCarta(Carta carta) {
	return cartas.add(carta);
    }
    public Boolean removeCarta(Carta carta) {
	return cartas.remove(carta);
    }

    // Transforma as informações da Classe em uma String
    @Override
    public String toString() {
	String out = "Nome: "+getNome()+"\n";
	out += "CPF: "+getCpf()+"\n";
	out += "Foto: "+getFoto()+"\n";
	out += "Email: "+getEmail()+"\n";
	out += "Id: "+getId()+"\n";
	out += this.getPeca().toString() +"\n";
	out += "Cartas: ";
	// Devolve a descrição de cada carta
	for (int i = 0; i < cartas.size(); i++)
	    out += cartas.get(i).getDescricao()+((i + 1 < cartas.size())
					    ? ", " : " ");
	return out;
    }
}
