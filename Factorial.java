import java.util.*;
import java.io.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Factorial f=new Factorial();
        int n=sc.nextInt();
        Number[] dp=new Number[n*100];
        int k=f.fact(n);
        int k1=f.factDp(n,dp);
        System.out.println("factorial easy :"+k);
        System.out.println("factorial dp :"+k1);
    }
    public int fact(int n){
        if(n==0||n==1){
            return 1;
        }
        int a=n*fact(n-1);
        return a;
    }
    public int factDp(int n,Number[] dp){
        if(n==0||n==1){
            dp[n]=1;
            return 1;
        }
        dp[n]=n*factDp(n-1,dp);
        return (int)dp[n];
    }
}
