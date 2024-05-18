import java.util.*;
import java.io.*;
public class Stack1 {
    public static class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        Pair(){
            this.i=-1;
            this.j=-1;
        }
        @Override
        public String toString() {
            return  "Pair {" + "i=" + this.i + ",j=" + this.j + "}";

        }
    }
    public static void main(String[] args) {
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(1,2));
        st.push(new Pair(3,4));
        st.push(new Pair(5,6));
        st.push(new Pair(7,8));
        while (st.isEmpty() == false) {
            System.out.println( st.pop());

        }

    }
}
