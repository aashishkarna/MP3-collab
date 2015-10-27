package ca.ubc.ece.cpen221.mp3.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraphTest {


	    @Test
	    public void addVertexGetVerticesTest() {
	        Vertex v1 = new Vertex("v1");
	        Vertex v2 = new Vertex("v2");
	        Vertex v3 = new Vertex("v3");
	        AdjacencyListGraph matrix = new AdjacencyListGraph();
	        matrix.addVertex(v1);
	        matrix.addVertex(v2);
	        matrix.addVertex(v3);
	        List<Vertex> vertices = new ArrayList<Vertex>();
	        vertices.add(v1);
	        vertices.add(v2);
	        vertices.add(v3);
	        assertEquals(vertices, matrix.getVertices());
	    }
	    
	    @Test
	    public void addEdgeEdgeExistsTest() {
	        Vertex v1 = new Vertex("v1");
	        Vertex v2 = new Vertex("v2");
	        Vertex v3 = new Vertex("v3");
	        AdjacencyListGraph matrix = new AdjacencyListGraph();
	        matrix.addVertex(v1);
	        matrix.addVertex(v2);
	        matrix.addVertex(v3);
	        matrix.addEdge(v1, v2);
	        matrix.addEdge(v3, v2);
	        assertEquals(true, matrix.edgeExists(v1, v2));
	        assertEquals(false, matrix.edgeExists(v2, v1));
	        assertEquals(true, matrix.edgeExists(v3, v2));    
	    }
	    
	    @Test
	    public void getDownStreamNeighboursTest() {
	        Vertex v1 = new Vertex("v1");
	        Vertex v2 = new Vertex("v2");
	        Vertex v3 = new Vertex("v3");
	        Vertex v4 = new Vertex("v4");
	        AdjacencyListGraph matrix = new AdjacencyListGraph();
	        matrix.addVertex(v1);
	        matrix.addVertex(v2);
	        matrix.addVertex(v3);
	        matrix.addVertex(v4);
	        matrix.addEdge(v1, v1);
	        matrix.addEdge(v1, v2);
	        matrix.addEdge(v1, v3);
	        matrix.addEdge(v1, v4);
	        matrix.addEdge(v2, v3);
	        matrix.addEdge(v2, v4);
	        List<Vertex> vertices = new ArrayList<Vertex>();
	        vertices.add(v1);
	        vertices.add(v2);
	        vertices.add(v3);
	        vertices.add(v4);
	        assertEquals(vertices, matrix.getDownstreamNeighbors(v1));
	        List<Vertex> vertices2 = new ArrayList<Vertex>();
	        vertices2.add(v3);
	        vertices2.add(v4);
	        assertEquals(vertices2, matrix.getDownstreamNeighbors(v2));
	    }
	    
	    @Test
	    public void getUpStreamNeighboursTest() {
	        Vertex v1 = new Vertex("v1");
	        Vertex v2 = new Vertex("v2");
	        Vertex v3 = new Vertex("v3");
	        Vertex v4 = new Vertex("v4");
	        AdjacencyListGraph matrix = new AdjacencyListGraph();
	        matrix.addVertex(v1);
	        matrix.addVertex(v2);
	        matrix.addVertex(v3);
	        matrix.addVertex(v4);
	        matrix.addEdge(v2, v1);
	        matrix.addEdge(v3, v1);
	        matrix.addEdge(v4, v1);
	        matrix.addEdge(v3, v3);
	        matrix.addEdge(v3, v4);
	        List<Vertex> vertices = new ArrayList<Vertex>();
	        vertices.add(v2);
	        vertices.add(v3);
	        vertices.add(v4);
	        assertEquals(vertices, matrix.getUpstreamNeighbors(v1));
	        List<Vertex> vertices2 = new ArrayList<Vertex>();
	        vertices2.add(v3);
	        assertEquals(vertices2, matrix.getUpstreamNeighbors(v3));
	        List<Vertex> vertices3 = new ArrayList<Vertex>();
	        vertices3.add(v4);
	        assertEquals(false, vertices3 == matrix.getUpstreamNeighbors(v3));
	    }
	

}
