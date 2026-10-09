// SELECTION SORT
// For each i, find the min in arr[i..n-1], swap it into i.

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        int n = arr.length;

        System.out.print("Before: ");
        printArr(arr);

        for (int i = 0; i < n - 1; i++) {      // i = slot to fill
            int minIndex = i;                  // assume arr[i] is min

            for (int j = i + 1; j < n; j++) {  // scan the rest
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;              // store index of smaller value
                }
            }

            int temp = arr[i];                 // swap min into i
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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

// Time: O(n^2) | Space: O(1)