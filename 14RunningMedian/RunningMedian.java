public class RunningMedian{
    private MyHeap MaxH = new MyHeap(false);
    private MyHeap MinH = new MyHeap();
    public RunningMedian(){
	MaxH.add(Integer.MAX_VALUE);
	MinH.add(Integer.MIN_VALUE);
    }
    public void add(int adder){
	int compro = (MaxH.peek()+MinH.peek())/2;
	if(adder < compro)
	    MinH.add(adder);
	else
	    MaxH.add(adder);
	if(MinH.size() > MaxH.size()+1)
	    MaxH.add(MinH.remove());
	if(MaxH.size() > MinH.size()+1)
	    MinH.add(MaxH.remove());
    }
    public int median(){
	if(MaxH.size() > MinH.size())
	    return MaxH.peek();
	if(MinH.size() > MaxH.size())
	    return MinH.peek();
	return (MinH.peek()+MaxH.peek())/2;
    }
}