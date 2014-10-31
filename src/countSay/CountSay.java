package countSay;
public class CountSay{
	public String countAndSay(int n){
		if(n <= 0) return "";
        String s = "1";
        for(int i=2;i<=n;i++){
			StringBuilder sb = new StringBuilder();
            int j=0;
            while(j<s.length()){
				int value = Integer.parseInt(s.substring(j,j+1)); 
                int count = 1;
                int k = j+1;
                while(k<s.length() && s.charAt(k) == s.charAt(k-1)){
					k++;
                    count++;
				}
                sb.append(count);
                sb.append(value); 
                j = k;
			}         
            s = sb.toString();
		}
        return s;
	}
    public static void main(String[] args){
		int n =4;
        CountSay s = new CountSay();
        System.out.println(s.countAndSay(n));
	}
}
