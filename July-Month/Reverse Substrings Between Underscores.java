Problem: Reverse Substrings Between Underscores
Description:
You are given a string s. Reverse each substring that is between two underscores _, and remove the underscores.
If a single underscore does not have a matching closing underscore, treat it as a regular character.

Input Format:
A single line containing the string s.
Output Format:
A single line with the transformed string after reversing substrings between each pair of underscores and removing the underscores.

Example Input 1:
abc_def_ghi
Example Output 1:
abcfedghi
Example Input 2:
hello_world
Example Output 2:
hellodlrow

Solution

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        int n=str.length();
        int first=-1;
        int second=-1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='_'){
                   first=i;
                   second=-1;
                for(int j=i+1;j<n;j++){
                    if(str.charAt(j)=='_'){
                        second=j;
                        break;
                    }
                }
               if (second != -1) {
                    String sub = str.substring(first + 1, second);
                    String reversed = new StringBuilder(sub).reverse().toString();
                    sb.append(reversed);
                    i = second;
               }
                else{
                    if (i < n - 2) {
                        continue;
                    } else {
                        sb.append(str.charAt(i));
                    }
                }
            }
            else{
                 sb.append(str.charAt(i)) ;
            }
        }
        System.out.print(sb.toString());
    }
}
