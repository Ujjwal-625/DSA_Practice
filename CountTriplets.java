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

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
             Map<Long, Long> left = new HashMap<>();
            Map<Long, Long> right = new HashMap<>();
    
    for (long num : arr) {
        right.put(num, right.getOrDefault(num, 0L) + 1);
    }
    
    long count = 0;
    
    for (long x : arr) {
        right.put(x, right.get(x) - 1);
        
        if (x % r == 0) {
            long a = x / r;
            long c = x * r;
            
            long leftCount = left.getOrDefault(a, 0L);
            long rightCount = right.getOrDefault(c, 0L);
            
            count += leftCount * rightCount;
        }
        
        left.put(x, left.getOrDefault(x, 0L) + 1);
    }
    
    return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
