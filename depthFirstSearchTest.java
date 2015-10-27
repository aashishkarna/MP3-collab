package ca.ubc.ece.cpen221.mp3.tests;

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

public class depthFirstSearchTest {

    @Test
    public void test() {
        Graph g = new AdjacencyMatrixGraph();
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
        g.addEdge(v2, v5);
        Set<List<Vertex>> answer = new HashSet<>();
        List<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        answer.add(vertices);
        System.out.println(g.getDownstreamNeighbors(v1));
        
        assertEquals(answer, Algorithms.depthFirstSearch(g, v1));
    }

}
