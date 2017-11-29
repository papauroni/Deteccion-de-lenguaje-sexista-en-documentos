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
		 s=s.substring(1);
		 System.out.println(s);
		 File fichero = new File ("C:/Users/P/Desktop/TFG/FrasesSeparadas/SEXISTA/" + nombre + ".txt");
		 fichero.createNewFile();
		 
		 fileWriter = new FileWriter("C:/Users/P/Desktop/TFG/FrasesSeparadas/SEXISTA/" + nombre + ".txt");
		 printWriter = new PrintWriter(fileWriter);
		 printWriter.write(s);
		 fileWriter.close();
	}
	
	public  static void noSexista(FileReader file, String s, String nombre) throws IOException {
		 s=s.substring(1);
		 System.out.println(s);
		 File fichero = new File ("C:/Users/P/Desktop/TFG/FrasesSeparadas/NOSEXISTA/" + nombre + ".txt");
		 fichero.createNewFile();
		 
		 fileWriter = new FileWriter("C:/Users/P/Desktop/TFG/FrasesSeparadas/NOSEXISTA/" + nombre + ".txt");
		 printWriter = new PrintWriter(fileWriter);
		 printWriter.write(s);
		 fileWriter.close();
	}
	
	
	public static void ejecutar() {
		int i=1;
		int aux=i;
		while(i <=1) {
		try {
			aux=i;
			s="";
			nombre=manejoNombre(aux);
			//fileReader = new FileReader("C:/Users/P/Desktop/TFG/frases/" + nombre + ".txt");
			fileReader = new FileReader("C:\\Users\\P\\Desktop\\TFG\\BancoDePruevas\\BOE-A-2017-9750.pdf");
			BufferedReader bf = new BufferedReader(fileReader);
			while ((sCadena = bf.readLine())!=null) {
				   System.out.println(sCadena);
					
				   if( sCadena.equals("SEXISTA")) sexista(fileReader, s, nombre);
				   if( sCadena.equals("NOSEXISTA")) noSexista(fileReader, s, nombre);
				   s= s + " " + sCadena;
				}
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
