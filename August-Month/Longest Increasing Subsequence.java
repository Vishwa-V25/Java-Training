Problem Title: Length of Longest Increasing Subsequence in a String
Problem Statement:
Given a string str consisting of lowercase or uppercase English letters, your task is to find the length of the Longest Increasing Subsequence (LIS) of characters in lexicographical order.
A subsequence is a sequence derived from the string by deleting some or no elements without changing the order of the remaining elements.
The subsequence is strictly increasing, meaning each character is lexicographically greater than the previous one.

Input Format:
A single line containing the string str.

Output Format:
Print a single integer: the length of the longest strictly increasing subsequence.

Constraints:
1 ≤ |str| ≤ 1000

The string contains only English letters (lowercase or uppercase).

Sample Input 1:
abacus
Sample Output 1:
4
  
Explanation:
The longest increasing subsequence is "abcs" which has a length of 4.

Solution
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < str.charAt(i) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}


