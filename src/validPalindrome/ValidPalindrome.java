package validPalindrome;
public class ValidPalindrome{
	public boolean isPalindrome(String s){
		if(s == null || s.length() < 2) return true;
        s = s.toLowerCase();
		int l = 0;
        int r = s.length()-1;
        while(l<r){
			if(!isAlphaNumeric(s.charAt(l)))
				 l++;
            else if(!isAlphaNumeric(s.charAt(r))) 
				 r--;
            else if(s.charAt(l) != s.charAt(r))
				 return false;
            else {
                  l++;
                  r--;
            }
		}
        return true;
	}
    private boolean isAlphaNumeric(char c){
        if(c >= 'A' && c <= 'Z') return true;
		if(c >= 'a' && c <= 'z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
	}
    public static void main(String[] args){
		String s = "1a2";
        ValidPalindrome solu = new ValidPalindrome();
        System.out.println(solu.isPalindrome(s));
	}
}
