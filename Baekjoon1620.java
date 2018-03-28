package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      String input[]=in.readLine().split(" ");
	      HashMap<String,String> map=new HashMap<String,String>();
	      HashMap<String,String> map1=new HashMap<String,String>();
	      int n=Integer.parseInt(input[0]);
	      int m=Integer.parseInt(input[1]);
	      for(int i=1;i<=n;i++)
	      {
	    	  String tmp=in.readLine();
	    	  map.put(i+"",tmp);
	    	  map1.put(tmp,i+"");
	      }
	      for(int i=0;i<m;i++)
	      {
	    	  String value=in.readLine();
	    	  if(map.containsKey(value))
	    	  {
	    		  System.out.println(map.get(value));
	    	  }
	    	  else if(map1.containsKey(value))
	    	  {
	    		  System.out.println(map1.get(value));
	    	  }
	      }
	      
	}

}
