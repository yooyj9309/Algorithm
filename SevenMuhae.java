import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SevenMuhae {
	/*
	 * ������ ������ : 1) ���۵帮���� ��ǲ ���� -> �̰� Scanner���� �ξ� ������ Ÿ�� �޴� ���� �Ű� �Ƚᵵ �Ǿ ����
	 * 			  2) PriorityQueue ���� �Ẹ��. �׸��� ��뷮 ������ ��� �������̷� �������� ����.
	 * 			     ���� ���� �߿� 7 ������ ��̰� ���� ���°� �ƴ�
	 * 			  3) ������� ���� ���� ����....
	 * */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
		
		PriorityQueue<Double> pq=new PriorityQueue<>(
				new Comparator<Double>(){
					@Override
					public int compare(Double w1, Double w2) {
						// TODO Auto-generated method stub
						return w2.compareTo(w1);
					}
				});
		
		for(int i=0;i<num;i++)
		{
			double tmp=Double.parseDouble(in.readLine());
			
			if(pq.size()==7)
			{
				if(pq.peek()<=tmp)
					continue;
				else{
					pq.poll();
					pq.add(tmp);
				}
			}
			else if(pq.size()<7)
			{
				pq.add(tmp);
			}
		}
		double arr1[]=new double[7];
		for(int i=6;i>=0;i--)
		{
			arr1[i]=pq.poll();
		}
		for(double a:arr1)
			System.out.format("%.3f\n",a);
	}

}
