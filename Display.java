import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Display extends JFrame
{
	public ArrayList<Road> roads;
	public ArrayList<Intersection> intersections;
	
	double minX = 0;
	double maxX = 0;
	double minY = 0;
	double maxY = 0;
	
	public Display(Graph graph)
	{
		intersections = graph.vertices;
		roads = graph.edges;
		minX = graph.minX;
		maxX = graph.maxX;
		minY = graph.minY;
		maxY = graph.maxY;
		
		initUI();
	}
	
	public void initUI()
	{
		setTitle("ayy");
		setSize(1300,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
//		System.out.println("there are " + roads.size() + " roads");
//		System.out.println("there are " + intersections.size() + " intersections");		
		
		for(int i = 0; i < roads.size(); i++)
		{	
			//System.out.println("i'm supposed to be drawing something!");
			double scale = scaleFactor();
			//System.out.println(scale);
			//and then a line from each point to point
			//g.drawRect((int)(getHeight()*0.5), (int)(getWidth()*0.5), 20, 20);
			g.drawRect((int)((roads.get(i).IntersectionA.longitude - minX)*scale),  getHeight()-(int)((roads.get(i).IntersectionA.latitude-minY)*scale), 2, 2);
			g.drawRect((int)((roads.get(i).IntersectionB.longitude - minX)*scale),  getHeight()-(int)((roads.get(i).IntersectionB.latitude-minY)*scale), 2, 2);
			g.drawLine((int)((roads.get(i).IntersectionA.longitude - minX)*scale), getHeight()-(int)((roads.get(i).IntersectionA.latitude-minY)*scale), (int)((roads.get(i).IntersectionB.longitude-minX)*scale), getHeight()-(int)((roads.get(i).IntersectionB.latitude-minY)*scale));
		}
	}
	
	public double scaleFactor()
	{
		double a = maxX-minX;
		//System.out.println(a);
		double b = maxY-minY;
		//System.out.println(b);
		double c = getWidth();
		//System.out.println(c);
		double d = getHeight();
		//System.out.println(d);
		
		if(a>b)
		{
			return c/a;
		}
		return d/b;
		
	}
}
