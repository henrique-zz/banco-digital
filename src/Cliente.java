import java.util.Scanner;

public class Cliente {
	static Scanner input = new Scanner(System.in);
	private String nome;
	private int idade;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int perguntaIdade(){
		System.out.print("\nDigite a idade do cliente: ");
		return Integer.parseInt(input.nextLine());
	}

	public String perguntaNome(){
		System.out.print("\nDigite o nome do cliente: ");
		return input.nextLine();
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + "]";
	}


}
