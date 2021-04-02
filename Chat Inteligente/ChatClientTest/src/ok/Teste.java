package ok;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {

		String nome = "";
		String msgp = "";
		String resp = "";
		String respBot = "";

		Produto produto = new Produto();
		produto.setId(1);
		produto.setDescricao("Geladeira Samsunf Frost Free RF27T5501SG Black Inox - 614 Litros");
		produto.setTipo("Refrigerador");
		 

		Pedido pedido = new Pedido();
		pedido.setnumero(480028);
		pedido.setDescricao("Compra realizada no site: www.casasbahia.com.br");
		pedido.setdata("12/02/2021");
		pedido.setStatus("Para Entrega");
		pedido.setProduto(produto);

		try {
			new CadastroDB().inserirProduto(produto);
			new CadastroDB().inserirPedido(pedido);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Carregando");

		nome = JOptionPane.showInputDialog("Seja Bem vindo, Qual o seu nome?");

		try {

			while (msgp != "0") {
				msgp = JOptionPane.showInputDialog("Olá" + nome + ", como podemos ajudar?"
						+ "\nOpções: Número do pedido, número da nota fiscal,  status do pedido"
						+ "\nPara finalizar a sessão por favor digite 0");

				IChat objChat = (IChat) Naming.lookup("rmi://localhost:8282/chat");
				Message msg = new Message(nome, msgp);
				objChat.sendMessage(msg);
				System.out.print(returnMessage(objChat.retrieveMessage()));
				new CadastroDB().inserirMensagem(msg);

				if (msgp.equals("0")) {
					System.out.println(("Finalizando"));
					break;
				} else if (msgp.toUpperCase().contains("NUMERO") || msgp.toUpperCase().contains("NÚMERO")) {
					resp = JOptionPane.showInputDialog(
							nome + ", Deseja saber o numero do pedido?" + "\nDigite SIM ou NAO");
					if (resp.toUpperCase().contains("SIM"))
						respBot = "Número do pedido - " + Integer.toString(pedido.getnumero());
					else
						respBot = "Erro, Tente novamente.";
				} else if (msgp.toUpperCase().contains("NOTA") || msgp.toUpperCase().contains("FISCAL")
						|| msgp.toUpperCase().contains("NF")) {
					resp = JOptionPane.showInputDialog(
							nome + ", Deseja saber o número da nota fiscal?" + "\nDigite SIM ou NAO");
					if (resp.toUpperCase().contains("SIM"))
						respBot = "Número da sua nota fiscal: 880080080088282244040228";
					else
						respBot = "Erro, Tente novamente.";
				} else if (msgp.toUpperCase().contains("STATUS")) {
					resp = JOptionPane
							.showInputDialog(nome + ", Deseja saber o status do pedido?" + "\nDigite SIM ou NAO");
					if (resp.toUpperCase().contains("SIM"))
						respBot = "Status do pedido: " + pedido.getStatus();
					else
						respBot = "Erro, Tente novamente.";
				} else
					respBot = "Erro, Tente novamente.";

				Message msgBot = new Message("Baianinho", respBot);
				objChat.sendMessage(msgBot);
				System.out.print(returnMessage(objChat.retrieveMessage()));
				new CadastroDB().inserirMensagem(msgBot);
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
			valor = message.getUsuario() + ": " + message.getMensagem() + "\n";
		}
		return valor;
	}
}