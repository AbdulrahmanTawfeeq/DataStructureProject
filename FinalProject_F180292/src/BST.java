import java.util.LinkedList;
import java.util.Queue;

public class BST {
	private BinaryNode root;

	public BST(BinaryNode root) {
		super();
		this.root = root;
	}

	public BST() {
		// TODO Auto-generated constructor stub
	}

	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	/**
	 * To insert the node by using the recursion way
	 */
	public void insert(int data) {
		BinaryNode nodeToAdd = new BinaryNode(data);
		if (root == null) {
			setRoot(nodeToAdd);
		} else {
			traverseAndAddNode(root, nodeToAdd);
		}
	}

	private void traverseAndAddNode(BinaryNode binaryNode, BinaryNode nodeToAdd) {
		if (nodeToAdd.getData() < binaryNode.getData()) {
			if (binaryNode.getLeft() == null) {
				nodeToAdd.setParent(binaryNode);// every new node to save its parent
				binaryNode.setLeft(nodeToAdd);
			} else {
				traverseAndAddNode(binaryNode.getLeft(), nodeToAdd);
			}
		} else if (nodeToAdd.getData() > binaryNode.getData()) {
			if (binaryNode.getRight() == null) {
				nodeToAdd.setParent(binaryNode);// every new node to save its parent
				binaryNode.setRight(nodeToAdd);
			} else {
				traverseAndAddNode(binaryNode.getRight(), nodeToAdd);
			}
		}

	}

	public BinaryNode search(BinaryNode parent, BinaryNode nodeToFind) {
		if (parent == null || parent.getData() == nodeToFind.getData()) {
			return parent;
		} else {
			if (nodeToFind.getData() < parent.getData()) {
				return search(parent.getLeft(), nodeToFind);
			} else if (nodeToFind.getData() > parent.getData()) {
				return search(parent.getRight(), nodeToFind);
			}
		}
		return null;

	}

	public void deleteNode(int value) {
		BinaryNode binaryNode = new BinaryNode(value);
		BinaryNode nodeToBeDeleted = search(root, binaryNode);
		if (nodeToBeDeleted != null) {
			if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
				deleteCase1(nodeToBeDeleted);
			} else if (nodeToBeDeleted.getLeft() != null && nodeToBeDeleted.getRight() != null) {
				// case of the deleted node has two children
				deleteCase3(nodeToBeDeleted);
			} else if (nodeToBeDeleted.getLeft() != null) {
				deleteCase2(nodeToBeDeleted);
			} else if (nodeToBeDeleted.getRight() != null) {
				deleteCase2(nodeToBeDeleted);
			}
		}
	}

	private void deleteCase3(BinaryNode nodeToBeDeleted) {
		BinaryNode minNode = minLeftTraversal(nodeToBeDeleted.getRight()); // we saved the min left node in var
		System.out.println(minNode);
		deleteCase1(minNode); // we deleted it by this method as it does not have children
		minNode.setLeft(nodeToBeDeleted.getLeft());
		minNode.setRight(nodeToBeDeleted.getRight());
		minNode.setParent(nodeToBeDeleted.getParent());
		// in case of deleting the root, it has no parent
		if (nodeToBeDeleted.getParent() == null) {
			setRoot(minNode);
		} else {
			if (nodeToBeDeleted.getParent().getLeft() == nodeToBeDeleted) {
				nodeToBeDeleted.getParent().setLeft(minNode);
			} else if (nodeToBeDeleted.getParent().getRight() == nodeToBeDeleted) {
				nodeToBeDeleted.getParent().setRight(minNode);
			}
		}

	}

	private BinaryNode minLeftTraversal(BinaryNode binaryNode) {
		if (binaryNode.getLeft() == null) {
			return binaryNode;
		}
		return minLeftTraversal(binaryNode.getLeft());
	}

	private void deleteCase2(BinaryNode nodeToBeDeleted) {
		if (nodeToBeDeleted.getParent() == null) {
			if (nodeToBeDeleted.getLeft() != null) {
				setRoot(nodeToBeDeleted.getLeft());
				nodeToBeDeleted = null;
			} else if (nodeToBeDeleted.getRight() != null) {
				setRoot(nodeToBeDeleted.getRight());
				nodeToBeDeleted = null;
			}
		} else {
			if (nodeToBeDeleted.getParent().getLeft() == nodeToBeDeleted) {
				if (nodeToBeDeleted.getLeft() != null) {
					nodeToBeDeleted.getParent().setLeft(nodeToBeDeleted.getLeft());
					nodeToBeDeleted.getLeft().setParent(nodeToBeDeleted.getParent());
				} else if (nodeToBeDeleted.getRight() != null) {
					nodeToBeDeleted.getParent().setLeft(nodeToBeDeleted.getRight());
					nodeToBeDeleted.getRight().setParent(nodeToBeDeleted.getParent());
				}
			} else if (nodeToBeDeleted.getParent().getRight() == nodeToBeDeleted) {
				if (nodeToBeDeleted.getLeft() != null) {
					nodeToBeDeleted.getParent().setRight(nodeToBeDeleted.getLeft());
				} else if (nodeToBeDeleted.getRight() != null) {
					nodeToBeDeleted.getParent().setRight(nodeToBeDeleted.getRight());
				}
			}
		}

	}

	private void deleteCase1(BinaryNode nodeToBeDeleted) {
		if (nodeToBeDeleted.getParent().getLeft() == nodeToBeDeleted) {
			nodeToBeDeleted.getParent().setLeft(null);
		} else if (nodeToBeDeleted.getParent().getRight() == nodeToBeDeleted) {
			nodeToBeDeleted.getParent().setRight(null);
		}

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
		if (root == null) {
			return;
		}
		BinaryNode binaryNode = root;
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.add(binaryNode);
		while (!q.isEmpty()) {
			BinaryNode temp = q.poll();
			System.out.println(temp.getData());
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
	}

	@Override
	public String toString() {
		return "BST [root=" + root + "]";
	}

}
