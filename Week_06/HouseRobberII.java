package leetcode;

public class HouseRobberII {
	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		int[] dp1 = new int[n];
		// 不抢第一个
		dp1[0] = 0;
		dp1[1] = nums[1];
		for (int i = 2; i < n; i++) {
			// 动态转移方程
			// 类似通项公式
			dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
		}
		//不抢最后一个
		int[] dp2 = new int[n];
		dp2[0] = nums[0];
		dp2[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n - 1; i++) {
			// 动态转移方程
			// 类似通项公式
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
		}
		return Math.max(dp1[n - 1], dp2[n - 2]);

	}

}
