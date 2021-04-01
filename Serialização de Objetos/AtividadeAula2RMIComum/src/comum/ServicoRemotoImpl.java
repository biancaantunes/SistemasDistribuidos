package comum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl extends UnicastRemoteObject implements IServicoRemoto {

	private static List<Pessoa> lstPessoa = new ArrayList<>();
	
	public ServicoRemotoImpl() throws RemoteException {
	}
	
	private static final long serialVersionUID = 6832650147123632900L;

	@Override
	public void inserir(Pessoa p) throws RemoteException {
		lstPessoa.add(p);
	}
	@Override
	public List<Pessoa> listarPessoa() throws RemoteException {
		return lstPessoa;
	}
	@Override
	public void gerarAumento(PessoaFisica pf) throws RemoteException {
		if(pf.getIdade() < 20)
			pf.setSalario(pf.getSalario() * 1.1);
		else if ((pf.getIdade() >= 20) && (pf.getIdade() < 30))
			pf.setSalario(pf.getSalario() * 1.15);
		else
			pf.setSalario(pf.getSalario() * 1.2);
	}
	@Override
	public void gerarAumento(PessoaJuridica pj) throws RemoteException {
		if(pj.getIdade() < 20)
			pj.setSalario(pj.getSalario() * 1.1);
		else if ((pj.getIdade() >= 20) && (pj.getIdade() < 30))
			pj.setSalario(pj.getSalario() * 1.15);
		else
			pj.setSalario(pj.getSalario() * 1.2);
		
	}
}
