// LeetCode 283 - Move Zeroes (offline test template)

public class Q5_MoveZeroes_twoPointers {

    // ====== WRITE YOUR SOLUTION HERE ======
    static void moveZeroes(int[] nums) {
    int j = 0;                      // next place for a non-zero

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
        }
    }
}
    // ======================================

    static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    static boolean isSame(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {0, 1, 0, 3, 12},
            {0},
            {1, 2, 3},
            {0, 0, 1},
            {0, 0, 0},
            {1, 0},
            {4, 2, 4, 0, 0, 3, 0, 5, 1, 0}
        };

        int[][] expected = {
            {1, 3, 12, 0, 0},
            {0},
            {1, 2, 3},
            {1, 0, 0},
            {0, 0, 0},
            {1, 0},
            {4, 2, 4, 3, 5, 1, 0, 0, 0, 0}
        };

        int passed = 0;

        for (int t = 0; t < inputs.length; t++) {
            int[] nums = new int[inputs[t].length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = inputs[t][i];
            }

            System.out.print("Test " + (t + 1) + " Input:    ");
            printArr(nums);
            System.out.println();

            moveZeroes(nums);

            System.out.print("       Output:   ");
            printArr(nums);
            System.out.println();

            System.out.print("       Expected: ");
            printArr(expected[t]);
            System.out.println();

            if (isSame(nums, expected[t])) {
                System.out.println("       PASS");
                passed++;
            } else {
                System.out.println("       FAIL");
            }
            System.out.println();
        }

        System.out.println(passed + "/" + inputs.length + " passed");
    }
}