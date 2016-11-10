package Hw3Post;

import java.util.*;
import Hw3Post.LinkedList.Node;

public class Stack<T> {
	
	private Node<T> top;
	
	public Stack() {
		top = null;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	public void push (T item) {
		Node<T> t = new Node<T>(item);//create new node t
		t.next = top;
		top = t;
	}
	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node temp = top;
		while (temp != null) {
			result.append("[").append(temp.data).append("]");
			temp = temp.next;
		}
		return result.toString();
	}
}
