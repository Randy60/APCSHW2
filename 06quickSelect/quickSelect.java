import java.util.*;
public class quickSelect{
    public static void main(String[]args){
	Random r = new Random();
	int[]ar = new int[10000];
	int i = 0;
	while(i < ar.length){
	    ar[i] = r.nextInt(2000)-1000;
	    i++;
	}
	System.out.println(check(ar));
	ar = pivot(ar, 0, ar.length, 5);
	System.out.println(check(ar));
	//Arrays.sort(ar);
	//System.out.println(Arrays.toString(ar));
	//System.out.println(ar[4]);
    }
    public static int quickFind(int[]ary, int Si, int Ei, int num){
	Random r = new Random();
	int pivot = r.nextInt(Ei-Si) + Si;
	int[] D = new int[ary.length];
	for(int i = 0; i < ary.length; i++){
	    if(i < Si || i >= Ei){
		D[i] = ary[i];
	    }
	}
	//System.out.println(Arrays.toString(ary)+ "<<<");
	//int pivot = Si + r.nextInt(Ei-Si);
	int start = Si;
	int end = Ei - 1;
	for(int i = Si; i < Ei; i++){
	    //  System.out.println(Arrays.toString(D));
	    if(i != pivot){
		if(ary[i] < ary[pivot]){
		    D[start]=ary[i];
		    start++;
		}else{
		    if(ary[i] == ary[pivot]){
			if(i%2 == 1){
			    D[start]=ary[i];
			    start++;
			}else{
			    D[end]=ary[i];
			    end--;
			}
		    }else{
			D[end]=ary[i];
			end--;
		    }
		}
	    }
	}
	D[start] = ary[pivot];
	if(start == num){
	    return D[start];
	}
	if(num < start){
	    return quickFind(D, Si, start, num);
	}
	return quickFind(D, start+1, Ei, num);
    }
    public static boolean check(int[] ar){
	for(int i = 0; i < ar.length - 1; i++){
	    if(ar[i] - ar[i+1] > 0){
		return false;
	    }
	}
	return true;
    }
    public static int[] quickSort(int[]ar){
	return pivot(ar, 0, ar.length, ar.length/2);
    }
    public static int[] pivot(int[]ary, int Si, int Ei, int pivot){
	if(Ei-Si <= 1)
	    return ary;
	Random r = new Random();
	int[] D = new int[ary.length];
	for(int i = 0; i < ary.length; i++){
	    if(i < Si || i >= Ei){
		D[i] = ary[i];
	    }
	}
	//System.out.println(Arrays.toString(ary)+ "<<<");
	//int pivot = Si + r.nextInt(Ei-Si);
	int start = Si;
	int end = Ei - 1;
	for(int i = Si; i < Ei; i++){
	    //  System.out.println(Arrays.toString(D));
	    if(i != pivot){
		if(ary[i] < ary[pivot]){
		    D[start]=ary[i];
		    start++;
		}else{
		    if(ary[i] == ary[pivot]){
			if(i%2 == 1){
			    D[start]=ary[i];
			    start++;
			}else{
			    D[end]=ary[i];
			    end--;
			}
		    }else{
			D[end]=ary[i];
			end--;
		    }
		}
	    }
	}
	D[start] = ary[pivot];
	D = pivot(D, Si, end, (start+Si)/2);
	D = pivot(D, start, Ei, r.nextInt(Ei-end)+end);
	return D;
    }
}