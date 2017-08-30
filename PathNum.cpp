#pragma warning(disable: 4996)
#include <stdio.h>

int map[15][15] = { 0, };
void go(int x, int y, int n, int m)
{
	for (int i = x + 1; i < n; i++)
	{
		for (int j = y + 1; j < m; j++)
		{
			map[i][j] = map[i - 1][j] + map[i][j - 1];
		}
	}
}

void init(int x, int y, int n, int m)
{
	for (int i = 0; i < m; i++)
		map[x][i] = 1;
	for (int i = 0; i < n; i++)
		map[i][y] = 1;
}

int main()
{
	int n, m, k;
	scanf("%d %d %d", &n, &m, &k);

	if (k != 0)
	{
		int tmp = 0;
		k = k - 1;

		init(0, 0, k / m + 1, k%m + 1);
		go(0, 0, k / m + 1, k%m + 1);

		tmp = map[k / m][k%m];

		init(k / m, k%m, n, m);
		go(k / m, k%m, n, m);

		printf("%d", tmp*map[n - 1][m - 1]);
	}
	else
	{
		init(0, 0, n, m);
		go(0, 0, n, m);
		printf("%d", map[n - 1][m - 1]);
	}
	return 0;
}
