package ca.ubc.ece.cpen221.mp3.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AlgorithmsTest {

    @Test
    public void DFSTest() {
        Graph test = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        test.addVertex(v1);
        test.addVertex(v2);
        test.addVertex(v3);
        test.addVertex(v4);
        test.addVertex(v5);
        test.addVertex(v6);
        test.addVertex(v7);
        test.addEdge(v1, v2);
        test.addEdge(v1, v3);
        test.addEdge(v1, v4);
        test.addEdge(v2, v5);
        test.addEdge(v2, v6);
        test.addEdge(v5, v7);
        test.addEdge(v3, v7);
        
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(v1);
        vertices.add(v4);
        vertices.add(v3);
        vertices.add(v7);
        vertices.add(v2);
        vertices.add(v6);
        vertices.add(v5);
        List<Vertex> vertices2 = new LinkedList<Vertex>();
        vertices2.add(v2);
        vertices2.add(v6);
        vertices2.add(v5);
        vertices2.add(v7);
        List<Vertex> vertices3 = new LinkedList<Vertex>();
        vertices3.add(v3);
        vertices3.add(v7);
        List<Vertex> vertices4 = new LinkedList<Vertex>();
        vertices4.add(v4);
        List<Vertex> vertices5 = new LinkedList<Vertex>();
        vertices5.add(v5);
        vertices5.add(v7);
        List<Vertex> vertices6 = new LinkedList<Vertex>();
        vertices6.add(v6);
        List<Vertex> vertices7 = new LinkedList<Vertex>();
        vertices7.add(v7);
        answer.add(vertices);
        answer.add(vertices2);
        answer.add(vertices3);
        answer.add(vertices4);
        answer.add(vertices5);
        answer.add(vertices6);
        answer.add(vertices7);
        System.out.println(test.getDownstreamNeighbors(v2));

        assertEquals(answer, Algorithms.DFS(test));
        }
    
    @Test
    public void DFSLoopTest() {
        Graph test = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        test.addVertex(v1);
        test.addVertex(v2);
        test.addVertex(v3);
        test.addVertex(v4);
        test.addVertex(v5);
        test.addVertex(v6);
        test.addVertex(v7);
        test.addEdge(v1, v2);
        test.addEdge(v1, v3);
        test.addEdge(v1, v4);
        test.addEdge(v2, v5);
        test.addEdge(v2, v6);
        test.addEdge(v5, v7);
        test.addEdge(v3, v5);
        test.addEdge(v5, v3);
        
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(v1);
        vertices.add(v4);
        vertices.add(v3);
        vertices.add(v5);
        vertices.add(v7);
        vertices.add(v2);
        vertices.add(v6);
        List<Vertex> vertices2 = new LinkedList<Vertex>();
        vertices2.add(v2);
        vertices2.add(v6);
        vertices2.add(v5);
        vertices2.add(v7);
        vertices2.add(v3);
        List<Vertex> vertices3 = new LinkedList<Vertex>();
        vertices3.add(v3);
        vertices3.add(v5);
        vertices3.add(v7);
        List<Vertex> vertices4 = new LinkedList<Vertex>();
        vertices4.add(v4);
        List<Vertex> vertices5 = new LinkedList<Vertex>();
        vertices5.add(v5);
        vertices5.add(v7);
        vertices5.add(v3);
        List<Vertex> vertices6 = new LinkedList<Vertex>();
        vertices6.add(v6);
        List<Vertex> vertices7 = new LinkedList<Vertex>();
        vertices7.add(v7);
        answer.add(vertices);
        answer.add(vertices2);
        answer.add(vertices3);
        answer.add(vertices4);
        answer.add(vertices5);
        answer.add(vertices6);
        answer.add(vertices7);
        assertEquals(answer, Algorithms.DFS(test));
    }
    
    @Test
    public void BFSTest() {
        Graph test = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        test.addVertex(v1);
        test.addVertex(v2);
        test.addVertex(v3);
        test.addVertex(v4);
        test.addVertex(v5);
        test.addVertex(v6);
        test.addVertex(v7);
        test.addEdge(v1, v2);
        test.addEdge(v1, v3);
        test.addEdge(v1, v4);
        test.addEdge(v2, v5);
        test.addEdge(v2, v6);
        test.addEdge(v5, v7);
        test.addEdge(v3, v5);
        
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);
        List<Vertex> vertices2 = new LinkedList<Vertex>();
        vertices2.add(v2);
        vertices2.add(v5);
        vertices2.add(v6);
        vertices2.add(v7);
        List<Vertex> vertices3 = new LinkedList<Vertex>();
        vertices3.add(v3);
        vertices3.add(v5);
        vertices3.add(v7);
        List<Vertex> vertices4 = new LinkedList<Vertex>();
        vertices4.add(v4);
        List<Vertex> vertices5 = new LinkedList<Vertex>();
        vertices5.add(v5);
        vertices5.add(v7);
        List<Vertex> vertices6 = new LinkedList<Vertex>();
        vertices6.add(v6);
        List<Vertex> vertices7 = new LinkedList<Vertex>();
        vertices7.add(v7);
        answer.add(vertices);
        answer.add(vertices2);
        answer.add(vertices3);
        answer.add(vertices4);
        answer.add(vertices5);
        answer.add(vertices6);
        answer.add(vertices7);
        assertEquals(answer, Algorithms.BFS(test));
    }
    
    @Test
    public void BFSLoopTest() {
        Graph test = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        test.addVertex(v1);
        test.addVertex(v2);
        test.addVertex(v3);
        test.addVertex(v4);
        test.addVertex(v5);
        test.addVertex(v6);
        test.addVertex(v7);
        test.addEdge(v1, v2);
        test.addEdge(v1, v3);
        test.addEdge(v1, v4);
        test.addEdge(v2, v6);
        test.addEdge(v2, v5);
        test.addEdge(v5, v7);
        test.addEdge(v3, v5);
        test.addEdge(v5, v3);
        
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);
        List<Vertex> vertices2 = new LinkedList<Vertex>();
        vertices2.add(v2);
        vertices2.add(v5);
        vertices2.add(v6);
        vertices2.add(v3);
        vertices2.add(v7);
        List<Vertex> vertices3 = new LinkedList<Vertex>();
        vertices3.add(v3);
        vertices3.add(v5);
        vertices3.add(v7);
        List<Vertex> vertices4 = new LinkedList<Vertex>();
        vertices4.add(v4);
        List<Vertex> vertices5 = new LinkedList<Vertex>();
        vertices5.add(v5);
        vertices5.add(v3);
        vertices5.add(v7);
        List<Vertex> vertices6 = new LinkedList<Vertex>();
        vertices6.add(v6);
        List<Vertex> vertices7 = new LinkedList<Vertex>();
        vertices7.add(v7);
        answer.add(vertices);
        answer.add(vertices2);
        answer.add(vertices3);
        answer.add(vertices4);
        answer.add(vertices5);
        answer.add(vertices6);
        answer.add(vertices7);
        assertEquals(answer, Algorithms.BFS(test));
    }
    
    @Test
    public void shortDistanceSearcherTest() {
        Graph test = new AdjacencyListGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        test.addVertex(v1);
        test.addVertex(v2);
        test.addVertex(v3);
        test.addVertex(v4);
        test.addVertex(v5);
        test.addVertex(v6);
        test.addVertex(v7);
        test.addEdge(v1, v2);
        test.addEdge(v1, v3);
        test.addEdge(v1, v4);
        test.addEdge(v2, v5);
        test.addEdge(v2, v6);
        test.addEdge(v5, v7);
        test.addEdge(v3, v5);
        
        assertEquals(3, Algorithms.shortestDistance(test, v1, v7));
    }
    
    @Test
    public void nopathTest() {
        Graph test = new AdjacencyListGraph();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        test.addVertex(v1);
        test.addVertex(v2);
        test.addVertex(v3);
        test.addVertex(v4);
        test.addVertex(v5);
        test.addVertex(v6);
        test.addVertex(v7);
        test.addEdge(v1, v2);
        test.addEdge(v1, v3);
        test.addEdge(v1, v4);
        test.addEdge(v2, v5);
        test.addEdge(v2, v6);
        test.addEdge(v3, v5);
        
        assertEquals(-1, Algorithms.shortestDistance(test, v1, v7));
    }
	
}
