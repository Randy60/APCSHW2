public class HeapSort{
    public static void main(String[]args){
	int[] q = new int[100000];
	for(int i = 0; i < q.length; i++)
	    q[i] = (int)(Math.random()*100);
	System.out.println(check(q));
	sort(q);
	System.out.println(check(q));
    }
    public static boolean check(int[] ar){
	boolean right = true;
	for(int i = 1; i < ar.length; i++)
	    if(ar[i-1] > ar[i])
		right = false;
	return right;
    }
    public static int[] sort(int[] a){
	MyHeap alex = new MyHeap();
	alex.add(Integer.MIN_VALUE);
	for(int i = 0; i < a.length; i++)
	    alex.add(a[i]);
	for(int i = 0; i < a.length; i++)
	    a[a.length-i-1] = alex.remove();
	return a;
    }
}