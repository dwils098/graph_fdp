
import java.math.*;
import java.util.*;

public class Utilities {


public static double fa(double x, double k){return Math.pow(x, 2)/k;}
public static double fr(double x, double k){return Math.pow(k, 2)/x;}
	// Implementation of the FRUCHTERMAN and REINGOLD 1991 Algorithm
	public static void forceDirectedPlacement (int W, int L, Graph G, int iterations){
		int V = G.getVLength();
		int E = G.getELength();
		
		// is used to store the difference between two values
		double deltaX = 0;
		double deltaY = 0;
		
		int area = W*L;
		double k = Math.sqrt(area/(V));
		
		double t = 50;
		
		for(int i = 0; i<iterations; i++){
		
			G.print();
			
			
			// compute repulsive forces...
			// for each vertex..
			for(int v=0; v<V; v++){
				// set disp to 0
				Vertex temp = G.V.get(v);
				temp.dispx = 0.0;
				temp.dispy = 0.0;
				G.V.set(i, temp);
				
				for (int u=0; ((u<V)&&(u!=v)); u++){
					// vector between the position of two vertices
					deltaX = G.V.get(v).x - G.V.get(u).x;
					deltaY = G.V.get(v).y - G.V.get(u).y;
					
					Vertex temp2 = G.V.get(v);
					if (Double.isNaN(temp2.dispx)){temp2.dispx = 0;}
					temp2.dispx = temp2.dispx + ((deltaX/Math.abs(deltaX)) * fr(Math.abs(deltaX),k));
					if (Double.isNaN(temp2.dispy)){temp2.dispy = 0;}
					temp2.dispy = temp2.dispy + ((deltaY/Math.abs(deltaY)) * fr(Math.abs(deltaY),k));
					G.V.set(v, temp2);
				}
			}
			
			// compute attractive forces...
			for(int e=0; e<E; e++){
				
				Edge temp = G.E.get(e);
				
				deltaX = temp.v.x - temp.u.x;
				deltaY = temp.v.y - temp.u.y;
				
				temp.v.dispx = temp.v.dispx + ((deltaX/Math.abs(deltaX)) * fa(Math.abs(deltaX),k));
				temp.v.dispy = temp.v.dispy + ((deltaY/Math.abs(deltaY)) * fa(Math.abs(deltaY),k));
				
				temp.u.dispx = temp.u.dispx + ((deltaX/Math.abs(deltaX)) * fa(Math.abs(deltaX),k));
				temp.u.dispy = temp.u.dispy + ((deltaY/Math.abs(deltaY)) * fa(Math.abs(deltaY),k));

				G.E.set(e, temp);
			}
			
			// limit the maximum displacement to the temperature t
			// and then prevent from being displaced outside the frame
			for(int vx=0; vx<V; vx++){
				Vertex temp = G.V.get(vx);
				temp.x = temp.x + (temp.dispx/Math.abs(temp.dispx)) * Math.min(temp.dispx, t);
				temp.y = temp.y + (temp.dispy/Math.abs(temp.dispy)) * Math.min(temp.dispy, t);
				
				temp.x = Math.min(W/2, Math.max(-W/2, temp.x));
				temp.y = Math.min(L/2, Math.max(-L/2, temp.y));
				G.V.set(vx, temp);
			}
			
			t-=5;
		}
		
	}

	public void compute (){
		
		// Based off a Cartesian Coordinate System, using only the IV Quadrant,
		// Compute the position of the Nodes in the graph using an Adjacency Matrix.
		// 
		// The IV Quadrant is divide into 4, recursively until it reaches dimensions
		// of size equal to the threshold.
		//
		// Each dimension is composed of: a coordinate where it starts and a coordinate
		// where it ends, and the distance between the two is used to mark the diagonal
		// length of the Square that they form.
		//
		// A Dimension can contain more dimension, hence the notion of primality is relevant,
		// A Dimension is said to be prime if it can't be reduce (divide into more dimensions
		// of integer value).
		//
		// The rational of this method is as follows:
		// - Each prime dimension will be one of the following: 
		//		- Empty,
		//		- Contain a Node,
		//		- Contain an Edge.
		// - (1) Each adjacent pair of Nodes will be contained in the same Non-Prime Dimension
		//	 and so as the corresponding Edge. Each Triplets (Node, Edge, Node) will then be seen 
		//	 atomically.
		// - (2) Enforce step one until: all the Triplets are interconnected and inside the Dimension
		//	 consisting of the entire Quadrant.
		
		
	
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] AdjMx = {{0,1,0,0,0}, {0,0,0,1,0},{0,1,0,0,0},{1,0,0,0,1}, {0,0,0,0,0}};
		
		System.out.println (AdjMx.length);
		List<Vertex> V = new ArrayList<Vertex>();
	
		List<Edge> E = new ArrayList<Edge>();
		V.add(0, new Vertex(30,53));
		V.add(1, new Vertex(520,50));
		V.add(2, new Vertex(130,50));
		V.add(3, new Vertex(120,170));
		V.add(4, new Vertex(30,530));
		V.add(5, new Vertex(800,50));
		E.add(0, new Edge (V.get(0),V.get(1)));
		E.add(1, new Edge (V.get(0),V.get(2)));
		E.add(2, new Edge (V.get(1),V.get(2)));
		E.add(3, new Edge (V.get(3),V.get(2)));
		E.add(4, new Edge (V.get(1),V.get(5)));
		E.add(5, new Edge (V.get(5),V.get(2)));
		E.add(6, new Edge (V.get(4),V.get(2)));

		Graph graph = new Graph(V,E);
		
		Utilities.forceDirectedPlacement(800,800,graph, 10);
		
		

	}

}
