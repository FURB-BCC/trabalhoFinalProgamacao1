package src.model;

public class Aposentado extends Pessoa {
	
	public Aposentado(String nome, Profissao profissao, String dataDeNascimento) throws Exception {
		super(nome, profissao, dataDeNascimento);
	}
	
	
	public String toString(){
		return "Nome: " + getNome() + "\nProfissão: " + getProfissao() + "\nData de nascimento: " + getDataDeNascimento();
	}

}
