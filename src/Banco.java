import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Banco {
	static Scanner input = new Scanner(System.in);
	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public void adicionaConta(Conta conta){
		contas.add(conta);
	}

	public void exibeContas(){ //exibe todas as contas cadastradas no banco, sem diferenciar entre corrente e poupança, apenas se preocupa em listar quais que existem
		System.out.println(contas);
	}

	public List<Conta> exibeContasPorSaldo(){ //exibe todas as contas que estão cadastradas no banco em ordem do menor ao maior saldo da conta
		if(contas.isEmpty()){
			throw new RuntimeException("\nERRO\nLista vazia.");
		}

		List<Conta> listaOrdenadaPorSaldo = new ArrayList<>(contas);
		Collections.sort(listaOrdenadaPorSaldo);
		return listaOrdenadaPorSaldo;
	}

	public Cliente pesquisaClientePorNome(String nome){
		if(contas.isEmpty()){
			throw new RuntimeException("\nERRO\nLista vazia.");
		}
			
		for(Conta c : contas){
			if(c.getCliente().getNome().equalsIgnoreCase(nome)){
				return c.getCliente();
			}
		}

		System.out.println("Cliente não encontrado.");
		return null;
	}

	public void pedirEmprestimo(){
		System.out.print("\nDigite o valor do empréstimo desejado: R$ ");
		double valorEmprestimo = Double.parseDouble(input.nextLine());

		if(valorEmprestimo < 0){
			System.out.println("Não foi possível realizar o empréstimo.");
		}

		System.out.print("\nO total a pagar no final (com os juros) será de: R$ "+calcularJurosEmprestimo(valorEmprestimo));
	}

	private double calcularJurosEmprestimo(double valor){
		if(valor < 100){
			return valor + (valor * 0.1);
		} else if(valor < 300){
			return valor + (valor * 0.2);
		} else if (valor < 700){
			return valor + (valor * 0.3);
		} else if(valor < 1200){
			return valor + (valor * 0.4);
		} else {
			return valor + (valor * 0.5);
		}
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
