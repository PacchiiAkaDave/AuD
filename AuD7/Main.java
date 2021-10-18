import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    	
    	//Scanner läuft über ein File (Pattern: int int int int \n) und übergibt es mit Kapazitaet (Geldmittel) an die eigentliche Methode
    	final String file = "C://Users//steff//Desktop//Schule//Programmieren 1//Praktikum//eclipse-workspace//Algo8//src//knaller.dat";
    	ArrayList<Integer> einkaufsliste = Rucksack.rucksack(file, 1000);
    	
    	//Die erhaltene ArrayList korrekt aufteilen und ausgeben lassen
    	Rucksack.ausgeben(einkaufsliste);
    }
}






/*
Codefriedhof: Ursprüngliche Methode um aus einer ArrayList zwei Arrays zu machen

int[] knallerboom = new int[alles.size()/2];
int[] preise = new int[alles.size()/2];
	int j = 0;
int l = 0;

for(int i = 0; i < alles.size(); i++) {
	switch(i%2) {
	case(0):
		knallerboom[j] = alles.get(i);
		j++;
		break;
	case(1):
		preise[l] = alles.get(i);
		l++;
		break;
	default:
	}
}
*/