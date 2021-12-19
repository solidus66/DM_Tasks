package ru.vsu.cs.dm.graph.dijkstraAlgorithm;

public class DijkstraSolution {

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 6, 6);
        graph.addEdge(5, 6, 4);

        System.out.println();
        System.out.println(ANSI_CYAN + "Elements with the shortest paths from point A to point G: " + ANSI_RESET);
        graph.path();
        graph.clean();
    }
}
