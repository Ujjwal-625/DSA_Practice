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
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
     static int lcs(String s1,String s2,int i,int j){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+lcs(s1, s2, i+1, j+i);
        }
        
        return Math.max(lcs(s1, s2, i+1, j), lcs(s1, s2, i, j+1));
     }

    public static int commonChild(String s1, String s2) {
    // Write your code here
        return lcs(s1, s2, 0, 0);
    }

}

public class CommonChild {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
