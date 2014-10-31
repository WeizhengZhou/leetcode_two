package cloneGraph;


import java.util.*;

public class CloneGraph{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return null;
        
        Queue<UndirectedGraphNode> level = new LinkedList<>();
        level.add(node);

        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();//<key,value> = <node,node_copy>
        UndirectedGraphNode node_copy = new UndirectedGraphNode(node.label);//copy node
        map.put(node,node_copy);//put into map
        
        while(!level.isEmpty()){
    
            UndirectedGraphNode u = level.remove();//original node u
            UndirectedGraphNode u_copy = map.get(u);//u's copy
           
            for(UndirectedGraphNode v : u.neighbors){//for each edge (u,v) in original graph
            	if(!map.containsKey(v)){//node v is not visited
					level.add(v);//add v into to-be-visited list
					UndirectedGraphNode v_copy = new UndirectedGraphNode(v.label);//copy v
                    u_copy.neighbors.add(v_copy);//add edge (u,v) to copied graph
                    map.put(v,v_copy);//put into map 
				}	
                else{//back edge
                    UndirectedGraphNode v_copy = map.get(v);
                    u_copy.neighbors.add(v_copy);
				}
			}
            
		}
        return node_copy;
    }
	public static void main(String[] args){
		CloneGraph graph = new CloneGraph();
		UndirectedGraphNode node_1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node_2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node_3 = new UndirectedGraphNode(3);
		node_1.neighbors.add(node_2);
		node_1.neighbors.add(node_3);
		node_2.neighbors.add(node_1);
		node_3.neighbors.add(node_1);
	
		UndirectedGraphNode copy = graph.cloneGraph(node_1);
		System.out.println(copy);
		
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("node  " + this.label + ": ");
		for(UndirectedGraphNode node : neighbors)
			sb.append(" -> " + node.label );
		return  sb.toString();
	}
}

