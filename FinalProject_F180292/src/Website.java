import java.util.ArrayList;
import java.util.Stack;

public class Website {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Database.about_komar(); // called for the protected static method

//		Person Admin = new Admin("Admin", "Admin", "admin@gmail.com", "Male"); // Polymorphism
//
//		Admin.login();
//		Admin.getUsers();

//		Person User = new User("User1", "1111", "user@gmail.com", "Male");
//		User.contact();

//		Student ali=new Student("User1", "1111", "user@gmail.com", "Male", "F180292");
//		Course one=new Course("Computer Engineering", "CE");
//		Course two=new Course("Pharmacy", "phr");
//		Course three=new Course("Computer Science", "CS");
//		Course four=new Course("Dentistry", "DEN");
//		Course five=new Course("Nursing", "NUR");
//		Course six=new Course("Business", "BUS");
//		
//		ali.addCourses(one,two,three,four,five,six);
//		for (Course var : ali.getCourses()) {
//			System.out.println(var);
//		}

//		DynamicArray<Object> myDynamicArray = new DynamicArray<Object>();
//		List<String>list=new ArrayList<String>();
//		list.add("Ali");
//		list.add("Muhammed");
//		
//		List<String>list2=new ArrayList<String>();
//		list2.add("Ali2");
//		list2.add("Muhammed2");
//		
//		myDynamicArray.add(list);
//		myDynamicArray.add(list2);
//		
//		
//		
//		myDynamicArray.shrink();
//		System.out.println(myDynamicArray);
		
		
		
		

//		Student ali=new Student("User1", "1111", "user@gmail.com", "Male", "F180292");
//		ali.calcMyAverage();
		
		
		
		
		
		

//		LinkedList<String> linked = new LinkedList<String>();
//		linked.insertAtBeginning("Doing");
//		linked.insertAtBeginning("you");
//		linked.insertAtBeginning("are");
//		linked.insertAtBeginning("How");
//
//		linked.insertAtLast("?");
//		linked.insertAtLast(".");
//
//		linked.insertAt(",", 4);
//
//		linked.deleteByPosition(6);
//
//		linked.deleteByKey("Doing");
//		linked.deleteByKey(",");
//
//		System.out.println(linked.search("Doing"));
//		linked.show();

//		BinaryTree binaryTree = new BinaryTree(new BinaryNode(1)); // root with null sides left and right
//		binaryTree.getRoot().setLeft(new BinaryNode(2));
//		binaryTree.getRoot().getLeft().setLeft(new BinaryNode(4));
//		binaryTree.getRoot().getLeft().setRight(new BinaryNode(5));
//		binaryTree.getRoot().setRight(new BinaryNode(3));
//
//		System.out.println(binaryTree.getRoot().getLeft().getLeft().getData());
//		System.out.println(binaryTree.getRoot().getLeft().getData());
//		System.out.println(binaryTree.getRoot().getLeft().getRight().getData());
//		System.out.println(binaryTree.getRoot().getData());
//		System.out.println(binaryTree.getRoot().getRight().getData());
//
//		binaryTree.inorderPrint(binaryTree.getRoot());
//		binaryTree.insert(new BinaryNode(100));
//		binaryTree.byLevelPrint();
//		System.out.println(binaryTree.getRoot().getRight().getLeft().getData());

//		BST bst = new BST(new BinaryNode(50));
//		bst.insert(40);
//		bst.insert(75);
//		bst.insert(60);		
//		bst.insert(80);
//		bst.insert(77);
//		bst.insert(90);
//		bst.insert(76);
//// 		System.out.println(bst.getRoot().getRight().getRight().getData());
//		bst.byLevelPrint();
//		
//		/*
//		 * 			10
//		 * 		8		11
//		 *	  7	  9 	   12
//		 * 
//		 */
//		
//		System.out.println();
////		bst.byLevelPrint();
////		System.out.println(bst.search(bst.getRoot(), new Node(8)));
//		
//		bst.deleteNode(50);
//		System.out.println();
//		bst.byLevelPrint();

//		stack.empty()
//		stack.peek();
//		stack.pop();
//		stack.push(null);
//		stack.search(stack);
		
		
		
		
		
		
		
		

//		LinkedList<Integer> list = new LinkedList<Integer>();
//
//		list.insertAtBeginning(3);
//		list.insertAtBeginning(5);
//		list.insertAtBeginning(4);
//		list.insertAtBeginning(1);
//		list.insertAtBeginning(2); // 2 1 4 5 3
//
//		System.out.println(ascDescMinMax(list).getIndexOf(0));
		
		
		
		
		
		
		
		
		
		
		
//		Graph DFS = new Graph(7);
//		/*
//		 * 		1
//		 * 	  2   3
//		 * 	 4 5   6
//		 */
//		DFS.addNode(1, 3);
//		DFS.addNode(1, 2);
//		DFS.addNode(2, 5);
//		DFS.addNode(2, 4);
//		DFS.addNode(2, 1);
//		DFS.addNode(4, 2);
//		DFS.addNode(5, 2);
//		DFS.addNode(3, 6);
//		DFS.addNode(3, 1);
//		DFS.addNode(6, 3);
		
//		DFS.DFSVisit(1);
//		DFS.graphListRepresentation();
//		DFS.searchDFSway(1, 6);
//		DFS.BFSVisit(1);
		
		
		
		
		
		
//		Instructor jaza=new Instructor("User1", "1111", "user@gmail.com", "Male");
//		Stack<Integer> s = new Stack<Integer>();
//		s.push(11);
//		s.push(12);
//		s.push(13);
//		s.push(14);
//		jaza.attendance(s);
//		jaza.isAttend(14);
//		jaza.addCourses("English","Arabic");
//		jaza.showCourses();
//		jaza.deleteCourseByKey(1);
//		jaza.showCourses();
//		jaza.deleteAllCourses();
//		jaza.showCourses();
		
	}
	
	
	
	


	/**
	 * 
	 * @param list of user defined class LinkedList
	 * @return dynamic array of sorted list asc and desc with the min and max values
	 *         that can get any of them by the index using getIndexOf() method
	 *         inside the DynamicArray class
	 */

	@SuppressWarnings("rawtypes")
	public static DynamicArray<ArrayList> ascDescMinMax(LinkedList<Integer> list) {
		if (list != null) {
			try {
				int min = 0;
				int max = 0;

				ArrayList<Integer> asc = new ArrayList<Integer>();
				ArrayList<Integer> desc = new ArrayList<Integer>();
				ArrayList<Integer> minMax = new ArrayList<Integer>();
				DynamicArray<ArrayList> arrayOfArrayList = new DynamicArray<ArrayList>();

				// stack to push the values from the linkedList to it
				Stack<Integer> mainStack = new Stack<Integer>();
				while (list.getHead() != null) {
					// to delete the first item from the list each loop, from the beginning
					mainStack.push(list.deleteByPosition(0).getData());
				}

				// temp stack to push the values from the first on to get desc ordered stack
				Stack<Integer> tempStack = new Stack<Integer>();
				while (!mainStack.empty()) {
					// remove from the main stack to a variable
					int temp = mainStack.pop();

					// if the top of the temp stack is greater than the temp var, to remove it and
					// add it to the main stack
					while (!tempStack.empty() && tempStack.peek() > temp) {
						int popped = tempStack.pop();
						mainStack.push(popped);
						asc.remove(asc.indexOf(popped));
					}
					// once the temp stack does not have any greater that value, add the temp var to
					// it
					tempStack.push(temp);
					asc.add(temp);
				}
				// get the max value from the top of the temp stack as it is desc ordered
				if (!tempStack.empty()) {
					max = tempStack.peek();
				}

				// pop from the temp to the main stack to inverse the list
				while (tempStack.search(tempStack.peek()) != -1) {
					int popped = tempStack.pop();
					mainStack.push(popped);
					desc.add(popped);
					if (tempStack.empty()) {
						break;
					}
				}

				// get the min from the main stack as it is asc ordered
				if (!mainStack.empty()) {
					min = mainStack.peek();
				}

				// adding min and max to the minMax array list
				minMax.add(min);
				minMax.add(max);

				arrayOfArrayList.add(asc);
				arrayOfArrayList.add(minMax);
				//it will be shifted
				arrayOfArrayList.addAt(1,desc);
				arrayOfArrayList.removeFrom(0);
				arrayOfArrayList.addAt(0,asc);
				

				return arrayOfArrayList;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}

		} else {
			return new DynamicArray<>();
		}
		

	}

}
