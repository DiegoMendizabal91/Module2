public class Main {
    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph();
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        directedGraph = GraphBuilder.buildDirectedGraph("src/graph_builder_test.txt");
        undirectedGraph = GraphBuilder.buildUndirectedGraph("src/graph_builder_test.txt");
        int minPath = GraphUtils.minDistance(directedGraph, "0","4");
        System.out.println(minPath);
        int minPathUndirected = GraphUtils.minDistance(undirectedGraph, "4","1");
        System.out.println(minPathUndirected);

    }
}