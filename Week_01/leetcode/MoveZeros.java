package leetcode;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int j = 0;
		for ( int i=0;i<nums.length;i++){
			if (nums[i]!=0){
				nums[j] = nums[i];
		//相当于交换元素0及非零元素的位置
				if (i!=j){
					nums[i] = 0;
				}				
				j++;				
			}		
		}	 

    }
}
