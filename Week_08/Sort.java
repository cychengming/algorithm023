package leetcode;

public class Sort {
	/*
	 * 冒泡排序
	 */
	public static int[]  bubbleSort(int[] arr){
		int len = arr.length;
		for(int i=0;i<len-1;i++){
			for(int j=0;j<len-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
				}				
			}			
		}
		return arr;
	}
	
	/*
	 * 选择排序
	 */
	public static int[]  selectionSort(int[] arr){
		int len = arr.length;
		int minIndex,temp;
		for(int i=0;i<len-1;i++){
			minIndex = i;
			for(int j=i+1;j<len;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}				
			}
			temp = arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
	
	/*
	 * 插入排序
	 */
	public static int[]  insertionSort(int[] arr){
		int len = arr.length;
		int minIndex,temp;
		for(int i=0;i<len-1;i++){
			minIndex = i;
			for(int j=i+1;j<len;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j; //将最小数的索引保存
				}				
			}
			temp = arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
	
	
	
	public static void main(String[] args){
		int[] arr = new int[]{5,6,3,8};
		selectionSort(arr);
		//System.out.println(arr);
		for(int num:arr){
			System.out.print(num+" ");
		}
	}
}
