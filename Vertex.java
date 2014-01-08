public class Vertex{
	
	
	public double pos, dispx,dispy;
	public double x,y;

	// Each vertex has two vectors
	public Vertex(){
		this.pos = 0;
		this.dispx = 0.0;
		this.dispy = 0.0;
		this.x = 0;
		this.y = 0;
	}
	public Vertex(int x, int y){
		this.x = x;
		this.y=y;
		this.pos = 0;
		this.dispx = 0;
		this.dispy = 0;
	}
	
}