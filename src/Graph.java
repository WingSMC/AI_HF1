public class Graph {
	private int currentIndex;
	private GraphNode[] nodes;

	public int getNumNodes() {
		return nodes.length;
	}

	Graph(int nNodes) {
		currentIndex = 0;
		nodes = new GraphNode[nNodes];
	}

	void addNode(int x, int y) {
		assert currentIndex < nodes.length;
		nodes[currentIndex] = new GraphNode(currentIndex, x, y);
		++currentIndex;
	}

	void addEdge(int id1, int id2) {
		GraphNode n1 = nodes[id1];
		GraphNode n2 = nodes[id2];

		n1.addNeighbor(n2);
		n2.addNeighbor(n1);
	}

	public GraphNode[] getNodes() {
		return nodes;
	}
}
