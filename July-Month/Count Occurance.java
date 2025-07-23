Question Title: Count Character Frequencies Using Two Pointers
Problem Statement:
Given a string S, write a program to count and print the number of occurrences of each character in the string using the two-pointer technique (or simulate it using a sliding window approach).
Additionally, extend the problem to print the frequency of characters in every substring window of size K.
  
Input Format:
A single line string S of length 1 <= |S| <= 10^5
An integer K (only for the second part) such that 1 <= K <= |S|

Output Format:
Print the frequency of each character in the string.
For the sliding window part, print each substring of length K and the frequency of characters in that window.

Input 1:
abracadabra
Output 1:
a -> 5  
b -> 2  
r -> 2  
c -> 1  
d -> 1  

Solution 

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch :str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
