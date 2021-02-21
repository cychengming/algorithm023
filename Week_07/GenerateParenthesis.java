package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * 这道题之前用String拼接的时候不需要进行撤销操作，不是很理解
 * 
 * 
 */
public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		generate(res,new StringBuffer(),0,0,n);
		return res;

    }

	private void generate(List<String> res, StringBuffer path, int left, int right, int n) {
		if(path.length()==2*n){
			res.add(path.toString());
			return;
		}
		if(left<n){
			generate(res,path.append("("),left+1,right,n);
			path.deleteCharAt(path.length()-1);
		}
		if(right<left){
			generate(res,path.append(")"),left,right+1,n);
			path.deleteCharAt(path.length()-1);
		}
		
	}

}
