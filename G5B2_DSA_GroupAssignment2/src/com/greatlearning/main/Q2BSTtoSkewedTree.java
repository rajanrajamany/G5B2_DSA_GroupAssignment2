package com.greatlearning.main;

class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

public class Q2BSTtoSkewedTree {

	Node node;
	static Node prevNode = null;
	static Node newRootNode = null;

	void skeweTree(Node root) {
		if (root == null) {
			return;
		}

		skeweTree(root.left);

		if (newRootNode == null) {
			// This will ensure the left most node which is smallest in the BST is assigned
			// as new root node. - G5 B2
			newRootNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		skeweTree(root.right);
	}

	void printRightSkewedTree(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printRightSkewedTree(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Q2BSTtoSkewedTree tree = new Q2BSTtoSkewedTree();

		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		System.out.println("Right Skewed Tree is :- ");
		tree.skeweTree(tree.node);
		tree.printRightSkewedTree(newRootNode);
	}
}
