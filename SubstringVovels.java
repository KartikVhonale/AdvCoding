import java.util.*;
import java.io.*;
public class SubstringVovels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int count=0;
        int c=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                c++;
                if(c>count)count=c;
            }
            else{
                c=0;
            }
        }
        System.err.println(count);
    }
}
