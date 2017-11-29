package manejadorDeTexto;

import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("file.encoding", "UTF-8");
		Logica2.mostrarContenido2("https://www.boe.es/diario_boe/xml.php?id=BOE-A-2017-9133");
		//Test.createFile();
		//Test.abrirPDF();
	}
	
	
}
