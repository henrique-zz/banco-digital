
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) throws IdadeInvalidaException {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		this.imprimirInfosComuns();
	}
	
}
