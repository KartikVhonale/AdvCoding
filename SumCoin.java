
public class SumCoin {
    public static void main(String[] args) {
        int k=7;
        // int k=sc.nextInt();
        int[] arr={2,3,5};
        Number[] dp=new Number[k+10]; 
        int sum=0;
        System.out.println("permutaions : "+rec(arr, k, sum));
        System.out.println("permutaions2 : "+recdp(arr, k, sum,dp));
        System.out.println("permutaions3 : "+permTabu(arr, k));
        System.out.println("tabulation : "+combTabu(arr, k));
        System.out.println("combinations : "+combination(arr, k, sum,0));
    }
    public static int rec(int[] arr,int target,int sum){
        System.out.println(target+" "+sum);
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

    public static int recdp(int[] arr,int target,int sum,Number[] dp){
        if(dp[sum]!=null)return (int)dp[sum];
        System.out.println(target+" "+sum);
        if(target<sum)return 0;
        if(target==sum){
            sum=0;
            return 1;
        }
        int a=0;
        for(int i=0;i<arr.length;i++){
            a+=recdp(arr, target, sum+arr[i],dp);
        }
        dp[sum]=a;
        return a;
    }
    
    public static int permTabu(int[] arr,int target){
        int[] dp=new int [target+1];
        dp[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=target;j++){
                if(j-arr[i]>=0)
                dp[j]+=dp[j-arr[i]];
            }
        }
        return dp[target];
    }

    public static int combination(int[] arr,int target,int sum,int k){
        // System.out.println(target+" "+sum+" "+k);
        if(target<sum)return 0;
        if(target==sum){
            sum=0;
            return 1;
        }
        int a=0;
        for(int i=k;i<arr.length;i++){
            a+=combination(arr, target, sum+arr[i],k+i);
        }
        return a;
    }
    public static int combTabu(int[] arr,int target){
        int[] dp=new int [target+1];
        dp[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i];j<=target;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        return dp[target];
    }
}
