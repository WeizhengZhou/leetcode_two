package insertInterval;


import java.util.*;
public class InsertInterval{
	public List<Interval> insert(List<Interval> list, Interval x){
		List<Interval> res = new ArrayList<>();
        if(list == null){
            res.add(x);
            return res;
        }
        int i=0;
        for( ;i<list.size();i++){
			Interval a = list.get(i);
            if(a.end < x.start) res.add(a);//interval before x.start
            else if(a.start <= x.end){//interval overlapped with x
				x.start = Math.min(a.start,x.start);//update start
                x.end = Math.max(a.end,x.end);//update end
			}
            else{//interval after x.end
                break;	
			}
		}
        res.add(x);//add x
        res.addAll(list.subList(i,list.size()));//add rest of list
        return res;
	}
}
class Interval{
	int start = 0;
    int end = 0;
    Interval(int start, int end){
		this.start = start;
        this.end = end;
	}
}
