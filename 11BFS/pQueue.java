public class pQueue<T>{
    private Nodule<T> head = new Nodule(null, 1, null);
    public pQueue(T it, int pri){
	enqueue(it, pri);
    }
    private class Nodule<T>{
	public int priority;
	public Nodule next;
	public T has;
	public Nodule(T it, int pri, Nodule after){
	    next = after;
	    priority = pri;
	    has = it;
	}
	public int getPriority(){
	    return priority;
	}
	public Nodule<T> getNext(){
	    return next;
	}
	public T getValue(){
	    return has;
	}
	public void setNext(Nodule net){
	    next = net;
	}
    }
    public void enqueue(T it, int priority){
	Nodule marker = head;
	while(marker.getNext() != null && marker.getNext().getPriority() <= priority){
	    marker = marker.getNext();
	}
	marker.setNext(new Nodule<T>(it, priority, marker.getNext()));
    }
    public T dequeue(){
	T it = head.getNext().getValue();
	head.setNext(head.getNext().getNext());
	return it;
    }
    public boolean hasNext(){
	return head.getNext()!=null;
    }
    public int size(){
	int i = 0;
	Nodule marker = head;
	while(marker.getNext() != null){
	    i++;
	    marker.setNext(marker.getNext());
	}
	return i;
    }
}