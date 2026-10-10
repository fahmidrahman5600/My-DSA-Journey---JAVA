// BUBBLE SORT - optimized (with swapped flag)
// If a full pass makes no swaps, array is already sorted -> stop early.

public class Q2_BubbleSort_Optimized {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        int n = arr.length;

        System.out.print("Before: ");
        printArr(arr);

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

            if (!swapped) {
                break;
            }
        }

        System.out.print("After:  ");
        printArr(arr);
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Time:  Worst/Avg O(n^2), Best O(n) (already sorted)
// Space: O(1)
// Stable: Yes | In-place: Yes