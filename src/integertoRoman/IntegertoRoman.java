package integertoRoman;
public class IntegertoRoman{
    private String[] one = new String[]{"I","X","C","M"};
    private String[] five = new String[]{"V","L","D",""};
	public String intToRoman(int num){
		assert (num <=3999 && num>=1);
        int r = 1;
        int d = 0;
        while(num/r > 0){
   			d++;
            r *= 10;
        }
        System.out.println("d = " + d +", r = " +r);
        StringBuilder sb = new StringBuilder();
        while(d >= 0){
            sb.append(intToString(num/r,d));
            d--;
            num = num%r;
            r /=10;          
        }
        return sb.toString(); 
    }
    private String intToString(int x, int d){
        switch(x){
            case 0: return "";
        	case 1: return one[d];
            case 2: return one[d]+one[d];
            case 3: return one[d]+one[d]+one[d];
            case 4: return one[d]+five[d];
            case 5: return five[d];
            case 6: return five[d]+one[d];
            case 7: return five[d]+one[d]+one[d];
            case 8: return five[d]+one[d]+one[d]+one[d];
            case 9: return one[d]+one[d+1]; 
            default: return "";
        }
    } 
    public static void main(String[] args){
    	int num = 99;
    	IntegertoRoman s = new IntegertoRoman();
    	System.out.println(s.intToRoman(num));
    }
}
