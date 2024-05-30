
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws IdadeInvalidaException {
		Cliente cliente1 = new Cliente();
		cliente1.setNome(cliente1.perguntaNome());
		cliente1.setIdade(cliente1.perguntaIdade());
									
		Conta ccCliente1 = new ContaCorrente(cliente1);
		Conta poupancaCliente1 = new ContaPoupanca(cliente1);

		Double deposito = perguntarValor("depósito");
		ccCliente1.depositar(deposito);
		Double transferencia = perguntarValor("transferência");
		ccCliente1.transferir(transferencia, poupancaCliente1);
						
		Banco banco = new Banco("Banco DIO");
		banco.adicionaConta(poupancaCliente1);
		banco.adicionaConta(ccCliente1);
						
		banco.exibeContas();
		System.out.println("Contas do banco de menor ao maior saldo: "+banco.exibeContasPorSaldo());	

		ccCliente1.imprimirExtrato();
		poupancaCliente1.imprimirExtrato();

		Double saque = perguntarValor("saque");
		poupancaCliente1.sacar(saque);

		poupancaCliente1.imprimirExtrato();

		System.out.print("\nDigite o nome do cliente que deseja procurar: ");
		String nomeProcurar = input.nextLine();
		System.out.println(banco.pesquisaClientePorNome(nomeProcurar));

		banco.pedirEmprestimo();
	}

	static double perguntarValor(String texto){
		System.out.print("\nDigite o valor do(a) " +texto+ ": ");
		return Double.parseDouble(input.nextLine());
	}
	
}
