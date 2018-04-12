package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baekjoon7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      int n=Integer.parseInt(in.readLine());
	      Set map=new HashSet();
	      for(int i=0;i<n;i++)
	      {
	    	  String input[]=in.readLine().split(" ");
	    	  String key=input[0];
	    	  if(map.contains(key))
	    		  map.remove(key);
	    	  else
	    		  map.add(key);
	      }
	      List list=new ArrayList(map);
	      Collections.sort(list);
	      for(int i=list.size()-1;i>=0;i--)
	    	  System.out.println(list.get(i));
	}

}
