💡 Question: Array Transformation Based on Neighboring Elements
You are given an array of integers of size N. Transform the array according to the following rules:
The first element is replaced with the second element.
For each element from index 1 to N-2 (inclusive), replace it with the sum of the previous original element and the next element.
The last element is replaced with the previous original element.
Implement a program that takes the array as input and applies the above transformation in-place (i.e., without using an additional array).

🔢 Input Format:
The first line contains an integer N — the size of the array.
The second line contains N space-separated integers — the elements of the array.

📤 Output Format:
Print the transformed array as a single line of space-separated integers.

📌 Constraints:
2 <= N <= 1000
-10^5 <= arr[i] <= 10^5

Sample Input:
5
1 2 3 4 5

Sample Output:
2 4 6 8 4

Solution

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int prev=arr[0];
        for(int i=0;i<n;i++){
           if(i==0){
              prev=arr[i];
               arr[i]=arr[i+1];
           }
           else if(i<n-1){
              int current=arr[i];
               arr[i]=prev+arr[i+1];
               prev=current;
           }
           else{
               arr[i]=prev;
           }
        }
        for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
    }
}
