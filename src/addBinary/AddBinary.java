package addBinary;
public class AddBinary{
	public String addBinary(String a, String b){
		if(a == null) return b;
		if(b == null) return a;
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		while(i >=0 || j >=0){
			if(i>=0){
				carry += Integer.parseInt(a.substring(i,i+1));
				i--;
			}
			if(j>=0){
				carry += Integer.parseInt(b.substring(j,j+1));
				j--;
			}
			sb.append(carry%2);
			carry /= 2;
		}
		if(carry == 1) 
			sb.append("1");
		return sb.reverse().toString();
	}
	public static void main(String[] args){
		AddBinary solu = new AddBinary();
		String a = "101";
		String b = "1";
		System.out.println(solu.addBinary(a,b) + ", exp = 110");
		a = "1";
		b = "1";
		System.out.println(solu.addBinary(a,b) + ", exp = 1110");
		a = "0";
	    b = "0";
		System.out.println(solu.addBinary(a,b) + ", exp = 0");
	    a = null;
		b = "11";
		System.out.println(solu.addBinary(a,b) + ", exp = 11");
	}
}
