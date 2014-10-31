package sqrtX;
public class SqrtX{
	public int sqrt(int x){
        if(x<0) return -1;
        if(x == 0) return 0;
    	return search(1,x,x); 
    }
    private int search(int l, int r, int x){
    	if(l>r) return -1;
        int m = l+(r-l)/2;
        if(m <= x/m &&  x/(m+1) < (m+1))// m^2<= x < (m+1)^2, be careful, m might = 0
            return m;
        else if(x/m < m)// x < m^2, search on left half
            return search(l,m-1,x);
        else//search on right half
            return search(m+1,r,x);
    }
    public static void main(String[] args){
    	SqrtX solution = new SqrtX();
        int x= -1;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + -1);
        x = 0;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + 0);
        x = 1;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + 1);
        x = 2;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + 1);
        x = 3;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + 1);
        x = 4;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + 2);
        x = 8;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + 2);
        x = Integer.MAX_VALUE;
        System.out.println("x = " + x + ", sqrt(x) = " + solution.sqrt(x) + ", expected = " + (int) Math.sqrt(x));
	}
}
