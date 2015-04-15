public class CNode{
    public int a, b;
    private CNode next;
    public CNode(int x, int y, CNode Paul){
	a = x;
	b = y;
	next = Paul;
    }
    public CNode(int x, int y){
	a = x;
	b = y;
    }
    public int getX(){
	return a;
    }
    public int getY(){
	return b;
    }
    public CNode getNext(){
	return next;
    }
    public boolean hasNext(){
	return next != null;
    }
    public String toString(){
	if(next == null){
	    return "("+a+","+b+")";
	}else{
	    return "("+a+","+b+")"+next.toString();
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
