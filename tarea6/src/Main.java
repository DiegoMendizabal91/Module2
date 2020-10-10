import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        DirectedGraph directedGraph = new DirectedGraph();
//        UndirectedGraph undirectedGraph = new UndirectedGraph();
//        directedGraph = GraphBuilder.buildDirectedGraph("src/graph_builder_test.txt");
//        undirectedGraph = GraphBuilder.buildUndirectedGraph("src/graph_builder_test.txt");
//        int minPath = GraphUtils.minDistance(directedGraph, "0","4");
//        System.out.println(minPath);
//        int minPathUndirected = GraphUtils.minDistance(undirectedGraph, "4","1");
//        System.out.println(minPathUndirected);
        TreeSet<String> fruits = new TreeSet<String>();
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("watermelon");
        Iterator<String> iter = fruits.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next()+" ");
        }

    }
}