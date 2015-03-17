public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> head;
    public int size = 0;
    // public class MLLIterator<T> implements Iterator<T>{
	
    //}
    public String toString(){
	if(size == 0){
	    return "[]";
		}
	return head.toString();
    }
    public MyLinkedList(){
	head = null;
	fin = head;
	size = 0;
    }
    private LNode fin;
    public boolean remove(int n){
	size--;
	if(n == 0)
	    head = head.getNext();
	else
	    head.remove(n);
	return true;
    }
    public boolean add(T o){
	if(size == 0){
	    head = new LNode(o);
	    fin = head;
	}else{
	    fin.add(0, o);
	    fin = fin.getNext();
	}
	    size++;
	    return true;
    }
    public boolean add(int n, T c){
	if(n == size){
	    fin.add(0, c);
	    fin = fin.getNext();
	    size++;
	}
	size++;
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
    public T get(int n){
	if(n < 0)
	    throw new IndexOutOfBoundsException();
	return head.get(n);
    }
    public void set(int n, T o){
	if(n<0)
	    throw new IndexOutOfBoundsException();
	head.set(n, o);
    }
    public int size(){
	return size;
    }
    public int indexOf(T o){
	return head.indexOf(o);
    }
}
	    