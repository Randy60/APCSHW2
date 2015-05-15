public class Driver{
    public static void main(String[]args){
	MyHeap paul = new MyHeap();
	for(int i = 0; i < 10; i++){
	    paul.add((int)(100*Math.random()));
	}
	System.out.println(paul.toString());
	System.out.println(paul.remove());
	System.out.println(paul.toString());
    }
}