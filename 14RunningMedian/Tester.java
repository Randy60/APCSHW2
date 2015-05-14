public class Tester{
    public static void main(String[]args){
	RunningMedian Yoyo = new RunningMedian();
	for(int i = 0; i < 13; i++){
	    int a =(int) (Math.random()*100);
	    Yoyo.add(a);
	    System.out.print(a);
	}
	System.out.println();
	System.out.println(Yoyo.median());
    }
}