package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length==0) return res;
		boolean[] visited = new boolean[nums.length];
		backTrack(0,nums,visited,new ArrayList<Integer>(),res);		
		return res;	    
    }

	private void backTrack(int depth, int[] nums,boolean[] visited,ArrayList<Integer> list, List<List<Integer>> res) {
		//terminate
		if (depth==nums.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i=0;i<nums.length;i++){
			if (!visited[i]){
				list.add(nums[i]);
				visited[i] =true;
				backTrack(depth+1,nums,visited,new ArrayList<Integer>(),res);
				//撤销对当前值得选择以此来进入下一个分支
				visited[i] = false;
				list.remove(list.size()-1);
			}			
		}
		
		
	}
}
