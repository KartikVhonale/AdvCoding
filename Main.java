import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args){
        StringBuilder str= new StringBuilder();
        String s;
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        str.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=str.charAt(str.length()-1)){
                str.append(s.charAt(i));
            }
        }
        System.out.println(str);
    }
}