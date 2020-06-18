package model;

public class Detalhe {

	
	private LinhaCodigo linha = null;
	
	private String tipoLetra;
	private int tipoTamanhoInteiro;
	private int tipoTamanhoDecimal;
	private boolean decimal;
	
	public Detalhe(LinhaCodigo linha) {
		this.linha = linha;
		String tipo = this.linha.getTipo();
		this.tipoLetra = tipo.substring(0,1);
		if (tipo.indexOf('V')==-1) {
			decimal = false;
			String tipoTamanhoStr = tipo.substring(2, tipo.length()-1);
			tipoTamanhoInteiro = Integer.parseInt(tipoTamanhoStr);
		} else {
			decimal = true;
			String valores[] = tipo.split("V");
			String tamanhoInteiro = valores[0].substring(2,valores[0].length() - 1);
			String tamanhoDecimal = valores[1].substring(2,valores[1].length() - 1);
			tipoTamanhoInteiro = Integer.parseInt(tamanhoInteiro);
			tipoTamanhoDecimal = Integer.parseInt(tamanhoDecimal);
		}
	}

	public String toString() {
		return this.linha.getNome();
	}

	
	public String getTipoJava() {
		if ("X".equals(tipoLetra)) {
			return "String";
		} else {
			if (!decimal && tipoTamanhoInteiro<=4) {
				return "Integer";
			} else {
				return "Long";
			}
		}
	}

	public int getTamanho() {
		return tipoTamanhoInteiro;
	}
	
}