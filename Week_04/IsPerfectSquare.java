package leetcode;

public class IsPerfectSquare {
	//此题考查点 二分查找
	public boolean isPerfectSquare(int num) {
       if (num<2)return true;
       //为了防止溢出，需要用long
       long left = 2,right = num/2;
       while(left<=right){
    	   long mid = left+(right-left)/2;
    	   if(mid*mid==num)return true;
    	   if(mid*mid>num)right = mid-1;
    	   if(mid*mid<num)left = mid+1;   	   
       }		
		return false ;
    }
	 /*public boolean isPerfectSquare(int num) {
	        for (double  i=1;i*i<=num;i++){
		        	if (i*i==num){
		        		return true;
		        	}	        	
		        }
		        return false;
		    }
	        int i = 1;
	        while (num > 0) {
	            num -= i;
	            i += 2;
	        }
	        return num == 0;
	    }*/
}
