public class LNode{
    private Object value;
    private LNode next;
    public LNode(Object n){
	value = n;
    }
    public void remove(int n){
	if(n <= 1){
	    next = next.next;
	}else{
	    next.remove(n-1);
	}
    }
    public void add(int n, Object c){
	if(n <= 1){
	    LNode r = new LNode(c);
	    r.next = next;
	    next = r;
	}else{
	    next.add(--n, c);
	}
    }
    public Object get(int n){
	if(n == 0){
	    return value;
	}else{
	    return next.get(--n);
	}
    }
    public void set(int n, Object o){
	if(n == 0){
	    value = o;
	}else{
	    next.set(--n, o);
	}
    }
    public int size(){
	if(next == null){
	    return 1;
	}else{
	    return 1+next.size();
	}
    }
}