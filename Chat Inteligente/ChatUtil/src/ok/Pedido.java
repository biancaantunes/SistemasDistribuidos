package ok;

import java.io.Serializable;

public class Pedido implements Serializable {

	private static final long serialVersionUID = -8018531141678337588L;

	private int numero;
	private String descricao;
	private String data;
	private String status;
	private Produto produto;
	
	public int getnumero() {
		return numero;
	}
	public void setnumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getdata() {
		return data;
	}
	public void setdata(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", descricao=" + descricao + ", data=" + data + ", status="
				+ status + ", produto=" + produto + "]";
	}
}