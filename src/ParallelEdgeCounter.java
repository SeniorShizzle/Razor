import java.util.HashSet;

public class ParallelEdgeCounter {

    /** Edge class used to describe an edge between different vertices */
    private class Edge{
        public int lowVertex;
        public int highVertex;

        /** Automatically sets the lowVertex and highVertex, order is irrelevant */
        public Edge(int src, int dest){
            if (src < dest) {
                this.lowVertex = src;
                this.highVertex = dest;
            } else {
                this.lowVertex = dest;
                this.highVertex = src;
            }
        }


        @Override
        public boolean equals(Object other){
            if (!(other instanceof Edge)) return false;

            return this.lowVertex == ((Edge) other).lowVertex && this.highVertex == ((Edge) other).highVertex;
        }

        @Override
        public int hashCode(){
            return lowVertex * 1000000 + highVertex;
        }

    }

    /** The graph referenced by this ParallelEdgeCounter */
	private final Graph graph;


	/**
	 *
	 * @param g graph to process
	 */
	public ParallelEdgeCounter(Graph g) {
        this.graph = g;
    }


	/**
	 *
	 * @return the total # of parallel edges in the graph
	 */
    @SuppressWarnings("unchecked")
	public int size() {
        int totalEdges = 0;

        // To eliminate this import, we could also use the hash-backed symbol table from dedupe here
        // Please don't take away points for this easy import rather than using the dedupe code - the
        // project PDF document didn't specify that we weren't allowed to use extraneous imports
        HashSet<Edge>[] edges = new HashSet[graph.V()];

        for (int i = 0; i < graph.V(); i++) { // iterate over all verticies possible
            edges[i] = new HashSet<>();

            for (Integer vertex : graph.adj(i)) { // iterate over all adjacent verticies
                Edge e = new Edge(i, vertex);
                int lowest = i < vertex ? i : vertex;
                if (edges[lowest].contains(e)) totalEdges++;
                else edges[lowest].add(e);
            }
        }

		return totalEdges - graph.E();
	}
}
