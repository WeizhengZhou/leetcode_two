package interleavingString;
import java.util.*;
public class InterleavingString{
	public boolean isInterleave(String s1, String s2, String s3){
		if(s1 == null && s2 == null) return s3==null;
		if(s2 == null) return s1.equals(s3);
		if(s1 == null) return s2.equals(s3);
		if(s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length();
		int n = s2.length();

		boolean[][] table = new boolean[m+1][n+1];
        table[0][0] = true;
        for(int i=1;i<=m;i++){
			table[i][0] = table[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
		}
        for(int j=1;j<=n;j++){
			table[0][j] = table[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
		}
	    for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(s1.charAt(i-1) == s3.charAt(i+j-1))
					table[i][j] = table[i][j] || table[i-1][j];
                if(s2.charAt(j-1) == s3.charAt(i+j-1))
					table[i][j] = table[i][j] || table[i][j-1];
			}
		}
//		System.out.println(Arrays.deepToString(table));	
        return table[m][n];
	}
	public static void main(String[] ags){
		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";
		InterleavingString solu = new InterleavingString();
		solu.isInterleave(s1,s2,s3);
		
	}
}
