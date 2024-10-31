package DataTypes;

import java.util.Arrays;

public class ArrayCharles {
    public void playWithArrays() {
        int[] nums1 = new int[3];
        nums1 = new int[] { 3, -1, 17 };
        int[] nums2 = { 4, 0, 16 };
        int[] nums3 = new int[] { 3, -1 ,17 };

        // print array
        System.out.println(nums3); /* [I@20ad9418 */
        System.out.println(Arrays.toString(nums3)); /* [3, -1, 17] */
        // length of array
        System.out.println(nums3.length);

        // sort
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3));
        // N.B. Arrays are mutable, sort() changes original array!

        var result = Arrays.binarySearch(nums3, 17); // Works only with sorted arrays!
        System.out.println("Index is " + result);

        int[] numbers1 = { };
        int[] numbers2 = { };
        // If 2 arrays have different length, the greater length wins
        // If 2 arrays have the same length, the one with smaller first element is smaller
        // Null is smaller than any other values
        Arrays.compare(new int[] {3,7}, new int[]{3});
        Arrays.compare(new int[] {3,7}, new int[]{3,7});
        Arrays.compare(new int[] {3,7}, new int[]{2,7});
        Arrays.compare(new String[] {"ab","John"}, new String[] {"abc","Hey!"});

        Arrays.mismatch(new int[] {1,2}, new int[] {1,3});
        Arrays.mismatch(new int[] {1,2}, new int[] {1,2,3});
        Arrays.mismatch(new int[] {1,2}, new int[] {1,2});
    }

    public void playWithMultidimensionalArrays() {
        int[][] a = { {-1,17}, {3}, {5,103,11}, {4,9,-6,8} };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("a(%d,%d)=%d".formatted(i,j,a[i][j]));
            }
        }

        for (int[] row : a) {
            for (int element : row) {
                System.out.println("element = " + element);
            }
        }
    }
}
