package reverseInteger;

public class ReverseInteger{
	public int reverse(int x){
		if(x == Integer.MIN_VALUE) return 0;//throw overflow exception
		boolean isPositive = (x >0) ? true:false;
		x = Math.abs(x);
		int res = 0;
		while(x != 0){
			if(Integer.MAX_VALUE - res *10 < x%10){
				return -1;
			}
			res = res*10 + x%10;
			x /= 10;
		}
		if(isPositive) return res;
		else return -res;	
	}
	public static void main(String[] args){
		ReverseInteger solu = new ReverseInteger();
		System.out.println(Integer.MAX_VALUE);
		int x = -123;
		System.out.println(solu.reverse(x));
		x = 12345678;
		System.out.println(solu.reverse(x));
        x  = -123456789;
		System.out.println(solu.reverse(x));

	
	}
}
