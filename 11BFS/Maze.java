import java.util.*;
import java.io.*;
public class Maze{
    final static String clear =  "\033[2J";
    public void wait(int millis){
				try {
						Thread.sleep(millis);
				}
				catch (InterruptedException e) {
				}
    }
    private int maxx, maxy;
    public int[] start = new int[2];
    public Maze(String filename){
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	Maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    Maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		start[1] = i % maxx;
		start[0] = i / maxx;
	    }
	}
    }
    public char[][] Maze;
    public String toString(){
	String s = "";
	for(int i = 0; i < Maze[0].length; i++){
	    s+="%";
	}
	for(int i = 0; i < Maze.length; i++){
	    s+="\n"+"%";
	    for(int j = 0; j < Maze[i].length; j++){
		s+=Maze[i][j];
	    }
	    s+="%";
	}
	for(int i = 0; i < Maze[0].length; i++){
	    s+="%";
	}
	return s;
    }
    public boolean solve(boolean animate, boolean bfs){
	MyDeque<int[]> Frontier = new MyDeque<int[]>();
	Frontier.addFirst(start);
	while(1 == 1){
	    int[] next;
	    if(bfs){
		next = Frontier.removeFirst();
	    }else{
		next = Frontier.removeLast();
	    }
	    if(Maze[next[0]][next[1]] != '*' && Maze[next[0]][next[1]] != '-'){
		if(animate){
		    wait(20);
		    System.out.println(clear);
		    System.out.println(toString());
		}
		if(Maze[next[0]][next[1]] == 'E'){
		    for(int i = 0; i < Maze.length*Maze[0].length; i++){
			if(Maze[i/Maze.length][i%Maze.length] == '-')
			    Maze[i/Maze.length][i%Maze.length] = ' ';
		    }
		    for(int i = 2; i < Maze.length/2 - 1; i++){
			Maze[next[i]][next[++i]] = '$';
			wait(100);
			System.out.println(clear+toString());
		    }
		    return true;
		}
		Maze[next[0]][next[1]] = '-';
		int[] adder = new int[next.length+2];
		for(int i = 2; i < adder.length; i++){
		    adder[i] = next[i-2];
		}
		adder[0] = next[0]+1;
		adder[1] = next[1]+1;
		Frontier.addLast(adder);
		adder[0]-=2;
		Frontier.addLast(adder);
		adder[1]-=2;
		Frontier.addLast(adder);
		adder[0]+=2;
		Frontier.addLast(adder);
	    }
	}
    }
}
    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    //public boolean solveDFS(boolean animate){    }

    //public boolean solveBFS(){
    //return solveBFS(false);
//public boolean solveDFS(){
//return solveDFS(false);
