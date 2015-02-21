import java.util.*;
public class Tester{
    public static void main(String[]args){
       	if(args.length > 0){
	    int x = new Integer(args[0]);
	            KnightsTour al = new KnightsTour(x);
	}else{
	    KnightsTour al = new KnightsTour(6);
	}
	    
	    //		NQueens al = new NQueens(x);
    }
}