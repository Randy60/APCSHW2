public class Stack<T>{
    public SNode<T> head;
    public T peek(){
	return head.getValue();
    }
    public void push(T a){
	head = new SNode<T>(a, head);
    }
    public T pop(){
	T a = peek();
	head = head.getNext();
	return a;
    }
}