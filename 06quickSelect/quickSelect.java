import java.util.*;
public class quickSelect{
    public static void main(String[]args){
	Random r = new Random();
	int[]ar = new int[10];
	int i = 0;
	while(i < ar.length){
	    ar[i] = r.nextInt(200);
	    i++;
	}
	System.out.println(Arrays.toString(ar));
	ar = pivot(ar,0,10);
	System.out.println(Arrays.toString(ar));
	//Arrays.sort(ar);
	//System.out.println(Arrays.toString(ar));
	//System.out.println(ar[4]);
    }

    /*
    public static int pivotFind(int[]ary, int find){
	int start = 0;
	int end = ary.length;
	int now = 1;
	while(find != now){
	    System.out.println(Arrays.toString(ary)+"\n"+start+":"+end);
	    now = partition(ary, start, end);
	    if(now > find){
		end = now;
	    }
	    if(now < find){
		start = now;
	    }
	    System.out.println(Arrays.toString(ary));
	}
	return ary[now];
    }
    */
    public static int[] pivot(int[]ary, int Si, int Ei){
	Random r = new Random();
	int[] D = new int[ary.length];
	for(int i = 0; i < ary.length; i++){
	    if(i < Si && i >= Ei){
		D[i] = ary[i];
	    }
	}
	int pivot = Si + r.nextInt(Ei-Si);
	int start = Si;
	int end = Ei - 1;
	for(int i = Si; i < Ei; i++){
	    System.out.println(Arrays.toString(D));
	    if(ary[i] != ary[pivot]){
		if(ary[i] < ary[pivot]){
		    D[start]=ary[i];
		    start++;
		}else{
		    D[end]=ary[i];
		    end--;
		}
	    }else{
		if(i != pivot){
		    if(i%2 == 0){
			D[start]=ary[i];
			start++;
		    }else{
			D[end]=ary[i];
			end--;
		    }
		}
	    }
	}
	D[start] = ary[pivot];
	ary = D;
	System.out.println(Arrays.toString(ary));
    }
}