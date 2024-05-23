import java.util.*;
public class PriorityQueueworthy {
    public static void main(String[] args) {
        int[] arr={2,10,4,20,1,9,5};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        System.out.println(pq);
    }
}
