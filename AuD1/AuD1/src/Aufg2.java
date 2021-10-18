import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Aufg2 {
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int start = 0;
		int ziel = 0;
		int t1 = 0;
		int t2 = 0;
		int t3 = 0;
		
		
		File f1 = new File("100000.txt");
		File f2 = new File("1000000.txt");
		File f3 = new File("5000000.txt");
		Scanner s1 = new Scanner(f1);
		Scanner s2 = new Scanner(f2);
		Scanner s3 = new Scanner(f3);
		
		int[] a1 = new int[100000];
		int[] a2 = new int[1000000];
		int[] a3 = new int[5000000];
		
		for(int i = 0; i < a1.length; i++) {
			if(s1.hasNextLine()) {
				a1[i] = s1.nextInt();
				
			}
		}
		
		for(int i = 0; i < a2.length; i++) {
			if(s2.hasNextLine()) {
				a2[i] = s2.nextInt();
				
			}
		}
		
		for(int i = 0; i < a3.length; i++) {
			if(s3.hasNextLine()) {
				a3[i] = s3.nextInt();
				
			}
		}
		
//		start = (int) System.currentTimeMillis();
//		Quicksort.quickSort(a1);
//		ziel = (int) System.currentTimeMillis();
//		t1 = ziel - start;
//		System.out.println(t1);
//		
//		start = (int) System.currentTimeMillis();
//		Quicksort.quickSort(a2);
//		ziel = (int) System.currentTimeMillis();
//		t2 = ziel - start;
//		System.out.println(t2);
//		
//		start = (int) System.currentTimeMillis();
//		Quicksort.quickSort(a3);
//		ziel = (int) System.currentTimeMillis();
//		t3 = ziel - start;
//		System.out.println(t3);
//		
//		start = (int) System.currentTimeMillis();
//		Quicksort.quickSort(a1);
//		ziel = (int) System.currentTimeMillis();
//		t1 = ziel - start;
//		System.out.println(t1);
		
		
		start = (int) System.currentTimeMillis();
		AdvancedQuicksort.quickSort(a1);
		ziel = (int) System.currentTimeMillis();
		t1 = ziel - start;
		System.out.println(t1);
		
		start = (int) System.currentTimeMillis();
		AdvancedQuicksort.quickSort(a2);
		ziel = (int) System.currentTimeMillis();
		t2 = ziel - start;
		System.out.println(t2);
		
		start = (int) System.currentTimeMillis();
		AdvancedQuicksort.quickSort(a3);
		ziel = (int) System.currentTimeMillis();
		t3 = ziel - start;
		System.out.println(t3);
		
		start = (int) System.currentTimeMillis();
		AdvancedQuicksort.quickSort(a1);
		ziel = (int) System.currentTimeMillis();
		t1 = ziel - start;
		System.out.println(t1);
		
	}

}
