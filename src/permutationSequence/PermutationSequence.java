package permutationSequence;
import java.util.*;
public class PermutationSequence{    
	public String getPermutation(int n, int k){
		if(n <= 0) return "";
		if(n == 1) return "1";	        
		int[] factorial = new int[n];
		factorial[n-1] = 1;
		for(int i=n-2;i>=0;i--){
			factorial[i] = factorial[i+1]*(n-i-1);
		}
		boolean[] visited = new boolean[n];
		k = k-1;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			int rank = k/factorial[i];
			for(int j=0;j<n;j++){
				if(visited[j] == false){
					rank--;
					if(rank < 0){
						sb.append(j+1);
						visited[j] = true;
						break;
					}
				}
			}
			k = k%factorial[i];
		}
		return sb.toString();
	}
    public static void main(String[] args){
		PermutationSequence solu = new PermutationSequence();
		int n = 3;
		int k = 5;
        System.out.println(solu.getPermutation(n,k));
	}
}
