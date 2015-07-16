import org.apache.commons.validator.UrlValidator;

import java.net.*;
import java.util.*;
import java.io.*;


public class urlValidate {
	
	private String url;
	private ArrayList<String> data; 
	/*
	 * Constructor method that takes a url string as parameter
	 */
	public urlValidate(String input){
		this.url = input;
	}
	/*
	 * checks if this.url is valid using apache validator
	 *
	 */
	public boolean isVal(){
		UrlValidator urlValidator = new UrlValidator();
		if(urlValidator.isValid(url)){
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 * Sanitizes the string this.url
	 */
	public void sanitize(){
		try{
			URL x = new URL(url);
			URI aURI = new URI(x.getProtocol(), x.getUserInfo(), x.getHost(), x.getPort(), x.getPath(), x.getQuery(), "");
			url = aURI.toURL().toString();
			
			}catch(MalformedURLException e){
				System.out.println("bad url");
			}catch(URISyntaxException e){
				System.out.println("bad uri");
			}

		
	}
	/*
	 * Returns an arraylist containing the data from the website.
	 */
	public ArrayList<String> getData(){
		try{
		this.data = new ArrayList<String>();
		URL aUrl = new URL(this.url);
		BufferedReader in = new BufferedReader(new InputStreamReader(aUrl.openStream()));
		
		String inputLine;
		while((inputLine = in.readLine())!=null){
			data.add(inputLine);
		}
		in.close();
		
		return data;
		} catch(IOException e){
			return null;
		}
		
	}
	
	public String toString(){
		return url;
	}
	
	
}
