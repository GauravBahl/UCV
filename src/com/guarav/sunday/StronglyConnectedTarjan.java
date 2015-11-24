package com.guarav.sunday;
import java.util.*;
import java.io.*;
 
// Written by: Yancy Vance M. Paredes.
 
// Finding all strongly connected components using Tarjan's algorithm.
 
public class StronglyConnectedTarjan {
 
    public static int index;
    public static Stack<Node> stack;
    public static Vector<Vector<Node>> set;
     
    public static void main(String[] args) throws Exception {
        Scanner iFile = new Scanner(new FileReader("C:\\Users\\Gaurav Bahl\\Desktop\\tinyDG.txt"));
        Graph graph = new Graph();
        graph.setDirected();
        graph.setSortedNeighbors(true);
         
        while(iFile.hasNext()) {
            Node<String> a = new Node<String>(iFile.next());
            Node<String> b = new Node<String>(iFile.next());
             
            int aPos = graph.indexOf(a);
            int bPos = graph.indexOf(b);
             
            // If a does not exist in the graph yet.
            if(aPos == -1)
                aPos = graph.addNode(a);
             
            // If b does not exist in the graph yet.
            if(bPos == -1)
                bPos = graph.addNode(b);
                 
            Edge edge = new Edge(graph.getNodeAt(aPos), graph.getNodeAt(bPos));
             
            graph.addEdge(edge);
        }
         
        //graph.printNodes();
        //graph.printEdges();
         
        Vector<Node> nodes = graph.getNodes();
        index = 0;
        stack = new Stack<Node>();
        set = new Vector<Vector<Node>>();
         
        // Use all the different nodes as the root or source node. 
        for(int i = 0; i < nodes.size(); i++) {
            Node node = nodes.elementAt(i);
             
            if(node.index == null)
                strongConnect(graph, node);
        }
         
        for(int i = 0; i < set.size(); i++)
            System.out.println("Set " + i + ": " + set.elementAt(i));
         
        iFile.close();      
    }
     
    public static void strongConnect(Graph graph, Node node) {
        node.index = index;
        node.lowlink = index;
        index++;
        stack.push(node);
         
        Vector<Node> neighbors = graph.getNeighbors(node);
         
        for(int i = 0; i < neighbors.size(); i++) {
            Node neighbor = neighbors.elementAt(i);
             
            if(neighbor.index == null) {
                strongConnect(graph, neighbor);
                node.lowlink = Math.min(node.lowlink, neighbor.lowlink);
            }
            else if(stack.contains(neighbor)) {
                node.lowlink = Math.min(node.lowlink, neighbor.index);
            }
        }
         
        if(node.lowlink == node.index) {
            Vector<Node> subset = new Vector<Node>();
            Node neighbor = null;
             
            while(node != neighbor) {
                neighbor = stack.pop();
                subset.add(neighbor);
            }
             
            set.add(subset);
        }
         
    }
 
}