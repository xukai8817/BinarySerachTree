package com.edu.tree.red.black;

import com.edu.tree.AbstractTree;

/**
 * @author xukai 红黑树
 */
public class RBTree<E extends Comparable<E>> extends AbstractTree<E> {

	private RBTreeNode<E> root;

	private int size;

	public RBTree() {
	}

	public RBTree(E[] objects) {
		for (E e : objects) {
			insert(e);
		}
	}

	@Override
	public boolean search(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(E e) {
		RBTreeNode<E> newNode = createRBTreeNode(e);
		RBTreeNode<E> parent = null; // 插入元素的父结点
		if (root == null) {
			root = newNode;
			root.red = false;
		} else {
			RBTreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.e) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.e) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}
			}
			if (e.compareTo(parent.e) < 0) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		}
		newNode.parent = parent;
		root = RBTreeNode.balanceInsertion(root, newNode);
		size ++;
		return true;
	}

	public RBTreeNode<E> createRBTreeNode(E e) {
		return new RBTreeNode<E>(e);
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		return size;
	}

	public RBTreeNode<E> getRoot() {
		return root;
	}

}