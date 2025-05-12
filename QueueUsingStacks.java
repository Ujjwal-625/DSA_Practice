import java.io.*;
import java.util.*;

public class QueueUsingStacks {


 static class QueueUsingStack{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    
    void enqueue(int val){
       s1.push(val);
    }
    
    int deque(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        
        if(s2.empty())return -1;
        return s2.pop();
    }
    
    int getFront(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        
        if(s2.empty())return -1;
        return s2.peek();
    }
    
}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc=new Scanner(System.in);
        int queries=sc.nextInt();
        
        QueueUsingStack q=new QueueUsingStack();
        while(queries>0){
            int op=sc.nextInt();
            if(op==2){
                //deque
                q.deque();
            }
            else if(op==1){
                int val=sc.nextInt();
                q.enqueue(val);
            }
            else{
                System.out.println(q.getFront());
            }
            queries--;
        }
    }
}
