package src.model;

public class Empresario extends Pessoa {
	
	private String empresa;

	public Empresario(String nome, Profissao profissao, String dataDeNascimento, String empresa) throws Exception {
		super(nome, profissao, dataDeNascimento);
		setEmpresa(empresa);
	}
	
	/**
	 * @return the empresa
	 */
	protected String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 * @throws Exception 
	 */
	protected void setEmpresa(String empresa) throws Exception {
		if(empresa == null || empresa.trim().length()<=0)
			throw new Exception("Nome da empresa precisa ter mais de 3 caracteres.");
		this.empresa = empresa;
	}
	
	public String toString(){
		return "Nome: " + getNome() + "\nProfissão: " + getProfissao() + "\nData de nascimento: " + getDataDeNascimento() + "\nEmpresa: " + getEmpresa();
	}

}
