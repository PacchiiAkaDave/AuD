
public class PQElement {
	
	private String data;
	private double priority;
	 
	 public PQElement(String s, double d) { 
		 this.setData(s);
		 this.setPrio(d);
	 }
	 
	 public String getData() { 
		 return data;
	}
	 
	 public double getPrio() { 
		 return priority;
	 }
	 
	 public void setData(String s) {
		 this.data = s;
	 }
	 
	 public void setPrio(double d) { 
		 this.priority = d;
	 }
}
