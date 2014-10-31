package palindromeNumber;
public class PalindromeNumber{
	public boolean isPalindrome_2(int x){
		if(x == Integer.MIN_VALUE)	return false;
		x = Math.abs(x);
		String s = x + "";	
		String r = new StringBuilder(s).reverse().toString();
		if(s.equals(r)) return true;
		else return false;
	}
	public boolean isPalindrome_1(int x){
		if(x < 0) return false;
		int d = 1;
		while(x/d > 9) d *=10;

		while(x != 0){
			System.out.println(x + ", " + d);
			if(x/d != x%10) return false;
		    x = x%d;//remove most significant digit
			x = x/10;//remove least sigificant digit
			d = d/100;//two digits removed, so d = d / 100
		}	
		return true;
	}	
	public boolean isPalindrome(int x){
	       if(x < 0) return false;
	       int d = 1;
	       int y = x;
	       while(y!=0){
	           d *= 10;
	           y /= 10;
	       }
	       d = d/10;
	     
	       while(x!=0){
	           int msd = x/d;
	           int lsd = x%10;
	           if(msd != lsd) return false;
	           x = x%d;
	           x = x/10;
	           d = d/100;
	       }
	       return true;
	    }
	public static void main(String[] args){
		PalindromeNumber solu = new PalindromeNumber();
		int x = 1234321;
		System.out.println("x = " + x + ", isPal = " + solu.isPalindrome(x) + ", exp = " + true);
		x = 1010101;
		System.out.println("x = " + x + ", isPal = " + solu.isPalindrome(x) + ", exp = " + true);
		x = 0;
		System.out.println("x = " + x + ", isPal = " + solu.isPalindrome(x) + ", exp = " + true);
        x = 10;
		System.out.println("x = " + x + ", isPal = " + solu.isPalindrome(x) + ", exp = " + false);
		x = Integer.MAX_VALUE;
		System.out.println("x = " + x + ", isPal = " + solu.isPalindrome(x) + ", exp = " + true);
	    x = 1000000001;	
		System.out.println("x = " + x + ", isPal = " + solu.isPalindrome(x) + ", exp = " + true);
	}
}
