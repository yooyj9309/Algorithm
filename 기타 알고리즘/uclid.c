#include<stdio.h>
struct eu{
	int gcd;
	int c;
	int d;
};
int euclid(int, int);
struct eu extend(int,int);

void main()
{
	int a,b;
	struct eu gc;
	scanf("%d %d",&a,&b);
	gc=extend(a,b);
	if(a==0||b==0)								//if a or b is 0, gcd=0,x=0,y=0;
		printf("0 0 0");
	else
		printf("%d %d %d",gc.c,gc.d,gc.gcd);
}
//Using extend euclid, get minimal x,y about gcd.(ax+bu=gcd)
struct eu extend(int a,int b)
{
	struct eu k;
	struct eu g;
	if(b==0){
		k.gcd=a;
		k.c=1;
		k.d=0;
		return k;
	}

	g=extend(b,a%b);
	k.gcd=g.gcd;
	k.c=g.d;
	k.d=g.c-(a/b)*g.d;
	
	return k;
}
