package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CoinChange {
	//BFS
	 public int coinChange(int[] coins, int amount) {
         if (amount==0) return 0;
		 int count =1;
		 Arrays.sort(coins);
		 Deque<Integer> queue = new LinkedList<>();
         boolean[] visited = new boolean[amount + 1];
	     visited[amount] = true;
		 queue.offer(amount);
		 while(!queue.isEmpty()){
			 int size = queue.size();
			 for(int i=0;i<size;i++){
				 int temp = queue.poll();
				 for (Integer coin:coins){
                     int next = temp-coin;
                     if (next==0) return count;
                     if(next<0)break;
					 if (!visited[next]){
						 queue.offer(next);
                         visited[next] = true;
					 }
				 } 			 
			 }			 
			 count++;			 
		 }
		 return -1;
    }
	//¶¯Ì¬¹æ»® 
	public int coinChangeTwo(int[] coins, int amount) {
	        int max = amount+1;
	        int[] dp = new int[max+1];
	        Arrays.fill(dp,max);
	        dp[0] = 0;
	        for (int i=1;i<=amount;i++){
	            for (int j=0;j<coins.length;j++){
	                if (coins[j]<=i){
	                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
	                }
	            }
	        }
	        return dp[amount]>amount?-1:dp[amount];
	 }

}
