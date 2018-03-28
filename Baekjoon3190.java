package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Point1 {
	int x, y;

	public Point1(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

class Snake {
	ArrayList<Point1> body = new ArrayList<Point1>();
	int dir;
	int len;

	public Snake(Point1 p, int dir, int len) {
		body.add(p);
		this.dir = dir;
		this.len = body.size();
	}
}

class Info {
	int sec;
	String direction;

	public Info(int sec, String direction) {
		this.sec = sec;
		this.direction = direction;
	}
}

public class Baekjoon3190 {
	static int n=0;
	static int map[][]=null;
	static boolean die=false;
	static int a[]={1,0,-1,0};
	static int b[]={0,1,0,-1};
	static Snake snake=null;
	static int timer=0;
	public static void turnRight()
	{
		switch(snake.dir)
		{
		case 1:
			snake.dir=2;
			break;
		case 2:
			snake.dir=3;
			break;
		case 3 : 
			snake.dir=4;
			break;
		case 4 :
			snake.dir=1;
			break;
		}
	}
	public static void turnLeft()
	{
		switch(snake.dir)
		{
		case 1:
			snake.dir=4;
			break;
		case 2:
			snake.dir=1;
			break;
		case 3 : 
			snake.dir=2;
			break;
		case 4 :
			snake.dir=3;
			break;
		}
	}
	public static boolean contain(Point1 p)
	{
		boolean val=false;
		for(Point1 k:snake.body)
		{
			if(k.x==p.x&&k.y==p.y)
			{
				val=true;
				break;
			}
		}
		return val;
	}
	public static void move()
	{
		Point1 head=snake.body.get(0);
		switch(snake.dir)
		{	
		case 1:
			if(head.y-1>0)
			{
				if(map[head.y-1][head.x]==2)
				{
					snake.body.add(0, new Point1(head.y-1,head.x));
					map[head.y-1][head.x]=0;
				}
				else if(contain(new Point1(head.y-1,head.x))){
					die=true;
				}
				else if(map[head.y-1][head.x]==0)
				{
					snake.body.add(0, new Point1(head.y-1,head.x));
					snake.body.remove(snake.body.size()-1);
				}
			}
			else
				die=true;
			break;
		case 2:
			if(head.x+1<=n)
			{
				if(map[head.y][head.x+1]==2)
				{
					snake.body.add(0, new Point1(head.y,head.x+1));
				}
				else if(contain(new Point1(head.y,head.x+1))){
					die=true;
				}
				else if(map[head.y][head.x+1]==0)
				{
					snake.body.add(0, new Point1(head.y,head.x+1));
					Point1 t=snake.body.remove(snake.body.size()-1);
				}
			}
			else
				die=true;
			break;
		case 3 : 
			if(head.y+1<=n)
			{
				if(map[head.y+1][head.x]==2)
				{
					snake.body.add(0, new Point1(head.y+1,head.x));
				}
				else if(contain(new Point1(head.y+1,head.x))){
					die=true;
				}
				else if(map[head.y+1][head.x]==0)
				{
					snake.body.add(0, new Point1(head.y+1,head.x));
					snake.body.remove(snake.body.size()-1);
				}
			}
			else
				die=true;
			break;
		case 4 :
			if(head.x-1>0)
			{
				if(map[head.y][head.x-1]==2)
				{
					snake.body.add(0, new Point1(head.y,head.x-1));
				}
				else if(contain(new Point1(head.y,head.x-1))){
					die=true;
				}
				else if(map[head.y][head.x-1]==0)
				{
					snake.body.add(0, new Point1(head.y,head.x-1));
					snake.body.remove(snake.body.size()-1);
				}
			}
			else
				die=true;
			break;
		}
	}
	public static void show()
	{
		for(Point1 p:snake.body)
		{
			map[p.y][p.x]=3;
		}
		/*for(int i=0;i<n+2;i++)
		{
			for(int j=0;j<n+2;j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();*/
		for(Point1 p:snake.body)
		{
			map[p.y][p.x]=0;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      n=Integer.parseInt(in.readLine());
	      int k=Integer.parseInt(in.readLine());
	      map=new int[n+2][n+2];
	      String input[]=null;
	      for(int i=0;i<k;i++)
	      {
	    	 input =in.readLine().split(" ");
	    	 int x=Integer.parseInt(input[0]);
	    	 int y=Integer.parseInt(input[1]);
	    	 
	    	 map[x][y]=2;
	      }
	      int l=Integer.parseInt(in.readLine());
	      for(int i=0;i<n+2;i++)
	      {
	    	  map[0][i]=4;
	    	  map[i][0]=4;
	    	  map[n+1][i]=4;
	    	  map[i][n+1]=4;
	      }
	      snake=new Snake(new Point1(1,1),2,1);
	      Info info[]=new Info[l];
	      for(int i=0;i<l;i++)
	      {
	    	  input =in.readLine().split(" ");
	    	  int time=Integer.parseInt(input[0]);
	    	  String dir=input[1];
	    	  info[i]=new Info(time,dir);
	      }
	      int i=0;
	      while(!die)
	      {
	    	  timer++;
	    	  //System.out.println(timer + " "+snake.dir);
	    	  move();
	    	  show();
	    	  if(i<l&&!die)
	    	  {
	    		  if(info[i].sec==timer)
	    		  {
	    			  if(info[i].direction.equals("D"))
	    			  {
	    				  turnRight();
	    				  i++;
	    			  }
	    			  else if(info[i].direction.equals("L"))
	    			  { turnLeft();
	    			  	i++;
	    			  }
	    		  }
	    	  }
	      }
	      System.out.println(timer);
	}

}
