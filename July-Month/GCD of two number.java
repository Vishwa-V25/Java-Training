Problem: Greatest Common Divisor (GCD)
Description:
You are given two positive integers a and b. Your task is to find the Greatest Common Divisor (GCD) of these two integers.
The GCD of two integers is the largest integer that divides both of them without leaving a remainder.

Input Format:
A single line containing two space-separated positive integers a and b.

Output Format:
A single integer — the GCD of a and b.

Constraints:
1 <= a, b <= 10^9

Example Input 1:
36 60
Example Output 1:
12
Example Input 2:
14 35
Example Output 2:
7
Explanation:
GCD of 36 and 60 is 12 because 12 is the largest number that divides both 36 and 60.
GCD of 14 and 35 is 7 because 7 is the largest number that divides both 14 and 35.

Solution

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a =sc.nextInt();
        int b=sc.nextInt();
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
            
        }
        System.out.print(a);
    }
}
