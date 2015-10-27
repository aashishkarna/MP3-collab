package ca.ubc.ece.cpen221.mp3.graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {
    
    private final ArrayList<ArrayList<Boolean>> AdjMatrix = new ArrayList<ArrayList<Boolean>>();
    LinkedList<Vertex> VertexIndex = new LinkedList<Vertex>();
    private Integer CurrIndex = 0;

    /**
     * @param Vertex v to be added to the matrix
     * @requires v is not already a vertex in the graph
     * @modifies Adds a vertex v to the matrix.
     */
    @Override
    public void addVertex(Vertex v) {
        assert(!AdjMatrix.contains(v));
        AdjMatrix.add(new ArrayList<Boolean>());
        VertexIndex.add(v);
        for(int i = 0; i <= CurrIndex; i++) {
            for(int j = 0; j <= CurrIndex; j++) {
                if(i < AdjMatrix.size() && j < AdjMatrix.get(i).size()) {
                    if(AdjMatrix.get(i).get(j) == true) {
                        continue;
                    }
                    else {
                        AdjMatrix.get(i).set(j, false);
                    }
                }
                else {
                    AdjMatrix.get(i).add(false);
                }
            }
        }
        CurrIndex++;
    }

    /**
     * @param Vertex v1 and v2, the start and end of the edge respectively
     * @requires v1 and v2 are vertices in the matrix
     * @modifies Adds edge from v1 to v2 in the matrix
     */
    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        assert(AdjMatrix.contains(v1) && AdjMatrix.contains(v2));
        AdjMatrix.get(VertexIndex.indexOf(v1)).set(VertexIndex.indexOf(v2), true);
    }

    /**
     * @param Vertex v1 and v2, to be checked for an edge from the former to the latter
     * @requires v1 and v2 must be vertices in the matrix
     * @return a boolean value of whether there is an edge from v1 to v2
     */
    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        assert(AdjMatrix.contains(v1) && AdjMatrix.contains(v2));
        return AdjMatrix.get(VertexIndex.indexOf(v1)).get(VertexIndex.indexOf(v2));
    }

    /**
     * @param Vertex v, whose downstream vertices are to be obtained
     * @requires v is a Vertex in the matrix
     * @return List<Vertex> consisting of all v's downstream vertices
     */
    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        assert(AdjMatrix.contains(v));
        List<Vertex> dsn = new ArrayList<Vertex>();
        dsn.addAll(VertexIndex);
        for(Vertex iter: VertexIndex) {
            if(AdjMatrix.get(VertexIndex.indexOf(v)).get(VertexIndex.indexOf(iter)) == false) {
                dsn.remove(iter);
            }
        }
        
        return dsn;
    }

    /**
     * @param Vertex v, whose upstream vertices are to be obtained
     * @requires v is a Vertex in the matrix
     * @return List<Vertex> consisting of all v's upstream vertices
     */
    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        assert(AdjMatrix.contains(v));
        List<Vertex> usn = new ArrayList<Vertex>();
        usn.addAll(VertexIndex);
        for(Vertex iter: VertexIndex) {
            if(AdjMatrix.get(VertexIndex.indexOf(iter)).get(VertexIndex.indexOf(v)) == false) {
                usn.remove(iter);
            }
        }
        return usn;
    }

    /**
     * @return List<Vertex> of all the vertices contained in the matrix or
     *  an empty List<Vertex> if there are no vertices in the matrix
     */
    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.addAll(VertexIndex);
        if(!vertices.isEmpty()){
            return Collections.unmodifiableList(vertices);
        }else{
            return new LinkedList<Vertex>();
        }
    }
}
