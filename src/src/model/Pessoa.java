package src.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Pessoa {

	private String nome;
	private Profissao profissao;
	private String dataDeNascimento;
	private List<Emprestimo> emprestimos;




	public Pessoa(String nome, Profissao profissao, String dataDeNascimento) throws Exception {
		setNome(nome);
		setProfissao(profissao);
		setDataDeNascimento(dataDeNascimento);
		emprestimos = new ArrayList<Emprestimo>();
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

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

}
