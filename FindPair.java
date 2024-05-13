import java.util.*;
import java.io.*;

public class FindPair {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.err.println("give the target");
        int x=sc.nextInt();
        three(a, x);
    }
    public static void one(int[] a,int x){
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                if(a[j]+a[i]==x){
                    System.err.println(a[j]+" + "+a[i]+" = "+x);
                }
            }
        }
    }
    public static void two(int[] a,int x){
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            int k=x-a[i];
            if(Arrays.binarySearch(a,k)>=0){
                System.err.println(k+" + "+a[i]+" = "+x);
            }
        }
    }
    public static void three(int[] a,int x){
        //two pointer
        int l,r;
        Arrays.sort(a);
        r=a.length-1;
        l=0;
        while(l<=r){
            if(a[l]+a[r]==x){
                System.err.println(a[r]+" + "+a[l]+" = "+x);
                l++;
                r--;
            }
            else if(a[l]+a[r]>x){
                r--;
            }
            else{
                l++;
            }
        }
    }
    public static void four(){
        
    }
}
