package ca.ubc.ece.cpen221.mp3.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AlgorithmsTest {

	@Test
	public void test() {
		
	       Graph g = new AdjacencyListGraph();
	        Vertex v1 = new Vertex("v1");
	        Vertex v2 = new Vertex("v2");
	        Vertex v3 = new Vertex("v3");
	        Vertex v4 = new Vertex("v4");
	        Vertex v5 = new Vertex("v5");
	        g.addVertex(v1);
	        g.addVertex(v2);
	        g.addVertex(v3);
	        g.addVertex(v4);
	        g.addVertex(v5);
	        g.addEdge(v1, v2);
	        g.addEdge(v1, v3);
	        g.addEdge(v1, v4);
	        g.addEdge(v4, v5);
	        g.addEdge(v2, v5);
	        Set<List<Vertex>> answer = new HashSet<>();
	        List<Vertex> vertices = new LinkedList<Vertex>();
	        vertices.add(v1);
	        vertices.add(v4);
//	        vertices.add(v3);
//	        vertices.add(v2);
	        vertices.add(v5);
	        answer.add(vertices);
//	        System.out.println(g.getDownstreamNeighbors(v1));
//	        System.out.println(g.getVertices());
	        assertEquals(answer, Algorithms.depthFirstSearch(g,v1,v5));
	    }

	@Test
	public void newTest(){
		 Graph g = new AdjacencyListGraph();
	        Vertex v1 = new Vertex("v1");
	        Vertex v2 = new Vertex("v2");
	        Vertex v3 = new Vertex("v3");
	        Vertex v4 = new Vertex("v4");
	        Vertex v5 = new Vertex("v5");
	        Vertex v6 = new Vertex("v6");
	        Vertex v7 = new Vertex("v7");
	        g.addVertex(v1);
	        g.addVertex(v2);
	        g.addVertex(v3);
	        g.addVertex(v4);
	        g.addVertex(v5);
	        g.addVertex(v6);
	        g.addVertex(v7);
	        
	        g.addEdge(v1, v2);
	        g.addEdge(v1, v3);
	        g.addEdge(v1, v4);
	        g.addEdge(v4, v5);
	        g.addEdge(v2, v7);
	        g.addEdge(v1, v5);
	        g.addEdge(v4, v7);
	        
	        Set<List<Vertex>> answer = new HashSet<>();
	        List<Vertex> vertices1 = new LinkedList<Vertex>();
	        vertices1.add(v1);
//	        List<Vertex> vertices2 = new LinkedList<Vertex>();
	        vertices1.add(v2);
	        vertices1.add(v3);
	        vertices1.add(v4);
	        vertices1.add(v5);
	        vertices1.add(v7);
	        List<Vertex> vertices3 = new LinkedList<Vertex>();
	        vertices3.add(v1);
	        vertices3.add(v4);
	        vertices3.add(v7);
	        answer.add(vertices1);
//	        answer.add(vertices2);
//	        answer.add(vertices3);
	        System.out.println(g.getDownstreamNeighbors(v1));
	        List<Vertex> common = new ArrayList<>();
	        common.add(v7);
	       
	        
	        assertEquals(answer, Algorithms.breadthFirstSearch(g,v1,v7));
	        assertEquals(2,Algorithms.shortestDistance(g, v1, v5));
	        assertEquals(common, Algorithms.commonDownstreamVertices(g, v2, v4));
	}
	
	@Test
	public void BFStest(){
		Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        Vertex v8 = new Vertex("v8");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
      
        
        
        g.addEdge(v1, v2);
//        g.addEdge(v1, v3);
        g.addEdge(v1, v4);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
      
        
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices1 = new LinkedList<Vertex>();
        vertices1.add(v4);
        List<Vertex> vertices2 = new LinkedList<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v4);
        vertices2.add(v3);
//        vertices2.add(v4);
        List<Vertex> vertices3 = new LinkedList<Vertex>();
        vertices3.add(v2);
        vertices3.add(v3);
        vertices3.add(v4);
        List<Vertex> vertices4 = new LinkedList<Vertex>();
        vertices4.add(v3);
        vertices4.add(v4);
        answer.add(vertices1);
        answer.add(vertices2);
        answer.add(vertices3);
        answer.add(vertices4);
        System.out.println(g.getVertices());
        
        assertEquals(answer, Algorithms.BFS(g));
	}
	
	@Test
	public void DFStest(){
		Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        Vertex v8 = new Vertex("v8");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
      
        
        
        g.addEdge(v1, v2);
//        g.addEdge(v1, v3);
        g.addEdge(v1, v4);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v5);
      
        
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices1 = new LinkedList<Vertex>();
        vertices1.add(v4);
        vertices1.add(v5);
        List<Vertex> vertices2 = new LinkedList<Vertex>();
        vertices2.add(v1);
        vertices2.add(v4);
        vertices2.add(v5);
        vertices2.add(v2);
        vertices2.add(v3);
//        vertices2.add(v4);
//        vertices2.add(v5);
        List<Vertex> vertices3 = new LinkedList<Vertex>();
        vertices3.add(v2);
        vertices3.add(v3);
        vertices3.add(v4);
        vertices3.add(v5);
        List<Vertex> vertices4 = new LinkedList<Vertex>();
        vertices4.add(v3);
        vertices4.add(v4);
        vertices4.add(v5);
        List<Vertex> vertices5 = new LinkedList<Vertex>();
        vertices5.add(v5);
        answer.add(vertices1);
        answer.add(vertices2);
        answer.add(vertices3);
        answer.add(vertices4);
        answer.add(vertices5);
        System.out.println(g.getVertices());
        
        assertEquals(answer, Algorithms.DFS(g));
	}
}
