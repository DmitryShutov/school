package SimpleGraph;

import org.junit.jupiter.api.Test;

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
}
