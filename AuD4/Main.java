import java.util.Random;

public class Main {
	
	public static void swap(int[] Ar,int a, int b) {
		int tmp = Ar[a];
		Ar[a] = Ar[b];
		Ar[b] = tmp;
	}
	
	public static int[] randPerm() {
		int array[] = new int[10000];
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		Random rand = new Random();
		for(int i = array.length-1 ; i > 0; i--) {
			int z = rand.nextInt(i);
			swap(array,z,i);
		}
		return array;
	}

	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		int[] array = randPerm();
		
		for(int i = 0; i < array.length ; i++) {
			tree.insert(array[i], Integer.toString(i+1));
		}
		System.out.println(tree.height());
		System.out.println(tree.CheckRB());
		
//		tree.manipulate1();
//		System.out.println(tree.CheckRB());
//		tree.manipulate2();
//		System.out.println(tree.CheckRB());
		tree.manipulate3();
		System.out.println(tree.CheckRB());
//		tree.manipulate4();
//		System.out.println(tree.CheckRB());
	}	

}
