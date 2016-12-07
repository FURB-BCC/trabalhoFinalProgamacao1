package src.model;

public class Pessoa {
	
	private String nome;
	private Profissao profissao;
	private String dataDeNascimento;
	private String empresa;
	
	public Pessoa(String nome, Profissao profissao, String dataDeNascimento, String empresa){
		setNome(nome);
		setProfissao(profissao);
		setDataDeNascimento(dataDeNascimento);
		setEmpres(empresa);
	}
	
	

}
