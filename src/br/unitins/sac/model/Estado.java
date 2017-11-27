package br.unitins.sac.model;

public enum Estado {
	GOIAS(1, "Goi�s"), TOCANTINS(2, "Tocantins"), SAO_PAULO(24, "S�o Paulo");

	private Integer valor = 0;
	private String nome;

	Estado(Integer valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Integer getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return getNome();
	}
}