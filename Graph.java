import java.util.List;

public class Graph{
	
	public List<Vertex> V;
	public List<Edge> E;
	
	public Graph(List<Vertex> V, List<Edge> E){
		this.V = V;
		this.E = E;
	}
	
	public int getVLength(){return this.V.size();}
	public int getELength(){return this.E.size();}
	public void print(){
		System.out.println("Graph:");
		for(int i = 0; i< this.getVLength(); i++){
			Vertex temp =  V.get(i);
			System.out.println("Vertex ("+ i +") : ("+temp.x+", "+ temp.y +")");
		}
		for(int j = 0; j< this.getELength(); j++){
			Edge temp =  E.get(j);
			System.out.println("Edge ("+ j +") : " + temp.toString());
		}
	}
	}