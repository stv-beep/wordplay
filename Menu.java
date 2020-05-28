package Jocparaules;
import java.util.Scanner;
import java.io.*;

/**
 * Classe principal, menú del joc.
 * @author Aleix Algueró
 *
 */

public class Menu {
	public static boolean running = true;//un boolea per a tancar el programa quan sigui necessari
	public static boolean runningG = true;
	public static boolean runningJ = true;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 int tradang = 0;//paraules encertades
		 int tradcat = 0;//paraules encertades
		/*Creació del fitxer, comprovant si existeix abans*/
		try {
		File pp = new File("pp.txt");
		
		if (!pp.exists()) {
            pp.createNewFile();
            }
		 } catch (Exception e) {
	            e.printStackTrace();//imprimeix l'error
	        }
            

		System.out.println("Benvingut al WORDPLAY");
		
		int opt = 0;//opció escollida pel user
	do {
		System.out.println("Prem 1 per a jugar ó 2 per a gestionar l'aplicació. 3 per a sortir del programa.");
		opt = sc.nextInt();
		switch (opt) {
		
		case 1: //JOC
			System.out.println("Entrant al joc...\n");
			int opc_idioma = 0;
		 do {
			 System.out.println("Escull idioma ( 1 = Català | 2 = Anglès | 3 = Sortir)\n");
			 opc_idioma = sc.nextInt();
			 switch (opc_idioma) {
			 
			 case 1: //catala
				 
				 //mostrara paraula en angles i la tindrem que traduir
				 tradcat = joc1.anglesCatala();				 
				 break;
				 
			 case 2: //angles
				 tradang = joc1.catalaAngles();
				 break;
				 
			default:
				runningJ = false;
				break;

			 }
	
		 } while (runningJ); //NECESSITA ALGUNS RETOCS PER A SORTIR
	
		 break;
		 		
		case 2: //GESTIO DE L'APP
			System.out.println("Entrant a la gestió de l'aplicació...\n");
			int opc_gestio = 0;
			do {
				System.out.println("Tria entre Afegir = 1 || Modificar = 2 || Esborrar = 3 || Arxivar = 4 || Llistat = 5 || Sortir = 6");
				opc_gestio = sc.nextInt();
						switch(opc_gestio) {
								case 1: //AFEGIR
									System.out.println("AFEGIR\n");
									gestio1.afegir();
									break;
									
								case 2: //MODIFICAR
									break;
									
								case 3: //ESBORRAR
									break;
									
								case 4: //ARXIVAR
									System.out.println("ARXIVAR\n");
									System.out.println("Creant fitxer \"pp.txt\"...\n");
									gestio1.creacioFitxer();
									gestio1.creacioMarcador();
									break;
								
								case 5: //LLISTAT
									joc1.marcador(tradcat, tradang);
									break;
									
								default:		
									break;
										
								case 6:
									runningG = false;
									break;
						
						}	
						
						} while (runningG);

					break;

		case 3:
			running = false;
			break;
		
		default:
			System.out.println("Opció incorrecta. Si us plau, 1 joc, 2 gestió.");
			break;
		
		}
		
		
	} while (running);
		
		
		
	}

	/*Creació d'objectes per als mètodes*/
	public static Gestio gestio1 = new Gestio();
	public static Joc joc1 = new Joc();

}
