import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	if(root == null){
	    root = new BSTreeNode<T>(c);
	    return;
	}
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	boolean Left = (curr.getData().compareTo(t.getData()) >= 0);
	if(Left){
	    if(curr.getLeft() == null){
		curr.setLeft(t);
		return curr.getLeft();
	    }else{
		return add(curr.getLeft(), t);
	    }
	}else{
	    if(curr.getRight() == null){
		curr.setRight(t);
		return curr.getRight();
	    }else{
		return add(curr.getRight(), t);
	    }
	}
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	if(curr == null)
	    return null;
	if(c.equals(curr.getData())){
	    if(isLeaf(curr)){
		BSTreeNode<T> n = curr;
		curr = null;
		return n;
	    }
	    BSTreeNode<T> carl = curr;
	    if(curr.getRight() == null){
		return curr = curr.getLeft();
	    }else{
		carl = carl.getRight();
		while(carl.getLeft() != null){
		    carl = carl.getLeft();
		}
		curr.setData(carl.getData());
		return curr;
	    }
	}
	if(c.compareTo(curr.getData()) < 0){
	    return remove(curr.getLeft(), c);
	}else{
	    return remove(curr.getRight(), c);
	}
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

   
    public static void main( String[] args ) {

    }
    private class BSTreeNode<T extends Comparable> {

	private T data;
	private BSTreeNode<T> left;
	private BSTreeNode<T> right;

	public BSTreeNode( T d ) {
 
	    data = d;
	    left = right = null;
	}
    
	//accessors
	public T getData() {
	    return data;
	}
	public BSTreeNode<T> getLeft(){
	    return left;
	}
	public BSTreeNode<T> getRight(){
	    return right;
	}

	//mutators
	public void setData( T d ) {
	    data = d;
	}
	public void setLeft( BSTreeNode<T> l ){
	    left = l;
	}
	public void setRight( BSTreeNode<T> r ){
	    right = r;
	}
    }
}