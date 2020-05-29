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
            System.out.println("Creant fitxer pp.txt... Per favor, entra a l'opció \"AFEGIR\" per a afegir noves parelles.");
            
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
	 * Metode per a substituir una paraula per una altra.
	 */
	public static void modificar() {
		String[] str = {};
		try {
        FileReader fr = new FileReader("pp.txt");//creem reader del fitxer
        BufferedReader bf = new BufferedReader(fr);
        String paraula;
       String paraula2;

        String cadena;
        cadena = bf.readLine();
        str = cadena.split("-");//fem que str sigur per a fer splits
        System.out.println(cadena);//en aquest println

        System.out.println("Tria el nom que vols modificar");

        paraula = sc.next();//demanem al usuari el nom que vol modificar

        for(int k=0; k<str.length; k++) {//creem un for que el que fara sira buscar la paraula que ha ficat l'usuari

        str = cadena.split("-");
        if(str[k].equals(paraula)) {//En aquest if entrem quan la paraula que ha ficat l'usuari la trovem al arxiu

        System.out.println("Quin nom vols ficar nou?");
        paraula2 = sc.next();//li demanem la paraula al usuari
        str[k]=paraula2;//igualem la paraula que volem modificar per la nova
       PrintStream nova = new PrintStream(new FileOutputStream("pp.txt", true)); //escrivim la paraula nova
       nova.write(str[k].getBytes());
       nova.close();
        }
        }} catch (FileNotFoundException fnfe){
			 fnfe.printStackTrace();
			} catch (IOException ioe){
			 ioe.printStackTrace();
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
            System.out.println("Creant marcador... Per favor, entra a l'opció \"LLISTAT\" per a consultar el marcador.\n");

            PrintStream escriptor = new PrintStream(fitxerMarcador);
    		escriptor.println("Llistat de partides:\n"); 
        } catch (Exception e) {
            e.printStackTrace();//imprimeix l'error
        }
	}
		

}
