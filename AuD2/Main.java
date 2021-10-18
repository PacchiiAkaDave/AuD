import java.util.Random;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinPQ mPQ = new MinPQ(1000);
		Random rand = new Random();
		for(int i = 0; i < mPQ.getMaxsize(); i++) {
			
				mPQ.insert(Integer.toString(i+1),(double) rand.nextInt(10000));
			
		}
		
		
		
		System.out.println("ist die Heap-Bedingung erfüllt?" + mPQ.pruefeHeap());
		

		
//		int x = 0;
		
//		while(x < mPQ.getCurrentsize()) {
//			System.out.println(mPQ.getArray()[x].getPrio());
//			x = x*2+2;
//		}
		
//		for(int i = 0; i < 800; i++) {
//			System.out.println(mPQ.extractElement());
//		}
		for(int i = 0; i < mPQ.getCurrentsize();i++) {
			if(i%2==0) {
				mPQ.update(Integer.toString(i+1),(double) rand.nextInt((int) mPQ.getArray()[i].getPrio()));
			}
		}
		
		
		System.out.println("ist die Heap-Bedingung erfüllt?" + mPQ.pruefeHeap());
		
//		
//		x = 0;
//		
//		while(x < mPQ.getCurrentsize()) {
//			System.out.println(mPQ.getArray()[x].getPrio());
//			x = x*2+2;
//		}
	}

}
