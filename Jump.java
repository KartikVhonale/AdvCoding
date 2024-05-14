import java.io.*;
import java.util.*;
public class Jump {
    public static void main(String[] args) {
        int k=10;
        Number[] dp = new Number[k+10];
        // System.out.println(Jumpit(k,0));
        // System.out.println("with dp : "+sub.Jumpitdp(a,k,0,sum2,0));
        // System.out.println("with dp : "+Jumpitdp(k,0,dp));
        System.out.println("with tabulation : "+JumpitTab(k,0));
        System.out.println("with ternary operator : "+JumpitTern(k,0));
    }

    public static int Jumpit(int k,int sum){
        System.err.println("run1");
        if(sum==k){
            return 1;
        }
        if(sum>k){
            return 0;
        }
        int a=Jumpit(k,sum+1);
        int b=Jumpit(k, sum+2);
        int c=Jumpit(k, sum+3);
        return a+b+c;
    }
    public static int Jumpitdp(int k,int sum,Number[] dp){
        System.err.println("run2");
        if(dp[sum]!=null)return (int)dp[sum];
        if(sum==k){
            dp[sum]=1;
            return 1;
        }
        if(sum>k){
            dp[sum]=0;
            return 0;
        }
        int a=Jumpitdp(k,sum+1,dp);
        int b=Jumpitdp(k, sum+2,dp);
        int c=Jumpitdp(k, sum+3,dp);
        dp[sum]=a+b+c;
        return a+b+c;
    }
    public static int JumpitTab(int k,int sum){
        //using tabulation
        int[] dp = new int[k+10];
        dp[k+2]=0;
        dp[k+1]=0;
        dp[k]=1;
        for(int i=k-1;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2]+dp[i+3];
        }
        return dp[0];
    }
    public static int JumpitTern(int k,int sum){
        int p=1;
        int q=0,r=0;
        for(int i=k-1;i>=0;i--){
            int temp=p;
            p+=q+r;
            r=q;
            q=temp;
        }
        return p;
    }
}
