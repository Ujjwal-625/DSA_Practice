import java.io.*;
import java.util.*;

public class QueueAndStacks {
    // Write your code here.
    
     Stack<Character> st=new Stack<>();
     Queue<Character> q=new LinkedList<>();
    
     void pushCharacter(char ch){
        st.add(ch);
    }
    
     void enqueueCharacter(char ch){
        q.add(ch);
    }
    
     char popCharacter(){
        return st.pop();
    }
    
    char dequeueCharacter(){
        return q.poll();
    }
    
    

