package src.model;

public class Estudante extends Pessoa{
	
	private String instituicao;
	
	public Estudante(String nome, Profissao profissao, String dataDeNascimento, String instituicao) throws Exception {
		super(nome, profissao, dataDeNascimento);
		setInstituicao(instituicao);
	}
	
	/**
	 * @return the empresa
	 */
	protected String getInstituicao() {
		return instituicao;
	}

	/**
	 * @param empresa the empresa to set
	 * @throws Exception 
	 */
	protected void setInstituicao(String instituicao) throws Exception {
		if(instituicao == null || instituicao.trim().length()<=3)
			throw new Exception("Nome da instituição precisa ter mais de 3 caracteres");
		this.instituicao = instituicao;
	}
	
	public String toString(){
		return "Nome: " + getNome() + "\nProfissão: " + getProfissao() + "\nData de nascimento: " + getDataDeNascimento() + "\nEmpresa: " + getInstituicao();
	}

}
