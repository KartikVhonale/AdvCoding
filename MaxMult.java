import java.util.*;
import java.io.*;
public class MaxMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        System.out.println("give target");
        int target = sc.nextInt();

        int mult=a[0];
        int maxi=1;
        int count=0;
        int maxcount=0;
        int l=0,r=1;
        while(l<r&&r<n){
            if(mult<target){
                mult*=a[r++];
                count++;
            }
            else{
                mult/=a[l++];
                count--;
            }
            if(mult>maxi){
                maxcount=Math.max(maxcount,count); 
                maxi=mult;
            }
        }
        System.out.println(maxcount);
    }
}
