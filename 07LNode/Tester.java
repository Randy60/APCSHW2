public class Tester{
    public static void main(String[]args){
	for(int i = 0; i < 10000000; i++){
	    String s = "Ca";
	    int x = i;
	    while(x > 250){
		s+="a";
		x/=3;
		if(x%7==4)
		    s+="a";
		if(x%3 == 2)
		    s+= "a";
	    }
	    s+="rl";
	    System.out.println(s);
	}   
    }
}