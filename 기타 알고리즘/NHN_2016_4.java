import java.util.Scanner;

public class NHN_2016_4 {

	//숫자 범위 안나와 있고 몇억 이상 된다고 나와있으면 무조건 타입 생각하자
	//아예 인트로 하지말고 long이 int다고 생각을 하자
	//long 때문에 많이 틀리는 거 같으니 낼 시험도 조심하자
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		int tmp[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			if (arr[i] / 10 < 1)
				tmp[i] = arr[i];
			else
				tmp[i] = arr[i] / 10;
		}
		int temp = 0, temp1 = 0;

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n - 1; j++) {
				if (tmp[j] > tmp[j + 1]) {
					temp = tmp[j];
					tmp[j] = tmp[j + 1];
					tmp[j + 1] = temp;

					temp1 = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp1;
				} else if (tmp[j] == tmp[j + 1]) {
					if (arr[j] % 10 > arr[j + 1] % 10) {
						temp = tmp[j];
						tmp[j] = tmp[j + 1];
						tmp[j + 1] = temp;

						temp1 = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp1;
					}
				}
			}
		}
		String r1="";
		for (int i = 0; i < n; i++) {
			r1+=arr[i];
		}

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n - 1; j++) {
				if (tmp[j] < tmp[j + 1]) {
					temp = tmp[j];
					tmp[j] = tmp[j + 1];
					tmp[j + 1] = temp;

					temp1 = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp1;
				} else if (tmp[j] == tmp[j + 1]) {
					if (arr[j] % 10 < arr[j + 1] % 10) {
						temp = tmp[j];
						tmp[j] = tmp[j + 1];
						tmp[j + 1] = temp;

						temp1 = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp1;
					}
				}
			}
		}
		String r2="";
		for (int i = 0; i < n; i++) {
			r2+=arr[i];
		}
		System.out.println(Long.parseLong(r1)+Long.parseLong(r2));
	}

}
