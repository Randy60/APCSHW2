import java.util.*;
public class MyQueue<T>{
    private QNode<T> head,tail;
    public MyQueue(){
	head = null;
	tail = null;
    }
    public void enqueue(T o){
	if(tail == null){
	    tail = new QNode<T>(o);
	    head = tail;
	}else{
	    tail.add(o);
	    tail = tail.getNext();
	}
    }
    public boolean hasNext(){
	return (tail.getNext() != null);
    }
    public T dequeue(){
	if(head == null){
	    throw new NoSuchElementException();   
	}
	T it = head.getValue();
	head = head.getNext();
	return it;
    }
}