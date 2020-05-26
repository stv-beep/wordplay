package Jocparaules;
import java.util.Scanner;
import java.io.*;


public class Joc {
	public static Scanner sc = new Scanner(System.in);

	
	
	//mostrara paraula en angles i la tindrem que traduir
	
	//http://lineadecodigo.com/java/leer-fichero-de-texto-con-java/
	 public static void paraulaCat() { //http://www.w3api.com/wiki/Java:FileReader
		 String[] str = {};
		 try {
			 System.out.println("Mostrant paraula en anglès...\n");
			 FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			 BufferedReader bf = new BufferedReader(fr);
			 String sCadena;
			  
			 while ((sCadena = bf.readLine())!=null) {
				 /*hola-pola-mola
					string.split("-")*/
					
				 str = sCadena.split("-");
				 
			    System.out.println(str[1]);
			 } 
			 System.out.println("Escriu la traducció: ");
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[0])) {
				 System.out.println("Correcte!");
			 } else { System.out.println("Paraula incorrecta!"); };
			 
			 
			 
			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}
			
		}
	
	
	
	
	public static void paraulaAng() {
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
}
