import java.util.*;
public class Sorts{
    public static void main(String[]args){
	int i = 100000;
	if(args.length > 0){
	    i = Integer.parseInt(args[0]);
	}
	int[]ary=new int[i];
	Random r = new Random(234141);
	for(int j = 0; j < ary.length; j++){
	    ary[j] = r.nextInt(10000)-5000;
	}
	System.out.println(check(ary));
	mergeSort(ary);
	System.out.println(check(ary));

    }
    public static boolean check(int[] ar){
	 for(int i = 0; i < ar.length - 1; i++){
	     if(ar[i] - ar[i+1] > 0){
		 return false;
	     }
	 }
	 return true;
     }
    public static void mergeSort(int[] ar){
	if(ar.length < 64){
	    insertion(ar);
	}else{
	    int[] ar1 = new int[ar.length/2];
	    int[] ar2 = new int[ar.length - ar.length/2];
	    boolean n = true;
	    int i = 0;
	    int i1 = 0;
	    int i2 = 0;
	    while(i < ar.length){
		if(n = !n){
		    ar1[i1] = ar[i];
		    i1++;
		}else{
		    ar2[i2] = ar[i];
		    i2++;
		}
		i++;
	    }
	    mergeSort(ar1);
	    mergeSort(ar2);
	    int ar1c = 0;
	    int ar2c = 0;
	    for(int x = 0; x < ar.length; x++){
		if(ar2c == ar2.length){
		    ar[x] = ar1[ar1c];
		    ar1c++;
		}else{
		    if(ar1c == ar1.length){
			ar[x] = ar2[ar2c];
			ar2c++;
		    }else{
			if(ar1[ar1c]-ar2[ar2c] < 0){
			    ar[x] = ar1[ar1c];
			    ar1c++;
			}
			else{
			    ar[x] = ar2[ar2c];
			    ar2c++;
			}
		    }
		}
	    }
	}
    }
    public static void insertion(int[] ar){
	int x = 0;
	while(x < ar.length - 1){
	    if(ar[x]-ar[x+1] <= 0){
		x++;
	    }else{
		int i = ar[x];
		ar[x] = ar[x+1];
		ar[x+1] = i;
	 	if(x>0){
		    x--;
		}
	    }
	}
    }
}