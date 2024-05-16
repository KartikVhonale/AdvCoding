import java.util.*;
public class SumCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=7;
        // int k=sc.nextInt();
        int[] arr={2,3,5};
        int sum=0;
        System.out.println("permutaions : "+rec(arr, k, sum));
        System.out.println("combinations : "+perm(arr, k, sum,0));
    }
    public static int rec(int[] arr,int target,int sum){
        // System.out.println(target+" "+sum);
        if(target<sum)return 0;
        if(target==sum){
            sum=0;
            return 1;
        }
        int a=0;
        for(int i=0;i<arr.length;i++){
            a+=rec(arr, target, sum+arr[i]);
        }
        return a;
    }
    public static int perm(int[] arr,int target,int sum,int k){
        // System.out.println(target+" "+sum+" "+k);
        if(target<sum)return 0;
        if(target==sum){
            sum=0;
            return 1;
        }
        int a=0;
        for(int i=k;i<arr.length;i++){
            a+=perm(arr, target, sum+arr[i],k+i);
        }
        return a;
    }
    public static int combDp(int[] arr,int target,int sum,int k){
        if(target<sum)return 0;
        if(target==sum){
            sum=0;
            return 1;
        }
        int a=0;
        for(int i=k;i<arr.length;i++){
            a+=perm(arr, target, sum+arr[i],k+i);
        }
        return a;
    }
}
