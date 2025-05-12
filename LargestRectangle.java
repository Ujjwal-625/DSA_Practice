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
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */
     
     static int [] leftSmaller(List<Integer> h){
        Stack <Integer> st=new Stack<>();
        int ans[]=new int[h.size()];
        
        for(int i=0;i<h.size();i++){
            while(!st.empty() && h.get(st.peek())>=h.get(i)){
                st.pop();
            }
            if(st.empty()){
                ans[i]=0;
            }
            else{
                ans[i]=st.peek()+1;
            }
            st.push(i);
        }
        return ans;
     }
     
     static int [] rightSmaller(List<Integer> h){
        Stack <Integer> st=new Stack<>();
        int ans[]=new int[h.size()];
        
        for(int i=h.size()-1;i>=0;i--){
            while(!st.empty() && h.get(st.peek())>=h.get(i)){
                st.pop();
            }
            if(st.empty()){
                ans[i]=h.size()-1;
            }
            else{
                ans[i]=st.peek()-1;
            }
            st.push(i);
        }
        return ans;
     }


    public static long largestRectangle(List<Integer> h) {
        long ans=0;
        
        int [] leftsmallArray=leftSmaller(h);
        int [] rightSmallArray=rightSmaller(h);
    // Write your code here
        for(int i =0;i<h.size();i++){
            long area=(rightSmallArray[i]-leftsmallArray[i]+1)*h.get(i);
            ans=Math.max(ans,area);
        }
        return ans;
    }

}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
