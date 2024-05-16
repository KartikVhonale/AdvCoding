import java.io.*;
import java.util.*;

import javax.sound.midi.SysexMessage;
public class SubsetSum_True {
    public static void main(String[] args) {
        int[] a={4,2,7,1,3};
        int k=10;
        Number[][] dp = new Number[a.length+1][k+10];
        // System.out.println("with dp : "+sub.subsetSumdp(a,k,0,sum2,0,dp));
        System.out.println(SubsetSumTabu(a, k));
    }
    public static boolean SubsetSumTabu(int[] a,int k){
        int n=a.length;
        boolean dp[][]=new boolean[a.length+1][k+1];
        for(int i=0;i<a.length+1;i++){
            for(int j=0;j<k+1;j++){
                if(j==0)dp[i][j]=true;
                else if(i==0)dp[i][j]=false;
                else{

                    int val = a[i-1];
                    if(j<val)
                    dp[i][j]=dp[i-1][j];
                    else 
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-val];
                }
            }
        }
        printmat(dp);
        return dp[a.length][k];
    }
    public static void printmat(boolean[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==false)
                System.out.print("0 ");
                else
                System.out.print("1 ");
            }
            System.out.println();
        }
        System.out.println("___________________");
    }
}