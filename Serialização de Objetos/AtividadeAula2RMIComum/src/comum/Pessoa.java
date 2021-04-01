package comum;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = -903326886879682992L;

	private int id;
	private String nome;
	private String telefone;
	private int idade;
	private String endereco;
	private String cidade;
	private String estado;
	private double salario;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", idade=" + idade + ", endereco="
				+ endereco + ", cidade=" + cidade + ", estado=" + estado + ", salario=" + salario + "]";
	}
	
}