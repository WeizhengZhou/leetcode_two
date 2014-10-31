package gasStation;
public class GasStation{
	public int canCompleteCircuit(int[] gas, int[] cost){
    	if(gas == null || cost == null || gas.length != cost.length) return -1;
        int n = gas.length;
        int start =0;
        while(start<n){
			int remainGas = gas[start] - cost[start];
            int end = start+1;
            while(end<start+n){
            	 if(remainGas < 0) break;
                 remainGas = remainGas + gas[end%n] - cost[end%n];
                 end++;
            }
            if(remainGas >= 0) return start;
            start = end;
        }
        return -1;
	}
}
