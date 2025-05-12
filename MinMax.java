import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMax {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        int n = arr.length;
    long[] res = new long[n];
    int[] left = new int[n];
    int[] right = new int[n];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
            st.pop();
        }
        left[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }

    st.clear();

    for (int i = n - 1; i >= 0; i--) {
        while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
            st.pop();
        }
        right[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }

    long[] ans = new long[n + 1];
    for (int i = 0; i < n; i++) {
        int len = right[i] - left[i] - 1;
        ans[len] = Math.max(ans[len], arr[i]);
    }

    for (int i = n - 1; i >= 1; i--) {
        ans[i] = Math.max(ans[i], ans[i + 1]);
    }

    long[] result = new long[n];
    for (int i = 0; i < n; i++) {
        result[i] = ans[i + 1];
    }

    return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
