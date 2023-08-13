package treeTest;

import java.io.IOException;
import java.util.ArrayList;

import studentDM.StudentDM;
import studentPD.Student;
import treePD.BinaryTree;
import treePD.BinaryTree.Entry;

public class BinaryTreeTest {
	BinaryTree<Integer, Student> tree;
	StudentDM students;
	ArrayList<Student> studentList;

	public BinaryTreeTest() {
		tree = new BinaryTree<Integer, Student>();
		studentList = new ArrayList<Student>();
		students = new StudentDM();
	}
	
	/**
	* testTree() tests the provided binary tree with hardcoded dummy data to ensure
	* the insert, search, and remove functions function properly accordingly
	*/
	public void testTree() throws IOException {
		students.readStudentData();
		studentList = students.getStudentData();
		
		fillTree(tree, studentList);

		System.out.println("Binary Tree Test");
		System.out.println("Binary Tree Height = " + tree.height(tree.getRoot()));
		
		System.out.println("Search for 782209 - Anthony");
		System.out.println("Search result: " + tree.search(782209));
		
		tree.remove(782209);
		System.out.println("Removed 782209");
		System.out.println("Search for 782209");
		
		if (tree.search(782209) == null)
			System.out.println("Search result: 782209 not found");
		else
			System.out.println("Search result: " + tree.search(782209));
	}
	
	/**
	* fillTree() fills the tree with provided data
	* 
	* @param t		a tree to fill the data into
	* @param data	data to fill the tree with
	*/
	public void fillTree(BinaryTree t, ArrayList<Student> data) {
		for (int i = 0; i < data.size(); i++) {
			if (i == 0) {
				t.setRoot(data.get(i).getId(), data.get(i).getName());
			}
			t.getRoot().insert(data.get(i).getId(), data.get(i).getName());
		}
	}
}
