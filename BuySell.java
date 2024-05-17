public class BuySell {
    public static void main(String[] args) {
        int[] a={2,8,12,7,6,4,6,8,15,1,2};
        System.out.println(run(a));
        System.out.println(run2(a));
    }
    public static int run(int[] a){
        int n = a.length;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        int p=0;
        for(int i=0;i<n;i++) {
            if(maxi<a[i]){
                p=i;
                maxi=a[i];
            }
        }
        for(int i=0;i<p;i++) mini=Math.min(mini,a[i]);
        return (maxi-mini);
    }
    public static int run2(int[] a){
        int n = a.length;
        int p=a[0];
        int maxi=0;
        for(int i=2;i<n;i++) {
            if(a[i-1]>a[i]){
                maxi+=a[i-1]-p;
                p=a[i];
            }
            if(a[i]<p)p=a[i];
            if(i==n-1){
                if(p<a[i])maxi+=a[i]-p;
            }
        }
        
        return maxi;
    }
}
