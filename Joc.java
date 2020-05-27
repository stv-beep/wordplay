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
					
				 str = sCadena.split("-");//dividim la parella en dos amb el "-"
				 /*començo el bucle en 1, per a que trie la segona paraula, i vaig incrementant de 2*/
				 for (int i = 1; i<str.length;i+=2) {
					 
				 
			    System.out.println(str[i]);
			  
			 System.out.println("Escriu la traducció: ");
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[i-1])) {
				 System.out.println("Correcte!");
			 } else { System.out.println("Paraula incorrecta!"); }}};
			 
			 
			 
			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}
			
		}
	

	
	public static void paraulaAng() {
		String[] str = {};
		 try {
			 System.out.println("Mostrant paraula en català...\n");
			 FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			 BufferedReader bf = new BufferedReader(fr);
			 String sCadena;
			  
			 while ((sCadena = bf.readLine())!=null) {
				 /*hola-pola-mola
					string.split("-")*/
					
				 str = sCadena.split("-");

				 for (int i = 0; i<str.length;i+=2) {
					 
				 
			    System.out.println(str[i]);
			  
			 System.out.println("Escriu la traducció: ");
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[i+1])) {
				 System.out.println("Correcte!");
			 } else { System.out.println("Paraula incorrecta!"); }}};
			 
			 
			 
			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}
	}
	

	
	
}
