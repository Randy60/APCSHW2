import java.util.*;
public class Maze{
    final static String clear =  "\033[2J";
    public void wait(int millis){
				try {
						Thread.sleep(millis);
				}
				catch (InterruptedException e) {
				}
    }
    public Maze(String filename){
    
    }
    public char[][] maze;
    public String toString(){
	String s = "";
	for(int i = 0; i < maze[0].length; i++){
	    s+="%";
	}
	for(int i = 0; i < maze.length; i++){
	    s+="\n"+"%";
	    for(int j = 0; j < maze[i].length; j++){
		s+=maze[i][j];
	    }
	    s+="%";
	}
	for(int i = 0; i < maze[0].length; i++){
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
	    if(Maze[next[1]][next[0]] != '*'){
		if(animate){
		    wait(20);
		    System.out.println(clear+toString);
		}
		if(Maze[next[1]][next[0]] == 'E'){
		    return true;
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
    }
//public boolean solveDFS(){
//return solveDFS(false);
}