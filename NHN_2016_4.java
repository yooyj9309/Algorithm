import java.util.Scanner;

public class NHN_2016_4 {

	//���� ���� �ȳ��� �ְ� ��� �̻� �ȴٰ� ���������� ������ Ÿ�� ��������
	//�ƿ� ��Ʈ�� �������� long�� int�ٰ� ������ ����
	//long ������ ���� Ʋ���� �� ������ �� ���赵 ��������
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
