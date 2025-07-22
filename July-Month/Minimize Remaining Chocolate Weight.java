Problem Title: Minimize Remaining Chocolate Weight
Tags:Heap (Priority Queue), Greedy, Simulation

📝 Problem Description:
You are given an array weights where weights[i] is the initial weight of the i-th chocolate. Each day, you can pick one chocolate — specifically the heaviest one — eat half of it (rounded down), and put the remaining half back.
You are allowed to perform this operation exactly d times.
Return the minimum possible total weight of all the chocolates after d days.

🔒 Constraints:
1 <= weights.length <= 10^5
1 <= weights[i] <= 10^9
1 <= d <= 10^5

Example 1:
Input:
weights = [10, 20, 7, 8]
d = 3
  
Output:
29
  
Explanation:
Day 1: Pick 20 → eat 10 → put 10 back → heap = [10,10,8,7]
Day 2: Pick 10 → eat 5 → put 5 back → heap = [10,8,7,5]
Day 3: Pick 10 → eat 5 → put 5 back → heap = [8,7,5,5]
Total = 8 + 7 + 5 + 5 = 25

Solution
import java.util.*;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
        int n = sc .nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int d = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:arr){
            queue.add(num);
        }
        for(int i=0;i<d;i++){
            int val=queue.poll();
            int remaining=val/2;
            queue.add(remaining);
        }
        int min=0;
        for(int nums:queue){
            min+=nums;
        }
        System.out.print(min);
    }
}

