// TWO SUM - PAIR WITH GIVEN SUM (bubble sort + two pointers)
// Sort the array, then move i from the left and j from the right.
public class Q8_TwoSum {

    static boolean twoSum(int[] arr, int target) {
        bubbleSort(arr);                        // time = n^2, space = 1
        int i = 0, j = arr.length - 1;

        while (i < j) {                         // time = n
            if (arr[i] + arr[j] == target) return true;
            else if (arr[i] + arr[j] > target) j--;   // sum too big, shrink from right
            else i++;                                 // sum too small, grow from left
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        System.out.println(twoSum(arr1, 16));   // true  (6 + 10)

        int[] arr2 = {1, 2, 4, 3, 6};
        System.out.println(twoSum(arr2, 11));   // false

        int[] arr3 = {11};
        System.out.println(twoSum(arr3, 11));   // false (only one element)
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;                // already sorted, stop early
        }
    }
}