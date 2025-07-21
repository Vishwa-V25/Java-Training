97. Interleaving String
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
  
Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 
Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.

____________________________________________________________________________________________________________________________________________________________________

Solution

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        if((l1+l2)!=l3){
            return false;
        }
        Boolean[][] dp=new Boolean[l1][l2]; 
        return helper(s1,0,s2,0,s3,0,dp);
    }
    public boolean helper(String s1,int l1,String s2,int l2,String s3,int l3,Boolean[][] dp){
        if(l3==s3.length()){
            return true;
            
        if(l1<s1.length()&& l2<s2.length()&&dp[l1][l2]!=null){
            return dp[l1][l2];
        }
        char ch=s3.charAt(l3);
        if(l1<s1.length() && l2<s2.length()&& (s1.charAt(l1)==ch&&s2.charAt(l2)==ch)){
            boolean ok=helper(s1,l1+1,s2,l2,s3,l3+1,dp);
            if(ok){
                dp[l1][l2]=true;
                return true;
            }
            ok=helper(s1,l1,s2,l2+1,s3,l3+1,dp);
            dp[l1][l2]=ok;
            return ok;

        }
        else if(l1<s1.length() && s1.charAt(l1)==ch){
            boolean ok=helper(s1,l1+1,s2,l2,s3,l3+1,dp);
            if(l2<s2.length()){
                dp[l1][l2]=ok;
            }
            return ok;

        }
        else if(l2<s2.length() && s2.charAt(l2)==ch){
            boolean ok=helper(s1,l1,s2,l2+1,s3,l3+1,dp);
            if(l1<s1.length()){
                dp[l1][l2]=ok;
            }
            return ok;
        }
        return false;
    }
}
