import java.io.*;
import java.util.*;
public class Jump2 {
    public static void main(String[] args) {
        int k=6;
        int[] arr={2,3,0,2,2,3};
        Number[] dp = new Number[k+10];
        System.out.println(Jumpit2(arr,0));
    }

    public static int Jumpit(int[] arr,int i){
        if(i>arr.length){
            return 0;
        }
        if(arr.length==i){
            return 1;
        }
        int a=0;
        for(int j=1;j<=arr[i];j++){
            a+=Jumpit(arr, i+j);
        }
        return a;
    }
    public static int Jumpit2(int[] arr){
        int a=0;
        int n=arr.length;
        int[] dp=new int[arr.length+10];
        dp[n+1]=0;
        dp[n+2]=0;
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2]+dp[i+3];
        }
        return a;
    }
   
}
