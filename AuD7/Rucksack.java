import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Rucksack {
	
	/*
	 * n = anzahlPakete = Anzahl Knallerpakete
	 * a = preis = Preis in ganzen Euro Beträgen
	 * w = knallerstaerke = Knallstaerke (Anzahl Einzelknaller * Durchmesser in mm)
	 * G = Gesamtkapazitaet (1000€)
	*/	 
	static ArrayList<Integer> krach = new ArrayList<Integer>();
	static ArrayList<Integer> kosten = new ArrayList<Integer>();
	
	
	
    public static ArrayList<Integer> rucksack(String file, int geld) throws FileNotFoundException {
    	
    	Scanner s = new Scanner(new BufferedReader(new FileReader(file)));
    	
    	try {
	    	while(s.hasNext()) {
	    		int anzahlPakete = s.nextInt();
    			int knallerstaerke = (s.nextInt() * s.nextInt());
    			int preis = (s.nextInt());
	    		for(int i = 0; i < anzahlPakete; i++) {
	    			krach.add(knallerstaerke);
	    			kosten.add(preis);
	    		}
	    	}
    	} finally {
    		if(s != null) {
    			s.close();
    		}
    	}
    	return rucksackPseudo(krach.size()-1, toIntArray(kosten), toIntArray(krach), geld);
    }
	
	static int[] toIntArray(ArrayList<Integer> zuKonvertieren) {
		int konvertiert[] = new int[zuKonvertieren.size()];
		for (int i = 0; i < zuKonvertieren.size(); i++) {
			konvertiert[i] = zuKonvertieren.get(i);
		}
		return konvertiert;
	}
    
	
	
	//Pseudocode aus der Vorlesung
	public static ArrayList<Integer> rucksackPseudo(int n, int a[], int w[], int G) {
		
		int W[][] = new int[n+1][G+1];
		ArrayList<Integer> R[][] = (ArrayList<Integer>[][]) new ArrayList[n+1][G+1];
		
		for(int k = 0; k <= G; k++) {
			W[0][k] = 0;
			R[0][k] = new ArrayList<Integer>();
		}
		
		// Line 6 und 7 by Paul Dieterich
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= G; j++) {
				if(a[i] <= j && W[i-1][j-a[i]] + w[i] > W[i-1][j]) {
					R[i][j] = (ArrayList<Integer>) R[i-1][j-a[i]].clone();
					R[i][j].add(i);
					W[i][j] = W[i-1][j-a[i]] + w[i];
				} else {
					R[i][j] = R[i-1][j];
					W[i][j] = W[i-1][j];
				}
			}
		}
		System.out.println("Gesamtkrach bei optimaler Konfiguration: " + W[n][G] + "\n");
		return R[n][G];
	}
	
	
	
	public static void ausgeben(ArrayList<Integer> einkaufsliste) {
    	System.out.println("\t\tKrach" + "\tKosten");
    	int x = 1;
    	int anz = 1;
    	for(int i = 1; i <= einkaufsliste.size()-1; i++) {
    		if(krach.get(einkaufsliste.get(i)) == krach.get(einkaufsliste.get(i-1)) || kosten.get(einkaufsliste.get(i)) == kosten.get(einkaufsliste.get(i-1))) {
    			anz++;
    		}
    		else{
    			System.out.println("Paket" + x + ":" + "\t" + "x" + anz + "\t" + krach.get(einkaufsliste.get(i-1)) + "\t" + kosten.get(einkaufsliste.get(i-1)));
    			x++;
    			anz = 1;
    		}
    		 if(i == einkaufsliste.size()-1){
     			System.out.println("Paket" + x + ":" + "\t" + "x" + anz + "\t" + krach.get(einkaufsliste.get(i-1)) + "\t" + kosten.get(einkaufsliste.get(i-1)));
     		}
    	}
	}
	
}
