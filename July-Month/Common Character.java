🔤 Find One Common Character in All Strings
  
Problem Statement:
You are given an array of strings words, where each string consists of only lowercase English letters.
Your task is to find and print one character that is common to all the strings in the array.
If multiple characters are common, return any one of them.
If no common character exists, print No common character.
  
Example 1:
Input:  ["bella", "label", "roller"]
Output: l
(l and e are common; either is valid.)

Example 2:
Input:  ["cat", "dog", "fish"]
Output: No common character

_______________________________________________________________________________________________________________________________________________________________________

Solution

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner (System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.nextLine();
        }
        HashMap<Character,Integer> map =new HashMap<>();
        for(char ch:str[0].toCharArray()){
                if(!map.containsKey(ch)){
                    map.put(ch,1);
                }
        }
       for(int i=1;i<str.length;i++){
          for(char ch:str[i].toCharArray()){
              if(map.containsKey(ch) && i==map.get(ch)){
                  map.put(ch,map.get(ch)+1);
              }
           }
       }  
      for(char ch:str[0].toCharArray()){
        if(map.getOrDefault(ch,0)==str.length){
            System.out.println(ch);
        }  
      
      } 
    }
}
