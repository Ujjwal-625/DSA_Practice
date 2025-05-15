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
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */
     
     static int FindPrime(int i) {
    if (i <= 0) return -1; 

    int count = 0;
    int num = 2;

    while (true) {
        boolean isPrime = true;
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            count++;
            if (count == i) {
                return num;
            }
        }
        num++;
    }
}

 public static List<Integer> waiter(List<Integer> number, int q) {
    List<Integer> result = new ArrayList<>();
    List<Integer> a = new ArrayList<>(number);

    for (int i = 1; i <= q; i++) {
        int prime = FindPrime(i);
        Queue<Integer> divisible = new LinkedList<>();
        Stack<Integer> nonDivisible = new Stack<>();

        for (int j = 0; j <a.size(); j++) {
            int num = a.get(j);
            if (num % prime == 0) {
                divisible.add(num);
            } else {
                nonDivisible.push(num); 
            }
        }

        while (!divisible.isEmpty()) {
            result.add(divisible.poll());
        }

        
        a = new ArrayList<>();
        while (!nonDivisible.isEmpty()) {
            a.add(nonDivisible.pop());
        }
    }

    for (int i = a.size()-1; i >=0; i--) {
        result.add(a.get(i));
    }

    return result;
}



}
public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
