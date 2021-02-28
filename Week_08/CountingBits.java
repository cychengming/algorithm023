package leetcode;

public class CountingBits {
	/*
	 * 
	 * 
	 */
	public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i=0;i<=num;i++){
            ans[i] = popCount(i);
        }
        return ans;
    }
    public int popCount(int i){
        int count=0;
        while(i!=0){
            count++;
            i &=i-1;
        }
        return count;
    }

}
