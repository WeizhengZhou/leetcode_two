import plusOne;
public class PlusOne{
	public int[] plusOne(int[] digits){
		if(digits == null) return new int[]{1};
		int n = digits.length;
		int[] res = new int[n+1];
		int carry = 1;
		for(int i=n-1;i>=0;i--){
			carry += digits[i];
			res[i+1] = carry%10;
			carry /= 10;
		}
		if(carry == 0) return Arrays.copyOfRange(res,1,res.length);
		else{
			res[0] = 1;
			return res;
		}
	}
	public static void main(String[] args){

	}

}
