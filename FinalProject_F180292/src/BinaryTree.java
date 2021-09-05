import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private BinaryNode root;

	public BinaryTree(BinaryNode root) {
		super();
		this.root = root;
	}

	public BinaryTree() {
		// TODO Auto-generated constructor stub
		root = null; // the root to be null automatically
	}

	public void inorderPrint(BinaryNode binaryNode) {
		if (binaryNode == null) {
			return;
		}
		inorderPrint(binaryNode.getLeft());
		System.out.println(binaryNode.getData());
		inorderPrint(binaryNode.getRight());
	}

	public void preorderPrint(BinaryNode binaryNode) {
		if (binaryNode == null) {
			return;
		}
		System.out.println(binaryNode.getData());
		preorderPrint(binaryNode.getLeft());
		preorderPrint(binaryNode.getRight());
	}

	public void postorderPrint(BinaryNode binaryNode) {
		if (binaryNode == null) {
			return;
		}
		postorderPrint(binaryNode.getLeft());
		postorderPrint(binaryNode.getRight());
		System.out.println(binaryNode.getData());
	}

	public void byLevelPrint() {
		// if the first node "the root" is null
		if (root == null) {
			return;
		}
		// using the queue
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.add(root); // add the node to the q
		while (!q.isEmpty()) {
			BinaryNode temp = q.peek(); // get from the q and have it in temp node
			q.poll(); // remove from the q
			System.out.println(temp.getData());
			if (temp.getLeft() != null) {
				q.add(temp.getLeft()); // enqueue the left if not null
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());// enqueue the right if not null
			}
		}

	}

	public void byLevelWithBool() {
		// if the first node "the root" is null
		if (root == null) {
			return;
		}
		// using the queue
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.add(root); // add the node to the q
		while (!q.isEmpty()) {
			BinaryNode temp = q.peek(); // get from the q and have it in temp node
			q.poll(); // remove from the q
			System.out.print(temp.getData());
			System.out.println("   " + temp.isBool());
			if (temp.getLeft() != null) {
				q.add(temp.getLeft()); // enqueue the left if not null
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());// enqueue the right if not null
			}
		}

	}

	public boolean search(int key) {
		boolean found = false;
		if (root == null) {
			return found;
		}
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryNode temp = q.element();
			q.poll();
			if (temp.getData() == key) {
				found = true;
				break;
			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return found;
	}

	public BinaryNode searchBinaryNode(int key) {
		BinaryNode found = null;
		if (root == null) {
			return found;
		}
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryNode temp = q.element();
			q.poll();
			if (temp.getData() == key) {
				found = temp;
				break;
			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return found;
	}

	public void insert(BinaryNode newNode) {
		if (root == null) {
			root = newNode;
			return; // to go outside the method as our work is done, to avoid the error
		}
		// using dequeue as queue
		Deque<BinaryNode> q = new LinkedList<>();
		q.offer(root);
		while (q.size() != 0) {
			BinaryNode temp = q.poll();
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			} else {
				temp.setLeft(newNode);
				break;
			}

			if (temp.getRight() != null) {
				q.add(temp.getRight());
			} else {
				temp.setRight(newNode);
				break;
			}
		}
	}

	public void insertNodes(int... array) {
		if (array.length == 0) {
			return;
		}
		BinaryNode[] newNode = new BinaryNode[array.length];
		for (int i = 0; i < newNode.length; i++) {
			newNode[i] = new BinaryNode(array[i]);
		}
		if (root == null) {
			root = newNode[0];
		}
		int i = 1;
		while (i < newNode.length) {
			Queue<BinaryNode> q = new LinkedList<BinaryNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				BinaryNode temp = q.remove();
				if (temp.getLeft() != null) {
					q.add(temp.getLeft());
				} else {
					temp.setLeft(newNode[i]);
					break;
				}
				if (temp.getRight() != null) {
					q.add(temp.getRight());
				} else {
					temp.setRight(newNode[i]);
					break;
				}
			}
			i++;
		}

	}

	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
}
