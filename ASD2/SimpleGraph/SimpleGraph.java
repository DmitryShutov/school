package SimpleGraph;

class Vertex {
    public int Value;

    public Vertex(int val) {
        Value = val;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        int index = findEmptyIndex();
        if (index >= 0) {
            vertex[index] = new Vertex(value);
        }
    }

    private int findEmptyIndex() {
        for (int i = 0; i <= vertex.length - 1; i++) {
            if (vertex[i] == null) {
                return i;
            }
        }
        return -1;
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v) {
        vertex[v] = null;
        for (int i = 0; i <= vertex.length - 1; i++) {
            m_adjacency[v][i] = 0;
        }
        for (int j = 0; j < vertex.length - 1; j++) {
            m_adjacency[j][v] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 0;
    }
}
