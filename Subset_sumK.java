
public class Subset_sumK {
    public static void main(String[] args) {
        int[] a={3,34,4,12,5,2};
        int k=10;
        Subset_sumK sub = new Subset_sumK();
        int sum2 = calc_sum(a);
        Number[][] dp = new Number[sum2*2+10][a.length+10];
        System.out.println(sub.subsetSum(a,k,0,sum2,0));
        // System.out.println("with dp : "+sub.subsetSumdp(a,k,0,sum2,0,dp));
    }

    public int subsetSum (int[] a,int k,int sum,int sum2,int i){
        System.err.println(k+" "+sum+" "+sum2+" "+i);
        if(k>sum+sum2||i==a.length)return 0;
        if(k==sum+sum2||k==sum||sum2==k)return 1;
        int l=subsetSum(a, k, sum+a[i], sum2-a[i], i+1)+subsetSum(a, k, sum, sum2-a[i], i+1);
        return l;
    }
    public int subsetSumdp (int[] a,int k,int sum,int sum2,int i,Number[][] dp){
        System.err.println(k+" "+sum+" "+sum2+" "+i);
        if(dp[sum2+sum][i]!=null) return (int)dp[sum2][i];
        if(k>sum+sum2||i==a.length){
            dp[sum2][i]=0;
            return 0;
        }
        if(k==sum+sum2||k==sum||sum2==k){
            dp[sum2][i]=1;
            return 1;
        }
        dp[sum2][i]=subsetSum(a, k, sum+a[i], sum2-a[i], i+1)+subsetSum(a, k, sum, sum2-a[i], i+1);
        return (int)dp[sum2][i];
    }
    public int subsetSumTabu(int[] a){
        
        return 0;
    }
    public static int calc_sum(int[] a){
        int sum2=0;
        for(int i=0;i<a.length;i++){
            sum2+=a[i];
        }
        return sum2;
    }
}