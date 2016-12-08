package src.model;

public class Emprestimo {

	private int valor;

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if (valor > 0)
			this.valor = valor;
	}

	public Emprestimo(int valor) {
		setValor(valor);
	}

}
