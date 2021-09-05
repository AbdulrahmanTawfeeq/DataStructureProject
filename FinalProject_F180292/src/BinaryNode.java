
public class BinaryNode {
	private int data;
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;
	private boolean bool;

	public BinaryNode(int data, BinaryNode left, BinaryNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinaryNode() {

	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public BinaryNode getParent() {
		return parent;
	}

	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}
