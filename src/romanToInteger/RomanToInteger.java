package romanToInteger;
public class RomanToInteger{
	public int romanToInt(String s){
    	if(s == null) return -1;
        int value = 0;
        int pre = 0;
        int cur = 0;
        for(int i=s.length()-1;i>=0;i--){
			cur = atoi(s.substring(i,i+1));
            if(pre > cur)//IV, IX
                value -= cur;
            else
  				value += cur;//II, VII
            pre = cur;
		}
        assert value>=1 && value <= 3999; 
        return value;
        

    }
    private int atoi(String s){
		switch(s) {
			case "I" : return 1;
            case "V" : return 5;
            case "X" : return 10;
            case "L" : return 50;
            case "C" : return 100;
            case "D" : return 500;
            case "M" : return 1000;
	        default : return -1;	
		}
	}
}
