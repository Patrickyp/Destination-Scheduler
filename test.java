import java.net.*;
import java.util.ArrayList;
import java.io.*;

import javax.swing.JOptionPane;

public class test {
    public static void main(String[] args) throws Exception {
    	String[] tokens = null;
    	urlValidate url1v = new urlValidate("http://pearl.ics.hawaii.edu/~sugihara/courses/ics311s13/assign_p1_test_data/attractions01.txt");
		urlValidate url2v = new urlValidate("http://pearl.ics.hawaii.edu/~sugihara/courses/ics311s13/assign_p1_test_data/attractions01.txt");
		
			//first sanitize the 2 urls then extract destination strings from url2
			url1v.sanitize();
			url2v.sanitize();
				
			ArrayList<String> destinations = new ArrayList<String>();
			ArrayList<String> data = new ArrayList<String>();
			data = url2v.getData();
			
			for(int x = 0; x<data.size(); x++){
				 String delims = "\\t{1,}";
				if(x>=1){
				  tokens = data.get(x).split(delims);
				  destinations.add(tokens[1]);
				}
				
			}
			System.out.print(destinations);
			
    }  
}