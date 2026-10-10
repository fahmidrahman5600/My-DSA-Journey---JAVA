public class Q7_SelectionSort_FindTheLargestApproach {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        int n = arr.length;

        System.out.print("Before: ");
        printArr(arr);

        for (int i = arr.length-1; i > 0; i--) {      // i = slot to fill
            int maxIDX = i;                  // assume arr[i] is min

            for (int j = i - 1; j >= 0; j--) {  // scan the rest
                if (arr[j] > arr[maxIDX]) {
                    maxIDX = j;              // store index of smaller value
                }
            }

            int temp = arr[i];                 // swap max into i
            arr[i] = arr[maxIDX];
            arr[maxIDX] = temp;
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
