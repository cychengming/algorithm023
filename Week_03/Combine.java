package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * 这个题和子集及全排列的区别是需要进行剪枝
 * 
 * 
 */
public class Combine {
	 //组合的问题，类似从N个数中间选取K个数总共有多少种选法
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k==0) return res;
        selection(1,n,k,new ArrayList<Integer>(),res);
        return res;
    }

    private void selection(int cur,int n, int k, ArrayList<Integer> list, List<List<Integer>> res) {
      // 剪枝：list长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 list
      
       if (list.size() + (n - cur + 1) < k) {
          return;
       }
       //if (cur>n+1)return;
       //terminate
       if (k==list.size()){
           res.add(new ArrayList<Integer>(list));
           return;
       }
       //not pick current element
        selection(cur+1,n,k,list,res);
       //pick current element
        list.add(cur);
        selection(cur+1,n,k,list,res);
        list.remove(list.size()-1);
    }

}
