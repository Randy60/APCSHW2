public class Recursion{
    public String name(){
	return "Higgins,Randolph";
    }
    public int fact(int n){
	if(n < 0)
	    throw new IllegalArgumentException("nope");
	if(n == 1 || n == 0){
	    return n;
	}else{
	    return n * fact(n - 1);
	}
    }
    public int fib(int n){
	if(n < 0)
	    throw new IllegalArgumentException("nope");
	if(n == 1 || n == 0){
	    return 1;
	}else{
	    return  fib(n - 1)+fib(n - 2);
	}
    }
    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("nope");
	}else{
	    if(n == 0)
		return 0;
	    return sqrt(n, n / 2.0);
	}
    }
    public double sqrt(double n, double guess){
	if(guess*guess > n && (guess*guess)%n < n/10000){
	    return guess;
	}else{
	    return sqrt(n,(n / guess + guess)/2);
	}
    }
}