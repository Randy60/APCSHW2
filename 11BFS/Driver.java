public class Driver{
    public static void main(String[]args){
	//MyQueue checker = new MyQueue<Integer>();
	//checker.enqueue(2);
	//checker.enqueue(3);
	//System.out.println(""+checker.dequeue()+checker.dequeue());
	Maze prayer = new Maze("data1.dat");
	 System.out.println(prayer.solve(true, true));
    }
}
				