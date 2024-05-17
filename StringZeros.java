import java.util.Scanner;

public class StringZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Number[][] dp=new Number[2][n+1]; 
        System.out.println(run2(1, n));
        System.out.println(run2dp(1, n,dp));
    }
    public static int run(String s,int n){
        if(n<0)return 0;
        StringBuilder str=new StringBuilder(s);
        if(str.length()>0){
            System.err.println(s);
        char a=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(a=='0'&&str.charAt(i)=='0'){
                s="";
                return 1;
            }
            a=str.charAt(i);
        }}
        int k= run(s+"0",n-1)+run(s+"1", n-1);
        return (k+1);
    }
    public static int run2(int prev,int n){
        // System.err.println("run2");
        if(n==1){
            if(prev==0)return 1;
            return 2;
        }
        int k=0;
        if(prev==0)
        k = run2(1, n-1);
        else
        k= run2(0,n-1)+run2(1, n-1);

        return (k);
    }
    public static int run2dp(int prev,int n,Number[][] dp){
        // System.err.println("run2dp");
        if(n==1){
            if(prev==0)return 1;
            return 2;
        }
        if(dp[prev][n]!=null)return (int) dp[prev][n];
        int k=0;
        if(prev==0)
        k = run2dp(1, n-1,dp);
        else
        k= run2dp(0,n-1,dp)+run2dp(1, n-1,dp);
        dp[prev][n]=k;
        return (k);
    }
    public static int run2tabu(int n){
        int[][] dp=new int[2][n+1];
        
    }
}
