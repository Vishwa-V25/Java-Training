✅ Problem Statement: Common Character in N-1 Strings
You are given N strings. Your task is to find the first character (in order of appearance from the first string) that is common to at least (N - 1) strings among the given N strings.
Consider only characters that appear in the first string.
Print the first such character found.
You may assume that each string is non-empty and contains only lowercase English letters.

📥 Input Format
The first line contains an integer N — the number of strings.
The next N lines contain one string each.

📤 Output Format
Print a single character — the one that appears in at least N - 1 strings.

🔒 Constraints
2 ≤ N ≤ 100
1 ≤ Length of each string ≤ 100

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
        if(map.getOrDefault(ch,0)==str.length-1){
            System.out.println(ch);
            break;
        }  
      } 
    }
}
