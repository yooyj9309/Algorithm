package SamsungExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SW3503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int arr[]=null;
		for (int num = 1; num <= tc; num++) {
			int n = sc.nextInt();
			int max=0;
			ArrayList<Integer> list=new ArrayList<Integer>();
			int min=Integer.MAX_VALUE;
			arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
				if(max<arr[i])
					max=arr[i];
				if(min>arr[i])
					min=arr[i];
			}
			for(int a:arr)
			{
				if(a==max||a==min)
					continue;
				list.add(a);
			}
			Collections.sort(list);
			LinkedList<Integer> list1=new LinkedList<Integer>();
			LinkedList<Integer> list2=new LinkedList<Integer>();
			
		
			for(int i=0;i<list.size();i++)
			{
				if(i%2==0){
					list1.add(list.get(i));
				}
				else{
					list2.add(list.get(i));
				}
			}
			list1.addFirst(min);
			list1.addLast(max);
			
			list2.addFirst(min);
			list2.addLast(max);
			
			int max1=0;
			for(int i=1;i<list1.size();i++)
			{
				int dif=list1.get(i)-list1.get(i-1);
				if(dif>max1)
					max1=dif;
			}
			
			int max2=0;
			for(int i=1;i<list2.size();i++)
			{
				int dif=list2.get(i)-list2.get(i-1);
				if(dif>max2)
					max2=dif;
			}
			System.out.println("#"+num+" "+Math.max(max1, max2));
		}
	}

}
