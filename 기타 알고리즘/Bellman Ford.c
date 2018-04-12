#include <stdio.h>
 #define infinity 10000
 struct edge{
    int s;
	int vertex;
	int weight;
};
 
 void bellmanford(int );
 
int num; 
int edge; 
struct edge edges[1024];
int d[32];
 
void main() {
    int i, j;
    int k,start;
 
	printf("What's the number of vertex?");
    scanf("%d", &num);
	printf("What's source node?");
	scanf("%d",&start);
    edge = 0;
 
    for (i = 0; i < num; ++i)
	{
        for (j = 0; j < num; ++j) {
			printf("%d -> %d  ",i,j);
            scanf("%d", &k);
            if (k != 0) {
                edges[edge].s = i;
                edges[edge].vertex = j;
                edges[edge].weight = k;
                edge++;
            }
        }
	}
 
    bellmanford(start);
 
   for (i = 0; i < num; ++i)
        printf("%d   ", i + 1);

    printf("\n");
 
    for (i = 0; i < num; ++i)
        printf("%d   ", d[i]);
 
}
void bellmanford(int s) {
    int i, j;
 
    for (i = 0; i < num; ++i)
        d[i] = infinity;
 
    d[s] = 0;
 
    for (i = 0; i < num - 1; ++i)
        for (j = 0; j < edge; ++j)
            if (d[edges[j].s] + edges[j].weight < d[edges[j].vertex])
                d[edges[j].vertex] = d[edges[j].s] + edges[j].weight;
}