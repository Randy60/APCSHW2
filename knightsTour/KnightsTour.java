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
	return toString(board);
    }
    public String toString(int[][] ar){
	String s = "\n";
	for(int i = 0; i < ar.length*ar[0].length; i++){
	    if(i%ar.length == 0){
		s+="\n";
		for(int z = 0; z < ar[0].length*6; z++){
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
	s+="\n";
	for(int z = 0; z < ar[0].length*6; z++){
		    s+="-";
	}

	return clear + hide + go(0,0)+ s + "\n" + show;
    }
    public KnightsTour(int size){
	board = new int[size][size];
	solve();
    }

    

    public void solve(){
	int[][] nb = board;
	if(solve(0, 0, 1)){
	    System.out.println(toString(board));
	}else{
	    System.out.println("now");
	    wait(1000);
		System.out.println("no solution");
	}
    }
    public void setBoard(int[][] a){
	board = a;
    }
    public boolean solve(int x,int y,int currentMoveNumber){
	if(x < 0 || x >= board.length || y < 0 || y >= board.length || board[y][x] != 0)
	    return false;
	//	if(currentMoveNumber > 60)
	//System.out.println(toString());
	board[y][x] = currentMoveNumber;
	if(currentMoveNumber == (board.length*board.length)){
	    return true;
	}
	if(solve(x-1, y-2, currentMoveNumber+1) || solve(x+1, y-2, currentMoveNumber+1) ||
	   solve(x-1, y+2, currentMoveNumber+1) || solve(x+1, y+2, currentMoveNumber+1) ||
	   solve(x-2, y-1, currentMoveNumber+1) || solve(x+2, y-1, currentMoveNumber+1) ||
	   solve(x-2, y+1, currentMoveNumber+1) || solve(x+2, y+1, currentMoveNumber+1))
	    return true;
	board[y][x] = 0;
	return false;
    }

}