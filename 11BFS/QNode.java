public class QNode<T>{
    public T value;
    public QNode next;
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
    public void setNext(QNode net){
	next = net;
    }
    public QNode<T> getNext(){
	return next;
    }
}