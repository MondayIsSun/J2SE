package datastruct.tree;

import util.Tools;

public class BTree {

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 初始化二叉树的根节点
	public CBTNode_Pre initTree() {
		CBTNode_Pre root = new CBTNode_Pre();
		System.out.print("请输入根节点的数据---> ");
		root.data = Tools.input();// 这个工具类以及保证了输入不为空了
		root.left = null;
		root.right = null;
		return root;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 由前序遍历的顺序建立二叉树
	// "AB#D##C##"
	public static void createBinaryTreeByPreOrder(CBTNode_Pre node) {
		String ch = Tools.input();
		if ("#".equals(ch)) {
			node = null;
		} else {
			node.data = ch;
			node.left = new CBTNode_Pre();
			node.right = new CBTNode_Pre();
			createBinaryTreeByPreOrder(node.left);
			createBinaryTreeByPreOrder(node.right);
		}
		return;
	}

	// 前序遍历算法（前序无论是遍历还是建立都是从根节点开始的）
	public static void preOrderTraverse(CBTNode_Pre node) {
		if (node == null) {
			return;
		}
		if (node.data != null) {
			System.out.print(node.data);
		} else {
			System.out.print("#");
		}
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 由中遍历的顺序建立二叉树--->左子树--->右子树
	// 无论是中序遍历还是后序遍历都是从树的最左下角的叶子节点开始
	// #B#D#A#C#
	public static void createBinaryTreeByInOrder(CBTNode_In node) {
		String ch = Tools.input();
		if ("#".equals(ch)) {
			ch = Tools.input();
			node = new CBTNode_In();
			node.parent = new CBTNode_In();
		} else {
			// 创建中间节点
			node.data = ch;
		}
	}

	// 中序遍历算法
	public static void inOrderTraverse() {

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 由后序遍历的顺序建立二叉树
	public static void createBinaryTreeByPostOrder(CBTNode_Pre node) {

	}

	// 后序遍历算法
	public static void postOrderTraverse() {

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public static void main(String[] args) {
		CBTNode_Pre root = new CBTNode_Pre();
		// 前序遍历顺建立二叉树
		BTree.createBinaryTreeByPreOrder(root);
		// 前序遍历二叉树
		BTree.preOrderTraverse(root);
	}
}
