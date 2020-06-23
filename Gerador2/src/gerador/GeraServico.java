package gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.CamposCobol;
import model.Detalhe;
import model.DetalheVetor;
import model.Estrutura;
import model.ItemDetalhe;

public class GeraServico {

	private String PATH = "Ebix-Dados/";

	//private String nomePrograma;

	public void gerador(String nomePrograma, CamposCobol arquivo) {
		try {
			this.geraCodigo(nomePrograma, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void gerEstruturas(CamposCobol arquivo,BufferedWriter writer) throws IOException {
		for (Estrutura item : arquivo.getEstruturas()) {
			writer.write("protected static final FieldType[] " + item.getNomeCampos() + " = new FieldType[] {\n");
			for (ItemDetalhe itemDetalhe : item.getDetalhes()) {
				if (itemDetalhe instanceof Detalhe) {
					Detalhe detalhe = (Detalhe) itemDetalhe;
					writer.write("		new " + detalhe.getTipoJava() + "FieldType(\"" + detalhe.toString() + "\", " + detalhe.getTamanho() + "),\n");
				};
				if (itemDetalhe instanceof DetalheVetor) {
					DetalheVetor detalheVetor = (DetalheVetor) itemDetalhe;
					writer.write("		new IndexedFieldType(\"" + detalheVetor.getNome() + "\", " + detalheVetor.getTamanho() + ", new CommonAreaMetaData(" + detalheVetor.getNome() + ")),\n");
				}
			}
			writer.write("};\n");
		}
	}

	
	private void geraCodigo(String nomePrograma, CamposCobol arquivo) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH	+ nomePrograma + "Base.java"));
		
		writer.write("package br.com.bradseg.inet.adiantamentoparcela.segundaviaboleto.cics;\n");

		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.IndexedFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.LongFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;\n");

		//writer.write("@CicsGateway\n");
		writer.write("public abstract class " + nomePrograma + "Base  extends CTGProgramImpl{\n");

		writer.write("// Constantes do programa\n");
		writer.write("protected static final String PGMNAME = \"" + nomePrograma + "\";\n");
		//writer.write("private static final String TRANNAME = \"IN38\";\n");
		writer.write("protected static final int COMMLENGTH = 10000;\n");
		
		this.gerEstruturas(arquivo, writer);
		
			
		writer.write("/**\n");
		writer.write("* Construtor da classe que envia a definicao da transacao para o CTGProgram\n");
		writer.write("*/\n");
		writer.write("public " + nomePrograma + "Base() {\n");
		writer.write("	 super(PGMNAME, getTrName(), COMMLENGTH, getAreaIn(), getAreaOut());\n");
		writer.write("}\n\n");
		writer.write("protected abstract CommonAreaMetaData getAreaIn();\n\n");
		writer.write("protected abstract CommonAreaMetaData getAreaOut();\n\n");
		writer.write("protected abstract String getTrName();\n\n");
		writer.write("}\n");
		writer.close();

	}
	

}
