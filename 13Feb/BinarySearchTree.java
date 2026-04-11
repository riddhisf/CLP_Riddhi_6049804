package Treee;

public class BinarySearchTree {
	public static void main(String [] args) {
		Tree tree= new Tree();
		tree.root=tree.insert(50,tree.root);
		tree.root=tree.insert(60,tree.root);
		tree.root=tree.insert(40,tree.root);
		tree.root=tree.insert(30,tree.root);
		tree.root=tree.insert(10,tree.root);
		tree.root=tree.insert(70,tree.root);
		
		tree.inOrder(tree.root);
	}

}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

class Tree{
	Node root;
	
	Tree(){
		root=null;
	}
	
	public Node insert(int data, Node root) {
		if(root==null) {
			return new Node(data);
		}
		else if(data<root.data) {
			root.left= insert(data,root.left);
		}
		else {
			root.right= insert(data,root.right);
		}
		return root;
	}
	
	public void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data+" ");
		inOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data+" ");
	}
}