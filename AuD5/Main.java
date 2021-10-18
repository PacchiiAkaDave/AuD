import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		
		File karte = new File("OS_Map.txt");
		FileReader fr = new FileReader(karte);
		String s = null;
		char[] temp = new char[(int) karte.length()];
		fr.read(temp);
		s = new String(temp);
		fr.close();
		
		
		DirectedGraph graph = DirectedGraph.readGraph(s);
		
		System.out.println(graph.BFS("Neuenkirchen", "Borgholzhausen", 5));
		
		graph.printPath("Borgholzhausen");
		
		System.out.println(graph.BFS("Neuenkirchen", "Borgholzhausen", 6));
		
		graph.printPath("Borgholzhausen");
		
		
		System.out.println(graph.BFS("Ibbenbueren", "Borgholzhausen", 4));
		
		
		graph.printPath("Borgholzhausen");
		
		
		System.out.println(graph.BFS("Glandorf", "GMH", 5));
		
		graph.printPath("GMH");
		
		System.out.println(graph.BFS("Ladbergen","Highway to Hell",400));
		
		graph.printPath("Highway to Hell");
	}

}
