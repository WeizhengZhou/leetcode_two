package LRUCache;

import java.util.*;

public class LRUCache {
	private int size = 0;
	private final int capacity;
	private Map<Integer,Node> map = null;
	private Node head = null;
	private Node tail = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = null;             
    }   
    public int get(int key) {
    	if(!map.containsKey(key))
    		return -1;
    	else{
    		Node node = map.get(key);
    		moveToHead(node);
    		return node.value;
    	}      
    }    
    public void set(int key, int value) {
    	if(size >= capacity)
    		evictLRUNode();
    	Node node = null;
    	if(map.containsKey(key)){
    		node = map.get(key);
    	}
    	else{
    		node = new Node(key,value);
    		size++;
    	}
    	if(size == 0){
    		head = node;
    		tail = node;
    	}
    	else{
    		Node temp = head;
    		node.next = temp;
    		temp.pre = node;
    		head = node;
    	}
        
    }
    private void moveToHead(Node node){
    	if(node == head) return;
    	Node pre = node.pre;
    	Node next = node.next;
    	node.next = head;
    	head.pre = node;
    	head = node;
    	pre.next = next;
    	next.pre = pre;  	
    }
    private void evictLRUNode(){
    	Node last = tail;
    	Node pre = last.pre;
    	pre.next = null;
    	last.pre = null;
    	tail = pre;
    }
    class Node{
    	int key = 0;
    	int value = 0;
    	Node pre = null;
    	Node next = null;
    	public Node(int key, int value){
    		this.key = key;
    		this.value = value;
    	}
    }   
}

