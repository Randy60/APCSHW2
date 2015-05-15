import java.util.*;
public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    private Random r = new Random();
    private int twoExpN(int a){
	int q = 1;
	for(int i = 1; i < a; i++)
	    q*=2;
	return q;
    }
    private TreeNode<E> root;
    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return root.maxLength(root);
    }
    public BTree() {
	root = null;
    }
    
    public void add( E d ) { 
	if(root != null)
	    root.add(d);
	else
	    root = new TreeNode<E>(d);
    }

    private void add( TreeNode<E> curr, TreeNode<E> bn ) {
	curr.add(bn);
    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    public void preOrder( TreeNode<E> curr ) {
	System.out.println(root.preOrder());
    }


    public void inOrder( TreeNode<E> curr ) {
		System.out.println(root.inOrder());
    }

    public void postOrder( TreeNode<E> curr ) {
	System.out.println(root.postOrder());
    }

    public int getHeight() {
	return root.getHeight();
    }

    public int getHeight(TreeNode<E> curr){
	return curr.getHeight();
    }
    
    private String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	return curr.getLevel(curr, level, level, getHeight());
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0

          1      2

            3  4   5

      ====================*/
    public String toString(){
	String s = "";
	int a = 0;
	int z = getHeight();
	for(int i = z;  i >= 0; i--){
	    String n = "";
	    n+=root.getLevel(root, i,i,z)+"\n";
	    s = n + s;
	    a++;
	}
	return s;
    }

    public static void main( String[] args ) {

	BTree<Character> t = new BTree<Character>();

	for (int i = 0; i < 30; i++){
	    char q = 'A';
	    for(int g = 0; g < i; g++){
		q++;
	    }
	    t.add(q);
	}
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
    private class TreeNode<T>{
	private TreeNode<T> left, right;
	private T val;
	public TreeNode(T it){
	    left = null;
	    right = null;
	    val = it;
	}
	public TreeNode<T> getRight(){
	    return right;
	}
	public TreeNode<T> getLeft(){
	    return left;
	}
	public void addL(T d){
	    left = new TreeNode<T>(d);
	}
	public void addR(T d){
	    right = new TreeNode<T>(d);
	}
	public void add(T d){
	    if(left == null){
		left = new TreeNode<T>(d);
		return;
	    }
	    if(right == null){
		right = new TreeNode<T>(d);
		return;
	    }
	    if(Math.random() < 0.5){
		left.add(d);
	    }else{
		right.add(d);
	    }
	}
	public void add(TreeNode<T> it){
	  if(left == null)
		left = it;
	    if(right == null)
		right = it;
	    if(Math.random() < 0.5){
		left = it;
	    }else{
		right = it;
	    }
	}   
	public String postOrder(){
	    String s = "";
	    if(left != null){
		s+=left.postOrder();
	    }
	    if(right != null){
		s+=right.postOrder();
	    }
	    s+=val+" ";
	    return s;
	}
	public T getValue(){
	    return val;
	}
	public String preOrder(){
	    String s = "";
	    s+=val+" ";
	    if(left != null){
		s+=left.preOrder();
	    }
	    if(right != null){
		s+=right.preOrder();
	    }
	    return s;
	}
	public String inOrder(){
	    String s = "";
	    if(left != null){
		s+=left.inOrder();
	    }
	    s+=val+" ";
	    if(right != null){
		s+=right.inOrder();
	    }
	    return s;
	}
	public int getHeight(){
	    int l = 1;
	    int r = 1;
	    if(left != null){
		l+=left.getHeight();
	    }
	    if(right != null){
		r+=right.getHeight();
	    }
	    if(r > l)
		return r;
	    return l;
	}
	public String getLevel(TreeNode<E> curr, int currLevel, int targetLevel, int height){
	    if (currLevel == 1)
		return curr.toString() + spaces(Math.pow(2, height - targetLevel + 1) - 1);
	    String result = "";
	    if (curr.getLeft() != null)
		result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height);
	    else result += spaces(Math.pow(2, height - targetLevel + currLevel - 1));
	    if (curr.getRight() != null)
		result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height);
	    else result += spaces(Math.pow(2, height - targetLevel + currLevel - 1));
	    return result;
	}
	
	private int maxLength(TreeNode<T> curr) {
	    int max = curr.toString().length();
	    int temp;
	    if (curr.getLeft() != null) {
		temp = maxLength(curr.getLeft());
		if (temp > max)
		    max = temp;
	    }
	    if (curr.getRight() != null) {
		temp = maxLength(curr.getRight());
		if (temp > max)
		    max = temp;
	    }
	    return max;
	}
	public String toString(){
	    return ""+val;
	}
	private String spaces(double n) {
	    // returns a String of n spaces
	    String result = "";
	    for (int i = 0; i < n; i++)
		result += " ";
	    return result;
	}
    }
}