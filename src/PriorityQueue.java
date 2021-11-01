
public class PriorityQueue {
	private QueueNode head;

	private class QueueNode {
		GraphNode graphNode;
		double priority;
		QueueNode next;

		public QueueNode(GraphNode graphNode, double priority, QueueNode next) {
			this.graphNode = graphNode;
			this.priority = priority;
			this.next = next;
		}
	}

	public PriorityQueue() {
		head = new QueueNode(null, -1, null);
	}

	public void enque(GraphNode node, double newPriority) {
		QueueNode temp;

		// Search for existing node (not head)
		for (temp = head; temp.next != null && temp.next.graphNode != node; temp = temp.next)
			;

		QueueNode inserted = temp.next;

		// Found existing node if inserted isn't null else create a new node
		if (inserted == null) {
			inserted = new QueueNode(node, newPriority, null);
		} else if (inserted.priority < newPriority) {
			// New priority is higher, ignore
			return;
		} else {
			// Cut out node, fill gap
			temp.next = inserted.next;
		}

		// TODO: validate this
		// Find insertion location
		for (temp = head; temp.next != null
				&& !(temp.priority < newPriority && newPriority <= temp.next.priority); temp = temp.next)
			;

		// Insert to new location
		inserted.next = temp.next;
		temp.next = inserted;
	}

	public GraphNode deque() {
		QueueNode first = head.next;
		head.next = first.next;
		return first.graphNode;
	}

	public boolean isNotEmpty() {
		return head.next != null;
	}
}
