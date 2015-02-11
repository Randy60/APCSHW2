import java.util.*;
import java.io.*;


public class KnightsTour{
	//constants for the class
	//terminal specific character to clear screen , or hide/show cursor
	final static String clear =  "\033[2J";
	final static String hide =  "\033[?25l";
	final static String show =  "\033[?25h";

	//instance variable
    private int[][]board;


		//terminal specific character to move the cursor
    private String go(int x,int y){
				return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
				try {
						Thread.sleep(millis);
				}
				catch (InterruptedException e) {
				}
    }

    public String toString(){
				String ans = "\n";
				//build your knights tour here...
				return hide + go(0,0) + ans + "\n" + show;
    }
    public String toString(int[][] ar){
	String s = "";
	for(int i = 0; i < ar.length*ar[0].length; i++){
	    if(i%ar.length == 0){
		s+="\n";
		for(int z = 0; z < ar[0].length; z++){
		    s+="-";
		}
		s+="\n";
	    }
	    s+="|";
	    int x = ar[i/ar.length][i%ar.length];
	    if(x < 1000)
		s+="0";
	    if(x< 100)
		s+="0";
	    if(x < 10)
		s+="0";
	    s+=x;
	    s+="|";
	}
	return s;
    }
    public KnightsTour(int size){
				
    }

    

    public void solve(){
				
    }


    public void solve(int startx, int starty){
				
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
				System.out.println(this);
				wait(20);
				
				return false;
    }


}