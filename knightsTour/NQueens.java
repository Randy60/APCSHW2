import java.util.*;
import java.io.*;


public class NQueens{
	//constants for the class
	//terminal specific character to clear screen , or hide/show cursor
	final static String clear =  "\033[2J";
	final static String hide =  "\033[?25l";
	final static String show =  "\033[?25h";

	//instance variable
    public char[][]board;
    public NQueens(int a){
	board = new char[a][a];
	for(int i = 0; i < a*a; i++){
	    board[i/board.length][i%board.length] = '-';
	}
	int v = solve(0);
	System.out.println(toString());
	System.out.println(v);
    }

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
	String s = "\n"+" ";
	for(int i = 0; i < board.length; i++){
	    s+=" "+i;
	    if(i < 10)
		s+=" ";
	}
	for(int i = 0; i < ar.length*ar[0].length; i++){
	    if(i%ar.length == 0){
		s+="\n" + "  ";
		for(int z = 0; z < ar[0].length*3; z++){
		    s+="-";
		}
		s+="\n" + i/ar.length;
		if(i/ar.length < 10)
		    s+=" ";
	    }
	    s+="|";
	    s+=ar[i/ar.length][i%ar.length];
	    s+="|";
	}
	s+="\n"+"  ";
	for(int z = 0; z < ar[0].length*3; z++){
		    s+="-";
	}

	return clear + hide + go(0,0)+ s + "\n" + show;
    }
    public int solve(int at){
	/*if(board.length > at/board.length && board.length > at%board.length){
	    char was = board[at/board.length][at%board.length];
	    board[at/board.length][at%board.length] = 'h';
	    System.out.println(toString());
	    wait(100);
	    board[at/board.length][at%board.length] = was;
	    }*/
	if(at >= board.length*board.length){
	    int a = 0;
	    for(int i = at-1; i >= 0; i--){
		if(board[i/board.length][i%board.length] == 'Q')
		    a++;
	    }
	    return a;
	}
	if(board[at/board.length][at%board.length] != '-')
	    return solve(at+1);
	int x = at%board.length;
	int y = at/board.length;
	for(int i = 0; i < board.length; i++){
	    if(x >= i && board[y][x-i] == 'Q')
		return solve(at+1);
	    if(y >= i && board[y-i][x] == 'Q')
		return solve(at+1);
	    //if(x+i < board.length && board[y][x+i] == 'Q')
	    //return solve(at+1);
	    //if(y+i < board.length && board[y+i][x] == 'Q')
	    //return solve(at+1);
	    //if(y+i < board.length && x+i < board.length && board[y+i][x+i] == 'Q')
	    //return solve(at+1);
	    if(y+i < board.length && x >= i && board[y+i][x-i] == 'Q')
		return solve(at+1);
	    if(y >= i && x+i < board.length && board[y-i][x+i] == 'Q')
		return solve(at+1);
	    if(y >= i && x >= i && board[y-i][x-i] == 'Q')
		return solve(at+1);
	}
	board[y][x] = 'Q';
	int with = solve(at+1);
	if(with == board.length)
	    return with;
	for(int i = at; i < board.length * board.length; i++){
	    board[i/board.length][i%board.length] = '-';
	}
	return solve(at+1);
    }
}
	    