package Hw3Post;
import java.util.*;

import Hw3Post.LinkedList.Node;

public class Queue<T> {
	private Node<T> first;
	private Node<T> last;

	public void add(T item) {
		Node<T> t = new Node<T> (item);
		if (last != null) {
			last.next = t;
		}
		last = t;
		if (first == null) {
			first = last;
		}
	}
	public T remove() {
		if (first == null) throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if (first == null) throw new NoSuchElementException();
		return first.data;
	}
	public boolean isEmpty() {
		return first == null;
	}
	
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> temp = first;
        while(temp != null){
        	result.append(temp.data);
        	temp = temp.next;
        }
        return result.toString();			
	}
	
	
	
}