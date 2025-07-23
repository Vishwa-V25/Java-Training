Question
Convert the given integer to hexadeciaml value.

Solution
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        String hex="";
        char[] ch ="0123456789ABCDEF".toCharArray();
        while(n>0){
            int rem=n%16;
            hex=ch[rem]+hex;
            n=n/16;
        }
        System.out.print("0x"+hex);
    }
}
