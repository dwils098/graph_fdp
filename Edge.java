public class Edge{
	
	public Vertex u, v;
	
	// Each edge are an ordered pair of vertexes (u,v)
	public Edge(Vertex u,  Vertex v){
		this.u = u;
		this.v = v;
	}
	
	public String toString(){return "("+this.u.x+", "+this.u.y+"; "+ this.v.x + ", " + this.v.y+")";}
	
}