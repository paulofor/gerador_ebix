package gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.CamposCobol;
import model.Detalhe;
import model.Estrutura;

public class GeraServico {

	private String PATH = "Ebix-Dados/";

	private String nomeArquivo = "INET1082.java";

	public void gerador(CamposCobol arquivo) {
		try {
			this.geraCodigo(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void gerEstruturas(CamposCobol arquivo,BufferedWriter writer) throws IOException {
		for (Estrutura item : arquivo.getEstruturas()) {
			writer.write("protected static final FieldType[] " + item.getNomeCampos() + " = new FieldType[] {\n");
			for (Detalhe detalhe : item.getDetalhes()) {
				writer.write("		new " + detalhe.getTipoJava() + "FieldType(\"" + detalhe.toString() + "\", " + detalhe.getTamanho() + "),\n");
			}
			writer.write("};\n");
		}
	}

	
	private void geraCodigo(CamposCobol arquivo) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(PATH	+ nomeArquivo));
		
		writer.write("package br.com.bradseg.inet.adiantamentoparcela.segundaviaboleto.cics;\n");

		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.IndexedFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.LongFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;\n");
		writer.write("import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;\n");

		writer.write("@CicsGateway\n");
		writer.write("public class INET0802  extends CTGProgramImpl{\n");

		writer.write("// Constantes do programa\n");
		writer.write("private static final String PGMNAME = \"INET0802\";\n");
		writer.write("private static final String TRANNAME = \"IN38\";\n");
		writer.write("private static final int COMMLENGTH = 10000;");
		
		this.gerEstruturas(arquivo, writer);
		
		writer.write("private static final CommonAreaMetaData COMMAREAIN = new CommonAreaMetaData(COMMON_FIELDS, COMMAREAIN_FIELDS);\n");
		writer.write("private static final CommonAreaMetaData COMMAREAOUT = new CommonAreaMetaData(COMMON_FIELDS,COMMAREAOUT_FIELDS);\n");
		
		writer.write(" /**\n");
		writer.write("  * Construtor da classe que envia a definicao da transacao para o CTGProgram\n");
		writer.write("  */\n");
		writer.write(" public INET0802() {\n");
		writer.write("	 super(PGMNAME, TRANNAME, COMMLENGTH, COMMAREAIN, COMMAREAOUT);\n");
		writer.write(" }\n");
		
		writer.write("}\n");

		writer.close();

	}
	

}
