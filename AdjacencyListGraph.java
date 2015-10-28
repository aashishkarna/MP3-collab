package ca.ubc.ece.cpen221.mp3.graph;
import java.util.*;


import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
/**
 * The AdjacencyListGraph implements the Graph interface. This implementation
 * of a graph stores the Vertices of the graph. Each Vertex points to a collection
 * of neighboring Vertices. 
 * @author Aashish
 *
 */
public class AdjacencyListGraph implements Graph {

	//Declaring the objects to be used in this class
	private final SortedMap<Integer, ArrayList<Vertex> > vertexDownstreamMap; 
	private final SortedMap<Integer, ArrayList<Vertex> > vertexUpstreamMap;
	private final LinkedList<Vertex> allVertices = new LinkedList<>();
	private final LinkedList<Vertex> upstreamVertices = new LinkedList<>();
	private final LinkedList<Vertex> downstreamVertices = new LinkedList<>();
	
	
	/**
	 * This method creates an empty instance of an AdjacencyListGraph
	 */
	public AdjacencyListGraph(){
		this.vertexDownstreamMap= new TreeMap<Integer, ArrayList<Vertex> >();
		this.vertexUpstreamMap= new TreeMap<Integer, ArrayList<Vertex> >();
	}
	/**
	 * Adds a Vertex to the AdjacencyListGraph
	 * 
	 * @param Vertex v: the Vertex to be added
	 * 
	 * @modifies: the list of already existing vertices in the graph
	 * 
	 * @requires: v does not exist in the graph
	 */
	public void addVertex(Vertex v) {
		assert(!allVertices.contains(v));
		
		allVertices.add(v);
		upstreamVertices.add(v);
		downstreamVertices.add(v);
		
		vertexDownstreamMap.put(downstreamVertices.indexOf(v), new ArrayList<Vertex>() );
		vertexUpstreamMap.put(upstreamVertices.indexOf(v), new ArrayList<Vertex>() );
		
		
	}

	/**
	 * Adds an edge from one Vertex to another
	 * 
	 * @param Vertex v1: the Vertex from which the edge originates
	 * @param Vertex v2: the Vertex to which the edge points to
	 * 
	 * @modifies: adds an edge between v1 and v2 such that v2 is
	 * 			  a downstream neighbor of v1 and v1 is an upstream
	 * 			  neighbor of v2.
	 * 
	 * @requires: v1 and v2 are existing vertices in the graph.
	 */
	@Override
	public void addEdge(Vertex v1, Vertex v2) {
		assert(allVertices.contains(v1)&&allVertices.contains(v2));
		
		vertexDownstreamMap.get(downstreamVertices.indexOf(v1)).add(v2);
		vertexUpstreamMap.get(upstreamVertices.indexOf(v2)).add(v1);
		
		
	}

	/**
	 * Checks if there exists an edge from one Vertex to another
	 * 
	 * @param Vertex v1: the Vertex from which the edge originates
	 * @param Vertex v2: the Vertex to which the edge points to
	 * 
	 * @return: true if there exists an edge from v1 to v2
	 * 
	 * @requires: v1 and v2 are existing vertices in the graph
	 */
	@Override
	public boolean edgeExists(Vertex v1, Vertex v2) {
		assert(allVertices.contains(v1)&&allVertices.contains(v2));
		
		if(vertexDownstreamMap.get(downstreamVertices.indexOf(v1)).contains(v2)&&
				vertexUpstreamMap.get(upstreamVertices.indexOf(v2)).contains(v1)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Returns a list of all the downstream neighboring Vertices of the 
	 * given Vertex
	 * 
	 * @param Vertex v: the Vertex whose downstream neighbors are to be
	 * 					returned
	 * 
	 * @return: a list of all downstream neighboring vertices of v
	 * 
	 * @requires: v is an existing Vertex in the graph
	 */
	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v) {
		assert(allVertices.contains(v));
		
		List<Vertex> downstream = new LinkedList<>();
		downstream.addAll(vertexDownstreamMap.get(downstreamVertices.indexOf(v)));
		
		if(!downstream.isEmpty()){	
			return Collections.unmodifiableList(downstream) ;
		}else{
			return new LinkedList<Vertex>();
		}
	}

	/**
	 * Returns a list of all the downstream neighboring Vertices of the 
	 * given Vertex
	 * 
	 * @param Vertex v: the Vertex whose downstream neighbors are to be
	 * 					returned
	 * 
	 * @return: a list of all downstream neighboring vertices of v
	 * 
	 * @requires: v is an existing Vertex in the graph
	 */
	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v) {

		assert(allVertices.contains(v));
		
		List<Vertex> upstream = new LinkedList<>();
		upstream.addAll(vertexUpstreamMap.get(upstreamVertices.indexOf(v)));
		
		if(!upstream.isEmpty()){	
			return Collections.unmodifiableList(upstream) ;
		}else{
			return new LinkedList<Vertex>();
		}
	}

	/**
	 * Returns a list of all the existing Vertices in the graph
	 * 
	 * @return: a list of all existing vertices in the graph
	 * 
	 */
	@Override
	public List<Vertex> getVertices() {
		List<Vertex> vertices = new LinkedList<Vertex>();
		vertices.addAll(allVertices);
		
		if(!vertices.isEmpty()){
			return Collections.unmodifiableList(vertices);
		}else{
			return new LinkedList<Vertex>();
		}
	}
}
