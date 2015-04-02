public class Driver{
    public static void main(String[]args){
	
		Maze prayer = new Maze("data1.dat");
		System.out.println(prayer.solve(true, true));
    }
}
				