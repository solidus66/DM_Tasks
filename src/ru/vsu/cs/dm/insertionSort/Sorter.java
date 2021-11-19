package ru.vsu.cs.dm.insertionSort;

public abstract class Sorter<T extends Comparable<T>> {
    protected int comparisonsCounter = 0;
    private final StringBuilder comparisonsLog = new StringBuilder();

    protected void logCompare(T a, T b, char sign) {
        comparisonsLog.append(comparisonsCounter).append(": ").append(a.toString())
                .append(" ").append(sign).append(" ").append(b.toString()).append("\n");
    }

    protected void clearComparisons() {
        comparisonsCounter = 0;
        comparisonsLog.setLength(0);
    }

    public int getComparisonsCounter() {
        return comparisonsCounter;
    }

    public String getComparisonsLog() {
        return comparisonsLog.toString();
    }

    public abstract void sort(T[] array);
}