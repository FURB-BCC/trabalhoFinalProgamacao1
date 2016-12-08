package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.model.Estudante;
import src.model.Pessoa;
import src.model.Profissao;

public class Teste {

	@Test
	public void validaDataNascimento() {

		try {
			Pessoa p = new Estudante("Estudante", Profissao.Estudante, "dataInvalida", "FURB");
			fail();// Garante que, se não lançou excecao com a data invalida, o
					// teste falhe.
		} catch (Exception e) {
			assertEquals("A data deve ser expressa no formato DD/MM/AAAA", e.getMessage());
		}
	}

	@Test
	public void validaNome() {
		try {
			Pessoa p = new Estudante("", Profissao.Estudante, "01/01/1900", "FURB");
			fail();
		} catch (Exception e) {
			assertEquals("Nome precisa ter mais de 3 caracteres", e.getMessage());
		}
	}

}
