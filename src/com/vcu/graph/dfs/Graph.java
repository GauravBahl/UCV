package com.vcu.graph.dfs;

import java.util.Stack;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][];      // adjacency matrix
	private int nVerts;          // current number of vertices
	private Stack<Integer> stack;

	public Graph(){

		stack = new Stack<Integer>();
		vertexList =  new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int y=0; y<MAX_VERTS; y++){      
			for(int x=0; x<MAX_VERTS; x++){   
				adjMat[x][y] = 0;
			}
		}
		
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
	
	
	public void traversingDFS(){
		//begin at vertex 0
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0);   //display it
		stack.push(0); //push it
		
		
		while(!stack.isEmpty()){
			//get an unvisited adjacent vertex to stack top
			
			int unVisitedVertex = getUnVisitedVertex(stack.peek());
			
			if(unVisitedVertex == -1){
				stack.pop();
			}else{
				vertexList[unVisitedVertex].wasVisited = true;
				displayVertex(unVisitedVertex);
				stack.push(unVisitedVertex);
			}
			
		}
		
		//stack is empty we are done
		
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;  // reset
		}
		
	}
	
	
	public int getUnVisitedVertex(int v){
		
		for(int j=0;j<nVerts;j++){
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false){
				return j;
			}
		}
		
		return -1;
	}
	
	

}
