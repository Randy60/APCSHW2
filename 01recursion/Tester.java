public class Tester{
    public static void main(String[]args){
	Recursion al = new Recursion();
	for(double i = 10; i > -1; i-=0.5){
	    System.out.println(i);
	    System.out.println(al.sqrt(i));
	}
    }
}