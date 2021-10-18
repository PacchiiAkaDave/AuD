

public class AdvancedQuicksort {
	
	
	//greift auf die private rekursive Methode quickSort zu
		public static void quickSort(int[] liste){
			//obere und untere Grenze des Codes wird deklariert
			  int untereGrenze = 0;

			  int obereGrenze = liste.length-1;

			  quickSort(liste, untereGrenze,obereGrenze);
		}
		
		//rekursive Methode
		private static void quickSort(int[] liste, int untereGrenze, int obereGrenze) {
			
			//Median von 3
			//Hier wird das erste Element, das mittlere und das letzte verglichen
			//das mittelgr��te davon soll in der Mitte sein
			if(liste[obereGrenze] < liste[untereGrenze]) {
				int tmp = liste[obereGrenze];

				liste[obereGrenze] = liste[untereGrenze];

				liste[untereGrenze] = tmp;
			}
			
			if(liste[((untereGrenze + obereGrenze)/2)] < liste[untereGrenze]) {
				int tmp = liste[((untereGrenze + obereGrenze)/2)];

				liste[((untereGrenze + obereGrenze)/2)] = liste[untereGrenze];

				liste[untereGrenze] = tmp;
			}
			
			if(liste[obereGrenze] < liste[((untereGrenze + obereGrenze)/2)]) {
				int tmp = liste[obereGrenze];

				liste[obereGrenze] = liste[((untereGrenze + obereGrenze)/2)];

				liste[((untereGrenze + obereGrenze)/2)] = tmp;
			}
		
			//untere Grenze f�r linke Seite initialisiert
			int links = untereGrenze;
			
			//obere Grenze f�r rechte Seite initialisiert
			int rechts = obereGrenze;
			
			//als Pivot Element wird der Mittelpunkt des Arrays benutzt
			int pivot = liste[((untereGrenze + obereGrenze) / 2)];
			
			
			
			//Partition
			//do-while geht mindestens einmal in die Schleife rein
			do {
				//Wenn das Element der linken Arrayseite kleiner ist
				//als das Pivotelement, kann das Element an der Stelle verbleiben.
				//Der "Pointer" verschiebt sich auf das n�chste Element nach rechts.
				while (liste[links] < pivot) {

					links++;

				}
				
				//Wenn das Element der rechten Arrayseite gr��er ist
				//als das Pivotelement, kann das Element an der Stelle verbleiben.
				//Der "Pointer" verschiebt sich auf das n�chste Element nach links.
				while (pivot < liste[rechts]) {

					rechts--;

				}

				//Hier ist das Element auf der linken Seite gr��er als das auf der rechten.
				//Die Elemente werden hier getauscht und die "Pointer" verschieben sich
				if (links <= rechts) {

					int tmp = liste[links];

					liste[links] = liste[rechts];

					liste[rechts] = tmp;

					links++;

					rechts--;

				}

			} while (links <= rechts);

			//wenn "rechts" gr��er als "untereGrenze" ist, wird die Methode nochmal neu aufgerufen
			//mit anderen gew�hlten Parametern. Hier wird also die linke H�lfte des Arrays behandelt und 
			//dessen Mittelpunkt als PivotElement deklariert.
			//Der Sortiervorgang geschieht also wie oben dargestellt und erl�utert.
			if (untereGrenze < rechts) {

				quickSort(liste, untereGrenze, rechts);

			}

			
			//wenn "links" kleiner als "obereGrenze" ist, wird die Methode nochmal neu aufgerufen
			//mit anderen gew�hlten Parametern. Hier wird also die rechte H�lfte des Arrays behandelt und 
			//dessen Mittelpunkt als PivotElement deklariert.
			//Der Sortiervorgang geschieht also wie oben dargestellt und erl�utert.
			if (links < obereGrenze) {

				quickSort(liste, links, obereGrenze);

			}
			
			//Die Methode wird also nach Fertigstellung des Sortiervorgangs beendet
}
		
}
