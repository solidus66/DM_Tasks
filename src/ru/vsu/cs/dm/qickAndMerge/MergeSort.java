package ru.vsu.cs.dm.qickAndMerge;

public class MergeSort {

    private int countComparison = 0;
    private int swapCount = 0;


    public int[] sort(int[] a, int arrSize) {
        if (arrSize < 2) {
            return a;
        }
        int mid = arrSize / 2;
        int[] l = new int[mid];
        int[] r = new int[arrSize - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < arrSize; i++) {
            r[i - mid] = a[i];
        }

        sort(l, mid);

        sort(r, arrSize - mid);


        merge(a, l, r, mid, arrSize - mid);
        return a;
    }

    public int getCountComparison() {
        return countComparison;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            this.countComparison++;
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
                this.swapCount++;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
