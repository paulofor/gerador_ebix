package model;

public class LinhaCodigo {
	
	private String linhaTexto;
	private String nivel;
	private String nome;
	private String tipo;
	private int vetor;
	
	
	
	
	public boolean verificaLinha(String strLinha) {
		String linhaTrim = strLinha.trim();
		if (linhaTrim.length()<=3) return false;
		if (isNumeric(linhaTrim)) return false;
		if ("*".compareTo(linhaTrim.substring(0, 1))==0) return false;
		return true;
	}

	public void setLinhaTexto(String strLine) {
		this.linhaTexto = strLine;
		String linhaTrim = linhaTexto.trim();
		this.nivel = linhaTrim.substring(0, 2);
		//System.out.println("Nivel:" + this.nivel);
		int posicaoFinalNome = linhaTrim.substring(3).indexOf(" ") + 3;
		this.setNome(linhaTrim.substring(3, posicaoFinalNome-1));
		//System.out.println("Nome:" + this.nome);
		if (linhaTrim.contains("PIC")) {
			int posicaoFinalTipo = linhaTrim.indexOf('.');
			int posicaoInicialTipo = linhaTrim.indexOf("PIC", 0) + 3;
			String tipo = linhaTrim.substring(posicaoInicialTipo, posicaoFinalTipo).trim();
			//System.out.println("Tipo:" + tipo);
			this.tipo = tipo;
		}
		if (linhaTrim.contains("OCCURS")) {
			int posicaoInicio = linhaTrim.indexOf("OCCURS");
			String vetor = linhaTrim.substring(posicaoInicio);
			String[] palavras = vetor.split(" ");
			String quantidade = palavras[1];
			this.vetor = Integer.parseInt(quantidade);
		}
		
		
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEstrutura() {
		return (this.tipo==null);
	}
	
	public boolean isNumeric(String strNum) {
		strNum = strNum.trim();
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        long d = Long.parseLong(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	public String getNome() {
		return nome;
	}

	public int getVetor() {
		return vetor;
	}

	public String getNivel() {
		return nivel;
	}

	public String getTipo() {
		return tipo;
	}



}
