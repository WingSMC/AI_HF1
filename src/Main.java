import java.util.List;
import java.util.Scanner;

public class Main {
	static Graph graph;
	static VertexPair[] paths;
	/**
	 * # of routes to find
	 */
	static int p;
	/**
	 * # of vertices
	 */
	static int n;
	/**
	 * # of edges
	 */
	static int e;

	public static void main(String[] args) throws Exception {
		try (Scanner in = new Scanner(System.in)) {
			p = Integer.parseInt(in.nextLine());
			n = Integer.parseInt(in.nextLine());
			e = Integer.parseInt(in.nextLine());
			in.nextLine();
			Main.paths = new VertexPair[p];
			Main.graph = new Graph(n);

			// Read routes
			for (int i = 0; i < p; i++) {
				String[] line = in.nextLine().split("\t");

				int v1 = Integer.parseInt(line[0]);
				int v2 = Integer.parseInt(line[1]);
				Main.paths[i] = new VertexPair(v1, v2);
			}
			in.nextLine();

			// Read vertices
			for (int i = 0; i < n; i++) {
				String[] line = in.nextLine().split("\t");
				graph.addNode(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}
			in.nextLine();

			// Read edges
			for (int i = 0; i < e; i++) {
				String[] line = in.nextLine().split("\t");
				graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}
		}

		// TODO:
		// Calculate and Print results
		// List.of(Main.paths).stream().map
	}
}

final class VertexPair {
	int first;
	int second;

	public VertexPair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
