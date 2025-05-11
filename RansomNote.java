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
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
    
    if(magazine.size()<note.size()){
        System.out.println("No");
        return ;
    }
    
    Map<String,Integer> magazineMap=new HashMap<>();
    Map<String ,Integer> noteMap=new HashMap<>();
    for(String i: magazine){
        if(magazineMap.containsKey(i)){
            magazineMap.put(i, magazineMap.get(i)+1);
        }
        else{
            magazineMap.put(i,1);
        }
    }
    
    for(String i: note){
        if(noteMap.containsKey(i)){
            noteMap.put(i, noteMap.get(i)+1);
        }
        else{
            noteMap.put(i,1);
        }
    }
    
    for(String key:noteMap.keySet()){
        if(magazineMap.containsKey(key)){
            if(noteMap.get(key)>magazineMap.get(key)){
                System.out.println("No");
                return;
            }
        }
        else{
            System.out.println("No");
            return ;
        }
    }
    
    System.out.println("Yes");

    }

}

public class RansomNote{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
