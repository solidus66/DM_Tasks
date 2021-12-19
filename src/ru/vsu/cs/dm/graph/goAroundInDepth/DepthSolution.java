package ru.vsu.cs.dm.graph.goAroundInDepth;

public class DepthSolution {

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

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);

        System.out.println();
        System.out.println(ANSI_CYAN + "Visits: " + ANSI_RESET);
        graph.dfs();
    }
}