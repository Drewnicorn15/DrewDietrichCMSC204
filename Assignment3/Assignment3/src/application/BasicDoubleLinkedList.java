package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * @author Drew Dietrich
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	public class Node
	{
		Node prev;
		Node next;
		T data;
		public Node(T d){
			data = d;
			next = null;
			prev = null;
		}

	}

	public class DoubleLinkedListIterator implements ListIterator<T>
	{
		Node left,right;
		/**
		 * Constructor to initialize the current pointer to the head of the BasicDoubleLinkedList. The other attributes defined for this class can be initialized as well.

		 */
		public DoubleLinkedListIterator()
		{
			left = null;
			right = head;
		}
		@Override
		public boolean hasNext()
		{
			return right !=null;
		}

		@Override
		public boolean hasPrevious()
		{
			return left!=null;
		}
		@Override
		/*
		 * @throws NoSuchElementException
		 */
		public T next() throws NoSuchElementException
		{
			left = right;
			if(right == null)
			{
				throw new NoSuchElementException();
			}
			right = right.next;
			return left.data;
		}
		@Override
		public T previous()
		{
			right = left;
			if(left == null)
			{
				throw new NoSuchElementException();
			}
			left = left.prev;
			return right.data;
		}
		@Override
		/**
		 * @throws UnsupportedOperationException
		 */
		public void add(T arg0) throws UnsupportedOperationException{
			throw new UnsupportedOperationException("Unimplemented method 'add'");
		}
			/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");
		}
			/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");
		}
/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException("Unimplemented method 'remove'");
		}
		/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void set(T arg0) throws UnsupportedOperationException{
			throw new UnsupportedOperationException("Unimplemented method 'set'");
		}



	}
	protected  Node head;
	protected  Node tail;
	protected int size;
    public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size =0;
    }

	
	/** 
	 * Returns the number of nodes in the list
	 * @return the size of the linked list 
	 */
	public int getSize()
	{
		return size;
	}
	
	/** 
	 * Adds element to the front of the list and updated the size of the list
	 * @param data the data to be added to the list
	 */
	public void addToFront(T data)
	{
		Node n = new Node(data);
		if(size==0) {
			head =n;
			tail = n;
		}else {
		n.next = head;
		head.prev = n;
		head  = n;
		}
		size++;
	}
	
	/** 
	 * Adds an element to the end of the list and updated the size of the list
	 * @param data the data to be added to the list
	 */
	public void addToEnd(T data)
	{
		
		Node n = new Node(data);
		n.prev = tail;
		if(size==0) 
		{
			head = n;
			tail = n;
		}else {
		
		tail.next = n;
		tail = n;
		
		}
		size++;
	}
	
	/** 
	 * Returns but does not remove the first element from the list.
	 * @return the data element or null
	 */
	public T getFirst()
	{
		return head==null? null: head.data;
	}
	/** 
	 * Returns but does not remove the last element from the list.
	 * @return the data element or null
	 */
	public T getLast()
	{
		return tail==null ? null: tail.data;
	}
	/**
	 * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list. You may not use any of the other retrieval methods associated with the class in order to complete the removal process. You must use the provided comparator (do not use equals) to find those elements that match the target.
	 * @param targetData the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return a node containing the targetData or null
	 */
	public Node remove(T targetData, Comparator<T> comparator){
		Node newHead = head;
		while(newHead != null)
		{
			if(comparator.compare(newHead.data, targetData)==0)
			{
				size--;
				if(newHead.equals(head))
				{
					return new Node(retrieveFirstElement());
				}

				if(newHead.equals(tail))
				{
					return new Node(retrieveLastElement());
				}

				newHead.next.prev = newHead.prev;
				newHead.prev.next = newHead.next;
				newHead.next = null;
				newHead.prev = null;
				return newHead;
			}

			newHead = newHead.next;
		}

		return null;
	}
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null.
	 * @return the data element or null
	 */
	public T retrieveFirstElement()
	{
		if(tail == null)
			return null;
		T toReturn = head.data;
		head = head.next;
		if(head == null)
			return toReturn;
		head.prev = null;
		return toReturn;
	}
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null.
	 * @return the data element or null
	 */
	public T retrieveLastElement()
	{
		if(tail == null)
			return null;
		T toReturn = tail.data;
		tail = tail.prev;
		if(tail == null)
			return toReturn;
		tail.next = null;
		return toReturn;
	}
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> toReturn = new ArrayList<>();
		Node newHead = head;
		while(newHead != null)
		{
			toReturn.add(newHead.data);
			newHead = newHead.next;
		}

		return toReturn;
	}
	/**
	 * This method returns an object of the DoubleLinkedListIterato
	 * @return a ListIterator object
	 */
    @Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
 
}

