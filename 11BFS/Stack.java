public class Stack<T>{
    public int addto;
    public Object[] user = new Object[100000];
    public Stack(T it){
	enqueue(it);
    }
    public void enqueue(T it){
	user[addto] = it;
	addto++;
    }
    public T dequeue(){
	if(addto == -1){
	    throw new NullPointerException();
	}else{
	    
	    return (T)user[--addto];
	}
    }
    public boolean hasNext(){
	return (addto != -1);
    }
}