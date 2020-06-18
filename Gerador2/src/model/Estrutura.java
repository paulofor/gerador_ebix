package model;

import java.util.ArrayList;
import java.util.List;

public class Estrutura {
	
	private List<Detalhe> detalhes;
	
	private LinhaCodigo linha = null;
	
	public Estrutura(LinhaCodigo linha) {
		this.linha = linha;
		this.detalhes = new ArrayList<Detalhe>();
	}

	public void debug() {
		System.out.println();
		System.out.println("Estrutura: " + this.linha.getNome() +"(" + this.linha.getVetor() + ")");
		for (Detalhe detalhe : detalhes) {
			System.out.println("Item: " + detalhe);
		}
	}

	public void add(Detalhe detalhe) {
		this.detalhes.add(detalhe);
	}
	
	public List<Detalhe> getDetalhes() {
		return detalhes;
	}

	public String getNomeCampos() {
		return this.linha.getNome().toUpperCase().replaceAll("-", "_");
	}
}
