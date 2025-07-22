🔹 Problem Title:
Check Palindrome Rearrangement Possibility
🔸 Problem Statement:
You are given a string str consisting of lowercase English letters. Determine whether the characters of the string can be rearranged to form a palindrome.
A palindrome is a string that reads the same forwards and backwards.
Based on the character frequencies, print:
"Even length" – if all characters appear an even number of times (can form a palindrome of even length).
"odd length" – if exactly one character has an odd frequency (can form a palindrome of odd length).
"No palindrome" – if more than one character has an odd frequency, so no palindrome is possible.
  
Input Format:
A single string str
(1 ≤ str.length ≤ 10⁵)
Consisting only of lowercase English letters 'a' to 'z'.

Output Format:
Print one of the following based on the conditions:
"Even length"
"odd length"
"No palindrome"

 Example 1:
Input:
aabb
Output:
Even length
Explanation: 'a' and 'b' both occur twice. A valid palindrome like "abba" can be formed.

Example 2:
Input:
aabbc

Output:
odd length
Explanation: 'a' and 'b' occur twice, 'c' occurs once. Only one odd count → can form palindrome like "bacab".

Example 3:
Input:
aabcd

Output:
No palindrome
Explanation: More than one character has odd counts. No palindrome possible.

🔹 Constraints:
1 ≤ str.length ≤ 10⁵

str contains only lowercase letters 'a' to 'z'.

Solution

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int flag = 0;

        for (char ch : str.toCharArray()) {
            flag ^= (1 << (ch - 'a')); 
        }

        if (flag == 0) {
            System.out.print("Even length");
        } else if ((flag & (flag - 1)) == 0) {
            System.out.print("odd length");
        } else {
            System.out.print("No palindrome");
        }
    }
}


