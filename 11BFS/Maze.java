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
    public int startx, starty;
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
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }
    public char[][] Maze;
    public String toString(){
	String s = "";
	for(int i = 0; i < Maze.length; i++){
	    s+="\n";
	    for(int j = 0; j < Maze[i].length; j++){
		s+=Maze[i][j];
	    }
	}
	return s;
    }
    private class CNode{
	private int a;
	private int b;
	private CNode next;
	public int getX(){
	    return a;
	}
	public int getY(){
	    return b;
	}
	public CNode getNext(){
	    return next;
	}
	public boolean hasNext(){
	    return next != null;
	}
	public CNode(int x, int y, CNode Paul){
	    a = x;
	    b = y;
	    next = Paul;
	}
    }
    public boolean solve(boolean animate, boolean bfs){
	MyQueue<CNode> Frontier = new MyQueue<CNode>();
	Frontier.enqueue(new CNode(startx, starty, null));
	while(Frontier.hasNext()){
	    CNode net = null;
	    if(bfs){
		//System.out.println(Frontier.removeFirst().getX());
		net = Frontier.dequeue();
	    }else{
		net = Frontier.dequeue();
	    }
	    //Maze[net.getY()][net.getX()] = 'X';
	    System.out.println(""+Maze[net.getX()][net.getY()]);
	    if(Maze[net.getY()][net.getX()] != '*' || Maze[net.getY()][net.getX()] != '-'){
		if(animate){
		    wait(20);
		    System.out.println(clear);
		    System.out.println(toString());
		}
		if(Maze[net.getY()][net.getX()] == 'E'){
		    for(int i = 0; i < Maze.length*Maze[0].length; i++){
			if(Maze[i/Maze.length][i%Maze.length] == '-')
			    Maze[i/Maze.length][i%Maze.length] = ' ';
		    }
		    while(net.hasNext()){
			Maze[net.getY()][net.getX()] = '$';
			net = net.getNext();
			wait(100);
			System.out.println(clear+toString());
		    }
		    return true;
		}
		Maze[net.getY()][net.getX()] = '-';
		CNode al = new CNode(net.getX()+1, net.getY(), net);
		CNode bl = new CNode(net.getX()-1, net.getY(), net);
		CNode cl = new CNode(net.getX(), net.getY()+1, net);
		CNode dl = new CNode(net.getX(), net.getY()-1, net);
		Frontier.enqueue(al);
		Frontier.enqueue(bl);
		Frontier.enqueue(cl);
		Frontier.enqueue(dl);
	    }
	}
	return false;
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
