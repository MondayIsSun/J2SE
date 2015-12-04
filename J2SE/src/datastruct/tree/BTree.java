package datastruct.tree;

import util.Tools;

public class BTree {

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// ��ʼ���������ĸ��ڵ�
	public CBTNode_Pre initTree() {
		CBTNode_Pre root = new CBTNode_Pre();
		System.out.print("��������ڵ������---> ");
		root.data = Tools.input();// ����������Լ���֤�����벻Ϊ����
		root.left = null;
		root.right = null;
		return root;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// ��ǰ�������˳����������
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

	// ǰ������㷨��ǰ�������Ǳ������ǽ������ǴӸ��ڵ㿪ʼ�ģ�
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

	// ���б�����˳����������--->������--->������
	// ����������������Ǻ���������Ǵ����������½ǵ�Ҷ�ӽڵ㿪ʼ
	// #B#D#A#C#
	public static void createBinaryTreeByInOrder(CBTNode_In node) {
		String ch = Tools.input();
		if ("#".equals(ch)) {
			ch = Tools.input();
			node = new CBTNode_In();
			node.parent = new CBTNode_In();
		} else {
			// �����м�ڵ�
			node.data = ch;
		}
	}

	// ��������㷨
	public static void inOrderTraverse() {

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// �ɺ��������˳����������
	public static void createBinaryTreeByPostOrder(CBTNode_Pre node) {

	}

	// ��������㷨
	public static void postOrderTraverse() {

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public static void main(String[] args) {
		CBTNode_Pre root = new CBTNode_Pre();
		// ǰ�����˳����������
		BTree.createBinaryTreeByPreOrder(root);
		// ǰ�����������
		BTree.preOrderTraverse(root);
	}
}
