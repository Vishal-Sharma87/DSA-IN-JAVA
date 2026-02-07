import java.util.ArrayList;

import arrays.ArraysOfVishal;
import utilsOfVishal.UtilsOfVishal;

public class Main {

    public static void main(String[] args) {

        int[] a = { 1, 1, 1 };
        int[] b = { 2, 2, 2 };
        ArraysOfVishal.moveZeroesToEndInArrays(a);
        ArrayList<Integer> union = ArraysOfVishal.getUnionOfTwoSortedArraysWithDuplicates(a, b);
        System.out.println(union.toString());

    }
}