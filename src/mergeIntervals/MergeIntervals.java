package mergeIntervals;
import java.util.*;
public class MergeIntervals{
	public List<Interval> merge(List<Interval> list){
    	if(list == null || list.size() < 2) return list;
        //sort
        Collections.sort(list, new Comparator<Interval>(){
			@Override
            public int compare(Interval a, Interval b){
            	return (a.start - b.start); 
            }
        });
        List<Interval> res = new LinkedList<>();
        int i = 0;
        while(i<list.size()){
		    int start = list.get(i).start;
            int end = list.get(i).end;
            int j = i+1;
			while(j<list.size()){
				if(list.get(j).start > end) break;
                end = Math.max(end,list.get(j).end);
                j++;
			}
            res.add(new Interval(start,end));
            i = j;
        }
        return res;
    }
}
class Interval{
	int start = 0;
    int end = 0;
    public Interval(int start, int end){
		this.start = start;
        this.end = end;
	}
}
