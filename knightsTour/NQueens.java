import java.util.*;
import java.io.*;


public class NQueens{
	//constants for the class
	//terminal specific character to clear screen , or hide/show cursor
	final static String clear =  "\033[2J";
	final static String hide =  "\033[?25l";
	final static String show =  "\033[?25h";

	//instance variable
    private char[][]board;


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
    public String toString(char[][] ar){
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
	    s+=x;
	    s+="|";
	}
	s+="\n";
	for(int z = 0; z < ar[0].length*6; z++){
		    s+="-";
	}

	return clear + hide + go(0,0)+ s + "\n" + show;
    }
    public int solve(int at){
	if(at == board.length*board.length + 1)
	    return 0;
	for(int i = at%board.length; i >= 0; i--){
	    if(board[at/board.length][i] == 'Q')
		return solve(at+1);
	}
	for(int i = at/board.length; i >= 0; i--){
	    if(board[i][at%board.length] == 'Q')
		return solve(at+1);
	}
	for(int i = at%board.length; i >= 0 && at/board.length+i > 