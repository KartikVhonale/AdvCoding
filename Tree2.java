import java.util.*;
public class Tree2 {

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
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

        System.out.println(node.right.left.right.data);
    }    
}