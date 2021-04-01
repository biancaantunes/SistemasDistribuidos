package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import comum.IServicoRemoto;
import comum.Pessoa;
import comum.PessoaFisica;
import comum.PessoaJuridica;

public class AppPrincipal {

	public static void main(String[] args) {

		try {
			IServicoRemoto objPessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:8080/pessoa");
			
			PessoaFisica pf = new PessoaFisica();
			pf.setId(1);
			pf.setNome("Pedro");
			pf.setTelefone("(16)1413-4568");
			pf.setEndereco("Rua 6");
			pf.setCidade("Araraquara");
			pf.setEstado("SP");
			pf.setCPF("123.456.789-13");
			pf.setIdade(22);
			pf.setSalario(1000);
			pf.setNomePai("Marcio da Silva");
			pf.setNomeMae("Maria Lourdes");
			
			
			PessoaJuridica pj = new PessoaJuridica();
			pj.setId(2);
			pj.setNome("Luana Souza");
			pj.setTelefone("(21)99555-1738");
			pj.setIdade(10);
			pj.setEndereco("Avenida teste da silva");
			pj.setCidade("Rio de Janeiro");
			pj.setEstado("RJ");
			pj.setSalario(10000);
			pj.setCNPJ("90.803.175/0001-20");
			
			objPessoa.inserir(pf);
			objPessoa.inserir(pj);
			objPessoa.gerarAumento(pf);
			objPessoa.gerarAumento(pj);
			
			for(Pessoa pessoa : objPessoa.listarPessoa()) {
				if(pessoa.getClass().getSimpleName().equals("PessoaFisica"))
					System.out.println("********Pessoa Física********");
				else
					System.out.println("********Pessoa Jurídica********");
				System.out.println("ID: " + pessoa.getId());
				System.out.println("Nome: " + pessoa.getNome());
				System.out.println("Telefone: " + pessoa.getTelefone());
				System.out.println("Endereco: " + pessoa.getEndereco());
				System.out.println("Cidade: " + pessoa.getCidade());
				System.out.println("Estado: " + pessoa.getEstado());
				System.out.println("Salário: R$" + pessoa.getSalario());
				System.out.println(pessoa.toString());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
