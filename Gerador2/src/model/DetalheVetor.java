package model;

public class DetalheVetor implements ItemDetalhe{

	private int tamanho;
	private String nome;
	
	public DetalheVetor(int tamanho, String nome) {
		this.tamanho = tamanho;
		this.nome = nome;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
