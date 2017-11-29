package manejadorDeTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logica {
	
	static FileReader fileReader;
	static FileWriter fileWriter;
	static PrintWriter printWriter = null;
	static String nombre = "0001";
	static String sCadena;
	static String s;
	
	public static String manejoNombre(int aux) {
		if(1<=aux && aux<=9)nombre = "000"+aux;
		if(10<=aux && aux<=99)nombre = "00"+aux;
		if(100<=aux && aux<=999)nombre = "0"+aux;
		if(1000<=aux && aux<=9999)nombre = ""+aux;
		//System.out.println(nombre);
		return nombre;
	}
	
	public static void sexista(FileReader file, String s, String nombre) throws IOException {
		 s=replace(s);
		 System.out.println(s);
		 System.out.println();
		 File fichero = new File (Constants.rutaDestino + "SEXISTA/" + nombre + ".txt");
		 fichero.createNewFile();
		 
		 fileWriter = new FileWriter(Constants.rutaDestino + "SEXISTA/" + nombre + ".txt");
		 printWriter = new PrintWriter(fileWriter);
		 printWriter.write(s);
		 fileWriter.close();
	}
	
	public  static void noSexista(FileReader file, String s, String nombre) throws IOException {
		s=replace(s);
		 System.out.println(s);
		 System.out.println();
		 File fichero = new File (Constants.rutaDestino + "NOSEXISTA/" + nombre + ".txt");
		 fichero.createNewFile();
		 
		 fileWriter = new FileWriter(Constants.rutaDestino + "NOSEXISTA/" + nombre + ".txt");
		 printWriter = new PrintWriter(fileWriter);
		 printWriter.write(s);
		 fileWriter.close();
	}
	
	public static String replace(String s) {
		s=s.substring(1);
		s=s.replaceAll(" *$", "");
		s=s.replace(" A "," ");
		s=s.replace(" Ante "," ");
		s=s.replace(" Bajo "," ");
		s=s.replace(" Con "," ");
		s=s.replace(" Cabe "," ");
		s=s.replace(" Contra "," ");
		s=s.replace(" De "," ");
		s=s.replace(" Desde "," ");
		s=s.replace(" En "," ");
		s=s.replace(" Entre "," ");
		s=s.replace(" Hacia "," ");
		s=s.replace(" Hasta "," ");
		s=s.replace(" Para "," ");
		s=s.replace(" Por "," ");
		s=s.replace(" Segun "," ");
		s=s.replace(" Sin "," ");
		s=s.replace(" So "," ");
		s=s.replace(" Sobre "," ");
		s=s.replace(" Tras "," ");
		s=s.replace(" Durante "," ");
		s=s.replace(" Mediante "," ");
		s=s.replace(" Incluso "," ");
		s=s.replace(" Excepto "," ");
		s=s.replace(" Salvo "," ");
		s=s.replace(" Mas "," ");
		s=s.replace(" Menos "," ");
		
		s=s.replace("A ","");
		s=s.replace("Ante ","");
		s=s.replace("Bajo ","");
		s=s.replace("Con ","");
		s=s.replace("Cabe ","");
		s=s.replace("Contra ","");
		s=s.replace("De ","");
		s=s.replace("Desde ","");
		s=s.replace("En ","");
		s=s.replace("Entre ","");
		s=s.replace("Hacia ","");
		s=s.replace("Hasta ","");
		s=s.replace("Para ","");
		s=s.replace("Por ","");
		s=s.replace("Segun ","");
		s=s.replace("Sin ","");
		s=s.replace("So ","");
		s=s.replace("Sobre ","");
		s=s.replace("Tras ","");
		s=s.replace("Durante ","");
		s=s.replace("Mediante ","");
		s=s.replace("Incluso ","");
		s=s.replace("Excepto ","");
		s=s.replace("Salvo ","");
		s=s.replace("Mas ","");
		s=s.replace("Menos ","");
		
		s=s.toLowerCase();
		
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
		s=s.replace(" - ","");
		s=s.replace(" – ","");
		s=s.replace("-"," ");
		s=s.replace("–"," ");
		s=s.replace("_","");
		s=s.replace(";","");
		s=s.replace(":","");
		s=s.replace("*","");
		s=s.replace(" / ","");
		s=s.replace("/"," ");
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
		s=s.replace("«","");
		s=s.replace("»","");
		s=s.replace("·","");
		s=s.replace("$","");
		s=s.replace("%","");
		s=s.replace("&","");
		s=s.replace("\\","");
		s=s.replace("“","");
		s=s.replace("”","");
		s=s.replace("…","");
		
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
		
		s=s.replace(" a "," ");
		s=s.replace(" ante "," ");
		s=s.replace(" bajo "," ");
		s=s.replace(" con "," ");
		s=s.replace(" cabe "," ");
		s=s.replace(" contra "," ");
		s=s.replace(" de "," ");
		s=s.replace(" desde "," ");
		s=s.replace(" en "," ");
		s=s.replace(" entre "," ");
		s=s.replace(" hacia "," ");
		s=s.replace(" hasta "," ");
		s=s.replace(" para "," ");
		s=s.replace(" por "," ");
		s=s.replace(" segun "," ");
		s=s.replace(" sin "," ");
		s=s.replace(" so "," ");
		s=s.replace(" sobre "," ");
		s=s.replace(" tras "," ");
		s=s.replace(" durante "," ");
		s=s.replace(" mediante "," ");
		s=s.replace(" incluso "," ");
		s=s.replace(" excepto "," ");
		s=s.replace(" salvo "," ");
		s=s.replace(" mas "," ");
		s=s.replace(" menos "," ");
		
		s=s.replaceAll(" *$", "");
		
		s=s.replaceAll(" a$"," ");
		s=s.replaceAll(" ante$"," ");
		s=s.replaceAll(" bajo$"," ");
		s=s.replaceAll(" con$"," ");
		s=s.replaceAll(" cabe$"," ");
		s=s.replaceAll(" contra$ "," ");
		s=s.replaceAll(" de$"," ");
		s=s.replaceAll(" desde$"," ");
		s=s.replaceAll(" en$"," ");
		s=s.replaceAll(" entre$"," ");
		s=s.replaceAll(" hacia$"," ");
		s=s.replaceAll(" hasta$"," ");
		s=s.replaceAll(" para$"," ");
		s=s.replaceAll(" por$"," ");
		s=s.replaceAll(" segun$"," ");
		s=s.replaceAll(" sin$"," ");
		s=s.replaceAll(" so$"," ");
		s=s.replaceAll(" sobre$"," ");
		s=s.replaceAll(" tras$"," ");
		s=s.replaceAll(" durante$"," ");
		s=s.replaceAll(" mediante$"," ");
		s=s.replaceAll(" incluso$"," ");
		s=s.replaceAll(" excepto$"," ");
		s=s.replaceAll(" salvo$"," ");
		s=s.replaceAll(" mas$"," ");
		s=s.replaceAll(" menos$"," ");
		
		s=s.replaceAll("^a ","");
		s=s.replaceAll("^ante ","");
		s=s.replaceAll("^bajo ","");
		s=s.replaceAll("^con ","");
		s=s.replaceAll("^cabe ","");
		s=s.replaceAll("^contra  ","");
		s=s.replaceAll("^de ","");
		s=s.replaceAll("^desde ","");
		s=s.replaceAll("^en ","");
		s=s.replaceAll("^entre ","");
		s=s.replaceAll("^hacia ","");
		s=s.replaceAll("^hasta ","");
		s=s.replaceAll("^para ","");
		s=s.replaceAll("^por ","");
		s=s.replaceAll("^segun ","");
		s=s.replaceAll("^sin ","");
		s=s.replaceAll("^so ","");
		s=s.replaceAll("^sobre ","");
		s=s.replaceAll("^tras ","");
		s=s.replaceAll("^durante ","");
		s=s.replaceAll("^mediante ","");
		s=s.replaceAll("^incluso ","");
		s=s.replaceAll("^excepto ","");
		s=s.replaceAll("^salvo ","");
		s=s.replaceAll("^mas ","");
		s=s.replaceAll("^menos ","");
		
		
		s=s.replace(" acerca de "," ");
		s=s.replace(" al lado de ","");
		s=s.replace(" alrededor de ","");
		s=s.replace(" antes de ","");
		s=s.replace(" a pesar de ","");
		s=s.replace(" cerca de ","");
		s=s.replace(" con arreglo a ","");
		s=s.replace(" con objeto de ","");
		s=s.replace(" debajo de ","");
		s=s.replace(" delante de ","");
		s=s.replace(" dentro de ","");
		s=s.replace(" despues de ","");
		s=s.replace(" detras de ","");
		s=s.replace(" encima de ","");
		s=s.replace(" en cuanto a ","");
		s=s.replace(" enfrente de ","");
		s=s.replace(" en virtud de ","");
		s=s.replace(" frente a ","");
		s=s.replace(" fuera de ","");
		s=s.replace(" gracias a ","");
		s=s.replace(" junto a ","");
		s=s.replace(" lejos de ","");
		s=s.replace(" por culpa de ","");
		
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
		
		s=s.replace(" ñ "," ");
		s=s.replace(" i "," ");
		s=s.replace(" ii "," ");
		s=s.replace(" iii "," ");
		
		s=s.replace(" a "," ");
		s=s.replaceAll("^a "," ");
		s=s.replaceAll(" a$"," ");
		s=s.replace(" e "," ");
		s=s.replaceAll("^e "," ");
		s=s.replaceAll(" e$"," ");
		s=s.replace(" i "," ");
		s=s.replaceAll("^i "," ");
		s=s.replaceAll(" i$"," ");
		s=s.replace(" o "," ");
		s=s.replaceAll("^o "," ");
		s=s.replaceAll(" o$"," ");
		s=s.replace(" u "," ");
		s=s.replaceAll("^u "," ");
		s=s.replaceAll(" u$"," ");
		s=s.replace(" y "," ");
		s=s.replaceAll("^y "," ");
		s=s.replaceAll(" y$"," ");
		
		s=s.replace("aaa"," ");
		s=s.replace(" m "," ");
		s=s.replace(" n "," ");
		s=s.replace(" b "," ");
		s=s.replace(" c "," ");
		s=s.replace(" d "," ");
		s=s.replace(" f "," ");
		s=s.replace(" num "," ");
		s=s.replace("csv","");
		s=s.replace("oiea","");
		s=s.replace("cee","");
		s=s.replace(" nviii "," ");
		s=s.replace(" v "," ");
		s=s.replace(" iv "," ");
		s=s.replace("vii"," ");
		s=s.replace("viii"," ");
		s=s.replace(" ix "," ");
		s=s.replace("xx","");
		s=s.replace(" x "," ");
		s=s.replace(" esfas "," ");
		s=s.replace(" omt "," ");
		s=s.replace(" omi "," ");
		s=s.replace(" mur "," ");
		s=s.replace(" inap "," ");
		s=s.replace(" ruct "," ");
		s=s.replace("tfue","");
		s=s.replace(" q "," ");
		s=s.replace(" p "," ");
		s=s.replace("oiey"," ");
		s=s.replace("nrp"," ");
		s=s.replace(" h "," ");
		s=s.replace(" g "," ");
		s=s.replace(" art "," ");
		s=s.replace(" ad "," ");
		s=s.replace(" z "," ");
		s=s.replace(" s "," ");
		s=s.replace(" xviii "," ");
		s=s.replace(" xvii "," ");
		s=s.replace(" xvi "," ");
		s=s.replace(" xiv "," ");
		s=s.replace(" xix "," ");
		s=s.replace(" xbrl "," ");
		s=s.replace(" www"," ");
		s=s.replace("uagadugu","");
		s=s.replace(" tur "," ");
		s=s.replace(" t "," ");
		s=s.replace(" ssi "," ");
		s=s.replace(" rd "," ");
		s=s.replace(" psis "," ");
		s=s.replace("oie","");
		s=s.replace("noruegsobre","");
		s=s.replace(" mm "," ");
		s=s.replace("lseccion","seccion");
		s=s.replace("lsoberanide","");
		s=s.replace("lislde","");
		s=s.replace(" k "," ");
		s=s.replace(" j "," ");
		s=s.replace(" ciii "," ");
		s=s.replaceAll(" s$"," ");
		s=s.replaceAll("^s "," ");
		
		s=s.replace("  "," ");
		s=s.replaceAll(" *$", "");
		return s;
	}
	
	public static void ejecutar() {
		int i=1;
		int aux=i;
		int numArchivos = Constants.numArchivos;
		while(i <= numArchivos) {
		try {
			aux=i;
			s="";
			nombre=manejoNombre(aux);
			fileReader = new FileReader(Constants.rutaExtraccion + nombre + ".txt");
			//fileReader = new FileReader("C:\\Users\\P\\Desktop\\TFG\\BancoDePruevas\\Milibro.docx");
			BufferedReader bf = new BufferedReader(fileReader);
			while ((sCadena = bf.readLine())!=null) {
				   //System.out.println(sCadena);
					
					if(sCadena.equals("NOSEXISTA")) noSexista(fileReader, s, nombre);
					if(sCadena.equals("SEXISTA"))  sexista(fileReader, s, nombre);
				   s= s + " " + sCadena;
				}
			
			
			//s=s.replace("\","");
//			File fichero = new File ("C:/Users/P/Desktop/TFG/BancoDePruevas/destino/" + nombre + ".txt");
//			 fichero.createNewFile();
//			 
//			 fileWriter = new FileWriter("C:/Users/P/Desktop/TFG/BancoDePruevas/destino/" + nombre + ".txt");
//			 printWriter = new PrintWriter(fileWriter);
//			 printWriter.write(s);
//			 fileWriter.close();
			i++;
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}

//
// \t  Insert a tab in the text at this point.
// \b  Insert a backspace in the text at this point.
// \n  Insert a newline in the text at this point.
// \r  Insert a carriage return in the text at this point.
// \f  Insert a formfeed in the text at this point.
// \'  Insert a single quote character in the text at this point.
// \"  Insert a double quote character in the text at this point.
// \\  Insert a backslash character in the text at this point.




// java weka.core.converters.TextDirectoryLoader -dir /directory/with/your/text/files > output.arff