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
		int distance = 0;
		if (a.equals(b)) {
			return 0;
		} else {
			distance = searcherDFS(graph, a, b);
			return distance;
		}

	
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
				branch.add(w);
				if (!discoveredVertices.contains(w)) {
					discoveredVertices.add(w);

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
				branch.add(w);
				if (!discoveredVertices.contains(w)) {
					discoveredVertices.add(w);

					for (Vertex z : g.getDownstreamNeighbors(w)) {
						vertexQueue.add(z);
					}
				}

			}
			listSet.add(branch);
		}

		return listSet;
	}

	public static int searcherDFS(Graph g, Vertex a, Vertex b) {
//		Set<List<Vertex>> listSet = new HashSet<>();
//		List<Vertex> allVertices = new ArrayList<>();
		int counter = 0;

//		allVertices = g.getVertices();

		Queue<Vertex> vertexQueue = new LinkedList<Vertex>();
		Queue<Vertex> downstreamQueue = new LinkedList<Vertex>();
		List<Vertex> discoveredVertices = new ArrayList<>();

		vertexQueue.add(a);
		while (!vertexQueue.contains(b)) {
			// Vertex w = vertexQueue.poll();
			// branch.add(w);

			for (Vertex z : vertexQueue) {
				if (!discoveredVertices.contains(z)) {
					discoveredVertices.add(z);
					downstreamQueue.addAll(g.getDownstreamNeighbors(z));

				}

			}
			vertexQueue.clear();
			counter++;
			if (downstreamQueue.contains(b)) {
				break;
			}

			else {
				// Vertex x = downstreamQueue.poll();
				// branch.add(w);

				for (Vertex y : downstreamQueue) {
					if (!discoveredVertices.contains(y)) {
						discoveredVertices.add(y);
						vertexQueue.addAll(g.getDownstreamNeighbors(y));

					}
				}
				downstreamQueue.clear();
				counter++;
			}

		}
		// listSet.add(branch);

		return counter;

	}

}
