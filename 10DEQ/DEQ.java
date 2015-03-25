import java.util.*;
public class MyDeque<T>{
    private Object[] holder = new Object[100];
    private int head = 0;
    private int tail = 0;
    private void doube(){
	Object[] rec = new Object[holder.length*2];
	for(int i = 0; i < holder.length; i++){
	    rec[i] = (i+head)%holder.length;
	}
	head = 0;
	tail = holder.length - 1;
	holder = rec;
    }
    public void addFirst(T o){
	if((tail+1)%holder.length == head){
	    doube();
	}
	head = (head-1)%holder.length;
	holder[head] = o;
    }
    public void addLast(T o){
	if((tail+1)%holder.length == head){
	    doube();
	}
	holder[tail] = o;
	tail = (tail+1)%holder.length;
    }
    public T removeFirst(){
	if(head == tail){
	    throw new NullPointerException();
	}
	head = (head+1)%holder.length;
	return (T)holder[(head-1)%holder.length];
    }
    public T removeLast(){
	if(head == tail){
	    throw new NullPointerException();
	}
	tail = (tail-1)%holder.length;
	return (T)holder[tail];
    }
    public T getFirst(){
	if(head == tail){
	    throw new NullPointerException();
	}
	return (T)holder[head];
    }
    public T getLast(){
	if(head == tail){
	    throw new NullPointerException();
	}
	return (T)holder[(tail-1)%holder.length];
    }
}