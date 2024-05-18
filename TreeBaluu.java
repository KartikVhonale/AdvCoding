import java.util.Stack;

public class TreeBaluu{
    public static class pair{
        TreeNode root;
        int state;

        pair(TreeNode i, int j){
            this.root=i;
            this.state=j;
        }
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
            this.left=null;https://codeshare.io/jALAEP
            this.right=null;
        }
    }
    public static void preorder(TreeNode head){
        if(head==null){
            return;
        }

        System.out.println(head.val);
        preorder(head.left);
        preorder(head.right);
    }
    public static void printit(TreeNode head){
        if(head==null){
            return;
        }
        if( head.left==null && head.right==null)
        System.out.println(null +" -> "+head.val+" <- "+null);
        else if( head.right==null)
        System.out.println(head.left.val +" -> "+head.val+" <- "+null);
        else  if( head.left==null)
        System.out.println(null +" -> "+head.val+" <- "+head.right.val);
        else
        System.out.println(head.left.val+" -> "+head.val+" <- "+head.right.val);
        printit(head.left);
        printit(head.right);
    }
    public static int numberofnodes( TreeNode head){
        if( head==null){return 0;}
        return 1+numberofnodes(head.left)+numberofnodes(head.right);
    }
    public static int sum( TreeNode head){
        if( head==null){return 0;}
        return head.val+sum(head.left)+sum(head.right);
    }
    public static int maxnode( TreeNode head){
        if( head==null){return 0;}
        int max=Math.max(head.val,Math.max(maxnode(head.left),maxnode(head.right)));
        return max;
    }
    public static int maxedge( TreeNode head){
        if( head==null){return 0;}
        int max=Math.max(0,Math.max(maxedge(head.left),maxedge(head.right)));
        return max+1;
    }

    public static void main(String[] args) {
        

        //Stack declaration

        Stack<pair> stack= new Stack<>();

        Integer arr[]={1,2,4,null,null,5,6,null,null,null,3,7,null,9,null,null,8,null,null};
        TreeNode head = new TreeNode(arr[0]);
        stack.push(new pair(head, 0));
        int i=1;
        while(!stack.isEmpty() && i< arr.length){
            pair currPair=stack.peek();

            if(currPair.state==0){
                if(arr[i]!=null){
                    TreeNode curr=stack.peek().root;
                    curr.left=new TreeNode(arr[i]);
                    i+=1;
                    stack.peek().state+=1;
                    stack.push(new pair(curr.left, 0));
                }
                else{
                    i+=1;
                    stack.peek().state+=1;
                }
            }
            else if(currPair.state==1){
                if(arr[i]!=null){
                    TreeNode curr=stack.peek().root;
                    curr.right=new TreeNode(arr[i]);
                    i+=1;
                    stack.peek().state+=1;
                    stack.push(new pair(curr.right, 0));
                }
                else{
                    i+=1;
                    stack.peek().state+=1;
                }
            }
            else{  // currNode.state==2
                stack.pop();
            }
        }
        preorder(head);
        printit(head);
        System.out.println(numberofnodes(head));
        System.out.println(sum(head));
        System.out.println(maxnode(head));
        System.out.println(maxedge(head)-1);
    }
} 