package application;
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
    Comparator<T> compare;
    /**
     * Creates an empty list that is associated with the specified comparator.
     * @param c Comparator to compare data elements
     */
    public SortedDoubleLinkedList(Comparator<T> c)
    {
        compare = c;
    }
    
    
    /** 
     * Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several times. Your implementation must traverse the list only once in order to perform the insertion.
     * @param data the data to be added to the list

     */
    public void add(T data)
    {
        if(head ==null){super.addToFront(data); return;}
        Node trav = head;
        if(size==1)
        {
            if(compare.compare(trav.data, data)<0)
                super.addToEnd(data);
            else
               super.addToFront(data);
            return;
        }
        while(trav.next != null)
        {
            if(compare.compare(trav.data, data)>=0)
                break;
            trav = trav.next;
        }
        if(trav.next == null && compare.compare(trav.data, data)<0)
        {
            super.addToEnd(data);
            return;
        }
        if(trav.equals(head))
        {
            super.addToFront(data);
            return;
        }
        Node toAdd = new Node(data);
        Node prev = trav.prev;
        toAdd.next = trav;
        toAdd.prev = prev;
        prev.next = toAdd;
        trav.prev = toAdd; 
        size++;

    }
    /**
     * This operation is invalid for a sorted list.
     * @throws UnsupportedOperationException if the method is called
     * 
     */
    @Override
    public void addToEnd(T data) throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
        /**
     * This operation is invalid for a sorted list.
     * @throws UnsupportedOperationException if the method is called
     * 
     */
    @Override
    public void addToFront(T data) throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    /**
     * Implements the remove operation by calling the super class remove method.
     * @return a node containing the data or null
     */
    @Override
    public Node remove(T targetData, Comparator<T> comparator){
        return super.remove(targetData, comparator);
    }
    /**
     * Implements the iterator by calling the super class iterator method.
     * @return an iterator positioned at the head of the list
     */
    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
    }
}
