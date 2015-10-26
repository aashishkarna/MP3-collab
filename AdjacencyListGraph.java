package ca.ubc.ece.cpen221.mp3.graph;
import java.util.*;


import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {

	private final HashMap<Vertex, HashSet<Vertex> > vertexDownstreamList; 
	private final HashMap<Vertex, HashSet<Vertex> > vertexUpstreamList;
	private final LinkedList<Vertex> allVertices = new LinkedList<>();
	
	
	
	public AdjacencyListGraph(){
		this.vertexDownstreamList= new HashMap<Vertex, HashSet<Vertex> >();
		this.vertexUpstreamList= new HashMap<Vertex, HashSet<Vertex> >();
	}
	
	public void addVertex(Vertex v) {
		vertexDownstreamList.put(v, new HashSet<Vertex>() );
		vertexUpstreamList.put(v, new HashSet<Vertex>() );
		allVertices.add(v);
		
	}

	@Override
	public void addEdge(Vertex v1, Vertex v2) {
		assert(vertexDownstreamList.containsKey(v1)&&vertexUpstreamList.containsKey(v1)&&
				vertexDownstreamList.containsKey(v2)&&vertexUpstreamList.containsKey(v2));
		
		vertexDownstreamList.get(v1).add(v2);
		vertexUpstreamList.get(v2).add(v1);
		
		
	}

	@Override
	public boolean edgeExists(Vertex v1, Vertex v2) {
		assert(vertexDownstreamList.containsKey(v1)&&vertexUpstreamList.containsKey(v1)&&
				vertexDownstreamList.containsKey(v2)&&vertexUpstreamList.containsKey(v2));
		
		if(vertexDownstreamList.get(v1).contains(v2)&&vertexUpstreamList.get(v2).contains(v1)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v) {
		assert (vertexDownstreamList.containsKey(v) && vertexUpstreamList.containsKey(v));
		
		List<Vertex> downstream = new LinkedList<>();
		downstream.addAll(vertexDownstreamList.get(v));
		
		if(!vertexDownstreamList.get(v).isEmpty()){	
			return Collections.unmodifiableList(downstream) ;
		}else{
			return new LinkedList<Vertex>();
		}
	}

	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v) {

		assert (vertexDownstreamList.containsKey(v) && vertexUpstreamList.containsKey(v));
		
		List<Vertex> upstream = new LinkedList<>();
		upstream.addAll(vertexUpstreamList.get(v));
		
		if(!vertexUpstreamList.get(v).isEmpty()){	
			return Collections.unmodifiableList(upstream) ;
		}else{
			return new LinkedList<Vertex>();
		}
	}

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
