// BUBBLE SORT - simple version

public class Q1_BubbleSort_Basic {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        int n = arr.length;

        System.out.print("Before: ");
        printArr(arr);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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

// Time:  O(n^2) always
// Space: O(1)