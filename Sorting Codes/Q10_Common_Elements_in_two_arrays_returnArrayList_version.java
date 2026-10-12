import java.util.ArrayList;
import java.util.Arrays;

// INTERSECTION OF TWO ARRAYS (sort + two pointers + ArrayList)
// Returns the common elements. A value appears min(count in nums1, count in nums2) times.
public class Q10_Common_Elements_in_two_arrays_returnArrayList_version {

    static ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }

    static int testNo = 1;
    static int passed = 0;

    // expected must be in ascending order, since the result comes out sorted
    static void test(int[] nums1, int[] nums2, ArrayList<Integer> expected) {
        String in1 = Arrays.toString(nums1);   // save before sorting mutates them
        String in2 = Arrays.toString(nums2);

        ArrayList<Integer> result = intersection(nums1, nums2);
        boolean ok = result.equals(expected);
        if (ok) passed++;

        System.out.println("Test " + testNo++ + ": " + (ok ? "PASS" : "FAIL"));
        if (!ok) {
            System.out.println("  nums1    = " + in1);
            System.out.println("  nums2    = " + in2);
            System.out.println("  expected = " + expected);
            System.out.println("  got      = " + result);
        }
    }

    // helper so test cases stay short: list(2, 2) -> [2, 2], list() -> []
    static ArrayList<Integer> list(Integer... values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    public static void main(String[] args) {
        // Duplicates: min count of each value is kept
        test(new int[]{1, 2, 2, 1}, new int[]{2, 2}, list(2, 2));
        test(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, list(4, 9));
        test(new int[]{1, 1, 1}, new int[]{1, 1}, list(1, 1));
        test(new int[]{2, 3, 2}, new int[]{1, 2}, list(2));
        test(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}, list(2, 3));

        // No common elements
        test(new int[]{1, 2, 3}, new int[]{4, 5, 6}, list());
        test(new int[]{3, 4, 2, 3}, new int[]{1, 5}, list());

        // Smallest inputs
        test(new int[]{1}, new int[]{1}, list(1));
        test(new int[]{1}, new int[]{2}, list());

        // Everything matches, different order
        test(new int[]{1, 2, 3}, new int[]{3, 2, 1}, list(1, 2, 3));

        // One element vs many
        test(new int[]{5}, new int[]{1, 2, 3, 4, 5}, list(5));

        // Boundary value and partial overlap
        test(new int[]{100, 100, 1}, new int[]{100, 50}, list(100));
        test(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 4, 6, 8, 10}, list(2, 4, 6));

        System.out.println("\nPassed " + passed + " / " + (testNo - 1));
    }
}