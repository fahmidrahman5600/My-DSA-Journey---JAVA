import java.util.Arrays;

// LEETCODE 2956: FIND COMMON ELEMENTS BETWEEN TWO ARRAYS
// answer[0] = count of indices i where nums1[i] is present in nums2
// answer[1] = count of indices j where nums2[j] is present in nums1
// Constraints: 1 <= n, m <= 100, 1 <= nums[i] <= 100
public class Q9_Common_Elements_in_two_arrays_Leetcode_2956 {

    // static int[] findIntersectionValues(int[] nums1, int[] nums2) {
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     int i = 0;
    //     int j = 0;
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     while(i < nums1.length && j < nums2.length){
    //         if(nums1[i] == nums2[j]){
    //             ans.add(nums1[i]);
    //             i++;
    //             j++;
    //         }
    //         else{
    //             if(nums1[i] < nums2[j]){
    //                 i++;
    //             }
    //             else{
    //                 j++;
    //             }
    //         }
    //     }

    //     int[] ansArr = new int[ans.size()];
    //     for(int k=0; k<ans.size(); k++){
    //         ansArr[i]=ans.get(i);
    //     }
    //     return ansArr;
    // }

    static int[] findIntersectionValues(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int i = 0, j = 0;
    int count1 = 0, count2 = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
            int val = nums1[i];

            // count every copy of val in nums1
            while (i < nums1.length && nums1[i] == val) {
                count1++;
                i++;
            }
            // count every copy of val in nums2
            while (j < nums2.length && nums2[j] == val) {
                count2++;
                j++;
            }
        } else if (nums1[i] < nums2[j]) {
            i++;
        } else {
            j++;
        }
    }

    return new int[]{count1, count2};
}


    static int testNo = 1;
    static int passed = 0;

    static void test(int[] nums1, int[] nums2, int[] expected) {
        int[] result = findIntersectionValues(nums1, nums2);
        boolean ok = Arrays.equals(result, expected);
        if (ok) passed++;

        System.out.println("Test " + testNo++ + ": " + (ok ? "PASS" : "FAIL"));
        if (!ok) {
            System.out.println("  nums1    = " + Arrays.toString(nums1));
            System.out.println("  nums2    = " + Arrays.toString(nums2));
            System.out.println("  expected = " + Arrays.toString(expected));
            System.out.println("  got      = " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {
        // LeetCode examples
        test(new int[]{2, 3, 2}, new int[]{1, 2}, new int[]{2, 1});
        test(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}, new int[]{3, 4});
        test(new int[]{3, 4, 2, 3}, new int[]{1, 5}, new int[]{0, 0});

        // Smallest possible input
        test(new int[]{1}, new int[]{1}, new int[]{1, 1});

        // Duplicates counted per index, not per value
        test(new int[]{1, 1, 1, 1}, new int[]{1}, new int[]{4, 1});
        test(new int[]{1, 2, 3, 4, 5}, new int[]{5, 5, 5, 5}, new int[]{1, 4});

        // Everything matches
        test(new int[]{1, 2, 3}, new int[]{3, 2, 1}, new int[]{3, 3});

        // One element vs many
        test(new int[]{5}, new int[]{1, 2, 3, 4, 5}, new int[]{1, 1});

        // Max value boundary (100)
        test(new int[]{100, 100, 1}, new int[]{100, 50}, new int[]{2, 1});

        // Partial overlap
        test(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 4, 6, 8, 10}, new int[]{3, 3});

        System.out.println("\nPassed " + (testNo - 1 == 0 ? 0 : passed) + " / " + (testNo - 1));
    }
}