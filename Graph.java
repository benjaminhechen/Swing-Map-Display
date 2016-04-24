import java.util.ArrayList;

public class Graph 
{
	public ArrayList<Intersection> vertices;
	public ArrayList<Road> edges;
	
	double minX = 0;
	double maxX = 0;
	double minY = 0;
	double maxY = 0;
			
	public Graph(ArrayList<Intersection> vertices, ArrayList<Road> edges)
	{
		this.vertices = vertices;
		this.edges = edges;
	}
	
	//method to determine dijkstra's algorithm
	
}
