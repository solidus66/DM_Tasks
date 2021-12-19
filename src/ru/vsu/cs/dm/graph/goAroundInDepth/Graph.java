package ru.vsu.cs.dm.graph.goAroundInDepth;

import java.util.Stack;

public class Graph {
    private final Vertex[] vertexArray;
    private final int[][] adjMat;
    private int nVerts;
    private final Stack<Integer> stack;

    public Graph() {
        int MAX_VERTS = 10;
        vertexArray = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>();
    }

    public void addVertex(char lab) {
        vertexArray[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexArray[v].getLabel());
    }

    public void dfs() {
        vertexArray[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexArray[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexArray[j].wasVisited = false;
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexArray[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }
}
