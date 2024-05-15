import java.io.*;
import java.util.*;
public class Jump2 {
    public static void main(String[] args) {
        int k=6;
        int[] arr={2,3,0,2,2,3};
        System.out.println(Jumpit2(arr));
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
    public static int Jumpit2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n]; 
        dp[n-1] = 0;     
        
        for(int i = n - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE; 
           
            for(int j = 1; j <= nums[i] && i+j < n; j++){ 
                if(dp[i+j] == 0 && i+j != n-1) continue;
                min = Math.min(1 + dp[i+j], min);
                dp[i] = min;
                
            }
        }
        return dp[0];
    }
    public int jumpitBfs(int[] nums) {
        int ans = 0;
        int end = 0;
        int farthest = 0;
    
        for (int i = 0; i < nums.length - 1; ++i) {
          farthest = Math.max(farthest, i + nums[i]);
          if (farthest >= nums.length - 1) {
            ++ans;
            break;
          }
          if (i == end) {   
            ++ans;         
            end = farthest; 
          }
        }
    
        return ans;
      }
      public int JumpitMemo(int ind,int[]nums,int[]dp){
        if(ind==nums.length-1) return 0;
        int min = Integer.MAX_VALUE;
        if(ind>=nums.length) return (int)(1e9);
        if(nums[ind]==0) return (int)(1e9);
        if(dp[ind]!=-1) return dp[ind];


        for(int i=0;i<nums[ind];i++){
            
            min = Math.min(min,1+f(ind+i+1,nums,dp));
            
        }
        return dp[ind]=min;
    }       
   
}