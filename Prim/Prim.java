// PRIM'S ALGORITHM
// using HashSet and PriorityQueue (min-heap)

import java.util.*;
import java.io.*;

// Edge of a graph
class Edge implements Comparable<Edge>{
    
    private int source, destination, weight;
    
    public Edge(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public int compareTo(Edge e){
        return this.weight - e.weight;
    }
    
    public int getOtherEdge(int vertice){
        
        if(vertice == this.source)
            return this.destination;
        else
            return this.source;
        
    }
    
    public void setSource(int source){
        this.source = source;
    }
    
    public void setDestination(int destination){
        this.destination = destination;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
        
    public int getSource(){
        return this.source;
    }
    
    public int getDestination(){
        return this.destination;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
}

// graph class
class Graph{
    
    private Set<Edge>[] adjacency;
    private int numVertices, numEdges;
 
    // constructor
    public Graph(int numVertices, int numEdges){
        
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        
        adjacency = new HashSet[numVertices];
    
        for(int i = 0; i < numVertices; i++)
            adjacency[i] = new HashSet<Edge>();
    }
 
    // getters
    public int getNumVertices(){
        return numVertices;
    }
    
    public int getNumEdges(){
        return numEdges;
    }

    public Set<Edge>[] getAdjacency(){
        return adjacency;
    }
    
    //setters
    public void setNumVertices(int numVertices){
        this.numVertices = numVertices;
    }
    
    public void setNumEdges(int numEdges){
        this.numEdges = numEdges;
    }

    public void setAdjacency(){
        adjacency = new HashSet[numVertices];
        for(int i = 0; i < numVertices; i++)
            adjacency[i] = new HashSet<Edge>();
    }


    
    // check if graph is empty
    public boolean isEmpty(){
        
        boolean flag = false;
        int counter = 0;
        
        for(int i = 0; i<numVertices; i ++)
            if(adjacency[i].size()<=0)
                counter++;
        
        if(counter == numVertices)
            return true;
        else
            return flag;
    }
    
    
    // check if the edge to be added is valid
    private boolean isValidEdge(int source,int destination){
        
        // invalid vertex
        if(0 > source || source >= numVertices || 0 > destination || destination >=  numVertices){
            System.out.println("Invalid vertices for edges - Invalid Edges");
            return false;
        }
        
        // self loops not allowed
        if(source == destination){
            System.out.println("Self loops not allowed");
            return false;
        }
        
        return true;
    }


    // handling parallel edge
    // keeping the edge with minimum cost
    private boolean handleParallelEdge(int source,int destination,int weight){
        
        boolean flag = false;
        
        for(Edge e: adjacency[source]){
            if(e.getDestination() == destination){
                flag = true;
                if(e.getWeight() > weight){
                    e.setWeight(weight); 
                }
                    
            }
        }
        
        for(Edge e: adjacency[destination]){
            if(e.getDestination() == source){
                flag = true;
                if(e.getWeight() > weight){
                    e.setWeight(weight);
                    // System.out.println("TESTING"+e.getWeight());
                }
                    
            }
        }    
        return flag;
    }
 
    // addEdge
    public void addEdge(int source, int destination, int weight){
        
        // checking if valid and doesn't have parallel edge
        if(isValidEdge(source, destination)){
            if(!handleParallelEdge(source,destination,weight)){
                addEdgeToGraph(source, destination, weight);
            }else{
                System.out.println("Parallel Edge handled");
            }
        }
        else{
            System.out.println("Can't add edge");
        }
            
    }

    private void addEdgeToGraph(int source, int destination, int weight){
        
        Edge edge = new Edge(source, destination, weight);
        adjacency[source].add(edge);
            
        edge = new Edge(destination, source, weight);
        adjacency[destination].add(edge);
            
        System.out.println("Edge added to graph");
    }

   
    
    // displaying graph
    public void printGraph(){
        
        if(!isEmpty()){
            displayGraph();
        }
        else{
            System.out.println("Empty Graph");
        }
        
    }
    
    private void displayGraph(){
    
        System.out.println("THE GRAPH:");
    	System.out.println("----------------------------------------");
        System.out.print("Source\t| Destinations with Weight");
        
        for(int i =0; i < numVertices; i++){
            
            System.out.print("\n"+i+ "\t| ");
            
            Iterator<Edge> iter = adjacency[i].iterator();
            if(adjacency[i].size()>0){
                    
                while(iter.hasNext()){
                    Edge current = iter.next();
                    System.out.print(current.getDestination()+"(w:"+current.getWeight()+")  ");
                }    
            }
            else{
                System.out.print("No edges from this source");    
            }
                
        }    
    }

    

}

class Prims {
    
    private Set<Integer> visited;
    private Set<Edge> mstEdges;
    private PriorityQueue<Edge> minHeap;
    private int minWeight;
    private boolean possibleMST;
    
    public boolean getPossibleMST(){
        return possibleMST;
    }
    
    public int getMinWeight(){
        return minWeight;
    }
    
    public Set<Edge> getMST(Graph graph){
        
        if(!graph.isEmpty()){
            return findMSTUsingPrim(graph);
        }
        else{
            System.out.println("EMPTY GRAPH therefore, No MST");
            return null;
        }
        
    }
    
    // finding MST using Prims algorithm
    private Set<Edge> findMSTUsingPrim(Graph graph){
        
        // setting starting node
        int currentVertex = 0;
        
        // visited to keep track of visited elements
        visited = new HashSet<Integer>();
        visited.add(Integer.valueOf(currentVertex));
        
        // to store the edges of the minimum spanning tree
        mstEdges = new HashSet();
        
        // PriorityQueue
        minHeap = new PriorityQueue<Edge>();
        
        // min weight
        minWeight = 0;
        
        int counter = 0;
        int numVertices = graph.getNumVertices();
        Set<Edge> adj[] = graph.getAdjacency();
        
        
        while(counter < numVertices-1){
            
            for(Edge edge : adj[currentVertex]){
               if(!visited.contains(Integer.valueOf(edge.getOtherEdge(currentVertex))))
                    minHeap.add(edge);
            }
            
            Edge nextEdge = findNextMin(visited , minHeap);
            
            if(nextEdge == null){
                System.out.println("\nThere is no one single MST for this entire graph");
                possibleMST =false;
                return null;
            }
            
            minWeight += nextEdge.getWeight();
            mstEdges.add(nextEdge);
            
            if(visited.contains(Integer.valueOf(nextEdge.getSource())))
                currentVertex = nextEdge.getDestination();
            else
                currentVertex = nextEdge.getSource();
        
            visited.add(Integer.valueOf(currentVertex));
            
            // System.out.println("TESTING COUNTER:"+counter) ;   
            counter ++;
        }
        
        System.out.println("MST FOUND");
        possibleMST = true;
        return mstEdges;
    }
    
    // finding next minimum edge from minheap which is not visited
    private Edge findNextMin(Set<Integer> visited, PriorityQueue<Edge> minHeap){
            
        if(minHeap.isEmpty()){
            return null;
        }
            
        Edge edge = minHeap.poll();
        if(visited.contains(Integer.valueOf(edge.getSource())) && visited.contains(Integer.valueOf(edge.getDestination())))
            return findNextMin(visited, minHeap);
        else
            return edge;
    }
    
    // printing MST
    public void printMST(){
        System.out.println("\n----------------------------------\n");
        if(this.possibleMST==false && mstEdges.size()<=0){
            System.out.println("\nMST\nThere is no one single MST for this graph.");
            System.out.println("No MST from source 0");
            return;
        }
        else if( this.possibleMST == false){
            System.out.println("\nMST\nThere is no one single MST for this graph.");
            System.out.println("MST from source 0 is:");
            displayMST();
        }
        else{
            System.out.println("\n\nTHE MST FOR THE GRAPH: ");
            displayMST();
        }
    }
    
    private void displayMST(){
        
        System.out.println("----------------------------------");
        
        System.out.println("Edge\t| Weight");
        for(Edge edge: mstEdges)
            System.out.println(edge.getSource()+" - "+edge.getDestination()+"\t| "+edge.getWeight());
        
        
        System.out.println("\nMinimum Cost: "+minWeight);
    }
}


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	
	    Scanner sc = new Scanner(System.in);
	    
	    int numVertices, numEdges, source, destination,weight,choice;
	    Prims p = new Prims();
	    
	    do{
            
            System.out.println("\n----------------------------------------------");	       
	        System.out.println("PRIM'S ALGORITHM");
	        System.out.println("----------------------------------------------");
	        System.out.println("Give input for the graph to calculate the MST using Prim's algorithm");
	        System.out.println("----------------------------------------------\n");
	       
	        System.out.print("Enter the number of vertices you want: ");
	        numVertices = sc.nextInt();
	    
	        System.out.print("Enter the number of edges you want: ");
	        numEdges = sc.nextInt();
	    
	        if(numVertices>0){
	        
    	        Graph graph = new Graph(numVertices,numEdges);
    	        
    	        System.out.println("----------------------------------------");
    	        System.out.print("The vertices of your graph are: ");
    	        for(int i =0 ; i< numVertices; i++)
    	            System.out.print(i + " ");
    	        System.out.println("\n----------------------------------------");
    	       
    	        if(numEdges>0){
    	            System.out.println("\nEnter the values for the edges:");
            	    for(int i =0 ; i< numEdges; i++){
            	        System.out.println("----------------------------------------");
            	        System.out.println("EDGE "+(i+1));
            	        System.out.print("Enter source vertex: ");
            	        source = sc.nextInt();
            	        System.out.print("Enter destination vertex: ");
            	        destination = sc.nextInt();
            	        System.out.print("Enter weight of the edge: ");
            	        weight = sc.nextInt();
            	        System.out.println("----------------------------------------");
        	       
    	                graph.addEdge(source, destination, weight);
    	                }
    	        }         
    	        else if (numEdges < 0){
    	            System.out.println("\n\nInvalid input for number of edges\nPlease try again");
    	        }
    	        
    	        
            	
    	        System.out.println("----------------------------------------\n");
    	        
    	        if(!graph.isEmpty()){
    	            // finding MST using Prim's algorithm
        	        System.out.println("Finding MST: ");
        	        p.getMST(graph);
        	        System.out.println("----------------------------------------\n");
        	        
        	       // printing graph
        	        graph.printGraph();
    
        	        p.printMST();
        	        
    	        }
    	        else{
    	            System.out.println("EMPTY GRAPH therefore, No MST");
    	        }
	            
	        } 
	        else if(numVertices<=0 && numEdges <= 0){
	            System.out.println("\n\nInvalid input for number of vertices and edges\nPlease try again");
	        }
	        else{
	            System.out.println("\n\nInvalid input for number of vertices\nPlease try again");
	        }
	        
	        
	       
	        System.out.println("-------------------------------------");
	        System.out.println("Do you want to repeat this?");
	        System.out.print("Enter 1 to repeat and 0 to stop: ");
	        choice = sc.nextInt();
	    }while(choice == 1);
	    
	    
	    System.out.println("\n-----------------------------");
	    System.out.println("THANK YOU");
	    System.out.println("------------------------------");
	}
}



















