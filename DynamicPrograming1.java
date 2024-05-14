import java.util.Scanner;

public class DynamicPrograming1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Number[] dp=new Number[n*10];
        DynamicPrograming1 d=new DynamicPrograming1();
        int k1=d.fibo(n);
        System.out.println("simple:"+k1+" ");
        int k=d.fiboDp(n,dp);
        System.out.println("dp:"+k+" ");
    }
    public int fiboDp(int n,Number[] dp){
        if(dp[n]!=null)return (int)dp[n];
        if(n==0||n==1){
            dp[n]=n;
            return n;
       }  
        // System.out.println("hello2");
        int a=fiboDp(n-1,dp)+fiboDp(n-2,dp);
        dp[n]=a;
        return a;
    }
    public int fibo(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        // System.out.println("hello1");
        int a=fibo(n-1)+fibo(n-2);
        return a;
    }
    
}
