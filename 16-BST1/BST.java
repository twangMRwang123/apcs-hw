import java.io.*;
import java.util.*;

public class BST {

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(Node n){
	Node piggy = null;
	Node temp = root;
	if (root == null){
	    root = n;
	}
	else{
	    while (temp != null){
		if (temp.getData() > n.getData()){
		    piggy = temp;
		    temp = temp.getLeft();
		}
		else if (temp.getData() < n.getData()){
		    piggy = temp;
		    temp = temp.getRight();
		}
		else{
		    return;
		}
	    }
	    Node index = search(piggy.getData());
	    if (piggy.getData() > n.getData())
		index.setLeft(n);
	    else
		index.setRight(n);
	}
    }
	

    public Node search(int i){
	Node temp = root;
	while (temp != null){
	    if (temp.getData() == i)
		return temp;
	    else{
		if (temp.getData() > i)
		    temp = temp.getLeft();
		else if (temp.getData() < i)
		    temp = temp.getRight();
	    }
	}
	return null;
    }

    public Node search2(Node c, int x){
	if (c.getData() == x){
	    return c;
	}
	if (c == null){
	    return null;
	}
	else{
	    if (c.getData() > x){
		return search2(c.getLeft(), x);
	    }
	    else{
		return search2(c.getRight(), x);
	    }
	}
    }

    public void delete(Node n){
	// get a pointer to the parent of the node we want to delete.
	// 3 cases:
	// 1) node is a leaf - set parent's left/right to null
	// 2) node has one child - set parent's left/right to the node's non-null pointer
	// cases a and b can be combined
	// 3) node has 2 children 
	// - find the largest value on the left subtree (1 left, then as far right as possible)
	// - make a copy of that value
	// - pretend you have a tree w/ the node to delete as the root 
	// and delete the highest node in the left subtree (0/1 children) (recursive w/ fake root)
	// - replace the node to delete with the copied value
	// ROOT - treat as special case with if statement OR use a dummy node
	// dummy's value should be less than any possible tree value
    }
	    
	
    public static void main(String[] args){
	BST tree = new BST();
	Node test = new Node(72);
	tree.insert(new Node(3));
	tree.insert(new Node(45));
	tree.insert(new Node(0));
	System.out.println(tree.search(3).getLeft());
	tree.insert(new Node(12));
	tree.insert(new Node(206));
	tree.insert(test);
	tree.insert(new Node(54));
	tree.insert(new Node(84));
	tree.insert(new Node(76));	
	System.out.println(tree.search2(test,84).getLeft());
	tree.insert(new Node(207));
	System.out.println(tree.search(207).getLeft());
	tree.insert(new Node(206));
	System.out.println(tree.search(207).getRight());
	System.out.println(tree.search(12));
	System.out.println(tree.search(0).getRight());

    }

	
}

class Node {

    private int data;
    private Node left,right;

    public Node(int i) {
	data = i;
	left = null;
	right = null;
    }

    public void setData(int i) {
	data = i;
    }

    public int getData() {
	return data;
    }

    public void setLeft(Node n){
	left = n;
    }

    public void setRight(Node n){
	right = n;
    }

    public Node getLeft() {
	return left;
    }

    public Node getRight() {
	return right;
    } 

    public String toString() {
	return ""+data;
    }

}
