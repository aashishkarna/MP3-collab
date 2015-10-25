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
		
		
		return 0;
	}

	private Set<List<Vertex>> depthFirstSearch (Graph g, Vertex a ){
		
		g = new AdjacencyListGraph();
		List<Vertex> discoveredVertices = new ArrayList<Vertex>();
		Stack<Vertex> vertexStack = new Stack<>();
		Set<List<Vertex>> listSet = new HashSet<>();
		
		vertexStack.push(a);
		while(!vertexStack.empty()){
			Vertex v = vertexStack.pop();
			if(!discoveredVertices.contains(v)){
				discoveredVertices.add(0,v);
				for(Vertex w : g.getDownstreamNeighbors(v)){
					vertexStack.push(w);
				}
			}
		}
		listSet.add(discoveredVertices);
		
		
		return listSet;
	}
}
