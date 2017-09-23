import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SevenMuhae {
	/*
	 * 오늘의 느낀점 : 1) 버퍼드리더로 인풋 받자 -> 이게 Scanner보다 훨씬 빠르고 타입 받는 것을 신경 안써도 되어서 좋음
	 * 			  2) PriorityQueue 많이 써보자. 그리고 대용량 연산의 경우 마구잡이로 솔팅하지 말자.
	 * 			     문제 조건 중에 7 사이즈 어레이가 괜히 나온게 아님
	 * 			  3) 용욱이형 존나 잘함 ㄷㄷ....
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
