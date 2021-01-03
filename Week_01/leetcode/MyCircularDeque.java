package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MyCircularDeque {
	private Deque<Integer> deque;
	private int size;
	/** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
    	deque = new LinkedList<Integer>();
    	this.size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
    	if(deque.size()<size){
    		return deque.offerFirst(value);
    	}
    	return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(deque.size()<size){
    		return deque.offerLast(value);
    	}
    	return false;
    }
   
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
    	return null!=deque.pollFirst();
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	return null!=deque.pollLast();
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	return null==deque.peekFirst()?-1:deque.peekFirst();
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	return null==deque.peekLast()?-1:deque.peekLast();
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
    	return deque.isEmpty();
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
    	return size ==deque.size(); 
    }

}
