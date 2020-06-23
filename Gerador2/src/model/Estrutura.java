package model;

import java.util.ArrayList;
import java.util.List;

public class Estrutura {
	
	private List<ItemDetalhe> detalhes;
	
	private LinhaCodigo linha = null;
	
	public Estrutura(LinhaCodigo linha) {
		this.linha = linha;
		this.detalhes = new ArrayList<ItemDetalhe>();
	}

	public void debug() {
		System.out.println();
		System.out.println("Estrutura: " + this.linha.getNome() +"(" + this.linha.getTamanhoVetor() + ")");
		for (ItemDetalhe detalhe : detalhes) {
			System.out.println("Item: " + detalhe);
		}
	}

	public void add(ItemDetalhe detalhe) {
		this.detalhes.add(detalhe);
	}
	
	public List<ItemDetalhe> getDetalhes() {
		return detalhes;
	}

	public String getNomeCampos() {
		return this.linha.getNome().toUpperCase().replaceAll("-", "_");
	}
}
