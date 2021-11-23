package br.ufc.quixada.entity;

public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	private String fone;
	private double renda;

	public Cliente() {}
	
	public Cliente(String cpf, String nome, String fone, double renda) {
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
		this.renda = renda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome
				+ ", fone=" + fone + ", renda=" + renda + "]";
	}


}
