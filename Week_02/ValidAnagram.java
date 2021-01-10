package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())return false;
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
	    Arrays.sort(s1);
	    Arrays.sort(t1);
	    //System.out.println(s1.toString());
	    //System.out.println(t1.toString());
	    //Ϊʲô�˴�������String equals ���Ƚ�
	    return Arrays.equals(s1, t1);
    }
	public boolean isAnagramSolutionTwo(String s, String t) {
		if(s.length()!=t.length())return false;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){			
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		for (int i=0;i<t.length();i++){	
			char ch = t.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)-1);
			if (map.get(ch)<0){
				return false;
			}
		}
		return true;
    }
	
}
