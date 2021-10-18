
public class MinPQ {
	private PQElement array[];
	 private int maxsize;
	 private int currentsize;
	 
	// Konstruktor
	 public MinPQ(int max) {
		 array = new PQElement[max];
		 this.maxsize = max;
		 this.currentsize = 0;
	}
	 
	 public boolean isEmpty() {
		 if(this.array == null || this.currentsize == 0) {
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean insert(PQElement n) {
		 if(n.equals(null) || currentsize == maxsize) {
			 return false;
		 }
		 this.currentsize++;
		 this.array[this.currentsize-1] = n;
		 upheap(this.array,this.currentsize-1);
		 return true;
	 }
	 
	 public boolean insert(String d, double p) {
		 //neues PQElement erstellen mit d und p als Instanzvariablen
		 if(currentsize == maxsize) {
			 return false;
		 }
		 this.currentsize++;
		 this.array[this.currentsize-1] = new PQElement(d,p);
		 upheap(this.array,this.currentsize-1);
		 return true;
	 }
	 
	 public PQElement extractElement() { 
		 //geringste Prio als Rückgabe in Form von Element
		 if(this.isEmpty() == true) {
			 return null;
		 }
		 PQElement min = this.array[0];
		 this.array[0] = this.array[this.currentsize-1];
		 this.currentsize--;
		 downheap(this.array,0);
		 return min;
	 }
	 
	 public String extractData() { 
		 //geringste Prio als Rückgabe in Form von String
		 if(this.isEmpty() == true) {
			 return null;
		 }
		String min = this.array[0].getData();
		this.array[0] = this.array[this.currentsize-1];
		this.currentsize--;
		downheap(this.array,0);
		return min;
	 }
	 
	 public void update(String s,double n) {
		 int i = 0;
		 while(!this.array[i].getData().equals(s)) {
			 i++;
		 }
		 	if(this.array[i].getPrio() < n) {
		 			this.array[i].setPrio(n);
		 			downheap(this.array,i);
		 		} else {
		 			this.array[i].setPrio(n);
		 			upheap(this.array,i);
		 	}
		 		
		}
	 
	 
	 //Hilfsmethoden
	 public boolean pruefeHeap() {
		 for(int i = 1; i < this.currentsize; i++) {
			 if(this.array[i].getPrio() < this.array[this.parent(i)].getPrio()) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 private int left(int i) {
		 return 2*i+1;
	 }
	 private int right(int i) {
		 return 2*i+2;
	 }
	 private int parent(int i) {
		 if(i == 0) {
			 return 0;
		 }
		 return (i-1)/2;
	 }
	 private void downheap(PQElement[] A, int i) {
		 int l = left(i);
		 int r = right(i);
		 int smallest;
		 if(l <= this.currentsize && A[l].getPrio() < A[i].getPrio()) {
			 smallest = l;
		 } else {
			 smallest = i;
		 }
		 if(r <= this.currentsize && A[r].getPrio() < A[smallest].getPrio()) {
			 smallest = r;
		 }
		 if(smallest != i) {
			swap(A,smallest,i);
			downheap(A, smallest);
		 }
		 
	 }
	 
	 private void swap(PQElement[] A,int a,int b) {
			PQElement tmp = A[a];
			
			A[a] = A[b];

			A[b] = tmp;
		}
	 
//	 private void BuildMinHeap(PQElement[] A) {
//		 this.currentsize = A.length;
//		 for(int i = A.length/2; i > 0 ; i--) {
//			 downheap(A,i);
//		 }
//	 }
//	 
//	 private void heapsort(PQElement[] A) {
//		 BuildMinHeap(A);
//		 for(int i = A.length; i > 1; i--) {
//			 swap(A,0,i);
//			 this.currentsize = this.currentsize - 1;
//			 downheap(A,0);
//		 }
//	 }
	 
	 private void upheap(PQElement[] A, int i) {
		 while(i > 0 && A[parent(i)].getPrio() > A[i].getPrio()) {
			 swap(A,parent(i),i);
			 i = parent(i);
		 }
	 }
	 
	 public PQElement[] getArray() {
		 return array;
	 }
	 
	 public int getCurrentsize() {
		 return currentsize;
	 }
	 
	 public int getMaxsize() {
		 return maxsize;
	 }
}
