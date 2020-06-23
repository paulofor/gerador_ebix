package br.com.bradseg.inet.adiantamentoparcela.segundaviaboleto.cics;
import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;
import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IndexedFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.LongFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;
public abstract class INET1803Base  extends CTGProgramImpl{
// Constantes do programa
protected static final String PGMNAME = "INET1803";
protected static final int COMMLENGTH = 10000;
protected static final FieldType[] INET1803_AREA = new FieldType[] {
};
protected static final FieldType[] INET1803_ENTRADA = new FieldType[] {
		new LongFieldType("INET1803-APOL", 6),
		new LongFieldType("INET1803-CPF-CNPJ", 16),
		new StringFieldType("FILLER", 78),
};
protected static final FieldType[] DADOS_APOLICE = new FieldType[] {
		new StringFieldType("INET1803-EXIST-CAPA-FROTA", 1),
		new LongFieldType("INET1803-CD-CNPJ-CPF", 16),
		new IntegerFieldType("INET1803-CD-SUC", 4),
		new IntegerFieldType("INET1803-CD-RAMO", 4),
		new IntegerFieldType("INET1803-CD-CIA", 4),
		new LongFieldType("INET1803-NM-APOL", 6),
		new IntegerFieldType("INET1803-NM-ITEM", 4),
};
protected static final FieldType[] INET1803_DADOS_ERRO = new FieldType[] {
		new IntegerFieldType("INET1803-CD-RETORNO", 2),
		new IntegerFieldType("INET1803-SQLCODE", 4),
		new StringFieldType("INET1803-MS-RETORNO", 60),
		new StringFieldType("FILLER", 34),
		new IndexedFieldType("DADOS-APOLICE", 25, new CommonAreaMetaData(DADOS-APOLICE)),
		new StringFieldType("FILLER", 325),
};
/**
* Construtor da classe que envia a definicao da transacao para o CTGProgram
*/
public INET1803Base() {
	 super(PGMNAME, getTrName(), COMMLENGTH, getAreaIn(), getAreaOut());
}

protected abstract CommonAreaMetaData getAreaIn();

protected abstract CommonAreaMetaData getAreaOut();

protected abstract String getTrName();

}
