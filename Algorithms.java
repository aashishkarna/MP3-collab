package ca.ubc.ece.cpen221.mp3.graph;

import java.util.*;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {

	int distance = 0;
	/**
	 * *********************** Algorithms ****************************
	 * 
	 * Please see the README for the machine problem for a more detailed
	 * specification of the behavior of each method that one should implement.
	 */

	/**
	 * This is provided as an example to indicate that this method and other
	 * methods should be implemented here.
	 * 
	 * You should write the specs for this and all other methods.
	 * 
	 * @param graph
	 * @param a
	 * @param b
	 * @return
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {

		int minDistance1 = Integer.MAX_VALUE;
		int minDistance2 = Integer.MAX_VALUE;
		 Set<List<Vertex>> depthFirst = depthFirstSearch(graph,a,b);
		Set<List<Vertex>> breadthFirst = breadthFirstSearch(graph, a, b);
		for (List<Vertex> path : breadthFirst) {
			if (path.size() < minDistance1) {
				minDistance1 = path.size();
			}
		}
		for (List<Vertex> path : depthFirst) {
			if (path.size() < minDistance2) {
				minDistance2 = path.size();
			}
		}

		if(minDistance1<minDistance2){
			return minDistance1;
		}else{
			return minDistance2;
		}
	}

	public static Set<List<Vertex>> breadthFirstSearch(Graph g, Vertex a, Vertex b) {

//		List<Vertex> vertexList = new ArrayList<>();
		Set<List<Vertex>> listSet = new HashSet<>();


	//	List<Vertex> allVertices = new ArrayList<>();



			Queue<Vertex> vertexQueue = new LinkedList<Vertex>();
			List<Vertex> discoveredVertices = new ArrayList<>();
			List<Vertex> branch = new ArrayList<>();
			vertexQueue.add(a);
			while (!vertexQueue.isEmpty()) {
				Vertex w = vertexQueue.poll();
				
				if(!discoveredVertices.contains(w)) {
					discoveredVertices.add(w);
					branch.add(w);
					for (Vertex z : g.getDownstreamNeighbors(w)) {
						vertexQueue.add(z);
					}
				}
				
				
				if (w.equals(b)){
					break;
				}
			}
			listSet.add(branch);
		
		
/*		for (Vertex temp : l) {
			if (!discoveredVertices.contains(temp)) {
				discoveredVertices.add(temp);
			}
			if (temp.equals(b)) {
				vertexList.add(a);
				vertexList.add(b);

				listSet.add(vertexList);
			} else {
				allDownstream = g.getDownstreamNeighbors(temp);
				Set<List<Vertex>> search1 = new HashSet<>();
				search1 = breadthFirstSearch(g, temp, b, allDownstream);

				for (List<Vertex> newPath : search1) {
					newPath.add(0, a);
					listSet.add(newPath);
				}

			}

			// listSet.add(discoveredVertices);
			// discoveredVertices.clear();
		}*/

		return listSet;

	}

	public static Set<List<Vertex>> depthFirstSearch(Graph g, Vertex a, Vertex b) {

//		List<Vertex> downStreamVertices = new ArrayList<>();
		List<Vertex> discoveredVertices = new ArrayList<>();
		Set<List<Vertex>> listSet = new HashSet<>();
		Stack<Vertex> vertexStack = new Stack<>();
		
//		downStreamVertices = g.getDownstreamNeighbors(a);

		List<Vertex> branch = new ArrayList<>();
		vertexStack.push(a);
		while (!vertexStack.empty()) {
			Vertex w = vertexStack.pop();
			
			
			if (!discoveredVertices.contains(w)) {
				discoveredVertices.add(w);
				branch.add(w);
				for (Vertex z : g.getDownstreamNeighbors(w)) {
					vertexStack.add(z);
				}
			}
			if(w.equals(b)){
				break;
			}
		}
		listSet.add(branch);

		return listSet;

	}

	public static List<Vertex> commonUpstreamVertices(Graph g, Vertex a, Vertex b) {

		List<Vertex> upstreamA = g.getUpstreamNeighbors(a);
		List<Vertex> upstreamB = g.getUpstreamNeighbors(b);
		List<Vertex> commonVertices = new ArrayList<>();

		for (Vertex u : upstreamA) {
			if (upstreamB.contains(u)) {
				commonVertices.add(u);
			}
		}
		return commonVertices;
	}

	public static List<Vertex> commonDownstreamVertices(Graph g, Vertex a, Vertex b) {

		List<Vertex> downstreamA = g.getDownstreamNeighbors(a);
		List<Vertex> downstreamB = g.getDownstreamNeighbors(b);
		List<Vertex> commonVertices = new ArrayList<>();

		for (Vertex u : downstreamA) {
			if (downstreamB.contains(u)) {
				commonVertices.add(u);
			}
		}
		return commonVertices;
	}

	public static Set<List<Vertex>> DFS(Graph g) {

		Set<List<Vertex>> listSet = new HashSet<>();
		Stack<Vertex> vertexStack = new Stack<>();
		List<Vertex> allVertices = new ArrayList<>();

		allVertices = g.getVertices();
		for (Vertex v : allVertices) {
			List<Vertex> discoveredVertices = new ArrayList<>();
			List<Vertex> branch = new ArrayList<>();
			vertexStack.push(v);
			while (!vertexStack.empty()) {
				Vertex w = vertexStack.pop();
				
				if (!discoveredVertices.contains(w)) {
					discoveredVertices.add(w);
					branch.add(w);
					for (Vertex z : g.getDownstreamNeighbors(w)) {
						vertexStack.add(z);
					}
				}
				
			}
			listSet.add(branch);
		}

		return listSet;
	}

	public static Set<List<Vertex>> BFS(Graph g) {

		Set<List<Vertex>> listSet = new HashSet<>();
		List<Vertex> allVertices = new ArrayList<>();

		allVertices = g.getVertices();
		for (Vertex v : allVertices) {
			Queue<Vertex> vertexQueue = new LinkedList<Vertex>();
			List<Vertex> discoveredVertices = new ArrayList<>();
			List<Vertex> branch = new ArrayList<>();
			vertexQueue.add(v);
			while (!vertexQueue.isEmpty()) {
				Vertex w = vertexQueue.poll();
				
				if(!discoveredVertices.contains(w)) {
					discoveredVertices.add(w);
					branch.add(w);
					for (Vertex z : g.getDownstreamNeighbors(w)) {
						vertexQueue.add(z);
					}
				}
				
			}
			listSet.add(branch);
		}

		return listSet;
	}
	
}
