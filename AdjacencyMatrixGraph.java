package ca.ubc.ece.cpen221.mp3.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {
    
    private final ArrayList<ArrayList<Boolean>> AdjMatrix = new ArrayList<ArrayList<Boolean>>();
    LinkedList<Vertex> VertexIndex = new LinkedList<Vertex>();
    private Integer CurrIndex = 0;

    @Override
    public void addVertex(Vertex v) {
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

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        AdjMatrix.get(VertexIndex.indexOf(v1)).set(VertexIndex.indexOf(v2), true);
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        return AdjMatrix.get(VertexIndex.indexOf(v1)).get(VertexIndex.indexOf(v2));
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        List<Vertex> dsn = new ArrayList<Vertex>();
        dsn.addAll(VertexIndex);
        for(Vertex iter: VertexIndex) {
            if(AdjMatrix.get(VertexIndex.indexOf(v)).get(VertexIndex.indexOf(iter)) == false) {
                dsn.remove(iter);
            }
        }
        return dsn;
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        List<Vertex> usn = new ArrayList<Vertex>();
        usn.addAll(VertexIndex);
        for(Vertex iter: VertexIndex) {
            if(AdjMatrix.get(VertexIndex.indexOf(iter)).get(VertexIndex.indexOf(v)) == false) {
                usn.remove(iter);
            }
        }
        return usn;
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.addAll(VertexIndex);
        return vertices;
    }
}
