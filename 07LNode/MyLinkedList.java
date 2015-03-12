public class MyLinkedList{
    private LNode head;
    public String toString(){
	return head.toString();
    }
    public void remove(int n){
	if(n == 0)
	    head = head.getNext();
	else
	    head.remove(n);
    }
    public boolean add(Object o){
	return add(0, o);
    }
    public boolean add(int n, Object c){
	if(n < 0)
	    throw new IndexOutOfBoundsException();
	if(n == 0){
	    LNode r = new LNode(c, head);
	    head = r;
	}else{
	    head.add(n, c);
	}
	return true;
    }
    public Object get(int n){
	if(n < 0)
	    throw new IndexOutOfBoundsException();
	return head.get(n);
    }
    public void set(int n, Object o){
	if(n<0)
	    throw new IndexOutOfBoundsException();
	head.set(n, o);
    }
    public int size(){
	return head.size();
    }
}
	    