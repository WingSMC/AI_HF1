import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueueTest {

	@Test
	public void enqueBasedOnPriorityTest() {
		PriorityQueue pq = new PriorityQueue();
		GraphNode testNode = new GraphNode(10, 9, 0);
		pq.enque(new GraphNode(1, 1, 1), 0);
		pq.enque(new GraphNode(2, 2, 1), 0);
		pq.enque(new GraphNode(3, 2, 0), 1);
		pq.enque(new GraphNode(4, 0, 1), 0);
		pq.enque(testNode, 2);
		assertNotEquals(testNode.id, pq.deque().id);
		pq.enque(testNode, 0);
		assertEquals(testNode.id, pq.deque().id);
	}
}
