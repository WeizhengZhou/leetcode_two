package zigZagConversion;
public class ZigZagConversion{
	public String convert(String s, int nRows){
		if(s == null || s.length() < 2) return s;
		StringBuilder[] sbs = new StringBuilder();


		return convert_1(s,0,nRows);	

	}
	private String convert_1(String s, int start, int nRows, StringBuilder[] sbs){
		if(start >= s.length()){
			return constructResult(sbs);
		}
		for(int i=0;i<nRows;i++){
			sbs[i].append(s.substring(start+i,start+i+1));
		}
		return convert_2(s,start+nRows,sbs);
	}
	private String convert_2(String s, int start, int nRows, StringBuilder[] sbs){
		if(start >= s.length()){
			return constructResult(sbs);
		}
		for(int i=nRows-2;i>=1;i--){
			sbs[i].append(s.substring(start+i,start+i+1));
		}
		return convert_1(s,start+nRows-2,sbs);
	}
	private String constructResult(StringBuilder sbs){
		StringBuilder res = new StringBuilder();
		for(int i=0;i<sbs.length;i++){
			res.append(sbs[i].toString());
		}
		return res.toString();
	}
}
