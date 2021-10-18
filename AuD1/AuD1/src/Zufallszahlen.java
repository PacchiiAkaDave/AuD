import java.util.Random;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;


//Quelle zur Datenein- und Auslesung: http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_17_001.htm
//https://www.youtube.com/watch?v=fzfit1Op0Kc

public class Zufallszahlen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter writer;
		Random rand = new Random();
		File f1 = new File("100000.txt");
		File f2 = new File("1000000.txt");
		File f3 = new File("5000000.txt");
		
		try {
			writer = new FileWriter(f1);
			for(int i = 0; i < 100000; i++) {
			writer.write(rand.nextInt(5000000) + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			writer = new FileWriter(f2);
			for(int i = 0; i < 1000000; i++) {
			writer.write(rand.nextInt(5000000) + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			writer = new FileWriter(f3);
			for(int i = 0; i < 5000000; i++) {
			writer.write(rand.nextInt(5000000) + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	
	}

}
