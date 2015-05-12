import java.util.*;
public class MyHeap{
    private ArrayList<Integer> heapy = new ArrayList<Integer>();
    public MyHeap(){
	heapy.add(1);
    }
    private boolean isMax = true;
    public MyHeap(boolean it){
	heapy.add(1);
	isMax = it;
    }
    public String toString(){
	return heapy.toString();
    }
    public void add(int adder){
	if(isMax){
	    addTrue(adder);
	    return;
	}
	addFalse(adder);
    }
    public void addTrue(int adder){
	heapy.add(adder);
	heapy.set(0, heapy.get(0) +1);
	for(int i = heapy.size()-1; i > 1; i/=2)
	    if(heapy.get(i) > heapy.get(i/2)){
		    heapy.set(i, heapy.get(i/2));
		    heapy.set(i/2, adder);
		}
    }
    public void addFalse(int adder){
	heapy.add(adder);
	heapy.set(0, heapy.get(0) +1);
	for(int i = heapy.size()-1; i > 1; i/=2)
	    if(heapy.get(i) < heapy.get(i/2)){
		    heapy.set(i, heapy.get(i/2));
		    heapy.set(i/2, adder);
		}
    }
    public int removeTrue(){
	heapy.set(0, heapy.get(0)-1);
	int it = heapy.get(1);
	heapy.set(1, heapy.remove(heapy.size()-1));
	int at = 1;
	while(at*2 < heapy.size() && (heapy.get(at) < heapy.get(at*2)||heapy.get(at) < heapy.get(at*2+1)))
	    if(heapy.get(at*2) > heapy.get(at*2+1)){
		int temp = heapy.get(at);
		heapy.set(at, heapy.get(at*2));
		heapy.set(at*2, temp);
		at*=2;
	    }else{
		int temp = heapy.get(at);
		heapy.set(at, heapy.get(at*2+1));
		heapy.set(at*2+1, temp);
		at=at*2+1;
	    }
	return it;
    }
    public int removeFalse(){
	heapy.set(0, heapy.get(0)-1);
	int it = heapy.get(1);
	heapy.set(1, heapy.remove(heapy.size()-1));
	int at = 1;
	while(at*2 < heapy.size() && (heapy.get(at) > heapy.get(at*2)||heapy.get(at) > heapy.get(at*2+1)))
	    if(heapy.get(at*2) < heapy.get(at*2+1)){
		int temp = heapy.get(at);
		heapy.set(at, heapy.get(at*2));
		heapy.set(at*2, temp);
		at*=2;
	    }else{
		int temp = heapy.get(at);
		heapy.set(at, heapy.get(at*2+1));
		heapy.set(at*2+1, temp);
		at=at*2+1;
	    }
	return it;
    }
    public int remove(){
	if(isMax)
	    return removeTrue();
	return removeFalse();
    }
    public int peek(){
	return heapy.get(1);
    }
}