import java.util.Arrays;

public class Pathfinder {
	/**
	 * [n][0] refers to [n][1]+dist(nodes[n],node[end])
	 * 
	 * [n][1] refers to the distance to the node from the start THROUGH the graph
	 */
	private double[][] nodeHeuristics;
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
		nodeHeuristics = new double[graph.getNumNodes()][2];
		for (double[] ds : nodeHeuristics) {
			ds[0] = Double.POSITIVE_INFINITY;
			ds[1] = Double.POSITIVE_INFINITY;
		}

		nodes = graph.getNodes();
		endNode = nodes[end];
	}

	private double computeHeuristic(GraphNode currentNode, double distSoFar) {
		return endNode.distanceFrom(currentNode) + distSoFar;
	}

	public double findShortestDistance(GraphNode start) {
		return expand(start, 0);
	}

	private double expand(GraphNode currentNode, double distSoFar) {
		double heuristic = computeHeuristic(currentNode, distSoFar);
		if (nodeHeuristics[currentNode.id][0] < heuristic) {
			return Double.POSITIVE_INFINITY;
		}
		nodeHeuristics[currentNode.id][0] = heuristic;

		if (currentNode.equals(endNode)) {
			return distSoFar;
		}

		return 0;
	}
}

class PriorityQueue {
	private QueueNode head;

	private class QueueNode {
		GraphNode graphNode;
		double priority;
		QueueNode next;
	}

	public void enque(GraphNode node, double heuristic) {
		QueueNode newNode = new QueueNode();
		newNode.graphNode = node;
		newNode.priority = heuristic;

		QueueNode temp = head;
		if (head == null || head.priority > heuristic) {
			newNode.next = head;
			head = newNode;
			return;
		}

		while (temp.next != null && temp.next.priority < heuristic) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	public GraphNode deque() {
		QueueNode temp = head;
		head = head.next;
		return temp.graphNode;
	}

	public boolean isEmpty() {
		return head == null;
	}
}
