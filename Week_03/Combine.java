package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * �������Ӽ���ȫ���е���������Ҫ���м�֦
 * 
 * 
 */
public class Combine {
	 //��ϵ����⣬���ƴ�N�����м�ѡȡK�����ܹ��ж�����ѡ��
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k==0) return res;
        selection(1,n,k,new ArrayList<Integer>(),res);
        return res;
    }

    private void selection(int cur,int n, int k, ArrayList<Integer> list, List<List<Integer>> res) {
      // ��֦��list���ȼ������� [cur, n] �ĳ���С�� k�������ܹ��������Ϊ k �� list
      
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
