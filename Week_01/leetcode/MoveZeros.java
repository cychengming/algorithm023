package leetcode;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
        int j = 0;
		for ( int i=0;i<nums.length;i++){
			if (nums[i]!=0){
				nums[j] = nums[i];
                //�൱�ڽ���Ԫ��0������Ԫ�ص�λ��
				if (i!=j){
					nums[i] = 0;
				}				
				j++;				
			}		
		}	 

    }
}
