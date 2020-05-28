package Jocparaules;
import java.util.Scanner;
import java.io.*;


public class Joc {
	public static Scanner sc = new Scanner(System.in);

	
	
	//mostrara paraula en angles i la tindrem que traduir
	
	//http://lineadecodigo.com/java/leer-fichero-de-texto-con-java/
	/**
	 * Metode per a donar intents de traduccio de les paraules a l'usuari.
	 * Es guardaran les paraules a l'array, i el bucle determinarà quina s'ha de traduir
	 */
	 public static void paraulaCat() { //http://www.w3api.com/wiki/Java:FileReader
		 String[] str = {};//array on guardarem les paraules, sent els indexs parells català i els imparells anglès
		 try {
			 System.out.println("Mostrant paraula en anglès...\n");
			 FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			 BufferedReader bf = new BufferedReader(fr);
			 String sCadena;
			  
			 while ((sCadena = bf.readLine())!=null) {
				 /*hola-pola-mola
					string.split("-")*/
					
				 str = sCadena.split("-");//dividim la parella en dos amb el "-"
				 /*començo el bucle en 1 (angles), per a que trie la segona paraula, i vaig incrementant de 2 en 2*/
				 for (int i = 1; i<str.length;i+=2) {

			    System.out.println(str[i]);//mostrem la paraula a traduir (index imparell)
			  
			 System.out.println("Escriu la traducció: ");
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[i-1])) {//si la paraula es igual a l'anterior que es la seua parella...
				 System.out.println("Correcte!");
			 } else { System.out.println("Paraula incorrecta!"); }}};
			 
			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}	
		}
	

	/**
	* Metode per a donar intents de traduccio de les paraules a l'usuari.
	* Es guardaran les paraules a l'array, i el bucle determinarà quina s'ha de traduir
	*/
	public static void paraulaAng() {
		String[] str = {};//array on guardarem les paraules, sent els indexs parells català i els imparells anglès
		 try {
			 System.out.println("Mostrant paraula en català...\n");
			 FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			 BufferedReader bf = new BufferedReader(fr);
			 String sCadena;
			  
			 while ((sCadena = bf.readLine())!=null) {
				 /*hola-pola-mola
					string.split("-")*/
					
				 str = sCadena.split("-");//dividim la parella en dos amb el "-"
				 /*començo el bucle en 0 (la paraula en catala), per a que trie la segona paraula, i vaig incrementant de 2 en 2*/
				 for (int i = 0; i<str.length;i+=2) {

			    System.out.println(str[i]);//mostrem la paraula a traduir (index parell)
			  
			 System.out.println("Escriu la traducció: ");
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[i+1])) {//si la paraula es igual a la posterior que es la seua parella...
				 System.out.println("Correcte!");
			 } else { System.out.println("Paraula incorrecta!"); }}};

			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}
	}	
}
