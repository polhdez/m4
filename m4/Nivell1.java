package m4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Nivell1 {

	public static void main(String[] args) throws PlatException, TipusException, ComandaException {

		int bitllet1 = 5;
		int bitllet2 = 10;
		int bitllet3 = 20;
		int bitllet4 = 50;
		int bitllet5 = 100;
		int bitllet6 = 200;
		int bitllet7 = 500;
		int total;
		
		// Fase 2
		HashMap<String, Integer> menu = new HashMap<String,Integer>();
		menu.put("Espaguetis", bitllet1);
		menu.put("Mandonguilles", bitllet2);
		menu.put("Filet", bitllet3);
		
		String[] choices = new String[menu.size()];
		int count = 0;
		for(Map.Entry<String, Integer> plat : menu.entrySet()) {
			System.out.println("[" + count + "]" + plat.getKey() + " " + plat.getValue() + "€");
			choices[count] = plat.getKey();
			count++;
		}
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> platsDemanats = new ArrayList<String>();
		boolean running = true;
		while(running) {
			while(true) {
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
					break;
				}
				else {
					throw new PlatException("Plat fora de la llista!");
				}
			}
			
			int check;
			while(true) {
				System.out.println("Vols acabar de demanar? 1:Si / 0:No");
				try {
					check = scanner.nextInt();
					if (check == 1) {
						running = false;
						break;
					}
					if (check == 0) {
						break;
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
		scanner.close();
		
		// Fase 3
		int preuTotal = 0;
		for(String plat : platsDemanats) {
			preuTotal += menu.get(plat);
		}
		System.out.println("Preu total: " + preuTotal + "€");
	}

}
