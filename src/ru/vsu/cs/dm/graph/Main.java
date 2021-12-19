package ru.vsu.cs.dm.graph;

import ru.vsu.cs.dm.graph.dijkstraAlgorithm.DijkstraSolution;
import ru.vsu.cs.dm.graph.goAroundInDepth.DepthSolution;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        printStartInfo();
        int answer = readAnswer();

        switch (answer) {
            case 1 -> DepthSolution.main();
            case 2 -> DijkstraSolution.main();
        }
    }

    private static int readAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("I choose: ");
        return scan.nextInt();
    }

    private static void printStartInfo() {
        System.out.println();
        System.out.println(ANSI_CYAN + """
                Select '1' to pick DepthSolution\s
                Select '2' to pick DijkstraSolution""" + ANSI_RESET);
    }
}