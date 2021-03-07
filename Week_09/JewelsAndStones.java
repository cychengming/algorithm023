package leetcode;

public class JewelsAndStones {
	public int numJewelsInStones(String jewels, String stones) {
		int count =0;
        int[] jewelsType = new int[58];
        for(char ch:jewels.toCharArray()){
        	jewelsType[ch-'A']=1;
        }
	    for(char ch:stones.toCharArray()){
        	if(jewelsType[ch-'A']==1){
        		count++;
        	}
	    }
	    return count;
    }
}
