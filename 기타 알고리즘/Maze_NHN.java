import java.util.Arrays;
import java.util.Scanner;

public class Maze_NHN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int maze[][] = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				maze[i][j]=0;
			}
		}
		int n = scan.nextInt();
		boolean answer[] = new boolean[n];
	
		
		for (int k = 0; k < n; k++) {
			boolean found = false;
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					maze[i][j] = scan.nextInt();
				}
			}

			int row = 0, col = 0;

			while (row < 8 && col < 8) {
				if (row == 7 && col == 7) {
					found = true;
					break;
				} 
				else if (maze[row][col] == 0)
					break;
				else {
					if (maze[row][col] == 1 || maze[row][col] == 3) {
						if (maze[row][col + 1] == 1 || maze[row][col + 1] == 4)
							col++;
						else
							break;
					} else if (maze[row][col] == 2 || maze[row][col] == 4) {
						if (maze[row + 1][col] == 3 || maze[row + 1][col] == 2)
							row++;
						else
							break;
					}
				}
			}
			answer[k] = found;
		}
		for (int i = 0; i < n; i++) {
			if (answer[i])
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
