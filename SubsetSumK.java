import java.io.*;
import java.util.*;

public class SubsetSumK {
    public static void main(String[] args) {
        int[] a = { 3, 34, 4, 12, 5, 2 };
        int k = 10;
        Subset_sumK sub = new Subset_sumK();
        int sum2 = calc_sum(a);
        Number[][] dp = new Number[sum2 + 10][a.length + 10];
        // System.out.println(sub.subsetSum(a,k,0,sum2,0));
        System.out.println("with dp : "+sub.subsetSumdp(a,k,0,sum2,0,dp));
    }

    public int subsetSum(int[] a, int k, int sum, int sum2, int i) {
        System.err.println(k + " " + sum + " " + sum2 + " " + i);
        if (k > sum + sum2 || i == a.length)
            return 0;
        if (k == sum + sum2 || k == sum || sum2 == k)
            return 1;
        int l = subsetSum(a, k, sum + a[i], sum2 - a[i], i + 1) + subsetSum(a, k, sum, sum2 - a[i], i + 1);
        return l;
    }

    public int subsetSumdp(int[] arr, int target, int sum, int totalSum, int i, Number[][] dp) {
        System.err.println(k + " " + sum + " " +totalSum + " " + i);
        if (sum == target && i == arr.length) return 1;
        if (i >= arr.length) return 0;
        if (dp[i][sum + totalSum] != null)
            return (int)dp[i][sum + totalSum];

        dp[i][sum + totalSum] = subsetSumdp(arr, target, sum + arr[i], totalSum,i+1, dp)+ subsetSumdp(arr,target,sum - arr[i],totalSum,i, dp);
        return (int)dp[i][sum+totalSum];
    }

    public static int calc_sum(int[] a) {
        int sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            sum2 += a[i];
        }
        return sum2;
    }
}
