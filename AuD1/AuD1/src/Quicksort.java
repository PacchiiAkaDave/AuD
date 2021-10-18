
public class Quicksort {

	//Quelle für Code: https://www.pohlig.de/Unterricht/Inf2002/Tag49/31.2.2_QuickSort_die_Implementierung.htm
	
	
	//greift auf die private rekursive Methode quickSort zu
	public static void quickSort(int[] liste){
		//obere und untere Grenze des Codes wird deklariert
		  int untereGrenze = 0;

		  int obereGrenze = liste.length-1;

		  quickSort(liste, untereGrenze,obereGrenze);
	}
	
	//rekursive Methode
	private static void quickSort(int[] liste, int untereGrenze, int obereGrenze) {
		//untere Grenze für linke Seite initialisiert
		int links = untereGrenze;
		
		//obere Grenze für rechte Seite initialisiert
		int rechts = obereGrenze;
		
		//als Pivot Element wird der Mittelpunkt des Arrays benutzt
		int pivot = liste[((untereGrenze + obereGrenze) / 2)];
		
		
		//Partition
		//do-while geht mindestens einmal in die Schleife rein
		do {
			//Wenn das Element der linken Arrayseite kleiner ist
			//als das Pivotelement, kann das Element an der Stelle verbleiben.
			//Der "Pointer" verschiebt sich auf das nächste Element nach rechts.
			while (liste[links] < pivot) {

				links++;

			}
			
			//Wenn das Element der rechten Arrayseite größer ist
			//als das Pivotelement, kann das Element an der Stelle verbleiben.
			//Der "Pointer" verschiebt sich auf das nächste Element nach links.
			while (pivot < liste[rechts]) {

				rechts--;

			}

			//Hier ist das Element auf der linken Seite größer als das auf der rechten.
			//Die Elemente werden hier getauscht und die "Pointer" verschieben sich
			if (links <= rechts) {

				int tmp = liste[links];

				liste[links] = liste[rechts];

				liste[rechts] = tmp;

				links++;

				rechts--;

			}

		} while (links <= rechts);

		//wenn "rechts" größer als "untereGrenze" ist, wird die Methode nochmal neu aufgerufen
		//mit anderen gewählten Parametern. Hier wird also die linke Hälfte des Arrays behandelt und 
		//dessen Mittelpunkt als PivotElement deklariert.
		//Der Sortiervorgang geschieht also wie oben dargestellt und erläutert.
		if (untereGrenze < rechts) {

			quickSort(liste, untereGrenze, rechts);

		}

		
		//wenn "links" kleiner als "obereGrenze" ist, wird die Methode nochmal neu aufgerufen
		//mit anderen gewählten Parametern. Hier wird also die rechte Hälfte des Arrays behandelt und 
		//dessen Mittelpunkt als PivotElement deklariert.
		//Der Sortiervorgang geschieht also wie oben dargestellt und erläutert.
		if (links < obereGrenze) {

			quickSort(liste, links, obereGrenze);

		}
		
		//Die Methode wird also nach Fertigstellung des Sortiervorgangs beendet
		


	}
	
}