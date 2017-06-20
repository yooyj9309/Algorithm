#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#pragma warning (disable : 4996)
struct p {
   float x;
   float y;
   float an; //선택된 점을 기준으로의 각도
};
float compute(struct p A, struct p B);

void main()
{
   int n; 
   struct p *t;
   int pindex;
   int i, j;
   int   min_index;
   float sum = 0, length, len_tmp;
   float angle, min, pangle;

   printf("Enter the number of ts : ");
   scanf("%d", &n);

   t = (struct p *)malloc((n + 1) * sizeof(struct p));
  
   t[0].x = 0;
   t[0].y = 0;

 
   for (i = 1; i <= n; i++)
   {
      scanf("%f %f", &t[i].x, &t[i].y);
   }
   pindex = 0;
   pangle = 0;
   while (1){ 
      min = 10000;
      for (i = 0; i <= n; i++)
      {
         if (pindex != i)
         {
            angle = compute(t[pindex], t[i]);
            angle = angle - pangle;
            if (angle < 0)
               angle = angle + 360;
            if (t[i].an != 1 && min >= angle)
            {
               if (min == angle)
               {
                  length = sqrt((t[pindex].x - t[min_index].x) * (t[pindex].x - t[min_index].x)
                     + (t[pindex].y - t[min_index].y) * (t[pindex].y - t[min_index].y));
                  len_tmp = sqrt((t[pindex].x - t[i].x) * (t[pindex].x - t[i].x)
                     + (t[pindex].y - t[i].y)*(t[pindex].y - t[i].y));
               }
               min = angle;
               min_index = i;
            }
         }
      }
      length = sqrt((t[pindex].x - t[min_index].x)*(t[pindex].x - t[min_index].x)
         + (t[pindex].y - t[min_index].y)*(t[pindex].y - t[min_index].y));
      
      sum = sum + length;
      
      t[min_index].an = 1;
      pindex = min_index;
      pangle = min;
      if (min_index == 0)   
         break;
   }
   printf("Result = %0.2f\n", sum + 2);
}
float compute(struct p A, struct p B)
{
   float dx, dy;
   float angle;

   dx = B.x - A.x;
   dy = B.y - A.y;

   if ((dx >= 0) && (dy == 0))
      angle = 0;
   else
   {
      angle = (float)abs(dy) / (abs(dx) + abs(dy));
      if ((dx < 0) && (dy >= 0))
         angle = 2 - angle;
      else if ((dx <= 0) && (dy < 0))
         angle = 2 + angle;
      else if ((dx > 0) && (dy < 0))
         angle = 4 - angle;
   }
   angle = angle * (90.0);
   return angle;
}
