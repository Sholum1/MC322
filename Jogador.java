import Validadores.*;

/**
 * Jogador: Classe responsável por construir instâncias de jogadores
 */
public class Jogador {

    private String nome, cpf, foto, email;
    private int dinheiro, id;
    private static int count = 0;

    // Construtor da Classe
    public Jogador(String nome, String cpf, String foto, String email) {
	this.nome = nome;
	this.cpf = cpf;
	this.foto = foto;
	this.email = email;
	this.dinheiro = 2000;
	this.id = count++;
    }

    // Inicio dos Getter e Setters
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

    // Transforma as informações da Classe em uma String
    @Override
    public String toString() {
	String out = "Nome: "+getNome()+"\n";
	out += "CPF: "+getCpf()+"\n";
	out += "Foto: "+getFoto()+"\n";
	out += "Email: "+getEmail()+"\n";
	out += "Id: "+getId();
	return out;
    }
}
