import java.util.*;
public class Sorts{
    public boolean check(int[] ar){
	for(int i = 0; i < ar.length - 1; i++){
	    if(ar[i] - ar[i+1] > 0){
		return false;
	    }
	}
	return true;
    }
    public void merge(int[] ar){
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
	    merge(ar1);
	    merge(ar2);
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
    public void insertion(int[] ar){
	int x = 0;
	int z = ar.length - 1;
	while(x < z){
	    if(ar[x] <= ar[x+1]){
		x++;
	    }else{
		int i = ar[x];
		ar[x] = ar[x+1];
		ar[x+1] = i;
		if(x!=0){
		    x--;
		}
	    }
	}
    }
    public void radix(int[] ar){
	boolean okay = true;
	for(int i = 0; okay; i++){
	    int ov = 10;
	    for(int j = i; j > 0; j--)
		ov*=10;
	    int[][] lists = new int[10][ar.length];
	    int[] counts = new int[10];
	    for(int j = 0; j < ar.length; j++){
		list[ar[j]%ov][counts[ar[j]%ov]] = ar[j];
		counts[ar[j]%ov]++;
	    }
	    int k = 0;
	    for(int j = 0; k < 10; j++){
		
	    }
	}
}