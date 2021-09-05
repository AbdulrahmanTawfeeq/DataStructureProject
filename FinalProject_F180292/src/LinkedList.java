
public class LinkedList<T> {
	private Node<T> head;

	public LinkedList(Node<T> head) {
		super();
		this.head = head;
	}

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	public void insertAtBeginning(T data) {
		Node<T> newNode = new Node<T>(data, head);
		setHead(newNode);
	}

	public void insertAtLast(T data) {
		Node<T> newNode = new Node<T>(data, null);

		// to avoid this Error: java.lang.NullPointerException: Cannot invoke
		// "Node.getNext()" because "currentNode" is null
		if (getHead() == null) {
			setHead(newNode);
		} else {
			Node<T> currentNode = getHead();
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			// after the loop, we get the node that has next is null
			currentNode.setNext(newNode);
		}

	}

	public void insertAt(T data, int position) {
		if (position >= 0) {
			Node<T> previous = null;
			Node<T> current = getHead();
			int count = 0;

			if (position == 0 && getHead() != null) {
				insertAtBeginning(data);
			} else if (position == 0 && getHead() == null) {
				Node<T> newNode = new Node<T>(data, null);
				setHead(newNode);
			} else if (position != 0 && getHead() == null) {
				return;
			} else {
				Node<T> newNode = new Node<T>(data, null);
				while (count < position) {
					previous = current;
					current = current.getNext();
					count++;

					// to avoid java.lang.NullPointerException: Cannot invoke "Node.getNext()"
					// because
					// "current" is null, so it dose not have next
					if (current == null) {
						break;
					}
				}
				previous.setNext(newNode);
				newNode.setNext(current);
			}
		} else {
			System.out.println("The position value should be >= 0");
		}

	}

	public void show() {
		Node<T> currentNode = getHead();
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}

	public Node<T> deleteByPosition(int posistion) {
		Node<T> deleted = null;
		if (posistion >= 0) {
			Node<T> previous = null;
			Node<T> current = getHead();
			int counter = 0;

			while (counter < posistion) {
				if (current == null) {
					break;
				}
				previous = current;
				current = current.getNext();
				counter++;

			}
			// to avoid java.lang.NullPointerException: Cannot invoke "Node.getNext()"
			// because "current" is null
			// previous == null && current != null means the first element
			if (previous == null && current != null) {
				setHead(current.getNext());
				deleted = current;
			} else if (current == null) { // if null, current.getNext() will release an exception of nullPointer
//				System.out.println("No such position in the list!");
				deleted = null;
			} else {
				previous.setNext(current.getNext());
				deleted = current;
			}
		} else {
			System.out.println("The position value should be >= 0");
		}
		return deleted;

	}

	public void deleteByKey(T data) {
		Node<T> previous = null;
		Node<T> currentNode = getHead();
		boolean result = false;
		while (currentNode != null) {
			if (currentNode.getData() == data && previous == null) {
				setHead(currentNode.getNext());
				result = true;
				break;
			} else if (currentNode.getData() == data && previous != null) {
				previous.setNext(currentNode.getNext());
				result = true;
			}
			previous = currentNode;
			currentNode = currentNode.getNext();
		}
		if (result == false) {
			System.out.println("The data is not found to be deleted!");
		}
	}

	public boolean search(T data) {
		Node<T> currentNode = getHead();
		boolean result = false;
		while (currentNode != null) {
			if (currentNode.getData() == data) {
				result = true;
			}
			currentNode = currentNode.getNext();
		}
		return result;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}

}
