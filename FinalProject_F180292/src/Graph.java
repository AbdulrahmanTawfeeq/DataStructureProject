import java.util.Deque;
import java.util.Queue;

public class Graph {
	int numNodes; // number of nodes inside the graph
	LinkedList<Integer>[] arrayOfLnList;

	public Graph(int numNodes) {
		this.numNodes = numNodes;
		arrayOfLnList = new LinkedList[numNodes];

		for (int i = 0; i < numNodes; i++) {
			arrayOfLnList[i] = new LinkedList<Integer>();
			arrayOfLnList[i].setHead(null);
		}
	}

	public void addNode(int src, int edg) {
		try {
			Node<Integer> n = new Node<Integer>(edg, null);
			n.setNext(arrayOfLnList[src].getHead());
			arrayOfLnList[src].setHead(n); // arrayOfLnList[node] is created by the above loop with null as initial
											// value
											// for the head
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void DFSVisit(int startVertex) {
		try {
			Boolean[] visited = new Boolean[numNodes];
			for (int i = 0; i < visited.length; i++) {
				visited[i] = false;
			}
			// using Deque as stack
			Deque<Integer> d = new java.util.LinkedList<Integer>();
			d.push(startVertex);
			while (d.size() != 0) {
				int n = d.peekFirst();
				visited[n] = true;
				Node<Integer> head = arrayOfLnList[n].getHead();
				boolean isAllChildrenVisited = true;
				while (head != null) {
					if (visited[head.getData()] == false) {
						d.addFirst(head.getData());
						visited[head.getData()] = true;
						isAllChildrenVisited = false;
						break;
					} else {
						head = head.getNext();
					}
				}
				// if no children, then back track;
				if (isAllChildrenVisited == true) {
					int out = d.pollFirst();
					System.out.println("back track and print the visited element: " + out);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void searchDFSway(int startVertex, int toBeFound) {
		try {
			Boolean[] visited = new Boolean[numNodes];
			Boolean isFound = false;
			for (int i = 0; i < visited.length; i++) {
				visited[i] = false;
			}
			// using Deque as stack
			Deque<Integer> d = new java.util.LinkedList<Integer>();
			d.push(startVertex);
			while (d.size() != 0) {
				int n = d.peekFirst();
				visited[n] = true;
				Node<Integer> head = arrayOfLnList[n].getHead();
				boolean isAllChildrenVisited = true;
				while (head != null) {
					if (toBeFound == head.getData()) {
						System.out.println("Node " + toBeFound + " is found");
						isFound = true;
						break;
					}
					if (visited[head.getData()] == false) {
						d.addFirst(head.getData());
						visited[head.getData()] = true;
						isAllChildrenVisited = false;
						break;
					} else {
						head = head.getNext();
					}
				}
				if (isFound == true) {
					break;
				}
				// if no children, then back track;
				if (isAllChildrenVisited == true) {
					int out = d.pollFirst();
					System.out.println("back track and print the visited element: " + out);
				}
			}
			if (isFound == false) {
				System.out.println("Node is not found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void BFSVisit(int startVertex) {
		try {
			Boolean[] visited = new Boolean[numNodes];
			for (int i = 0; i < visited.length; i++) {
				visited[i] = false;
			}
			// using Queue
			Queue<Integer> d = new java.util.LinkedList<Integer>();
			d.add(startVertex);
			while (d.size() != 0) {
				int n = d.poll();
				System.out.println("Visited: " + n);
				visited[n] = true;
				Node<Integer> head = arrayOfLnList[n].getHead();
				while (head != null) {
					if (visited[head.getData()] == false) {
						d.add(head.getData());
						visited[head.getData()] = true;
					} else {
						head = head.getNext();
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void graphListRepresentation() {
		// TODO Auto-generated method stub
		System.out.println("Array |");
		System.out.println("______|");
		for (int i = 0; i < arrayOfLnList.length; i++) {
			System.out.println("" + i + "     |--->" + arrayOfLnList[i]);
		}
	}

}
