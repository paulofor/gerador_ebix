package br.com.bradseg.inet.adiantamentoparcela.segundaviaboleto.cics;
import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;
import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IndexedFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.LongFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;
@CicsGateway
public class INET0802  extends CTGProgramImpl{
// Constantes do programa
private static final String PGMNAME = "INET0802";
private static final String TRANNAME = "IN38";
private static final int COMMLENGTH = 10000;// Campos comuns entre Entrada e Saida
protected static final FieldType[] COMMON_FIELDS = new FieldType[] {
		new StringFieldType("NM-TRANSACAO", 4, TRANNAME),
		new StringFieldType("HD-COMUNICACAO", 16),
		new StringFieldType("CD-PROGRAMA", 8, PGMNAME),
		new IntegerFieldType("TP-REGISTRO", 2, new Integer(01)),
		new IntegerFieldType("CD-ORIGEM", 2, new Integer(02))
};
protected static final FieldType[] AREA_COM_1802_ENT = new FieldType[] {
		new StringFieldType("NM-TRANSAC-1802-EN", 4, TRANNAME),
		new StringFieldType("HD-COMUNIC-1802-EN", 16, TRANNAME),
		new StringFieldType("CD-PROGRAMA-1802-EN", 8, TRANNAME),
		new IntegerFieldType("TP-REGISTRO-1802-EN", 2, TRANNAME),
		new IntegerFieldType("CD-ORIGEM-1802-EN", 2, TRANNAME),
};
protected static final FieldType[] DADOS_ENTRADA = new FieldType[] {
		new LongFieldType("CD-CNPJ-CPF-CORR-1802-EN", 16, TRANNAME),
		new IntegerFieldType("CD-SUC-1802-EN", 4, TRANNAME),
		new IntegerFieldType("CD-RAMO-1802-EN", 4, TRANNAME),
		new IntegerFieldType("CD-CIA-1802-EN", 4, TRANNAME),
		new LongFieldType("NO-APOL-1802-EN", 6, TRANNAME),
		new IntegerFieldType("NO-ITEM-1802-EN", 4, TRANNAME),
		new LongFieldType("NO-ENDOSSO-1802-EN", 9, TRANNAME),
};
protected static final FieldType[] DS_DADOS_ERRO = new FieldType[] {
		new IntegerFieldType("CD-ERRO-1802-RE", 1, TRANNAME),
		new StringFieldType("DS-MSG-ERRO-1802-RE", 30, TRANNAME),
		new IntegerFieldType("COD-ERRO-1802-RE", 2, TRANNAME),
		new IntegerFieldType("SQL-CODE-1802-RE", 4, TRANNAME),
};
protected static final FieldType[] DADOS_APOLICE_1802_RET = new FieldType[] {
		new LongFieldType("CD-CNPJ-CPF-CORR-1802-RE", 16, TRANNAME),
		new IntegerFieldType("CD-SUC-1802-RE", 4, TRANNAME),
		new IntegerFieldType("CD-RAMO-1802-RE", 4, TRANNAME),
		new IntegerFieldType("CD-CIA-1802-RE", 4, TRANNAME),
		new LongFieldType("NO-APOL-1802-RE", 6, TRANNAME),
		new IntegerFieldType("NO-ITEM-1802-RE", 4, TRANNAME),
		new StringFieldType("NM-SEGURADO-1802-RE", 80, TRANNAME),
		new StringFieldType("DS-TP-COB-1802-RE", 20, TRANNAME),
};
protected static final FieldType[] TABELA_PREST_RE = new FieldType[] {
		new IntegerFieldType("NR-PREST-1802-RE", 4, TRANNAME),
		new StringFieldType("DT-VENCTO-AMD-1802-RE", 10, TRANNAME),
		new StringFieldType("NR-TITULO-1802-RE", 20, TRANNAME),
		new IntegerFieldType("NR-DV-TIT-1802-RE", 1, TRANNAME),
		new StringFieldType("DT-PAGTO-AMD-1802-RE", 10, TRANNAME),
		new LongFieldType("VR-PREMIO-1802-RE", 15, TRANNAME),
		new StringFieldType("DS-STATUS-1802-RE", 10, TRANNAME),
		new StringFieldType("CD-STATUS-1802-RE", 1, TRANNAME),
		new LongFieldType("NR-ENDOSSO-1802-RE", 9, TRANNAME),
		new StringFieldType("DT-CONTROLE-1802-RE", 10, TRANNAME),
		new IntegerFieldType("CD-TPO-DOC-1802-RE", 3, TRANNAME),
		new StringFieldType("HA-PENDENCIA-1802-RE", 1, TRANNAME),
		new StringFieldType("ID-SISTEMA-1802-RE", 1, TRANNAME),
		new StringFieldType("DG-REF-1802-RE", 65, TRANNAME),
		new StringFieldType("OBJ-SEGURADO-1802-RE", 20, TRANNAME),
};
private static final CommonAreaMetaData COMMAREAIN = new CommonAreaMetaData(COMMON_FIELDS, COMMAREAIN_FIELDS);
private static final CommonAreaMetaData COMMAREAOUT = new CommonAreaMetaData(COMMON_FIELDS,COMMAREAOUT_FIELDS);
 /**
  * Construtor da classe que envia a definicao da transacao para o CTGProgram
  */
 public INET0802() {
	 super(PGMNAME, TRANNAME, COMMLENGTH, COMMAREAIN, COMMAREAOUT);
 }
}
