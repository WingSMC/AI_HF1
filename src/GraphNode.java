import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	int id;
	double x, y;
	List<GraphNode> neighbors = new ArrayList<GraphNode>();

	GraphNode(int id, double x, double y) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	double distanceFrom(GraphNode g) {
		double dx = this.x - g.x;
		double dy = this.y - g.y;
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	void addNeighbor(GraphNode g) {
		this.neighbors.add(g);
	}
}
