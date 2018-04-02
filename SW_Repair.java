package SamsungExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
	int arrTime=0;
	int arrTime_reception = 0;
	int arrTime_repair = 0;
	
	int number = 0;
	int reception = 0;
	int repair = 0;

	public Customer(int number, int arrTime) {
		this.arrTime = arrTime;
		this.number = number;
	}

	public int getFinishReceptionTime(int[] alist) {
		return arrTime_reception + alist[reception];
	}

	public int getFinishRepairTime(int[] blist) {
		return arrTime_repair + blist[repair];
	}

	private static Comparator<Customer> comparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer n1, Customer n2) {
			if (n1.reception < n2.reception)
				return -1;
			else if (n1.reception == n2.reception)
				return 0;
			else
				return 1;

		}
	};
}

public class SW_Repair {

	public static Customer[] customers = null;
	public static boolean recetionQ[];
	public static boolean repairQ[];
	public static int alist[];
	public static int blist[];
	public static Customer[] doReception;
	public static Customer[] doRepair;

	public static ArrayList<Customer> getCustomers(int timer) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		for (int i=1;i<customers.length;i++) {
			if (customers[i].arrTime == timer)
				list.add(customers[i]);
		}
		return list;
	}

	public static ArrayList<Customer> returnTheReception(int timer) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		for (int i=1;i<doReception.length;i++) {
			Customer c=doReception[i];
			if (c != null) {
				int finishTime = c.getFinishReceptionTime(alist);
				if (finishTime == timer) {
					doReception[c.reception] = null;
					list.add(c);
				}
			}
		}
		if(!list.isEmpty())
		Collections.sort(list, new Comparator<Customer>() {

			@Override
			public int compare(Customer n1, Customer n2) {
				if (n1.reception < n2.reception)
					return -1;
				else if (n1.reception == n2.reception)
					return 0;
				else
					return 1;

			}
			
		});
		
		return list;
	}
	
	public static void returnTheRepair(int timer) {
		
		for (int i=1;i<doRepair.length;i++) {
			Customer c=doRepair[i];
			if (c != null) {
				int finishTime = c.getFinishRepairTime(blist);
				if (finishTime == timer) {
					doRepair[c.repair] = null;
				}
			}
		}
	}
	
	public static void allocateReception(Queue<Customer> receptionQ,int timer)
	{
		for(int i=1;i<doReception.length;i++)
		{
			if(!receptionQ.isEmpty()&&doReception[i]==null){
				Customer c=receptionQ.poll();
				doReception[i]=c;
				c.reception=i;
				c.arrTime_reception=timer;
			}
		}
	}
	public static int allocateRepair(Queue<Customer> repairQ,int timer)
	{
		int val=0;
		for(int i=1;i<doRepair.length;i++)
		{
			if(!repairQ.isEmpty()&&doRepair[i]==null){
				Customer c=repairQ.poll();
				doRepair[i]=c;
				c.repair=i;
				c.arrTime_repair=timer;
				val++;
			}
		}
		return val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			alist = new int[n + 1];
			blist = new int[m + 1];

			int tlist[] = new int[k + 1];

			customers = new Customer[k + 1];

			doReception = new Customer[n + 1];
			doRepair = new Customer[m + 1];

			for (int i = 1; i <= n; i++)
				alist[i] = sc.nextInt();
			for (int i = 1; i <= m; i++)
				blist[i] = sc.nextInt();

			for (int i = 1; i <= k; i++) {
				tlist[i] = sc.nextInt();
				customers[i] = new Customer(i, tlist[i]);
			}

			int timer = -1;
			Queue<Customer> receptionQ = new LinkedList<Customer>();
			Queue<Customer> repairQ = new LinkedList<Customer>();
			int people = 0;
			
			while (people!=k) {
				timer++;
				ArrayList<Customer> cList = getCustomers(timer);
				for (Customer c : cList) {
					receptionQ.add(c);
				}

				ArrayList<Customer> returnList=returnTheReception(timer); //시간이 됐으면 창구에서 빠지기
				returnTheRepair(timer);
				
				
				if(!returnList.isEmpty())//리셉션 창구에서 빠지기
				{
					for(Customer c:returnList)
						repairQ.add(c);
				}
					
				allocateReception(receptionQ,timer);// 리셉션 창구에 넣기
				
				people+=allocateRepair(repairQ,timer);// 리페어 창구에 넣기

			}
			int sum = 0;
			
			for (int i=1;i<customers.length;i++) {
				if (a == customers[i].reception && b == customers[i].repair)
					sum += customers[i].number;
			}
			if(sum==0)
				System.out.println("#" + num + " " + -1);
			else
				System.out.println("#" + num + " " + sum);

		}

	}

}
