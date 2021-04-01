import java.rmi.Naming;

import javax.swing.JOptionPane;

public class CalculatorClient {
	public static void main(String[] args) {
		
		int continuar;
		
		try {
			Calculator c = (Calculator) Naming
					.lookup("//localhost:8080/CalculatorService");
			
			do {
				int a = Integer.parseInt(JOptionPane.showInputDialog("Entre com o primeiro valor"));
				
				String opcao[] = {"+", "-", "*", "/"};
				int operacao = JOptionPane.showOptionDialog(null, "Escolha uma das operacoes", "Tipo de operacao", 0,
						JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
				
				int b = Integer.parseInt(JOptionPane.showInputDialog("Entre com o segundo valor"));
	
				if(operacao == 0)
					JOptionPane.showMessageDialog(null, "Soma: " + c.add(a, b));
				else if (operacao == 1)
					JOptionPane.showMessageDialog(null, "Subtracao: " + c.sub(a, b));
				else if (operacao == 2)
					JOptionPane.showMessageDialog(null, "Multiplicacao: " + c.mul(a, b));
				else
					if(b == 0)
						JOptionPane.showMessageDialog(null, "Impossivel dividir por zero!");
					else
						JOptionPane.showMessageDialog(null, "Divisao: " + c.div(a, b));
				continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar?"
																		+ "\n1 - Sim"
																		+ "\nOu então informe qualquer outro valor para sair do programa"));
			}while(continuar == 1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}