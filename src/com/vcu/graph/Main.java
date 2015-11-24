package com.vcu.graph;

public class Main {

	 // Driver method
    public static void main(String args[])
    {
        // Create graphs given in above diagrams
        System.out.println("Articulation points in first graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.AP();
        System.out.println();
 
        System.out.println("Articulation points in Second graph");
        Graph g2 = new Graph(5);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);
        g2.AP();
        System.out.println();
 
        System.out.println("Articulation points in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.AP();
        
    	
    	
        System.out.println("Articulation points in Fourth graph ");
        Graph g4 = new Graph(8);
        g4.addEdge(1, 2);
        g4.addEdge(1, 3);
        g4.addEdge(1, 4);
        g4.addEdge(2, 4);
        g4.addEdge(3, 4);
        g4.addEdge(3, 5);
        g4.addEdge(3, 6);
        g4.addEdge(4, 6);
        g4.addEdge(5, 6);
        g4.addEdge(5, 7);
        g4.addEdge(6, 7);
        g4.AP();
    }
}
	

