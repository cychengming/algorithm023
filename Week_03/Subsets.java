package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length==0)
	        return res;
		backTack(0,nums,new ArrayList<Integer>(),res);		
		return res;

    }

	private void backTack(int index , int[] nums, ArrayList<Integer> list, List<List<Integer>> res) {
		if (index==nums.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		//two branch pick or not
		//not pick current element
		backTack(index+1,nums,list,res);
		//pick current element
		list.add(nums[index]);
		//为啥 index++会出问题
		backTack(index+1,nums,list,res);
		list.remove(list.size()-1);					
	}
}
