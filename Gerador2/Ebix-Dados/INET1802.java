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
public class INET1802  extends INET1802Base{

	protected CommonAreaMetaData getAreaIn() {
		return new CommonAreaMetaData(AREA_COM_1802_ENT, DADOS_ENTRADA, DS_DADOS_ERRO);
	}
	
	protected CommonAreaMetaData getAreaOut() {
		return new CommonAreaMetaData(AREA_COM_1802_ENT, DADOS_ENTRADA, DS_DADOS_ERRO);
	}
}
