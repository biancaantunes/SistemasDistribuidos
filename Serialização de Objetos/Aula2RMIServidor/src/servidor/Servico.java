package servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import comum.ServicoRemotoImpl;


public class Servico {

	public Servico() throws RemoteException {
		try {
			LocateRegistry.createRegistry(8080);
			System.out.println("INICIO");
			Naming.rebind("rmi://localhost:8080/pessoa", new ServicoRemotoImpl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) throws RemoteException {
		new Servico();
	}
}
