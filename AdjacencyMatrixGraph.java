package ca.ubc.ece.cpen221.mp3.graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {
    
    ArrayList<ArrayList<Boolean>> AdjMatrix = new ArrayList<ArrayList<Boolean>>();
    Map<Vertex, Integer> VertexIndex;
    private Integer CurrIndex = 0;

    @Override
    public void addVertex(Vertex v) {
        AdjMatrix.add(new ArrayList<Boolean>());
        VertexIndex.put(v, CurrIndex);
        for(int i = 0; i <= CurrIndex; i++) {
            for(int j = 0; j <= CurrIndex; j++) {
                if(AdjMatrix.get(i).get(j) == true) {
                    continue;
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
        AdjMatrix.get(VertexIndex.get(v1)).set(VertexIndex.get(v2), true);
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        return AdjMatrix.get(VertexIndex.get(v1)).get(VertexIndex.get(v2));
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        List<Vertex> dsn = new ArrayList<Vertex>();
        dsn.addAll(VertexIndex.keySet());
        for(int i = 0; i <= VertexIndex.size(); i++) {
            if(AdjMatrix.get(VertexIndex.get(v)).get(i) == false) {
                dsn.remove(i);
            }
        }
        return dsn;
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        List<Vertex> usn = new ArrayList<Vertex>();
        usn.addAll(VertexIndex.keySet());
        for(int i = 0; i <= VertexIndex.size(); i++) {
            if(AdjMatrix.get(i).get(VertexIndex.get(v)) == false) {
                usn.remove(i);
            }
        }
        return usn;
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.addAll(VertexIndex.keySet());
        return vertices;
    }
}
