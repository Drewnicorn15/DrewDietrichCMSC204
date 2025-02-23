package application;
/**
 *  @author Andrew Dietrich
 */
public class ListNode<T> {
	private ListNode<T> next;
	private T value;

	public ListNode(T v)
	{
		next = null;
		value = v;
	}
	public ListNode(T v,ListNode<T> a)
	{
		next = a;
		value = v;
	}
	/**
	 * the getter for the Next Listnode 
	 * @return the ListNode after this one
	 */
	public ListNode<T> getNext() {
		return next;
	}
	/**
	 * the setter for the Next Listnode
	 * @param after the Listnode to be set as next 
	 */
	public void setNext(ListNode<T> after) {
		this.next = after;
	}
	/**
	 * the getter of the value stored in this listNode
	 * @return the value stored in this listNode 
	 */
	public T getValue() {
		return value;
	}
	/**
	 * the setter of the value stored in this ListNode
	 * @param value the value to be stored by this ListNode
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
}
