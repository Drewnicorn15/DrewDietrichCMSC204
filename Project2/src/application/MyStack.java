package application;

import java.util.ArrayList;
/**
 *  @author Andrew Dietrich
 */
public class MyStack<T> implements StackInterface<T>{
    private int maxSize;
    private ListNode<T> head;
    private int size;
    public MyStack(int size)
    {
        head = null;
        maxSize = size;
        size = 0;
    }
    public MyStack()
    {
        head = null;
        maxSize = 100;
        size =0;
    }
    
    	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
    @Override
    public boolean isEmpty() {
        return head==null; 
    }

    /**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
    @Override
    public boolean isFull() {
        return false;
    }
    /**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
    @Override
    public T pop() throws StackUnderflowException {
        if(isEmpty())
            throw  new StackUnderflowException();
        T toReturn = head.getValue();
        head = head.getNext();
        size--;
        return toReturn;

    }
/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
    @Override
    public T top(){
        if(head == null){
            return null;
        }
        return head.getValue();
    }
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
    @Override
    public int size() {
        return size;
    }
/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
    @Override
    public boolean push(T e) {
        size++;
        head = new ListNode<T>(e,head);
        return true;
    }
    /**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
    @Override
    public String toString()
    {
        if(size ==0) return "";
        String toRuString = ""+head.getValue();
        ListNode<T> traversal = head;
        while(traversal.getNext() != null)
        {
         traversal = traversal.getNext();
         toRuString = ""+traversal.getValue()+toRuString;   
        }
        return toRuString;
    }
    /**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
    @Override
    public String toString(String delimiter) {
        if(size ==0) return "";
        String toRuString = "";
        ListNode<T> traversal = head;
        while(traversal != null)
        {
        toRuString = delimiter+traversal.getValue()+toRuString;
         traversal = traversal.getNext();
            
        }
        return toRuString.substring(1);
    }
    /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
    @Override
    public void fill(ArrayList<T> list) {
        ArrayList<T> copy = new ArrayList<T>();
        copy.addAll(list);
        for(T element:copy)
            push(element);
    }
    

}
