package model;

import java.util.ArrayList;
import java.util.List;

public class CamposCobol {

	//List<LinhaCodigo> saida = new ArrayList<LinhaCodigo>();
	
	Estrutura estruturaCorrente = null;
	
	List<Estrutura> campos = new ArrayList<Estrutura>();
	
	String nivelDetalhe = null;

	public void add(LinhaCodigo linha) {
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
