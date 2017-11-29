package manejadorDeTexto;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Test {

	public static void abrirPDF() {
		try {
		     File path = new File ("C:/Users/P/Desktop/TFG/BancoDePruevas/BOE-A-2017-9750.pdf");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}
	}
	
	public static void flattenPDF() {
		
	}
}
