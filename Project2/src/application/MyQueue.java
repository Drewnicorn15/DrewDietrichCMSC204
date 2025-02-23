package application;

import java.util.ArrayList;
/**
 *  @author Andrew Dietrich
 */
public class MyQueue<T> implements QueueInterface<T>{
    private int maxSize;
    public ListNode<T> head;
    private ListNode<T> tail;
    private int size;
    public MyQueue(int Msize)
    {
        head = null;
        tail = head;
        maxSize = Msize;
        size = 0;
    }
    public MyQueue()
    {
        tail = null;
        head = null;
        maxSize = 100;
        size =0;
    }
	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 
	 */

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
    @Override
    public boolean isEmpty() {
        return head==null; 
    }

    /**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
    @Override
    public boolean isFull() {
        return false;
    }

	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
    @Override
	public T dequeue() throws QueueUnderflowException
    {
        if(isEmpty())
            throw new QueueUnderflowException();
        T toReturn = head.getValue();
        head = head.getNext();
        
        size--;
        return toReturn;
    }
        
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
    @Override
	public int size(){
        return size;
    }
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 */
    @Override
	public boolean enqueue(T e)
    {
        size++;
        if(isEmpty())
        {
            head = new ListNode<T>(e,null);
            tail = head;
            return  true;
        }{
        tail.setNext(new ListNode<T>(e,null));
        tail = tail.getNext();
        return true;
        }
    }
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
    @Override
	public String toString()
    {
        if(size ==0) return "";
        ListNode<T> headv2 = head;
        String toRetuString = "";
        while(headv2 != null)
        {
            toRetuString +=headv2.getValue();
            headv2 = headv2.getNext();
            
            
        }
        return toRetuString;
    }
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
    @Override
	public String toString(String delimiter)
    {
        if(size ==0) return "";
        ListNode<T> headv2 = head;
        String toRetuString = "";
        while(headv2 != null)
        {
            
            toRetuString += delimiter+headv2.getValue();
            headv2 = headv2.getNext();
            
        }
        return toRetuString.substring(1);
    }
    
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
      @Override
	public void fill(ArrayList<T> list){
        ArrayList<T> copy = new ArrayList<T>();
        copy.addAll(list);
        for(T element:copy)
            enqueue(element);

    }
	
 

}
