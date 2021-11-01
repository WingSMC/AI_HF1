public class Pathfinder {
	private GraphNode[] nodes;
	private GraphNode endNode;
	private PriorityQueue open;

	/**
	 * Constructor for Pathfinder
	 * 
	 * @param graph Graph to be used
	 * @param end   ID of the endNode
	 */
	Pathfinder(Graph graph, int end) {
		open = new PriorityQueue();
		nodes = graph.getNodes();
		endNode = nodes[end];
	}

	private double computeHeuristic(GraphNode currentNode, double distSoFar) {
		return endNode.distanceFrom(currentNode) + distSoFar;
	}

	public double findShortestDistance(int start) {
		GraphNode startNode = nodes[start];
		double heuristic = computeHeuristic(startNode, 0);
		open.enque(startNode, heuristic);
		return expand(startNode, 0);
	}

	private double expand(GraphNode currentNode, double distSoFar) {
		if (currentNode.equals(endNode)) {
			return distSoFar;
		}

		currentNode.neighbors.forEach(neighbor -> open.enque(neighbor, computeHeuristic(neighbor, distSoFar)));
		if (open.isNotEmpty()) {
			GraphNode nextNode = open.deque();
			return expand(nextNode, distSoFar + currentNode.distanceFrom(nextNode));
		}
		return distSoFar;
	}
}
