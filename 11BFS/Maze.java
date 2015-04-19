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
	//System.out.println(""+maxx+","+maxy);
	//copy from the single string to a 2D array
	Maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    Maze[i%maxx][i/maxx] = c;
	    if(c == 'S'){
		startx = i/maxx;
		starty = i%maxx;
	    }
	}
    }
    public char[][] Maze;
    public String toString(){
	String s = "";
	for(int i = 0; i < Maze[0].length; i++){
	    s+="\n";
	    for(int j = 0; j < Maze.length; j++){
		s+=Maze[j][i];
	    }
	}
	return s;
    }
    public boolean solveBFS(boolean animate){
	Queue<CNode> Frontier = new Queue<CNode>(new CNode(startx, starty, null));
	while(Frontier.hasNext()){
	    CNode net = Frontier.dequeue();
	    if(Maze[net.getY()][net.getX()] != '#' && Maze[net.getY()][net.getX()] != '-'){
		if(animate){
		    wait(100);
		    System.out.println(clear);
		    System.out.println(toString());
		    System.out.println("Frontier:"+net.toString());
		}


		if(Maze[net.getY()][net.getX()] == 'E'){
		    for(int i = 0; i < Maze.length*Maze[0].length; i++){
			if(Maze[i%Maze.length][i/Maze.length] == '-')
			    Maze[i%Maze.length][i/Maze.length] = ' ';
		    }
		    net = net.getNext();
		    while(net.hasNext()){
			Maze[net.getY()][net.getX()] = '@';
			net = net.getNext();
			if(animate){
			    wait(100);
			    System.out.println(clear+toString());
			}
		    }
		    Maze[net.getY()][net.getX()] = 'S';
		    if(animate){
			wait(100);
			System.out.println(clear+toString());
		    }
		    return true;
		}

		if(net.getY() != starty || net.getX() != startx){
		Maze[net.getY()][net.getX()] = '-';
		}
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
    public boolean solveDFS(boolean animate){
	Stack<CNode> Frontier = new Stack<CNode>(new CNode(startx, starty, null));
	Frontier.enqueue(new CNode(startx, starty));
	while(Frontier.hasNext()){
	    CNode net = Frontier.dequeue();
	    if(Maze[net.getY()][net.getX()] != '#' && Maze[net.getY()][net.getX()] != '-'){
		if(animate){
		    wait(100);
		    System.out.println(clear+toString());
		}


		if(Maze[net.getY()][net.getX()] == 'E'){
		    for(int i = 0; i < Maze.length*Maze[0].length; i++){
			if(Maze[i%Maze.length][i/Maze.length] == '-')
			    Maze[i%Maze.length][i/Maze.length] = ' ';
		    }
		    net = net.getNext();
		    while(net.hasNext()){
			Maze[net.getY()][net.getX()] = '@';
			net = net.getNext();
			if(animate){
			    wait(100);
			    System.out.println(clear+toString());
			}
		    }
		    Maze[net.getY()][net.getX()] = 'S';
		    if(animate){
			wait(100);
			System.out.println(clear+toString());
		    }
		    return true;
		}

		if(net.getY() != starty || net.getX() != startx){
		Maze[net.getY()][net.getX()] = '-';
		}
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
    public boolean solve(boolean animate,int type){
	if(type == 0)
	    return solveDFS(animate);
	if(type == 1)
	    return solveBFS(animate);
	if(type == 2)
	    return solveBest(animate);
	return solveAStar(animate);
    }
    public int[] solutionCoordinates(){
	solveBFS(false);
	int i = 0;
	int xcor = startx;
	int ycor = starty;
	while(Maze[ycor][xcor] != 'E'){
	    if(Maze[ycor][xcor] == '@'){
		Maze[ycor][xcor] = '$';
	    }
	    i++;
	    if(Maze[ycor+1][xcor] == '@'|| Maze[ycor+1][xcor] == 'E'){
		ycor++;
	    }else{
		if(Maze[ycor][xcor+1] == '@' || Maze[ycor][xcor+1] == 'E'){
		    xcor++;
		}else{
		    if(Maze[ycor-1][xcor] == '@' || Maze[ycor-1][xcor] == 'E'){
			ycor--;
		    }else{
			if(Maze[ycor][xcor-1] == '@' || Maze[ycor][xcor-1] == 'E'){
			    xcor--;
			}
		    }
		}
	    }
	}
	int[] ar = new int[i*2];
	xcor = startx;
	ycor = starty;
	i = 0;
	while(Maze[ycor][xcor] != 'E'){
	    if(Maze[ycor][xcor] == '$'){
		Maze[ycor][xcor] = ' ';
	    }
	    if(Maze[ycor+1][xcor] == '$'|| Maze[ycor+1][xcor] == 'E'){
		ycor++;
		ar[i] = xcor;
		i++;
		ar[i] = ycor;
		i++;
	    }else{
		if(Maze[ycor][xcor+1] == '$' || Maze[ycor][xcor+1] == 'E'){
		    xcor++;
		    ar[i] = xcor;
		    i++;
		    ar[i] = ycor;
		    i++;
		}else{
		    if(Maze[ycor-1][xcor] == '$' || Maze[ycor-1][xcor] == 'E'){
			ycor--;
			ar[i] = xcor;
			i++;
			ar[i] = ycor;
			i++;
		    }else{
			if(Maze[ycor][xcor-1] == '$' || Maze[ycor][xcor-1] == 'E'){
			    xcor--;
			    ar[i] = xcor;
			    i++;
			    ar[i] = ycor;
			    i++;
			}
		    }
		}
	    }
	}
	return ar;
    }
    public boolean solveBest(boolean animate){
	pQueue<CNode> Frontier = new pQueue<CNode>(new CNode(startx, starty, null), 0);
	int Ex = 0;
	int Ey = 0;
	for(int i = 0; i < Maze.length*Maze[0].length; i++){
	    if(Maze[i%Maze.length][i/Maze.length] == 'E'){
		Ey = i%Maze.length;
		Ex = i/Maze.length;
	    }
	}
	while(Frontier.hasNext()){
	    CNode net = Frontier.dequeue();
	    if(Maze[net.getY()][net.getX()] != '#' && Maze[net.getY()][net.getX()] != '-'){
		if(animate){
		    wait(100);
		    System.out.println(clear);
		    System.out.println(toString());
		    System.out.println("Frontier:"+net.toString());
		}


		if(Maze[net.getY()][net.getX()] == 'E'){
		    for(int i = 0; i < Maze.length*Maze[0].length; i++){
			if(Maze[i%Maze.length][i/Maze.length] == '-')
			    Maze[i%Maze.length][i/Maze.length] = ' ';
		    }
		    net = net.getNext();
		    while(net.hasNext()){
			Maze[net.getY()][net.getX()] = '@';
			net = net.getNext();
			if(animate){
			    wait(100);
			    System.out.println(clear+toString());
			}
		    }
		    Maze[net.getY()][net.getX()] = 'S';
		    if(animate){
			wait(100);
			System.out.println(clear+toString());
		    }
		    return true;
		}

		if(net.getY() != starty || net.getX() != startx){
		Maze[net.getY()][net.getX()] = '-';
		}
		CNode al = new CNode(net.getX()+1, net.getY(), net);
		CNode bl = new CNode(net.getX()-1, net.getY(), net);
		CNode cl = new CNode(net.getX(), net.getY()+1, net);
		CNode dl = new CNode(net.getX(), net.getY()-1, net);
		Frontier.enqueue(al, Math.abs(al.getX()-Ex)+Math.abs(al.getY()-Ey));
		Frontier.enqueue(bl, Math.abs(bl.getX()-Ex)+Math.abs(bl.getY()-Ey));
		Frontier.enqueue(cl, Math.abs(cl.getX()-Ex)+Math.abs(cl.getY()-Ey));
		Frontier.enqueue(dl, Math.abs(dl.getX()-Ex)+Math.abs(dl.getY()-Ey));
	    }
	}
	return false;
    }
    public boolean solveAStar(boolean animate){
	pQueue<CNode> Frontier = new pQueue<CNode>(new CNode(startx, starty, null), 0);
	int Ex = 0;
	int Ey = 0;
	for(int i = 0; i < Maze.length*Maze[0].length; i++){
	    if(Maze[i%Maze.length][i/Maze.length] == 'E'){
		Ey = i%Maze.length;
		Ex = i/Maze.length;
	    }
	}
	while(Frontier.hasNext()){
	    CNode net = Frontier.dequeue();
	    if(Maze[net.getY()][net.getX()] != '#' && Maze[net.getY()][net.getX()] != '-'){
		if(animate){
		    wait(100);
		    System.out.println(clear);
		    System.out.println(toString());
		    System.out.println("Frontier:"+net.toString());
		}


		if(Maze[net.getY()][net.getX()] == 'E'){
		    for(int i = 0; i < Maze.length*Maze[0].length; i++){
			if(Maze[i%Maze.length][i/Maze.length] == '-')
			    Maze[i%Maze.length][i/Maze.length] = ' ';
		    }
		    net = net.getNext();
		    while(net.hasNext()){
			Maze[net.getY()][net.getX()] = '@';
			net = net.getNext();
			if(animate){
			    wait(100);
			    System.out.println(clear+toString());
			}
		    }
		    Maze[net.getY()][net.getX()] = 'S';
		    if(animate){
			wait(100);
			System.out.println(clear+toString());
		    }
		    return true;
		}

		if(net.getY() != starty || net.getX() != startx){
		Maze[net.getY()][net.getX()] = '-';
		}
		CNode al = new CNode(net.getX()+1, net.getY(), net);
		CNode bl = new CNode(net.getX()-1, net.getY(), net);
		CNode cl = new CNode(net.getX(), net.getY()+1, net);
		CNode dl = new CNode(net.getX(), net.getY()-1, net);
		Frontier.enqueue(al, Math.abs(al.getX()-Ex)+Math.abs(al.getY()-Ey)+net.size());
		Frontier.enqueue(bl, Math.abs(bl.getX()-Ex)+Math.abs(bl.getY()-Ey)+net.size());
		Frontier.enqueue(cl, Math.abs(cl.getX()-Ex)+Math.abs(cl.getY()-Ey)+net.size());
		Frontier.enqueue(dl, Math.abs(dl.getX()-Ex)+Math.abs(dl.getY()-Ey)+net.size());
	    }
	}
	return false;
    }
}