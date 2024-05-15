import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) {
        int n=3,m=3;
        int[][] arr={{1,2,3},{0,3,2},{1,5,2}};
        Number[][] dp=new Number[n+10][m+10];
        grid(arr,n,m);
        System.out.println(minCost(arr, n-1, m-1));
        System.out.println("with dp : "+minCost2(arr, n-1, m-1,dp));
    }
    public static void grid(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    /* Returns cost of minimum cost path
    from (0,0) to (m, n) in mat[R][C]*/
    static int minCost(int cost[][], int m, int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n]
                    + Math.min(
                    minCost(cost, m - 1, n),
                    minCost(cost, m, n - 1));
    }
    static int minCost2(int cost[][], int m, int n,Number[][] dp)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        if(dp[m][n]!=null)return (int)dp[m][n];
        else if (m == 0 && n == 0)
            dp[m][n]=cost[m][n];
        else
            dp[m][n]=cost[m][n]
                    + Math.min(
                    minCost2(cost, m - 1, n,dp),
                    minCost2(cost, m, n - 1,dp));
            return (int)dp[m][n];
    }
}