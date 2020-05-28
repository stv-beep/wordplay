package Jocparaules;
import java.util.Scanner;
import java.io.*;

/**
 * Classe Gestio. Metodes de la gestió i configuració del joc.
 * @author Aleix Algueró
 *
 */
public class Gestio {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Metode que crea el fitxer. Si que al main també el creem, però allí a més, comprovem si ja existeix,
	 * per a evitar sobreescriure'l. Aquí el creem de nou, borrant les paraules que havien anteriorment.
	 */
	public static void creacioFitxer() {
		try {
            File pp = new File("pp.txt");
            System.out.println("Creant fitxer...Per favor, ves a l'opció \"AFEGIR\" per a afegir noves parelles");
            
            FileWriter fw = new FileWriter(pp);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();//imprimeix l'error
        }
	}
	
	
	/**
	 * Metode per a escriure parells de paraules i guardar-les a l'arxiu pp.txt
	 */
	public static void afegir() {
		System.out.println("Escriu la paraula en català: ");
		String catala = sc.nextLine();
		System.out.println("Escriu la paraula en anglès: ");
		String angles = sc.nextLine();
		String parella = catala + "-" + angles + "-"; //"-" per a separar les traduccions, "-" per a separar les parelles
		
		try {
			/*Amb el printstream escrivim al fitxer*/
			PrintStream escriptor = new PrintStream(new FileOutputStream("pp.txt", true)); 
			//Append - boolean si es true, llavors les dades s'escriurarn al final del fitxer i no substuiran altres paraules
			//https://es.stackoverflow.com/questions/68526/agregar-contenido-a-un-archivo-sin-sobrescribir-el-contenido
			escriptor.write(parella.getBytes());
			escriptor.close();
			
			
		} catch (Exception e) {
		e.printStackTrace();	
		}
			
	}
	
	/**
	 * Metode per a crear l'arxiu marcador.txt on es guardarà el número de paraules traduïdes correctament
	 */
	public static void creacioMarcador() {
		try {
            File fitxerMarcador = new File("marcador.txt");
            if (!fitxerMarcador.exists()) {
            	fitxerMarcador.createNewFile();
                } 
            System.out.println("Creant marcador...\n");
            FileWriter fw = new FileWriter(fitxerMarcador);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();
            PrintStream escriptor = new PrintStream(fitxerMarcador);
    		escriptor.println("Llistat de paraules traduïdes correctament:\n"); 
        } catch (Exception e) {
            e.printStackTrace();//imprimeix l'error
        }
	}
		
		

}
