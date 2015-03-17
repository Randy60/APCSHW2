public class LNode{
    private int value;
    private LNode next;
    public LNode(int n){
	value = n;
    }
    public LNode(int n, LNode x){
	value = n;
	next = x;
    }
    public void remove(int n){
	if(n <= 1){
	    next = next.next;
	}else{
	    if(next == null){
		throw new IndexOutOfBoundsException();
	    }
	    next.remove(n-1);
	}
    }
    public void add(int n, int c){
	if(n <= 1){
	    LNode r = new LNode(c);
	    r.next = next;
	    next = r;
	}else{
	    if(next == null){
		throw new IndexOutOfBoundsException();
	    }
	    next.add(--n, c);
	}
    }
    public LNode getNext(){
	if(next == null)
	    throw new IndexOutOfBoundsException();
	return next;
    }
    public int get(int n){
	if(n == 0){
	    return value;
	}else{
	    return next.get(--n);
	}
    }
    public void set(int n, int o){
	if(n == 0){
	    value = o;
	}else{
	    if(next == null)
		throw new IndexOutOfBoundsException();
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
    public String toString(int a){
	if(next == null)
	    return ""+value+"]";
	else
	    return ""+value+","+next.toString(0);
    }
    public String toString(){
	return "["+toString(0);
    }
    public int indexOf(int o){
	if(value == o){
	    return 1;
	}
	if(next == null){
	    throw new NullPointerException();
	}
	return 1 + next.indexOf(o);
    }
}