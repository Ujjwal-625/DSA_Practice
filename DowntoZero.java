import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
     
    

    public static int downToZero(int n) {
    // Write your code here
    
     Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[n + 1];
    Arrays.fill(visited, -1);

    queue.add(n);
    visited[n] = 0;

    while (!queue.isEmpty()) {
        int current = queue.poll();

        if (current == 0) {
            return visited[0];
        }

        if (visited[current - 1] == -1) {
            visited[current - 1] = visited[current] + 1;
            queue.add(current - 1);
        }

        for (int i = 2; i <= Math.sqrt(current); i++) {
            if (current % i == 0) {
                int next = Math.max(i, current / i);
                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
    return -1;
    
    }

} 

public class DowntoZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
