package comum;

import java.rmi.RemoteException;

public class PessoaFisica extends Pessoa {

	private String CPF;
	private String nomePai;
	private String nomeMae;
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public PessoaFisica() throws RemoteException {
		super();
	}
	
	@Override
	public String toString() {
		return "PessoaFisica [CPF=" + CPF + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + "]";
	}
	
	private static final long serialVersionUID = 1861679317905044532L;

}
