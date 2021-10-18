import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class DirectedGraph {
	public static final double INFINITY = Double.MAX_VALUE;
	private Map<String,Node> nodes = new HashMap<String,Node>();
	
	public static DirectedGraph readGraph(String file) {
		DirectedGraph Graph = new DirectedGraph();
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			String s = sc.next();
			String pre = sc.next();
			double dist = Double.valueOf(sc.next());
			if(!Graph.nodes.containsKey(s)) {
				Graph.nodes.put(s, new Node(s));
			}
			if(!Graph.nodes.containsKey(pre)) {
				Graph.nodes.put(pre, new Node(pre));
			}
			Graph.nodes.get(s).neighbors.add(new Edge(Graph.nodes.get(pre),dist));	
		}
		sc.close();
		return Graph;
	}
	
	public boolean BFS(String start, String dest, int max) {
		for(Node u : nodes.values()) {
			u.prev = null;
			u.visited = false;
		}
		nodes.get(start).prev = null;
		nodes.get(start).visited = true;
		nodes.get(start).dist = INFINITY;
		Queue<Node> q = new LinkedList<>();
		q.add(nodes.get(start));
		int currentDepth = 0;
		int elementsToDepthIncrease = 1;
		int nextElementToDepthIncrease = 0;
		while(!q.isEmpty()) {
			Node u = q.poll();
			if(u == nodes.get(dest)) {
				return true;
			}
			for(int i = 0; i < u.neighbors.size(); i++) {
				if(u.neighbors.get(i).dest.visited == false) {
					nextElementToDepthIncrease++;
				}
			}
			if(--elementsToDepthIncrease == 0) {
				if(++currentDepth > max) {
					return false;
				}
				elementsToDepthIncrease = nextElementToDepthIncrease;
				nextElementToDepthIncrease = 0;
			}
			for(Edge v : u.neighbors) {
				if(v.dest.visited == false && currentDepth != max) {
					v.dest.visited = true;
					v.dest.prev = u;
					v.dest.dist = v.weight;
					q.add(v.dest);
				}
			}
		}
		return false;
	}
	


	public void printPath(String dest) {
		if(!nodes.containsKey(dest) || nodes.get(dest).prev == null) {
			System.out.println("Ort nicht auffindbar");
			return;
		}
		double total_dist = 0;
		Node x = nodes.get(dest);
		System.out.print(x.name);
		while(x.prev != null) {
			System.out.print("<--" + x.dist + "---");
			total_dist += x.dist;
			x = x.prev;
			System.out.print(x.name);
		}
		
		System.out.println(" Gesamtdistanz: " + total_dist);
		
	}
}
