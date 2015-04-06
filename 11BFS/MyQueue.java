import java.util.*;
public class MyQueue<T>{
    private QNode<T> head,tail;
    public MyQueue(){
	head = new QNode<T>(null);
	tail = head;
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
	return (head.getNext() != null);
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