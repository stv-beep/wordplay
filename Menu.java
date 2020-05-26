package Jocparaules;
import java.util.Scanner;
import java.io.*;

public class Menu {
	public static boolean running = true;
	public static Scanner sc = new Scanner(System.in);
	
	

	
	
	public static void main(String[] args) {
		 
		/*Creació del fitxer*/
		try {
		File pp = new File("pp.txt");
		if (!pp.exists()) {
            pp.createNewFile();
            }
		 } catch (Exception e) {
	            e.printStackTrace();//imprimeix l'error
	        }
            
		Scanner sc = new Scanner(System.in);
		System.out.println("Benvingut al Joc de paraules anglès-català.");
		
		int opt = 0;
	do {
		System.out.println("Prem 1 per a jugar ó 2 per a gestionar l'aplicació. 3 per a sortir del programa.");
		opt = sc.nextInt();
		switch (opt) {
		
		case 1: //JOC
			System.out.println("Entrant al joc...\n");
			int opc_idioma = 0;
		 do {
			 System.out.println("Escull idioma ( 1 = Català | 2 = Anglès)\n");
			 opc_idioma = sc.nextInt();
			 switch (opc_idioma) {
			 
			 case 1: //catala
				 
				 //mostrara paraula en angles i la tindrem que traduir
				 joc1.paraulaCat();				 
				 
				 
				 
				 break;
				 
			 case 2: //angles
				 
				 
				 break;
			 }
			  
			 
		 } while (opt != 1 || opt != 2); //NECESSITA ALGUNS RETOCS PER A SORTIR
			
			
			break;
		
		case 2: //GESTIO DE L'APP
			System.out.println("Entrant a la gestió de l'aplicació...\n");
			int opc_gestio = 0;
			do {
				System.out.println("Tria entre Afegir = 1 || Modificar = 2 || Esborrar = 3 || Arxivar = 4 || Sortir = 5");
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
									
									
									break;
								
								default:
									break;
										
								case 5:
									running = false;
									break;
						
						}	
						
						} while (running);

			
			
			
					break;
			
			
			
		
		case 3:
			running = false;
		
		default:
			System.out.println("Opció incorrecta. Si us plau, 1 joc, 2 gestió.");
			break;
		
		}
		
		
	} while (running);
		
		
		
	}

	
	public static Gestio gestio1 = new Gestio();//creo objecte gestio
	public static Joc joc1 = new Joc();
	

}
