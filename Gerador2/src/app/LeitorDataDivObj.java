package app;

import gerador.GeraServico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import model.CamposCobol;
import model.LinhaCodigo;

public class LeitorDataDivObj {
	
	private String PATH = "/home/usuario/aplicacoes/Ebix-Dados/";
	
	private String nomePrograma;
	
	public void executa(String nomeArquivo) {
		try {
			CamposCobol arquivo = executaLeitura(nomeArquivo);
			arquivo.mostraEstruturas();
			GeraServico codigo1 = new GeraServico();
			codigo1.gerador(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public CamposCobol executaLeitura(String nomeArquivo) throws IOException {
		FileInputStream fstream = new FileInputStream(PATH + nomeArquivo);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		CamposCobol saida = new CamposCobol();

		while ((strLine = br.readLine()) != null)   {
		  System.out.println (strLine);
		  LinhaCodigo linha = new LinhaCodigo();
		  if (linha.verificaLinha(strLine)) {
			  linha.setLinhaTexto(strLine);
			  saida.add(linha);
		  }
		  
		}
		fstream.close();
		
		return saida;
		
	}
	
	
	


}
