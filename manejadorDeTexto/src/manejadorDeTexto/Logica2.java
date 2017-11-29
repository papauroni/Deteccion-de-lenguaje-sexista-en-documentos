package manejadorDeTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.xml.bind.DatatypeConverter;

public class Logica2 {

	public static void mostrarContenido(String url) throws Exception {
		URL ficheroUrl = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));

		String linea;
		while ((linea = in.readLine()) != null) {
			if (linea.contains("<texto>")) {
				int i = 1;
				while (!(linea = in.readLine()).contains("</texto>")) {
					if (!(linea.contains("<"))) {
						System.out.println(linea);
					}
					if (linea.contains("<")) {
						int a = linea.indexOf("<");
					}
					if (linea.contains(">")) {
						int b = linea.indexOf(">");
					}
					System.out.println(linea);
				}
			}
			// System.out.println(linea);
		}

		in.close(); // Cerramos la conexión
	}

	public static void mostrarContenido2(String url) throws Exception {
		URL ficheroUrl = new URL(url);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));

		String linea = null;
		
		while ((linea = in.readLine()) != null) {
			if (linea.contains("<texto>")) {
				metodo1(linea, in);
				// System.out.println(linea);

			}

			// System.out.println(linea);
		}

		in.close(); // Cerramos la conexión
	}

	public static String metodo1(String linea, BufferedReader in) throws IOException {
		String s = "";
		String lin = "";
		String aux = "";
		int a = 0;
		int b = linea.length();
		if (linea.contains("<texto>") && linea.contains("</texto>")) {
			//s = s + " " + linea.substring(linea.indexOf("<texto>") + 7, linea.indexOf("</texto>"));
			//s = s + "";
			s = linea.substring(linea.indexOf("<texto>") + 7, linea.indexOf("</texto>"));
			s = replace(s);
			System.out.println(s);
			return s;
		}
		while (!(linea = in.readLine()).contains("</texto>")) {
						
			if (!(linea.contains("<"))) {
				System.out.println(linea);
			}
			if (linea.contains("<table")) {
				while (!(linea = in.readLine()).contains("</table>")) {

				}
			}
			if (linea.contains("<")) {
				a = linea.indexOf(">") + 1;
			}
			if (linea.contains(">")) {
				b = linea.lastIndexOf("<");
			}
			if (a < b) {
				try {
					lin = linea.substring(a, b);
					s=replace(lin);
				} catch (Exception e) {
					System.out.println("error en el substring(a,b);");
				}
			}
			//System.out.println(lin);
			System.out.println(s);
			s="";
			lin="";
		}
		return s;

	}
	
	public static String replace(String s) {
		//s=s.toLowerCase();
		s=s.replace("«","");
		s=s.replace("»","");
		
		s=s.replace("Ã±","ñ");
		s=s.replace("Â","");
		s=s.replace("â»","");
		s=s.replace("â«","");
		s=s.replace("â€“","");
		s=s.replace("Ã¡","a");
		s=s.replace("ã³","o");
		s=s.replace("ã","a");
		s=s.replace("ã?","a");
		s=s.replace("a©","e");
		s=s.replace("ã­","i");
		s=s.replace("Â«","");
		s=s.replace("Ã­","i");
		s=s.replace("Â»","");
		s=s.replace("Ã­","i");
		s=s.replace("Ã³","o");
		s=s.replace("Ã©","e");
		s=s.replace("Ãº","u");
		s=s.replace(",","");
		s=s.replace(".","");
		s=s.replace("!","");
		s=s.replace("¡","");
		s=s.replace("?","");
		s=s.replace("¿","");
		s=s.replace("{","");
		s=s.replace("}","");
		s=s.replace("[","");
		s=s.replace("]","");
		s=s.replace("-","");
		s=s.replace("_","");
		s=s.replace(";","");
		s=s.replace(":","");
		s=s.replace("*","");
		s=s.replace("/","");
		s=s.replace("º","");
		s=s.replace("ª","");
		s=s.replace("=","");
		s=s.replace("(","");
		s=s.replace(")","");
		s=s.replace("+","");
		s=s.replace("<","");
		s=s.replace(">","");
		s=s.replace("|","");
		s=s.replace("@","");
		s=s.replace("#","");
		s=s.replace("~","");
		s=s.replace("¬","");
		s=s.replace("·","");
		s=s.replace("$","");
		s=s.replace("%","");
		s=s.replace("&","");
		s=s.replace("\\","");
		s=s.replace("í","i");
		s=s.replace("ï","i");
		s=s.replace("ì","i");
		s=s.replace("é","e");
		s=s.replace("è","e");
		s=s.replace("ë","e");
		s=s.replace("á","a");
		s=s.replace("à","a");
		s=s.replace("ä","a");
		s=s.replace("ö","o");
		s=s.replace("ó","o");
		s=s.replace("ò","o");
		s=s.replace("ü","u");
		s=s.replace("ú","u");
		s=s.replace("ù","u");
		
//		s=s.replace("Í","i");
//		s=s.replace("Ï","i");
//		s=s.replace("Ì","i");
//		s=s.replace("É","e");
//		s=s.replace("È","e");
//		s=s.replace("Ë","e");
//		s=s.replace("Á","a");
//		s=s.replace("À","a");
//		s=s.replace("Ä","a");
//		s=s.replace("Ö","o");
//		s=s.replace("Ó","o");
//		s=s.replace("Ò","o");
//		s=s.replace("Ü","u");
//		s=s.replace("Ú","u");
//		s=s.replace("Ù","u");
		
		
		s=s.replace("1","");
		s=s.replace("2","");
		s=s.replace("3","");
		s=s.replace("4","");
		s=s.replace("5","");
		s=s.replace("6","");
		s=s.replace("7","");
		s=s.replace("8","");
		s=s.replace("9","");
		s=s.replace("0","");
		s=s.replace("  "," ");
		
		
		//s=s.replace("ã","u");
		
		s=s.toLowerCase();
		return s;
	}
}
