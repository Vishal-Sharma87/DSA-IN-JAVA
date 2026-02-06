package utilsOfVishal;


public class SortOfVishal {

    private static int[] mergeSortHelper(int[] array, int l, int r) {

        if (l == r)
            return new int[] { array[l] };

        int mid = l + (r - l) / 2;

        int[] left = mergeSortHelper(array, l, mid);
        int[] right = mergeSortHelper(array, mid + 1, r);

        return mergeTwoSortedArrays(left, right);
    }

    public static void selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }
            UtilsOfVishal.swap(a, i, minIndex);
        }
    }

    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    UtilsOfVishal.swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void insertionSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                UtilsOfVishal.swap(a, j, j - 1);
                j--;
            }
        }
    }

    public static void bubbleSortRecursion(int[] a, int i, int j, boolean swapped) {
        if (i >= a.length)
            return;

        if (j == a.length - i - 1) {
            if (!swapped)
                return;
            bubbleSortRecursion(a, i + 1, 0, false);
        } else {
            if (a[j] > a[j + 1]) {
                UtilsOfVishal.swap(a, j, j + 1);
                bubbleSortRecursion(a, i, j + 1, true);
            } else {
                bubbleSortRecursion(a, i, j + 1, swapped);
            }
        }
    }

    public static void recursiveInsertionSort(int[] a, int i) {

        if (i >= a.length)
            return;

        int j = i;
        while (j > 0 && a[j] < a[j - 1]) {
            UtilsOfVishal.swap(a, j, j - 1);
            j--;
        }
        recursiveInsertionSort(a, i + 1);
    }

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;

        int[] mergedArray = new int[aLen + bLen];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < aLen && j < bLen) {

            int val;
            if (a[i] < b[j]) {
                val = a[i++];
            } else {
                val = b[j++];
            }
            mergedArray[index] = val;
            index++;
        }

        while (i < aLen) {
            mergedArray[index++] = a[i++];
        }
        while (j < bLen) {
            mergedArray[index++] = b[j++];
        }

        return mergedArray;
    }

    public static void mergeSort(int[] array) {
        // if the array is empty -> return
        if (array.length == 0)
            return;

        // call the actual merger sort implementation to return a array of sorted values
        int[] sortedArrays = mergeSortHelper(array, 0, array.length - 1);

        // copy the value of sorted array to the given arrays for correct ans
        System.arraycopy(sortedArrays, 0, array, 0, array.length);
    }

    public static void quickSort(int[] array) {
        if (array.length == 0)
            return;
        quickSortHelper(array, 0, array.length - 1);

    }

    private static void quickSortHelper(int[] array, int i, int j) {
        if (i >= j)
            return;

        // * 1. choice a pivot element (start, end, random) -> going with start
        // going with first element as pivot
        
        // * 2. get correct pivot index in range i to j;
        int pivotIndex = getCorrectPivotIndexInArray(array, i, j);
        
        // * 3. swap the pivot element with the array[pivotIndex];
        UtilsOfVishal.swap(array, i, pivotIndex);
        
        // * 4. make the array balance,
        // ** all the value in range i, pivotIndex - 1 should be smaller and
        // ** all the value in range pivotIndex + 1, j should be greater
        makeArrayBalancedForQuickSort(array, i, j, pivotIndex);
        
        // * 5. call the left recursion i, pivotIndex - 1
        quickSortHelper(array, i, pivotIndex - 1);

        // * 6. call the right recursion pivotIndex + 1, j
        quickSortHelper(array, pivotIndex + 1, j);
    }

    private static void makeArrayBalancedForQuickSort(int[] array, int i, int j, int pivotIndex) {
        int pivot = array[pivotIndex];

        while (i < pivotIndex && j > pivotIndex) {
            if (array[i] > pivot && array[j] < pivot) {
                UtilsOfVishal.swap(array, i, j);
                i++;
                j--;
            } else if (array[i] > pivot) {
                j--;
            } else {
                i++;
            }
        }

    }

    private static int getCorrectPivotIndexInArray(int[] array, int i, int j) {
        int pivot = array[i];

        int count = 0;
        for (int k = i + 1; k <= j; k++) {
            if (array[k] < pivot)
                count++;
        }

        return i + count;
    }

}
