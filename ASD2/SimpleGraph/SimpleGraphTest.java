package SimpleGraph;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SimpleGraphTest {
    private boolean vertexHasConnection(SimpleGraph graph, int v1) {
        for (int i = 0; i <= graph.vertex.length - 1; i++) {
            if (connectedVertices(graph, v1, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean connectedVertices(SimpleGraph graph, int v1, int v2) {
        return graph.m_adjacency[v1][v2] == 1;
    }

    @Test
    public void addOneVertex() {
        SimpleGraph graph = new SimpleGraph(1);
        graph.AddVertex(1);
        assertEquals(1, graph.vertex[0].Value);
        assertFalse(vertexHasConnection(graph, 0));
    }

    @Test
    public void addTwoVertex() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        assertEquals(1, graph.vertex[0].Value);
        assertEquals(2, graph.vertex[1].Value);
        assertFalse(vertexHasConnection(graph, 1));
    }


    @Test
    public void AddEdge() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        assertEquals(0, graph.m_adjacency[0][1]);
        graph.AddEdge(0, 1);
        assertEquals(1, graph.vertex[0].Value);
        assertEquals(2, graph.vertex[1].Value);
        assertEquals(1, graph.m_adjacency[0][1]);
        assertEquals(0, graph.m_adjacency[1][0]);
    }

    @Test
    public void RemoveEdge() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        assertEquals(1, graph.m_adjacency[0][1]);
        graph.RemoveEdge(0, 1);
        assertEquals(0, graph.m_adjacency[0][1]);
    }

    @Test
    public void RemoveVertex() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        assertEquals(1, graph.m_adjacency[0][1]);
        graph.RemoveVertex(0);
        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(0, graph.m_adjacency[1][0]);
    }

    @Test
    public void DepthFirstSearchEmptyGraph() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        assertEquals(0, graph.m_adjacency[0][1]);
        graph.DepthFirstSearch(0, 1);
        assertEquals(0, graph.m_adjacency[0][1]);
    }

    @Test
    public void DepthFirstSearchSimplestCase() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        assertEquals(1, graph.m_adjacency[0][1]);
        ArrayList<Vertex> res = graph.DepthFirstSearch(0, 1);
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).Value);
        assertEquals(2, res.get(1).Value);
    }

    @Test
    public void DepthFirstSearchCircleGraph() {
        SimpleGraph graph = new SimpleGraph(3);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 0);
        ArrayList<Vertex> res = graph.DepthFirstSearch(0, 2);
        assertEquals(3, res.size());
        assertEquals(0, res.get(0).Value);
        assertEquals(1, res.get(1).Value);
        assertEquals(2, res.get(2).Value);
    }

    @Test
    public void DepthFirstSearchNoWayInGraph() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        ArrayList<Vertex> res = graph.DepthFirstSearch(0, 4);
        assertEquals(0, res.size());
    }

    @Test       
    public void DepthFirstSearchMultipleWays() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 0);
        graph.AddEdge(4, 1);
        ArrayList<Vertex> res = graph.DepthFirstSearch(0, 4);
        assertEquals(4, res.size());
        assertEquals(0, res.get(0).Value);
        assertEquals(1, res.get(1).Value);
        assertEquals(2, res.get(2).Value);
        assertEquals(4, res.get(3).Value);
    }

    @Test
    public void BreadthFirstSearchEmptyGraph() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        assertEquals(0, graph.m_adjacency[0][1]);
        ArrayList<Vertex> res = graph.BreadthFirstSearch(0, 1);
        assertEquals(0, res.size());
    }

    @Test
    public void BreadthFirstSearchSimplestCase() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        assertEquals(1, graph.m_adjacency[0][1]);
        ArrayList<Vertex> res = graph.BreadthFirstSearch(0, 1);
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).Value);
        assertEquals(2, res.get(1).Value);
    }

    @Test
    public void BreadthFirstSearchCircleGraph() {
        SimpleGraph graph = new SimpleGraph(3);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(0, 2);
        ArrayList<Vertex> res = graph.BreadthFirstSearch(0, 2);
        assertEquals(2, res.size());
        assertEquals(0, res.get(0).Value);
        assertEquals(2, res.get(1).Value);
    }

    @Test
    public void bfsNoWayInGraph() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        ArrayList<Vertex> res = graph.BreadthFirstSearch(0, 4);
        assertEquals(0, res.size());
    }

    @Test
    public void bfsLotsOfConnection() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 4);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 4);
        ArrayList<Vertex> res = graph.BreadthFirstSearch(0, 4);
        assertEquals(3, res.size());
        assertEquals(0, res.get(0).Value);
        assertEquals(1, res.get(1).Value);
        assertEquals(4, res.get(2).Value);
    }
}
