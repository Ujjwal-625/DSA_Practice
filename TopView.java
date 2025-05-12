import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class  TopView {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
    static class Pair{
        Node node;
        int h;
        public Pair(Node node,int h){
            this.node=node;
            this.h=h;
        }
    }
    
    
	public static void topView(Node root) {
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        
        Map<Integer,Integer> mp=new TreeMap<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            
            if(!mp.containsKey(p.h)){
                mp.put(p.h, p.node.data);
            }
            
            if(p.node.left!=null){
               q.add(new Pair(p.node.left, p.h-1));
            }
            if(p.node.right!=null){
                q.add(new Pair(p.node.right, p.h+1));
            }
        }
        
        for(int i:mp.keySet()){
            System.out.print(mp.get(i)+" ");
        }
        
      
      
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
