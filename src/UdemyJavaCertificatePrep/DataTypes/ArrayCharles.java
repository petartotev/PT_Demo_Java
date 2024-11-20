package DataTypes;

import java.util.Arrays;

public class ArrayCharles {
    public void playWithArrays() {
        int[] nums1 = new int[3];
        nums1 = new int[] { 3, -1, 17 };
        int[] nums2 = { 4, 0, 16 };
        int[] nums3 = new int[] { 3, -1 ,17 };

        // Declare multiple arrays on the same line:
        int[] myNumbers, myValues;
        // Declare int[] and int:
        int[] myNumbersInArray, someNumber;

        // ⚠️ WARNING: Arrays don't implement equals() method!
        int[] myNums11= new int[] { 1, 2, 3 };
        int[] myNums22= new int[] { 1, 2, 3 };
        System.out.println("myNums11 == myNums22: " + (myNums11 == myNums22));          /* false */
        System.out.println("myNums11.equals(myNums22): " + myNums11.equals(myNums22));  /* false */

        // Print array:
        System.out.println(nums3);                  /* [I@20ad9418 */
        System.out.println(Arrays.toString(nums3)); /* [3, -1, 17] */

        // length
        System.out.println(nums3.length); /* 3 */

        // sort()
        /* ⚠️ WARNING: Arrays are mutable => sort() changes the original array! */
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3)); /* [-1, 3, 17] */

        // binarySearch()
        /* ⚠️ WARNING: Works only with sorted arrays! */
        var result = Arrays.binarySearch(nums3, 17);
        System.out.println("Index is " + result);

        // compare()
        /*
        If arr1 > arr2 => 1
        If arr1 < arr2 => -1
        If arr1 = arr2 => 0

        If 2 arrays have different length, the greater length wins.
        If 2 arrays have the same length, the one with smaller first element is smaller.
        Null is smaller than any other values.
        One String is smaller if it is a prefix of another.
        Uppercase is smaller than lowercase.
        Numbers are smaller than letters.
         */
        Arrays.compare(new int[] {3,7}, new int[]{3}); /* 1 */
        Arrays.compare(new int[] {3,7}, new int[]{3,7}); /* 0 */
        Arrays.compare(new int[] {3,7}, new int[]{2,7}); /* 1 */
        Arrays.compare(new String[] {"ab","John"}, new String[] {"abc","Hey!"});  /* -1 */
        Arrays.compare(new String[] {"xy","John"}, new String[] {"abc","Hey!"});  /* 1 */
        Arrays.compare(new String[] {"John","John"}, new String[] {"john","John"});  /* -1 */
        Arrays.compare(new String[] {"John","John"}, null);  /* 1 */

        // mismatch()
        Arrays.mismatch(new int[] {1,2}, new int[] {1,3}); /* 1 */
        Arrays.mismatch(new int[] {1,2}, new int[] {1,2,3}); /* 2 */
        Arrays.mismatch(new int[] {1,2}, new int[] {1,2}); /* -1 */
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
