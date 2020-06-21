package br.com.bradseg.inet.adiantamentoparcela.segundaviaboleto.cics;
import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;
import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IndexedFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.LongFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;
public abstract class INET1802Base  extends CTGProgramImpl{
// Constantes do programa
protected static final String PGMNAME = "INET1802";
protected static final int COMMLENGTH = 10000;protected static final FieldType[] AREA_COM_1802_ENT = new FieldType[] {
		new StringFieldType("NM-TRANSAC-1802-EN", 4),
		new StringFieldType("HD-COMUNIC-1802-EN", 16),
		new StringFieldType("CD-PROGRAMA-1802-EN", 8),
		new IntegerFieldType("TP-REGISTRO-1802-EN", 2),
		new IntegerFieldType("CD-ORIGEM-1802-EN", 2),
};
protected static final FieldType[] DADOS_ENTRADA = new FieldType[] {
		new LongFieldType("CD-CNPJ-CPF-CORR-1802-EN", 16),
		new IntegerFieldType("CD-SUC-1802-EN", 4),
		new IntegerFieldType("CD-RAMO-1802-EN", 4),
		new IntegerFieldType("CD-CIA-1802-EN", 4),
		new LongFieldType("NO-APOL-1802-EN", 6),
		new IntegerFieldType("NO-ITEM-1802-EN", 4),
		new LongFieldType("NO-ENDOSSO-1802-EN", 9),
};
protected static final FieldType[] DS_DADOS_ERRO = new FieldType[] {
		new IntegerFieldType("CD-ERRO-1802-RE", 1),
		new StringFieldType("DS-MSG-ERRO-1802-RE", 30),
		new IntegerFieldType("COD-ERRO-1802-RE", 2),
		new IntegerFieldType("SQL-CODE-1802-RE", 4),
};
protected static final FieldType[] DADOS_APOLICE_1802_RET = new FieldType[] {
		new LongFieldType("CD-CNPJ-CPF-CORR-1802-RE", 16),
		new IntegerFieldType("CD-SUC-1802-RE", 4),
		new IntegerFieldType("CD-RAMO-1802-RE", 4),
		new IntegerFieldType("CD-CIA-1802-RE", 4),
		new LongFieldType("NO-APOL-1802-RE", 6),
		new IntegerFieldType("NO-ITEM-1802-RE", 4),
		new StringFieldType("NM-SEGURADO-1802-RE", 80),
		new StringFieldType("DS-TP-COB-1802-RE", 20),
};
protected static final FieldType[] TABELA_PREST_RE = new FieldType[] {
		new IntegerFieldType("NR-PREST-1802-RE", 4),
		new StringFieldType("DT-VENCTO-AMD-1802-RE", 10),
		new StringFieldType("NR-TITULO-1802-RE", 20),
		new IntegerFieldType("NR-DV-TIT-1802-RE", 1),
		new StringFieldType("DT-PAGTO-AMD-1802-RE", 10),
		new LongFieldType("VR-PREMIO-1802-RE", 15),
		new StringFieldType("DS-STATUS-1802-RE", 10),
		new StringFieldType("CD-STATUS-1802-RE", 1),
		new LongFieldType("NR-ENDOSSO-1802-RE", 9),
		new StringFieldType("DT-CONTROLE-1802-RE", 10),
		new IntegerFieldType("CD-TPO-DOC-1802-RE", 3),
		new StringFieldType("HA-PENDENCIA-1802-RE", 1),
		new StringFieldType("ID-SISTEMA-1802-RE", 1),
		new StringFieldType("DG-REF-1802-RE", 65),
		new StringFieldType("OBJ-SEGURADO-1802-RE", 20),
};
/**
* Construtor da classe que envia a definicao da transacao para o CTGProgram
*/
public INET1802Base() {
	 super(PGMNAME, getTrName(), COMMLENGTH, getAreaIn(), getAreaOut());
}

protected abstract CommonAreaMetaData getAreaIn();

protected abstract CommonAreaMetaData getAreaOut();

protected abstract String getTrName();

}
