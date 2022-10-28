package stacks;

import java.util.EmptyStackException;

public class Stack {
	
	private class ListNode{
		 private int data;
		 private ListNode next;
		 
		 public ListNode(int data) {
			 this.data = data;
		 }
	 }
	
	 private ListNode top;
	 private int length;
	 
	 public Stack() {
		 top = null;
		 length = 0;
	 }
	 
	 public int length() {
		 return length;
	 }
	 
	 public boolean isEmpty() {
		 return length==0;
	 }
	 
	 public void push(int data) {
		 ListNode temp = new ListNode(data);
		 temp.next = top;
		 top = temp;
		 length++;
	 }
	 
	 public int pop() {
		 if(isEmpty()) {
			 throw new EmptyStackException();
		 }
		 int result = top.data;
		 top = top.next;
		 length--;
		 return result;
	 }
	 
	 public int peek() {
		 if(isEmpty()) {
			 throw new EmptyStackException();
		 }
		 return top.data;
	 }
	 
	 public static void main(String[] args) {
		Stack st = new Stack();
		
		st.push(10);
		st.push(15);
		st.push(20);
		System.out.println(st.pop());
		System.out.println(st.peek());
	}
	 
}
