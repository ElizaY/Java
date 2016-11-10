package Hw3Post;

import Hw3Post.LinkedList.Node;

public class DataStructureTest <T> {

	public static void main(String[] args) {
		System.out.println("Generic Type Practice");
		
//*************** NodeTest****************	
		System.out.println("\n****NodeTest****");
		Node my_node = new Node();
		//data , next 
		System.out.println("Initial Node: \n" + my_node.toString());
		//node value: this.data-0; next node: this.next-null
		
		Node my_nodeNext = new Node(12, my_node);
		System.out.println("After construct new node: \n" 
							+ my_nodeNext.toString());
		
//*************** LinkedListTest****************			
		System.out.println("\n****ListTest****");
		LinkedList<String> list = new LinkedList <String>();
	    list.addFirst("1");
	    list.addFirst("2");
	    list.addFirst("3");
	    list.addFirst("4");
	    System.out.println("given list is: " +list);


	    System.out.println("reversed list is: " + 
	    		list.reverse());

	    list.addFirst("5");
	    System.out.println("after add first: " + 
	    		list);
	    list.addLast("0");
	    System.out.println("after add last: " + 
	    		list);
//***************** StackTest*****************		
	    System.out.println("\n****StackTest****");
	    Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		System.out.println("Current stack:\n" 
				+ stack.toString());
		stack.push(3);
	    
		System.out.println("Push'3'onto stack:\n" 
				+ stack.toString());
		
		stack.pop();
		
		System.out.println("After pop:\n" 
				+ stack.toString());
		System.out.println("peek item on stack: " 
				+ stack.peek().toString());
	
//***************** QueueTest*****************
		System.out.println("\n****QueueTest****");
		Queue<String> queue = new Queue<String>();
		System.out.println("Initial queue is empty: " 
		+queue.isEmpty());
		queue.add("A ");
		queue.add("B ");
		queue.add("C ");
		System.out.println("After add items,queue is:\n" 
				+ queue.toString());
		queue.remove();
		System.out.println("After remove first items,queue is:\n" 
				+ queue.toString());
		System.out.println("peek item on stack: " 
				+ queue.peek().toString());
	
		
	}
}
	
	

