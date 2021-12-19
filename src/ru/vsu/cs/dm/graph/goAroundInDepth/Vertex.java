package ru.vsu.cs.dm.graph.goAroundInDepth;

public class Vertex {
    private final char label;
    public boolean wasVisited;

    public Vertex(final char label) {
        this.label = label;
        wasVisited = false;
    }

    public char getLabel() {
        return this.label;
    }

    public boolean isWasVisited() {
        return this.wasVisited;
    }

    public void setWasVisited(final boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
