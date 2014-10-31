package decodeWays;
public class DecodeWays{
	public int numDecodings(String s){
		if(s == null || s.length() == 0)
        	return 0;
        if(s.charAt(0) <= '0' || s.charAt(0) > '9')//first digit is 0 or not a number, cannot decode
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];//number of decode ways to decode s.substring(0,i)
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){//compute numDecodes of s.substring(0,i)
        	if(s.charAt(i-1) < '0' || s.charAt(i-1) > '9')//not a number
            	return 0;
            else if(s.charAt(i-1) == '0'){//current digit is '0'
                if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2')//previous digit is 1 or 2
                	dp[i] = dp[i-2];//can decode
                else
                    return 0;//cannot decode, return 0
            }
            else{//current digit 1~9
                if(s.charAt(i-2) == '1')//previous digit is 1
                    dp[i] = dp[i-1] + dp[i-2];//two way decode
                else if(s.charAt(i-2) == '2' && s.charAt(i-1) <= '6' && s.charAt(i-1) >= '0')//previous is 2 and current is 0~6
                    dp[i] = dp[i-1] + dp[i-2];
                else//no two way decode
                    dp[i] = dp[i-1];
            }
		}
        return dp[n];
	}
    public static void main(String[] args){
        DecodeWays solution = new DecodeWays();
        String s = null;
        s = "0";
        System.out.println("s = " + s + ", NDecodes = "+ solution.numDecodings(s) + ", Expect = " + 0); 
        s = "9"; 
        System.out.println("s = " + s + ", NDecodes = "+ solution.numDecodings(s) + ", Expect = " + 1); 
        
        s = "901"; 
        System.out.println("s = " + s + ", NDecodes = "+ solution.numDecodings(s) + ", Expect = " + 0); 

        s = "10"; 
        System.out.println("s = " + s + ", NDecodes = "+ solution.numDecodings(s) + ", Expect = " + 1); 
      
        s = "20";
        System.out.println("s = " + s + ", NDecodes = "+ solution.numDecodings(s) + ", Expect = " + 1);


        s = "21";
        System.out.println("s = " + s + ", NDecodes = "+ solution.numDecodings(s) + ", Expect = " + 2);


	}
}
