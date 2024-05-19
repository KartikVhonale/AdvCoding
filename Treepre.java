import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Treepre {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void inorder(Node head, ArrayList<Integer> alist){
        if(head == null)return;
        inorder(head.left, alist);
        alist.add(head.data);
        inorder(head.right, alist);
    }
    public static void preorder(Node head, ArrayList<Integer> alist){
        if(head == null)return;
        alist.add(head.data);
        preorder(head.left, alist);
        preorder(head.right, alist);
    }
    public static void postorder(Node head, ArrayList<Integer> alist){
        if(head == null)return;
        postorder(head.left, alist);
        postorder(head.right, alist);
        alist.add(head.data);
    }


    //find node
    public static boolean find(Node head,int target){
        if(head == null)return false;
        if(target==head.data)return true;
        return(find(head.left, target)||
        find(head.right, target));
    }
    //find node optimized
    public static boolean find2(Node head,int target){
        if(head == null)return false;
        if(target==head.data)return true;
        if(find2(head.left, target)) return true;
        if(find2(head.right, target)) return true;
        return false;
    }
    //path to the node
    public static boolean path(Node head,int target,ArrayList<Integer> a){
        if(head == null)return false;
        if(target==head.data){
            a.add(head.data);
            return true;
        }
        if(path(head.left, target,a)){
            a.add(head.data);
            return true;
        }
        if(path(head.right, target,a)){
            a.add(head.data);
            return true;
        }
        return false;
    }



    //orders combined 
    public static void order(Node head, ArrayList<Integer> prelist, ArrayList<Integer> inlist, ArrayList<Integer> postlist){
        if(head == null)return;
        prelist.add(head.data);
        order(head, prelist, inlist, postlist);
        inlist.add(head.data);
        order(head, prelist, inlist, postlist);
        postlist.add(head.data);
    }
    public static void printa(ArrayList<Integer> a){
        for(int i=0;i<a.size();i++){
            System.err.println(a.get(i));
        }
    }


    //level order
    public static void level(Node head,Queue<Integer> q,int count){
       
        if(head == null)return;
        while(!q.isEmpty()&&count!=0){
            System.out.print(q.peek()+ ",");
            q.remove();
            count--;
        }
        if(count==0)System.out.println();     
        if(head.left!=null){
            q.add(head.left.data);
            count++;
        }
        if(head.right!=null){
            q.add(head.right.data);
            count++;
        }
        
        level(head.left,q,count);
        level(head.right,q,count);
       
    }
    public static void level(Node head){
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        while (q.size()>0) {
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Node temp = q.remove();
                System.out.print(temp.data+" ");
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            System.out.println();
        }
    }

    //print elements at a level
    public static void levelElement(Node head,int level){
        if(head==null)return;
        if(level==0){
            System.out.print(head.data+" ");
            return;
        }
        levelElement(head.left, level-1);
        levelElement(head.right, level-1);
        return;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> alist=new ArrayList<>();
        Integer[] arr = {1, 2, 4, null, null, 5, 6, null, null, null, 3, 7, null, 9, null, null, 8, null, null};

        Node node = new Node(arr[0], null, null);
        int idx = 1;

        Stack<Pair> stack = new Stack<>();
        Pair p = new Pair(node, 0);
        stack.push(p);

        while(stack.size() > 0){
            Pair p1 = stack.peek();     // node, state

            if(p1.state == 0){      // lc
                if(arr[idx] == null){
                    idx++;
                    p1.state++;
                }
                else{           // arr[idx] != null
                    //1
                    Node temp = new Node(arr[idx], null, null);
                    //2
                    p1.node.left = temp;
                    //3
                    idx++;
                    //4
                    p1.state++;
                    //5
                    Pair p2 = new Pair(temp, 0);
                    stack.push(p2);
                }
            }
            else if(p1.state == 1){     // rc
                if(arr[idx] == null){
                    idx++;
                    p1.state++;
                }
                else{           // arr[idx] != null
                    //1
                    Node temp = new Node(arr[idx], null, null);
                    //2
                    p1.node.right = temp;
                    //3
                    idx++;
                    //4
                    p1.state++;
                    //5
                    Pair p2 = new Pair(temp, 0);
                    stack.push(p2);
                }
            }
            else{           // 2
                stack.pop();
            }
        }

        inorder(node, alist);
        System.out.println("inorder : "+alist);
        alist.clear();
        preorder(node, alist);
        System.out.println("preorder : "+alist);
        alist.clear();
        postorder(node, alist);
        System.out.println("postorder : "+alist);
        
        
        // //all in one
        // ArrayList<Integer> pre=new ArrayList<>();
        // ArrayList<Integer> in=new ArrayList<>();
        // ArrayList<Integer> post=new ArrayList<>();
        // System.out.println("preorder : "+pre);
        
        
        //find element
        System.out.println(find(node, 6));
        ArrayList<Integer> path_1=new ArrayList<>();
        path(node, 9, path_1);
        System.out.println("path : "+path_1);

        // level(node);
        levelElement(node,2);



    }
}
