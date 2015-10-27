package ca.ubc.ece.cpen221.mp3.graph;

import java.util.*;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {

	/**
	 * *********************** Algorithms ****************************
	 * 
	 * Please see the README for the machine problem for a more detailed
	 * specification of the behavior of each method that one should implement.
	 */

	/**
	 * Calculates the shortest distance between the two given Vertices.
	 *
	 * @param graph: The graph in which the vertices exist.
	 * @param origin: the origin Vertex
	 * @param destination: the destination Vertex
	 * @return the shortest distance between the two vertices
	 */
	public static int shortestDistance(Graph graph, Vertex origin, Vertex destination) {
		int distance = 0;
		if (origin.equals(destination)) {
			return 0;
		} else {
			try{
			distance = searcherDFS(graph, origin, destination);
			return distance;
			}catch(NullPointerException e){
				throw new IllegalArgumentException();
			}
		}
	}

	/**
	 * Returns a list of the common upstream neighbors of the two given Vertices
	 * 
	 * @param graph: the graph 
	 * @param a: one of the two Vertices whose common upstream neighbors are to be
	 * 			found 
	 * @param b: second of the two Vertices whose common upstream neighbors are to 
	 * 			be found 
	 * @return a list of the common upstream neighbors of Vertices a & b
	 */
	public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {

		List<Vertex> upstreamA = graph.getUpstreamNeighbors(a);
		List<Vertex> upstreamB = graph.getUpstreamNeighbors(b);
		List<Vertex> commonVertices = new ArrayList<>();

		for (Vertex u : upstreamA) {
			if (upstreamB.contains(u)) {
				commonVertices.add(u);
			}
		}
		return commonVertices;
	}

	/**
	 *  * Returns a list of the common downstream neighbors of the two given Vertices
	 * 
	 * @param graph: the graph 
	 * @param a: one of the two Vertices whose common downstream neighbors are to be
	 * 			found 
	 * @param b: second of the two Vertices whose common downstream neighbors are to 
	 * 			be found 
	 * @return a list of the common downstream neighbors of Vertices a & b
	 */
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

	/**
	 * Performs a depth-first search of the graph. The search starts at an arbitrary  
	 * node and explores as far as possible along each branch before backtracking.
	 * 
	 * @param graph: the graph which is to be searched
	 * @return a set of the lists containing the path traversed by the search. 
	 * 			Each list uses a different node as a starting point.
	 */
	public static Set<List<Vertex>> DFS(Graph graph) {

		Set<List<Vertex>> listSet = new HashSet<>();
		Stack<Vertex> vertexStack = new Stack<>();
		List<Vertex> allVertices = new ArrayList<>();

		allVertices = graph.getVertices();
		for (Vertex v : allVertices) {
			List<Vertex> discoveredVertices = new ArrayList<>();
			List<Vertex> branch = new ArrayList<>();
			vertexStack.push(v);
			while (!vertexStack.empty()) {
				Vertex w = vertexStack.pop();
				
				if (!discoveredVertices.contains(w)) {
					discoveredVertices.add(w);
					branch.add(w);
					for (Vertex z : graph.getDownstreamNeighbors(w)) {
						vertexStack.add(z);
					}
				}
			}
			listSet.add(branch);
		}
		return listSet;
	}

	/**
	 * Performs a breadth-first search of the graph. It starts at an arbitrary
	 * node and explores the neighbor nodes first, before moving to the next .
	 * level neighbors
	 * 
	 * @param graph: the graph which is to be searched
	 * @return a set of the lists containing the path traversed by the search.
	 * 			Each list uses a different node as a starting point.
	 */
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
				
				if (!discoveredVertices.contains(w)) {
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

	/**
	 * Searches and calculates the shortest path between two given vertices.
	 * 
	 * @param graph: the graph that contains the two given vertices.
	 * @param origin: the origin Vertex
	 * @param destination: the destination Vertex
	 * @return the shortest distance between the origin and the destination
	 */
	private static int searcherDFS(Graph graph, Vertex origin, Vertex destination) {

		int counter = 0;

		Queue<Vertex> vertexQueue = new LinkedList<Vertex>();
		Queue<Vertex> downstreamQueue = new LinkedList<Vertex>();
		List<Vertex> discoveredVertices = new ArrayList<>();

		vertexQueue.add(origin);
		while (!vertexQueue.contains(destination)||(!vertexQueue.isEmpty()&&!downstreamQueue.isEmpty())) {

			for (Vertex z : vertexQueue) {
				if (!discoveredVertices.contains(z)) {
					discoveredVertices.add(z);
					downstreamQueue.addAll(graph.getDownstreamNeighbors(z));
				}
			}
			vertexQueue.clear();
			counter++;
			if (downstreamQueue.contains(destination)) {
				break;
			}else {

				for (Vertex y : downstreamQueue) {
					if (!discoveredVertices.contains(y)) {
						discoveredVertices.add(y);
						vertexQueue.addAll(graph.getDownstreamNeighbors(y));
					}
				}
				downstreamQueue.clear();
				counter++;
			}
		}

		return counter;

	}

}
