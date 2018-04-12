package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node1 {
	int data;
	Node1 left = null;
	Node1 right = null;
}

public class Baekjoon5639 {
	public static Node1 root = new Node1();
	public static ArrayList<Integer> list=new ArrayList<Integer>();
	public static Node1 insert(Node1 root, int data) {
		Node1 p = root;
		Node1 newNode = new Node1();
		newNode.data = data;

		if (p == null) {
			//System.out.println(newNode.data);
			return newNode;
		} else if (p.data > newNode.data) {
			p.left = insert(p.left, data);
			//System.out.println(p.data);
			return p;
		} else if (p.data < newNode.data) {
			p.right = insert(p.right, data);
			//System.out.println(p.data);
			return p;
		} else{
			//System.out.println(p.data);
			return p;
			}
	}

	public static void insertBST(int data) {
		root = insert(root, data);
	}

	public static void postOrder(Node1 pNode) {
		if (pNode != null) {
			postOrder(pNode.left);
			postOrder(pNode.right);
			list.add(pNode.data);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		while ((tmp = in.readLine())!=null&&tmp.length()!=0) {
			int value = Integer.parseInt(tmp);
			insertBST(value);
		}
		postOrder(root);
		for(int i=0;i<list.size()-1;i++)
		{
			System.out.println(list.get(i));
		}
	}

}
