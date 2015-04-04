public class QNode<T>{
    public T value;
    private QNode next;
    public QNode(T a){
	value = a;
	next = null;
    }
    public void add(T o){
	next = new QNode<T>(o);
    }
    public T getValue(){
	return value;
    }
    public QNode<T> getNext(){
	return next;
    }
}