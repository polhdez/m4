package m4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Restaurant {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		final int bitllet1 = 5;
		final int bitllet2 = 10;
		final int bitllet3 = 20;
		final int bitllet4 = 50;
		final int bitllet5 = 100;
		final int bitllet6 = 200;
		final int bitllet7 = 500;
		
		// Fase 2
		HashMap<String, Integer> menu = new HashMap<String,Integer>();
		menu.put("Espaguetis", bitllet1);
		menu.put("Mandonguilles", bitllet2);
		menu.put("Filet", bitllet3);
		
		String[] arrayPlats = new String[menu.size()];
		int count = 0;
		for(Map.Entry<String, Integer> plat : menu.entrySet()) {
			arrayPlats[count] = plat.getKey();
			count++;
		}
		
		ArrayList<String> platsDemanats = new ArrayList<String>();
		
		boolean running = true;
		while(running) {
			while(true) {				
				showMenu(menu);
				try {
					platsDemanats = afegirPlats(arrayPlats, platsDemanats);
					break;
				}
				catch(Exception e) {
					System.out.println(e);
					continue;
				}
			}
			
			while(true) {
				try {
					if (finishComanda()) {
						running = false;
					}
					break;
				}
				catch(Exception e) {
					System.out.println(e);
					continue;
				}
			}
		}
		
		// Fase 3
		int preuTotal = 0;
		for(String plat : platsDemanats) {
			preuTotal += menu.get(plat);
		}
		System.out.println("Preu total: " + preuTotal + "€");
	}
		
	public static ArrayList<String> afegirPlats(String[] choices, ArrayList<String> platsDemanats) throws PlatException, TipusException {
		System.out.println("Quin plat vols?");
		int choice;
		try {
			choice = scanner.nextInt();
		}
		catch(Exception e) {
			throw new TipusException("Introdueix un número!");
		}
		
		if (choice < choices.length) {
			platsDemanats.add(choices[choice]);
			System.out.println(choices[choice] + " afegit a la llista!");
		}
		else {
			throw new PlatException("Plat fora de la llista!");
		}
		return platsDemanats;
	}
	
	public static void showMenu(HashMap<String, Integer> menu) {
		int count = 0;
		for(Map.Entry<String, Integer> plat : menu.entrySet()) {
			System.out.println("[" + count + "]" + plat.getKey() + " " + plat.getValue() + "€");
			count++;
		}
	}
	
	public static boolean finishComanda() throws ComandaException {
		int check;
		System.out.println("Vols acabar de demanar? 1:Si / 0:No");
		try {
			check = scanner.nextInt();
			if (check == 1) {
				return true;
			}
			if (check == 0) {
				return false;
			}
			else {
				throw new TipusException("Introdueix un número!");
			}
		}
		catch(Exception e) {
			throw new ComandaException("Opció no vàlida!");
		}				
	}
}
