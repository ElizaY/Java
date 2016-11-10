package Hw3Post;
import java.util.*;


public class LinkedList<T> implements Iterable<T> {
	private Node<T> head;
	
	public LinkedList(){
		head = null; 
		//empty list with head node null
	}
	public LinkedList(Node<T> node) {
		head = new Node<T> (node);
	}
	public LinkedList(T[] arr) {//set array of nums to list
		if (arr.length == 0)
			head = null;
		else {
			head = new Node<T>(arr[0]);
			Node<T> temp = head;
			Node<T> next;
			for (int i = 1; i<arr.length; i++) {
				next = new Node<T>(arr[i]);
				while(temp.getNext() != null) {
					temp = temp.getNext();}
				temp.setNext((T) next);
			}
		}
		System.out.println(head.toString());
	}
	//public LinkedList(Object data) {

	public T getHead() {
		return head.data;//get head node data
	}
	public T removeHead() {
		T temp = getHead();
		head = head.next;
		return temp;
		}
	public void addFirst(T item) {
		head = new Node<T>(item, head);
		}
	public void addLast(T item) {
		if( head == null)
			addFirst(item);
		else{
		Node<T> tmp = head;
		while(tmp.next != null) tmp = tmp.next;
		tmp.next = new Node<T>(item, null);
		}
	}
	public LinkedList<T> reverse() {
	    LinkedList<T> list = new LinkedList<T>();
	    Node<T> tmp = head;
	    while(tmp != null){
	    	list.addFirst( tmp.data );
	        tmp = tmp.next;
	      }
	      return list;
	   }	
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Object x:this) {
			result.append(x+" ");}
		return result.toString();
		
	}
	//********************************
	public static class Node<T> {
		T data;
		Node<T> next;
	
		public Node() {
			this.next = null;
		}

		public Node(T data) {
			this.data = data;
			next = null;
		}
		public Node(Node<T> node) {
			this.data = (T) node.data;
		}
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		public void setNext(T data) {
			this.data = data;	
		}
		public Node<T> getNext() {
			return next;
		}

		public T getData() {
			return data;
		}
		public String toString() {
	        return "Data:[" + this.data + "] Next:[" + this.next + "]";
		}
	}

//	@Override
	   public Iterator<T> iterator()
	   {
	      return new LinkedListIterator();
	   }

	   private class LinkedListIterator  
	   implements Iterator<T>
	   {
	      private Node<T> nextNode;

	      public LinkedListIterator()
	      {
	         nextNode = head;
	      }

	      public boolean hasNext()
	      {
	         return nextNode != null;
	      }

	      public T next()
	      {
	         if (!hasNext()) throw new NoSuchElementException();
	         T res = nextNode.data;
	         nextNode = nextNode.next;
	         return res;
	      }

	      public void remove() { throw new UnsupportedOperationException(); }
	   }
}



