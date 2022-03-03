package hashTable;

public class HashTable {
	
	private HashNode[] buckets;
	private  int numOfBuckets;
	private int size;
	
	public HashTable(int capacity) {
		this.numOfBuckets = capacity;
		buckets = new HashNode[capacity];
		this.size = 0;
	}
	
	public HashTable() {
		this(10);
	}
	
	private class HashNode{
		private Integer key;
		private String value;
		private HashNode next;
		
		public HashNode(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	private int getBucketIndex(Integer key) {
		return key % numOfBuckets;
	}
	
	public void put(Integer key, String value) {
		if(key == null || value == null) {
			throw new IllegalArgumentException("Key or Value is null");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = buckets[bucketIndex];
		HashNode node = new HashNode(key, value);
		node.next = head;
		buckets[bucketIndex] = node;
	}
	
	public String get(Integer key) {
		return null;
	}
	
	public String remove(Integer key) {
		return null;
	}
	
	public static void main(String[] args) {
		HashTable table = new HashTable();
		table.put(105, "Tom");
		table.put(21, "Sana");
		table.put(21, "Harry");
		System.out.println(table.size());
	}
	
}
