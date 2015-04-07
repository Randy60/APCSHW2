public class Queue<T>{
    public int addto = 0;
    public int takefrom = 0;
    public Object[] user = new Object[100000];
    public Queue(T it){
	user[addto] = it;
	addto++;
    }
    public void enqueue(T it){
	user[addto] = it;
	addto++;
    }
    public T dequeue(){
	if(takefrom == addto){
	    throw new NullPointerException();
	}
	T it = (T)user[takefrom];
	takefrom++;
	return it;
    }
    public boolean hasNext(){
	return (takefrom < addto);
    }
}