import java.util.*;
import java.net.*;
import java.io.*;


public class RoadMap{

	private int numcities;
	private int[][] matrix;
	private final int maxdistance=10;
	private URL aUrl;
	protected ArrayList data;
	private String[] tokens;
	/*
	 * Constructor for RoadMap that creates a 2d array and loads it with the 
	 * edge values given in the page.
	 */
	public RoadMap(String url)
	{
		urlValidate val = new urlValidate(url);
		val.sanitize();
		data = new ArrayList<String>();
		data = val.getData();
		/*
		 * After data has the string representation of the page, each line of the page is processed 
		 * by looping through data
		 */
		for(int x =0; x<data.size();x++){
			String delim = "\\t{1,}";
			//reads the number of vertices in the first line and makes appropriate sized array.
			if(x == 0){
				tokens = ((String) data.get(x)).split(delim);
				matrix = new int[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[0])];
				System.out.println(tokens[0]);
			}
			else{
				String[] tokens2 = ((String) data.get(x)).split(delim);
				matrix[Integer.parseInt(tokens[0])-1][Integer.parseInt(tokens[1])-1] = 5; //convertTime(tokens[2]);
			}
		}
		
	}
	
	public void Print()
	{
		
		for(int i=0;i<Integer.parseInt(tokens[0]); i+=1)
		{
			for(int j=0;j<Integer.parseInt(tokens[0]); j+=1)
			{
					String s= "" + this.matrix[i][j];				
					System.out.print(s+" ");
				
				if (j==(Integer.parseInt(tokens[0])-1))
				{
					System.out.println();
				}
				
				
			}
		}
		System.out.println();
	}
	
	public int NumCities()
	{
		return this.numcities;
	}
	
	public int GetDistanceFrom(int start, int finish)
	{
		return this.matrix[start][finish];
	}
	public static int convertTime(String input){
		String delim = ":";
		String[] timeToken = input.split(delim);
		return 3600 * Integer.parseInt(timeToken[0]) + 60 * Integer.parseInt(timeToken[1]) + Integer.parseInt(timeToken[2]);
	}
	
	
}