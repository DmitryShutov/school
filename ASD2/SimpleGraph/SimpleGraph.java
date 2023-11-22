package SimpleGraph;

import java.util.*;

class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;
    Stack<Vertex> routeVertexes = new Stack<Vertex>();

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

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        this.CleanDS();
        this.dfs(VFrom, VTo, true);
        return new ArrayList<Vertex>(routeVertexes);
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        this.CleanDS();
        return bfs(VFrom, VTo);
    }

    private void CleanDS() {
        this.routeVertexes = new Stack<Vertex>();
        for (Vertex v : vertex) {
            v.Hit = false;
        }
    }

    private int findFirstUnvisited(int current) {
        for (int i = 0; i <= this.m_adjacency[current].length - 1; i++) {
            boolean connected = this.m_adjacency[current][i] == 1;
            boolean unvisited = !this.vertex[i].Hit;
            if (connected && unvisited) {
                return i;
            }
        }
        return -1;
    }

    private ArrayList<Vertex> bfs(int fromIndex, int toIndex) {
        Map<Vertex, Vertex> predecessorMap = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = vertex[fromIndex];
        Vertex end = vertex[toIndex];
        queue.add(start);
    
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            currentVertex.Hit = true;
    
            if (currentVertex == end) {
                return constructPath(predecessorMap, start, end);
            }
    
            int currentIndex = Arrays.asList(vertex).indexOf(currentVertex);
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentIndex][i] == 1 && !vertex[i].Hit) {
                    queue.add(vertex[i]);
                    if (!predecessorMap.containsKey(vertex[i])) {
                        predecessorMap.put(vertex[i], currentVertex);
                    }
                }
            }
        }
        return new ArrayList<>();
    }
    
    private ArrayList<Vertex> constructPath(Map<Vertex, Vertex> predecessorMap, Vertex start, Vertex end) {
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = end;
    
        if (predecessorMap.get(step) == null) {
            return new ArrayList<>();
        }
    
        path.add(step);
        while (predecessorMap.get(step) != null) {
            step = predecessorMap.get(step);
            path.addFirst(step);
        }
    
        return new ArrayList<>(path);
    }  

    private Stack<Vertex> dfs(int fromIndex, int toIndex, boolean push) {
        vertex[fromIndex].Hit = true;
        if (push) {
            this.routeVertexes.push(vertex[fromIndex]);
        }
        boolean connectedWithTo = m_adjacency[fromIndex][toIndex] == 1;
        if (connectedWithTo) {
            routeVertexes.push(vertex[toIndex]);
            return routeVertexes;
        }
        int unvisitedConnected = findFirstUnvisited(fromIndex);
        if (unvisitedConnected != -1) {
            return dfs(unvisitedConnected, toIndex, true);
        }
        if (!this.routeVertexes.isEmpty()) {
            Vertex lastVertex = this.routeVertexes.pop();
            int lastVertexIndex = Arrays.asList(vertex).indexOf(lastVertex);
            vertex[lastVertexIndex].Hit = true;
            return dfs(lastVertexIndex, toIndex, false);
        }
        return routeVertexes;
    }
}
