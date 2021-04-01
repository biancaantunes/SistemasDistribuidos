import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		
		String nome = "";
		String msgp = "";
		
		System.out.println("Entrando no chat...");
		
		nome = JOptionPane.showInputDialog("Bem vindo ao Chat. Qual é o seu nome? ");
		
		try {
			
			while (msgp != "0") {
				msgp = JOptionPane.showInputDialog("Chat - " + nome	+ " Entre com a mensagem. (Entre com 0 para sair)");
				
				if(msgp.equals("0")) {
					System.out.println(("Saindo do chat..."));
					break;
				}
				
				IChatAula objChat = (IChatAula) Naming
						.lookup("rmi://localhost:8282/chat");
				Message msg = new Message(nome, msgp);
				objChat.sendMessage(msg);
				//System.out.println(returnMessage(objChat.retrieveMessage()));
				System.out.print(returnMessage(objChat.retrieveMessage()));
				new CadastroDB().inserir(msg);
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static String returnMessage(List<Message> lst) {
			
			String valor = "";
			for (Message message : lst) {
				//valor += message.getUsuario() + ": " + message.getMensagem()  + "\n";
				valor = message.getUsuario() + ": " + message.getMensagem()  + "\n";
			}
			return valor;
		}
	}
