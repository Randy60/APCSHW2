import java.util.*;
public class Pasture{
    public static void main(String[]args){
	Scanner s = new Scanner(System.in);
	char[][] field = new char[s.nextInt()][s.nextInt()];
	int T = s.nextInt();
	for(int i = 0; i < field.length; i++){
	    for(int j = 0; j < field[0].length; j++){
		field[i][j] = s.next().charAt(0);
	    }
	}
	System.out.println("\n"+"{}{{}");
	System.out.println(goTo(field, s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), T));
	for(int i = 0; i < field.length; i++){
	    String n = "\n";
	    for(int j = 0; j < field[0].length; j++){
		n+=field[i][j];
	    }
	    System.out.println(n);
	}
    }


    public static int goTo(char[][]field, int R1, int C1, int R2, int C2, int T){
	if(R1 < 0 || C1 < 0 || R1 >= field[0].length || C1 >= field.length || T < 0 || Math.abs((R1-R2)+(C1-C2)) > T || field[C1][R1] == '*')
	    return 0;
	if(C1 == C2 && R1 == R2){
	    return 1;
	}
	return goTo(field, R1+1, C1, R2, C2, T-1)+goTo(field, R1-1, C1, R2, C2, T-1)+goTo(field, R1, C1+1, R2, C2, T-1)+goTo(field, R1, C1-1, R2, C2, T-1);
    }
}