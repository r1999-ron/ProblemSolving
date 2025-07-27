package interview_specific_prep;

public class MissingAndRepeatativeElement {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        int[] result = findTwoElement(arr);
        System.out.println("Repeating: " +  result[0] + " Missing: " + result[1]);
    }

    private static int[] findTwoElement(int[] arr) {
        int n = arr.length;
        int repeat = -1, miss = -1;

        // First pass: identify the repeating element by marking visited indices
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                repeat = Math.abs(arr[i]);
            } else {
                arr[index] = -arr[index];
            }
        }

        // Second pass: identify the missing number (index with positive value)
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                miss = i + 1;
                break;
            }
        }

        return new int[]{repeat, miss};
    }
}
