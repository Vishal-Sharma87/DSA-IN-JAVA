package arrays;

import java.util.ArrayList;

import utilsOfVishal.UtilsOfVishal;

public class ArraysOfVishal {

    public static void rotateArrayByKSteps(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }

        int len = nums.length;
        // * get the optimal k, as k can be very large,
        // and rotating the array after its size results in repetition of work
        k = k % len;

        int partitionIndex = len - k - 1;

        // * reverse 0 -> partitionIndex
        UtilsOfVishal.reverseArray(nums, 0, partitionIndex);

        // * reverse partitionIndex + 1 -> size - 1
        UtilsOfVishal.reverseArray(nums, partitionIndex + 1, len - 1);
        // * then reverse the whole array as one unit

        UtilsOfVishal.reverseArray(nums, 0, len - 1);

        // * time: 2*n ~ n
        // * space : constant

    }

    public static int removerDuplicatesFromSortedArray(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        // get the prevUniqueVal
        int prevUniqueVal = nums[0];

        // set i and j
        int i = 1, j = 1;

        // iterate over array
        while (j < nums.length) {

            // if arr[j] is unique(greater than the prevUniqueVal swap it, increment i, j,
            // and update prevUniqueVal
            if (nums[j] > prevUniqueVal) {
                prevUniqueVal = nums[j];
                UtilsOfVishal.swap(nums, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }

    public static void moveZeroesToEndInArrays(int[] nums) {
        if (nums.length <= 0)
            return;

        int len = nums.length;
        int nextIndexOfNonZeroElement = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                UtilsOfVishal.swap(nums, nextIndexOfNonZeroElement, i);
                nextIndexOfNonZeroElement++;
            }
        }
    }

    public static ArrayList<Integer> getUnionOfTwoSortedArraysWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> union = new ArrayList<>();
        if (a.length == 0 && b.length == 0)
            return union;

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            int temp;
            if (a[i] == b[j]) {
                insertIfUnique(union, a[i]);
                i++;
                j++;
            } else {
                if (a[i] < b[j]) {
                    temp = a[i];
                    i++;
                } else {
                    temp = b[j];
                    j++;
                }
                insertIfUnique(union, temp);
            }

        }

        while (i < a.length) {
            insertIfUnique(union, a[i]);
            i++;
        }
        while (j < b.length) {
            insertIfUnique(union, b[j]);
            j++;
        }
        return union;
    }

    private static void insertIfUnique(ArrayList<Integer> a, int val) {
        if (a.size() == 0 || a.getLast() != val) {
            a.add(val);
        }
    }

}
