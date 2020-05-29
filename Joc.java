package Jocparaules;
import java.util.Scanner;
import java.io.*;

/**
 * Classe Joc. Metodes sobre el joc en sí, per a traduir les paraules.
 * @author Aleix Algueró
 *
 */

public class Joc {
	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * Metode per a donar intents de traduccio de les paraules a l'usuari.
	 * Mostrara paraula en angles i la tindrem que traduir.
	 * Es guardaran les paraules a l'array, i el bucle determinarà quina s'ha de traduir.
	 */
	 public static int anglesCatala() { //http://www.w3api.com/wiki/Java:FileReader
		 String[] str = {};//array on guardarem les paraules, sent els indexs parells català i els imparells anglès
		 int pts = 0;//comptador
		 try {
			 System.out.println("Mostrant paraula en anglès...\n");
			 FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			 BufferedReader bf = new BufferedReader(fr);
			 String sCadena;
			  
			 while ((sCadena = bf.readLine())!=null) {
					
				 str = sCadena.split("-");//dividim la parella en dos amb el "-"
				 /*començo el bucle en 1 (angles), per a que trie la segona paraula, i vaig incrementant de 2 en 2*/
				 for (int i = 1; i<str.length;i+=2) {

			 System.out.println("Escriu la traducció de \""+str[i]+"\": ");//mostrem la paraula a traduir (index imparell)
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[i-1])) {//si la paraula es igual a l'anterior que es la seua parella...
				 System.out.println("Correcte!");
				 pts++;//sumem punts
			 } else { System.out.println("Traducció incorrecta!");
			 System.out.println("La correcta és: "+str[i-1]+"\n");}}};
			 
			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}
		 System.out.println("La teua puntuació final és: "+pts+"\n");
		 return pts;}
	 


	/**
	* Metode per a donar intents de traduccio de les paraules a l'usuari.
	* Mostrara paraula en angles i la tindrem que traduir.
	* Es guardaran les paraules a l'array, i el bucle determinarà quina s'ha de traduir
	* @return pts vegades traduït correctament
	 */
	public static int catalaAngles() {
		String[] str = {};//array on guardarem les paraules, sent els indexs parells català i els imparells anglès
		int pts = 0;//comptador
		
		 try {
			 System.out.println("Mostrant paraula en català...\n");
			 FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			 BufferedReader bf = new BufferedReader(fr);
			 String sCadena;
			  
			 while ((sCadena = bf.readLine())!=null) {
					
				 str = sCadena.split("-");//dividim la parella en dos amb el "-"
				 /*començo el bucle en 0 (la paraula en catala), per a que trie la segona paraula, i vaig incrementant de 2 en 2*/
				 for (int i = 0; i<str.length;i+=2) {

			   System.out.println("Escriu la traducció de \""+str[i]+"\": ");
			 String intent1 = sc.nextLine();
			 if (intent1.contentEquals(str[i+1])) {//si la paraula es igual a la posterior que es la seua parella...
				 System.out.println("Correcte!");
				 pts++;//sumem punts
			
			 } else { System.out.println("Traducció incorrecta!");
			 System.out.println("La correcta és: "+str[i+1]+"\n");}}};
			 
			} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
			}
		 System.out.println("La teua puntuació final és: "+pts+"\n");
	return pts; }	
	

	/**
	 * Metode per a guardar i imprimir els punts aconseguits traduïnt
	 * @param ang int punts
	 * @param cat int punts
	 * @param partides int numero de partides
	 */
	public static void marcador(int ang, int cat, int partides) {
		
		try {
			/*Amb el printstream escrivim al fitxer*/
			PrintStream escriptor = new PrintStream(new FileOutputStream("marcador.txt", true)); 
			//Append - boolean si es true, llavors les dades s'escriurarn al final del fitxer i no substuiran altres paraules
			//https://es.stackoverflow.com/questions/68526/agregar-contenido-a-un-archivo-sin-sobrescribir-el-contenido
			escriptor.println("Partida " + partides); 
			escriptor.println("Paraules ben traduïdes del català a l'anglès: "+cat+" | "); 
			escriptor.close();

		} catch (Exception e) {
		e.printStackTrace();	
		}
		
		try {
			/*Amb el printstream escrivim al fitxer*/
			PrintStream escriptor = new PrintStream(new FileOutputStream("marcador.txt", true)); 
			//Append - boolean si es true, llavors les dades s'escriurarn al final del fitxer i no substuiran altres paraules
			//https://es.stackoverflow.com/questions/68526/agregar-contenido-a-un-archivo-sin-sobrescribir-el-contenido
			escriptor.println("Paraules ben traduïdes de l'anglès al català: "+ang+" | \n");
			escriptor.close();

		} catch (Exception e) {
		e.printStackTrace();	
		}
		
		System.out.println("Partida " + partides);
		System.out.println("Paraules ben traduïdes del català a l'anglès: "+cat);
		System.out.println("Paraules ben traduïdes de l'anglès al català: "+ang+"\n");
	}
	
	/**
	 * Metode per a comprovar si el document on es guarden les paraules pp.txt està buit o no
	 * @return boolean
	 */
	public static boolean docBuit(){
		try {
			FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
			BufferedReader bf = new BufferedReader(fr);
				String line;
				  
		if ((line = bf.readLine())!=null) {//comprova si hi ha linies
				return false;
			} else { return true; }
		
		} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
	} catch (IOException ioe){
		 ioe.printStackTrace();
		}
		return true;
	}
	
	
}
