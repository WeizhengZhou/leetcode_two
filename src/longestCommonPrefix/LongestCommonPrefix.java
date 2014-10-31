package longestCommonPrefix;

public class LongestCommonPrefix{
	public String longestCommonPrefix(String[] strs){
		if(strs == null) return "";
        return helper(strs, 0, strs.length-1);
    } 
    private String helper(String[] strs, int l, int r){
        if(l>r) return "";
        else if(l==r) return strs[l];
        else if(l+1==r){
            int index = 0;
            while(index < strs[l].length() &&
                  index < strs[r].length() &&
                  strs[l].charAt(index) == strs[r].charAt(index))
            	index++;
            return strs[l].substring(0,index);
        }
        else{
            int m = l+(r-l)/2;
            String a = helper(strs,l,m);//LCP of left half
            String b = helper(strs,m+1,r);//LCP of right half 
            return helper(new String[]{a,b},0,1);//LCP of total 
        }
    }
    public static void main(String[] args){
    	String[] strs = new String[]{"baab","bacb","b","cbc"};
    	LongestCommonPrefix solution = new LongestCommonPrefix();
    	System.out.println(solution.longestCommonPrefix(strs));
    }
}
