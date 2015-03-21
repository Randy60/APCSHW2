public class MyStack<T>{
    public SNode<T> head;
    public T peek(){
	return head.getValue();
    }
    public T push(T a){
	head = new SNode<T>(a, head);
	return head.getValue();
    }
    public T pop(){
	T a = peek();
	head = head.getNext();
	return a;
    }
    public boolean empty(){
	return head == null;
    }
    public int search(Object i){
	SNode<T> at = head;
	int x = 0;
	while(at != null){
	    if(at.getValue().equals(i))
		return x;
	    else{
		at = at.getNext();
		x++;
	    }
	}
	return -1;
    }
}