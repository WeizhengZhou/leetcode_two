package regularStringMatching;

public class RegularStringMatching {
	private char[] S = null;
	private char[] P = null;
	private int[][] dp = null;
	public boolean isMatch(String s, String p) {
		if(s == null && p == null) return true;
		if(s == null) return p == null;
		if(p == null) return s == null;
		this.S = s.toCharArray();
		this.P = p.toCharArray();
		this.dp = new int[S.length][P.length];
		helper(S,0,P,0);
		
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[S.length-1][P.length-1] == 1 ? true:false;

	}
	private int helper(char[] S, int i, char[] P, int j){
		System.out.println("i = " + i + ", j = " + j);
		if(dp[i][j] != 0) return dp[i][j];
		
		if(j >= P.length) return (i >= S.length)?1:-1;
		if(i >= S.length) return (j >= P.length)?1:-1;
		boolean isMatched = false;
		if(j == P.length-1 || P[j+1] != '*'){
			if(i == S.length-1){
				if(S[i] == P[j] || P[j] == '.'){
					isMatched = true;
				}
				else
					isMatched = false;
				
			}
			else if((S[i] == P[j] || P[j] == '.') && helper(S,i+1,P,j+1) == 1)
				isMatched = true;
			else
				isMatched = false;
			
		}
		else{
			while(i<S.length){
				if(S[i] == P[j] || P[j] == '.'){
					if(helper(S,i,P,j+2) == 1){			
						dp[i][j] = 1;
					    return 1;
					}
				}
				i++;
			}
			dp[i][j] = -1;
			return -1;
		}
	}
	public static void main(String[] args){
		RegularStringMatching solu = new RegularStringMatching();
		solu.isMatch("aa", "aa");
		
		
	}
}
