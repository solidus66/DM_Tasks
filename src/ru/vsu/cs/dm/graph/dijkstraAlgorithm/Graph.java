package ru.vsu.cs.dm.graph.dijkstraAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private final int INFINITY = 100000000;
    private final Vertex[] vertexList;
    private final int[][] relationMatrix;
    private int countOfVertices;
    private int countOfVertexInTree;
    private List<Path> shortestPaths;
    private int currentVertex;
    private int startToCurrent;

    public Graph() {
        int MAX_VERTS = 10;
        vertexList = new Vertex[MAX_VERTS];
        relationMatrix = new int[MAX_VERTS][MAX_VERTS];
        countOfVertices = 0;
        countOfVertexInTree = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                relationMatrix[i][k] = INFINITY;
                shortestPaths = new ArrayList<>();
            }
        }
    }

    public void addVertex(char lab) {
        vertexList[countOfVertices++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        relationMatrix[start][end] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].setInTree(true);
        countOfVertexInTree = 1;

        for (int i = 0; i < countOfVertices; i++) {
            int tempDist = relationMatrix[startTree][i];
            Path path = new Path(tempDist);
            path.getParentVertices().add(0);
            shortestPaths.add(path);
        }

        while (countOfVertexInTree < countOfVertices) {
            int indexMin = getMin();
            int minDist = shortestPaths.get(indexMin).getDistance();

            if (minDist == INFINITY) {
                System.out.println(ANSI_RED + "The graph contains unreachable vertices" + ANSI_RESET);
                break;
            } else {
                currentVertex = indexMin;
                startToCurrent = shortestPaths.get(indexMin).getDistance();
            }

            vertexList[currentVertex].setInTree(true);
            countOfVertexInTree++;
            updateShortestPaths();
        }

        displayPaths();
    }

    public void clean() {
        countOfVertexInTree = 0;
        for (int i = 0; i < countOfVertices; i++) {
            vertexList[i].setInTree(false);
        }
    }

    private int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for (int i = 1; i < countOfVertices; i++) {
            if (!vertexList[i].isInTree() && shortestPaths.get(i).getDistance() < minDist) {
                minDist = shortestPaths.get(i).getDistance();
                indexMin = i;
            }
        }
        return indexMin;
    }

    private void updateShortestPaths() {
        int vertexIndex = 1;
        while (vertexIndex < countOfVertices) {
            if (vertexList[vertexIndex].isInTree()) {
                vertexIndex++;
                continue;
            }

            int currentToFringe = relationMatrix[currentVertex][vertexIndex];
            int startToFringe = startToCurrent + currentToFringe;
            int shortPathDistance = shortestPaths.get(vertexIndex).getDistance();

            if (startToFringe < shortPathDistance) {
                List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertex).getParentVertices());
                newParents.add(currentVertex);
                shortestPaths.get(vertexIndex).setParentVertices(newParents);
                shortestPaths.get(vertexIndex).setDistance(startToFringe);
            }
            vertexIndex++;
        }
    }

    private void displayPaths() {
        for (int i = 0; i < countOfVertices; i++) {
            System.out.print(vertexList[i].getLabel() + " = ");
            if (shortestPaths.get(i).getDistance() == INFINITY) {
                System.out.println("0");
            } else {
                StringBuilder result = new StringBuilder(shortestPaths.get(i).getDistance() + " (");
                List<Integer> parents = shortestPaths.get(i).getParentVertices();
                for (Integer parent : parents) {
                    result.append(vertexList[parent].getLabel()).append(" -> ");
                }
                System.out.println(result.toString() + vertexList[i].getLabel() + ")");
            }
        }
    }
}
