package model;

import java.util.ArrayList;
import java.util.List;

public class CamposCobol {

	//List<LinhaCodigo> saida = new ArrayList<LinhaCodigo>();
	
	Estrutura estruturaCorrente = null;
	
	List<Estrutura> campos = new ArrayList<Estrutura>();
	

	public CamposCobol(List<LinhaCodigo> listaLinha) {
		int pos = 0;
		while (pos < listaLinha.size()) {
			LinhaCodigo linha = listaLinha.get(pos);
			if (linha.isEstrutura()) {
				pos = adicionaEstrutura(pos,listaLinha);
			}
		}
	}

	private int adicionaEstrutura(int pos,List<LinhaCodigo>listaLinha) {
		LinhaCodigo linha = listaLinha.get(pos);
		Estrutura estrutura = new Estrutura(linha);
		pos++;
		linha = listaLinha.get(pos);
		String nivelDetalhe = linha.getNivel();
		while (linha!=null && nivelDetalhe.compareTo(linha.getNivel())==0 && !linha.isEstrutura()) {
			Detalhe detalhe = new Detalhe(linha);
			System.out.println("Detalhe: " + detalhe.toString());
			estrutura.add(detalhe);
			pos++;
			if (listaLinha.size()>pos) {
				linha = listaLinha.get(pos);
				if (linha.isVetor()) {
					DetalheVetor detalheVetor = new DetalheVetor(linha.getTamanhoVetor(),linha.getNome());
					estrutura.add(detalheVetor);
					pos = adicionaEstrutura(pos,listaLinha);
					linha = listaLinha.get(pos);
					nivelDetalhe = linha.getNivel();
				}
			} else {
				linha = null;
			}
		}
		campos.add(estrutura);
		return pos;
	}
	
	/*
	private void add(LinhaCodigo linha) {
		//saida.add(linha);
		if (linha.isEstrutura() ) {
			if (linha.isVetor()) {
				
			}
			estruturaCorrente = new Estrutura(linha);
			campos.add(estruturaCorrente);
			nivelDetalhe = null;
		} else {
			if (nivelDetalhe==null) {
				nivelDetalhe = linha.getNivel();
			}
			if (nivelDetalhe.compareTo(linha.getNivel())==0) {
				Detalhe detalhe = new Detalhe(linha);
				estruturaCorrente.add(detalhe);
			}
		}
	}
	*/
	
	public List<Estrutura> getEstruturas() {
		return campos;
	}
	public void mostraEstruturas() {
		System.out.println(" *** Estruturas ***");
		for (Estrutura item : campos) {
			item.debug();
		}
	}
	
}
