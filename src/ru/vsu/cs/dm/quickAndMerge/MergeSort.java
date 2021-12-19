package ru.vsu.cs.dm.quickAndMerge;

public class MergeSort {

    private int countComparison = 0;
//    private int swapCount = 0;

    public int[] sort(int[] a, int arrSize) {
        if (arrSize < 2) {
            return a;
        }

        int mid = arrSize / 2;
        int[] l = new int[mid];
        int[] r = new int[arrSize - mid];

        System.arraycopy(a, 0, l, 0, mid);
        if (arrSize - mid >= 0) System.arraycopy(a, mid, r, 0, arrSize - mid);

        sort(l, mid);
        sort(r, arrSize - mid);

        merge(a, l, r, mid, arrSize - mid);

        return a;
    }

    private void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            this.countComparison++;
            if (l[i] <= r[j]) {
                a[k] = l[i++];
            } else {
                a[k] = r[j++];
            }
//            this.swapCount++;
            k++;
        }

        while (i < left) {
            a[k++] = l[i++];
//            this.swapCount++;
        }
        while (j < right) {
            a[k++] = r[j++];
//            this.swapCount++;
        }
    }

    public int getCountComparison() {
        return countComparison;
    }

//    public int getSwapCount() {
//        return swapCount;
//    }
}
