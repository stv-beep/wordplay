package Jocparaules;
import java.util.Scanner;
import java.io.*;


public class Gestio {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void creacioFitxer() {
		try {
            File pp = new File("pp.txt");
            
            FileWriter fw = new FileWriter(pp);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();//imprimeix l'error
        }
	}
	
	
	/**
	 * Metode per a escriure parells de paraules guardar-les a l'arxiu pp.txt
	 */
	public static void afegir() {
		System.out.println("Escriu la paraula en català: ");
		String catala = sc.nextLine();
		System.out.println("Escriu la paraula en anglès: ");
		String angles = sc.nextLine();
		String parella = catala + "-" + angles + "-"; // - per a separar les traduccions, "," per a separar les parelles
		
		try {
			PrintStream escriptor = new PrintStream(new FileOutputStream("pp.txt", true)); 
			//Append - boolean si es true, llavors les dades s'escriurarn al final del fitxer i no substuiran altres paraules
			//https://es.stackoverflow.com/questions/68526/agregar-contenido-a-un-archivo-sin-sobrescribir-el-contenido
			escriptor.write(parella.getBytes());
			escriptor.close();
			
		} catch (Exception e) {
		e.printStackTrace();	
		}
			
	}
	
	
	/*hola-pola-mola
	string.split("-")*/
	
	

	

}
