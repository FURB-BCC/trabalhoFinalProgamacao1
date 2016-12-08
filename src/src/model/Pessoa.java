package src.model;

public abstract class Pessoa {

	private String nome;
	private Profissao profissao;
	private String dataDeNascimento;
	private double valor = 0;
	private int quantidadeEmprestimos;
	private boolean temEmprestimo;

	public boolean isTemEmprestimo() {
		return temEmprestimo;
	}

	public void setTemEmprestimo(boolean temEmprestimo) {
		this.temEmprestimo = temEmprestimo;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setQuantidadeEmprestimos(int quantidadeEmprestimos) {
		this.quantidadeEmprestimos = quantidadeEmprestimos;
	}

	public Pessoa(String nome, Profissao profissao, String dataDeNascimento) throws Exception {
		setNome(nome);
		setProfissao(profissao);
		setDataDeNascimento(dataDeNascimento);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 * @throws Exception
	 */
	protected void setNome(String nome) throws Exception {
		if (nome == null || nome.trim().length() <= 3)
			throw new Exception("Nome precisa ter mais de 3 caracteres");
		this.nome = nome;
	}

	/**
	 * @return the profissao
	 */
	public Profissao getProfissao() {
		return profissao;
	}

	/**
	 * @param profissao
	 *            the profissao to set
	 */
	protected void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	/**
	 * @return the dataDeNascimento
	 */
	protected String getDataDeNascimento() {
		return dataDeNascimento;
	}

	/**
	 * @param dataDeNascimento
	 *            the dataDeNascimento to set
	 */
	protected void setDataDeNascimento(String dataDeNascimento) throws Exception {
		if (dataDeNascimento.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)\\d\\d)"))
			this.dataDeNascimento = dataDeNascimento;
		else
			throw new Exception("A data deve ser expressa no formato DD/MM/AAAA");
		this.dataDeNascimento = dataDeNascimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidadeEmprestimos() {
		return quantidadeEmprestimos;
	}

	public void addQuantidadeEmprestimos() {
		this.quantidadeEmprestimos++;
	}

}
