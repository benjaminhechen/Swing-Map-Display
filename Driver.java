import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver 
{
	public static void main(String [] args)
	{
		double minX = Double.NaN;
		double maxX = Double.NaN;
		double minY = Double.NaN;
		double maxY = Double.NaN;
		
		File file = new File("ur.txt");
    	ArrayList<Road> listInputRoad = new ArrayList<Road>();
    	ArrayList<Intersection> listInputIntersection = new ArrayList<Intersection>(); 
    	
    	try 
		{
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine())
			{
				System.out.println("working...");
				
				String splitThis = sc.nextLine();
				String[] split = splitThis.split("\\s+");
				
				//System.out.println(Arrays.toString(split));
				//System.out.println(split[0]);
				
				if(split[0].equals("i"))
				{
					//System.out.println("im here!");
					Intersection intersection = new Intersection();
					intersection.IntersectionID = split[1];
					intersection.latitude = Double.parseDouble(split[2]);
					
					if(Double.isNaN(minX))
					{
						minX = intersection.longitude;
					}
					if(Double.isNaN(maxX))
					{
						maxX = intersection.longitude;
					}
					intersection.longitude = Double.parseDouble(split[3]);
					if(Double.isNaN(minY))
					{
						minY = intersection.latitude;
					}
					if(Double.isNaN(maxY))
					{
						maxY = intersection.latitude;
					}
					
					if(intersection.latitude<minY)
					{
						minY = intersection.latitude;
					}
					if(intersection.latitude>maxY)
					{
						maxY = intersection.latitude;
					}
					if(intersection.longitude<minX)
					{
						minX = intersection.longitude;
					}
					if(intersection.longitude>minX)
					{
						maxX = intersection.longitude;
					}
					listInputIntersection.add(intersection);
				}
				
				//for testing
				else if(split[0].equals("r"))
				{
					Road road = new Road();
					road.RoadID = split[1];
					String interAName = split[2];
					String interBName = split[3];
					
					for(int i = 0; i < listInputIntersection.size(); i++)
					{
						if(interAName.equals(listInputIntersection.get(i).IntersectionID))
						{
							road.IntersectionA = listInputIntersection.get(i);
						}
						if(interBName.equals(listInputIntersection.get(i).IntersectionID))
						{
							road.IntersectionB = listInputIntersection.get(i);
						}
					}
					listInputRoad.add(road);
				}
			}
			sc.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
    		
    	Graph graph = new Graph(listInputIntersection, listInputRoad);
    	graph.maxX = maxX;
    	graph.maxY = maxY;
    	graph.minX = minX;
    	graph.minY = minY;
    	
  
   	
    	Display display = new Display(graph);
		display.setVisible(true);
		System.out.println("Done!");
    	}
}
