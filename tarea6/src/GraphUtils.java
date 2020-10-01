

import java.util.*;
import java.util.stream.Collectors;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static Integer findMin(List<Integer> list)
	{
		if (list == null || list.size() == 0) {
			return Integer.MAX_VALUE;
		}
		List<Integer> sortedlist = new ArrayList<>(list);
		Collections.sort(sortedlist);
		return sortedlist.get(0);
	}

	public static int minDistance(Graph graph, String src, String dest) {
		if(graph == null || src == null || dest == null || !graph.containsNode(graph.getNode(src)) || !graph.containsNode(graph.getNode(dest))){
			return -1;
		}
		if(src.equals(dest)){
			return 0;
		}

		Node node = graph.getNode(src);
		Set<Node> nodeEdges = graph.getNodeNeighbors(node);
		int pathCounter = 0;
		List<Integer> pathList = new ArrayList<>();
		if(nodeEdges.isEmpty()){
			return -1;
		}
		for (Node actualNode : nodeEdges) {
			Set<Node> nodeEdges2 = graph.getNodeNeighbors(actualNode);
			for (Node actualNode2 : nodeEdges2) {
				if (actualNode2.getElement().equals(node.getElement())){
					graph.removeEdge(node, actualNode);
					break;
				}
			}
			pathCounter++;
			if(actualNode.getElement().equals(dest)){
				pathList.add(pathCounter);
			} else {
				int minPath = minDistance(graph, actualNode.element, dest);
				if (minPath != -1) {
					pathCounter = pathCounter + minDistance(graph, actualNode.element, dest);
					pathList.add(pathCounter);
				}
				pathCounter = 0;
			}
			graph.addEdge(node, actualNode);
		}
		if(pathList.isEmpty()){
			return -1;
		}
		return findMin(pathList);
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null) {
			return null;
		}

		if (distance < 0 || !graph.containsElement(src) || src == null){
			return null;
		}
		Graph graphUnderTest = graph;
		Node node = graphUnderTest.getNode(src);
		Set<Node> nodeEdges = graphUnderTest.getNodeNeighbors(node);
		Set<String> nodeList = new HashSet<>();
		for (Node actualNode : nodeEdges) {
			graphUnderTest.removeEdgeFromTo(node, actualNode);
			graphUnderTest.removeEdgeFromTo(actualNode, node);
		}
		int contDistance = 0;
		if (distance == 0){
			return null;
		}
		for (Node actualNode : nodeEdges) {
			if(!(nodeList.contains(actualNode))){
				Set<String> nodeListInside = new HashSet<>();
				nodeList.add(actualNode.getElement());
				if (contDistance < distance){
					distance = distance -1;
//					graphUnderTest.removeEdge(node, actualNode);
					nodeListInside = nodesWithinDistance(graphUnderTest, actualNode.getElement(), distance);
					if(nodeListInside == null) {
						nodeListInside = new HashSet<>();
					}
//					graph.addEdgeFromTo(node,actualNode);
					nodeList.addAll(nodeListInside);
					distance++;
				} else {
					break;
				}
			}
		}

		return nodeList; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> clearListFromDuplicateFirstName(List<String> list1) {
		int cont = 0;
		Map<String, String> cleanMap = new LinkedHashMap<>();
		for (int i = 0; i < list1.size(); i++) {
			cleanMap.put(list1.get(i), list1.get(i));
			if(list1.get(i).equals("check")){
				cont++;
			}
		}
		List<String> list = new ArrayList<String>(cleanMap.values());
//		for(int i = 0; i < cont; i++){
//			list.add("check");
//		}
		return list;
	}

	public static boolean containsAllElements(List<String> values, Graph g){

			List<String> marked = clearListFromDuplicateFirstName(values);
			Map<Node, Set<Edge>> map = g.adjacencySets;
			boolean containElements= true;
			if (map.size() == (values.size()-1)) {
				for (int i = 0; i < marked.size(); i++) {
					containElements = g.containsElement(marked.get(i));
					if (!containElements && !marked.get(i).equals("check")){
						break;
					}
				}
			}else {
				return false;
			}
			return containElements;
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		try {
			if (values == null || g == null){
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}


		if(values.isEmpty()){
			return false;
		}

		if(!containsAllElements(values, g)){
			return false;
		}

		String valueToReview;
		int firstValueIndex= 0;
		String firstValue = "";
		for (int i = 0; i < values.size(); i++) {
			if(!values.get(i).equals("check")){
				firstValue = values.get(i);
				firstValueIndex = values.indexOf(firstValue);
				values.set(i,"check");
				if(values.get(values.size()-1).equals("check")){
					return true;
				}
				break;
			}
		}

		Node node = g.getNode(firstValue);
		Set<Node> nodeEdges = g.getNodeNeighbors(node);
		boolean continueCycle = false;
		valueToReview = values.get(firstValueIndex + 1);
		for (Node actualNode : nodeEdges) {
			if (valueToReview.equals(actualNode.getElement())) {
				continueCycle = isHamiltonianPath(g, values);
				if (continueCycle){
					break;
				}
			}
		}

		
		return continueCycle; // this line is here only so this code will compile if you don't modify it
	}
	
}
