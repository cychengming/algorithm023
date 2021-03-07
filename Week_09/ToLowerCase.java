package leetcode;

public class ToLowerCase {
	public String toLowerCase(String str) {
       //return str.toLowerCase();
		char[] arr = str.toCharArray();
		for(int i=0;i<arr.length;i++){			
			if(arr[i]>='A'&&arr[i]<='Z'){
				arr[i] +=32;
			}
		}
		return String.valueOf(arr);
    }
	public int lengthOfLastWord(String s) {
		String[] arr = s.split(" ");
		return arr.length==0?0:arr[arr.length-1].length();
		
		/*int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;*/
    }
	
}
