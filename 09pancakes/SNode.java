public class SNode<T>{
    public T value;
    private SNode next;
    public SNode(T a, SNode b){
	value = a;
	next = b;
    }
    public T getValue(){
	return value;
    }
    public SNode<T> getNext(){
	return next;
    }
}