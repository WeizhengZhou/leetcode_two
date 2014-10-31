package restoreIP;

import java.util.*;
public class RestoreIP{
	List<String> res = new ArrayList<>();
	public List<String> restoreIpAddresses(String s){
        if(s == null || s.length() < 4) return res; 
        String[] t = new String[4];
        helper(s,0,t,0);
        return res;
	}
    private void helper(String s, int index, String[] t, int section){
        if(section >= 4 && index < s.length()) return;
        if(index >= s.length() && section < 4 ) return;
		if(index == s.length() && section == 4){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<t.length;i++){
				sb.append(t[i]);
                if(i != t.length-1) 
					sb.append(".");
 			}
            res.add(sb.toString());
			return;
		}
        
        for(int i=index;i<Math.min(index+3,s.length());i++){
			int value = Integer.parseInt(s.substring(index,i+1));
            if(value > 255) return;
            t[section] = s.substring(index,i+1);
            helper(s,i+1,t,section+1);
            if(value == 0){
                break;
			}
		}	
	}
    public static void main(String[] args){
		RestoreIP solu = new RestoreIP();
		String s = "25525511135";
        List<String> res = solu.restoreIpAddresses(s);
        for(String t : res){
			System.out.println(t);
		}	
	}
}
