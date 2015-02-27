public class Sorts{
    
    public static void mergeSort(int[] ar){
	if(ar.length <= 64){
	    insertion(ar);
	}else{
	    int[] ar1 = new int[ar.length/2];
	    int[] ar2 = new int[ar.length - ar.length/2];
	    int i = 0;
	    while(i < ar1.length){
		ar1[i]= ar[i];
		i++;
	    }
	    i = 0;
	    while(i < ar2.length){
		ar2[i] = ar[i + ar1.length - 1];
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