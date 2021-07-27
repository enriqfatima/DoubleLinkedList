package edu.miracosta.cs113;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  public void add(int index, E obj)// Fill Here: this is where we insert the item in the linked list 
  { 
	  Node[index]= obj; 
	  
  }
  public void addFirst(E obj) { // (pg.92)Fill Here: Item is added tot he front of the list (head)
	  head = new Node <E> (obj); 
	  size ++; 
  }
  public void addLast(E obj) { // Fill Here: Item is added last of the list
	  tail = new Node<E>(obj);
	  size --;
  }
  

  public E get(int index) 
  { 	ListIterator<E> iter = listIterator(index); 
      	return iter.next();
  }  
  public E getFirst() { 
	  return head.data;  
  }
  
  public E getLast() { 
	  return tail.data;  
  }

  public int size() { // Fill Here: 
	  return -1;  
  } 

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { return new ListIter(0);  }
  public ListIterator listIterator() { return new ListIter(0);  }
  public ListIterator listIterator(int index){return new ListIter(index);}
  public ListIterator listIterator(ListIterator iter)
  {     return new ListIter( (ListIter) iter);  }

  // Inner Classes 
  /*
   * Node class: 
   */
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     
    		throw new IndexOutOfBoundsException("Invalid index " + i); 
    	}
        lastItemReturned = null;
 
        if (i == size)     
        	// Special case of last item
        {     
        	index = size;     
        	nextItem = null;      
        }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  
            	{
            		nextItem = nextItem.next;
            	}   
        }
            // end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    }

    public boolean hasNext() // Fill Here: 
    {  /*Returns true if next will now throw an exception
     	* nextitem is alluding to the Node that will be returned next (in its method)
     	* see if the nextItem is null or not 
    	*/
    	return nextItem != null ;
    }
    public boolean hasPrevious()// Fill Here
    {  //* returns true if prev will now throw an exception 
    	return (nextItem == null && size != 0) || nextItem.prev != null; 
    	/*when the iterator itself is at the end of the list then the enxt 
    	 * item would be null since there is nothing. checking the size of the list lets us see if the iterator is at the end.
    	 * ofc if its not null then the iterator isn't at the end of the list. the nextItem.prev is used to see if the prev item isn't null.
    	*/
    }
    public int previousIndex() // Fill Here
    { //Returns the index of the element that would be returned by a further call to previous.
    	
    	return 0;    
    } 
    public int nextIndex() 
    {  
    	
    	return 0;    
    } 
    public void set(E o) // not implemented 
    { 
    	
    }
    public void remove()// not implemented
    {
    	
    }      

    public E next() // Fill Here
    {  
    	if(!hasNext())
    	{
    		throw new NoSuchElementException(); // throw bc hasNext() isn't true; therefore, it throws an exception 
    	}
    	lastItemReturned = nextItem ; //the last item that is returned is set to the next item
    	nextItem = nextItem.next;//next item is adv to the new node 
    	index++; //increment 
        return lastItemReturned.data; 
    }

    public E previous() // Fill Here
    {  
    	if(!hasPrevious())
    	{
    		throw new NoSuchElementException(); // throw bc hasPrev() isn't true; therefore, it throws an exception 
    	}
    	if(nextItem == null)
    	{
    		nextItem = tail; //means that the nextItem has to be empty 
    	}
    	else 
    	{
    		nextItem = nextItem.prev; //then the nextItem has to be the prev item.
    	}
    	lastItemReturned = nextItem ; //set the prev item to the next item
    	index--; //a decrement  of the index since we are returning the last item
    	return lastItemReturned.data; 
    }

    public void add(E obj) { // Fill Here
    	add(obj);
    	return;
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList
