package wordBreak;


import java.util.*;
public class WordBreakII {
	private boolean[] isPoss = null;
    private List<String> res = new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> dict) {
        if(s == null || dict == null) return res;  
        isPossible(s,dict);
        if(isPoss[s.length()] == false)
        	return res;
        buildRes(s, s.length(), dict, "");
        return res;
    }
    private void buildRes(String s, int end, Set<String >dict, String t){
    	System.out.println("end = " + end + ", t = " + t);
        if(end < 0){
            res.add(t.substring(0,t.length()-1));
            System.out.println(t);
            return;
        }
        for(int start=end-1;start>=0;start--){
            if(dict.contains(s.substring(start,end)) && isPoss[start] == true){
                 buildRes(s, start, dict, t + s.substring(start,end) + " ");
            }
        }
    } 
    private void isPossible(String s, Set<String> dict) {	
		int n = s.length();	
		isPoss = new boolean[n+1];
		isPoss[0] = true;				
		for(int i=1;i<=n;i++){//break s.substring(0,i)
			for(int j=0;j<i;j++){
				if(dict.contains(s.substring(j,i)) && isPoss[j] == true)
					isPoss[i] = true;							
			}				
		}
		System.out.println(Arrays.toString(isPoss));
	}
    public static void main(String[] args){
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();	
		
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		WordBreakII solution = new WordBreakII();
		System.out.println(solution.wordBreak(s, dict));
	}

}
