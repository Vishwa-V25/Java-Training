Problem Title: Longest Common Substrings in Sorted Order
  
Problem Statement:
You are given two strings, str1 and str2. Your task is to find all longest common substrings that appear in both strings.
A substring is a contiguous sequence of characters within a string.
If there are multiple such substrings with the maximum possible length, print all of them in lexicographical (sorted) order.
If there is no common substring, print "No common substring found."

Input Format:
The first line contains the string str1.
The second line contains the string str2.

Output Format:
If at least one common substring exists with maximum length, print:
Longest Common Substring(s):
No common substring found.
  
🔒 Constraints:
1 ≤ length(str1), length(str2) ≤ 1000
Strings contain only lowercase or uppercase English letters.


solution
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxlen = 0;
        HashSet<String> substrings = new HashSet<>();
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxlen){
                        maxlen = dp[i][j];
                        substrings.clear();
                        substrings.add(str1.substring(i - maxlen, i));
                    } else if (dp[i][j] == maxlen){
                        substrings.add(str1.substring(i - maxlen, i));
                    }
                }
            }
        }
            List<String> resultList = new ArrayList<>(substrings);
            Collections.sort(resultList); 
            for (String s : resultList){
                System.out.println(s);
            }
        }
    }
