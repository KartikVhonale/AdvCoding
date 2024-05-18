import java.util.*;
public class Tree1 {
    //tree node
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
     
        public TreeNode(){
        }
        public TreeNode(int d){
            data = d;
            this.left= null;
            this.right = null;
        }
        public TreeNode(int d, TreeNode l, TreeNode r){
            this.data = d;
            this.left= l;
            this.right = r;
        }
        public void display(){
           System.out.print("("+data+ ")");
        }
     }
     //pair
     public static class pair{
        TreeNode root;
        int state;

        pair(TreeNode i, int j){
            this.root=i;
            this.state=j;
        }
    }
    public static void main(String[] args) {
        int i=0;
        Integer[] a={1,2,4,null,null,5,6,null,null,null,3,7,null,9,null,null,8,null,null};
        Stack<pair> st =new Stack<>();
        TreeNode root = new TreeNode(a[0]);
        pair  p = new pair(root,0);
        st.push(p);
        while(!st.isEmpty()&&i<a.length){
            pair currPair=st.peek();

            if(currPair.j==0){
                if(a[i]!=null){
                    TreeNode curr=st.peek().n;
                    curr.left=new TreeNode(a[i]);
                    i+=1;
                    st.peek().j+=1;
                    st.push(new pair(curr.left, 0));
                }
                else{
                    i+=1;
                    st.peek().j+=1;
                }
            }//KYA KARNA HEI
            else if(currPair.j==1){
                if(a[i]!=null){
                    TreeNode curr=st.peek().n;
                    curr.right=new TreeNode(a[i]);
                    i+=1;
                    st.peek().j+=1;
                    st.push(new pair(curr.right, 0));
                }
                else{
                    i+=1;
                    st.peek().j+=1;
                }
            }
            else{  // currNode.j==2
                st.pop();
            }
        }
        n.data = 1;

    }
}