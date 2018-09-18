package my.practice;

import java.util.ArrayList;

public class CustomHashMap<K, V> {

	ArrayList<Entry<K, V>> list;
	int maxCapacity;
	
	public CustomHashMap(int capacity) {
		this.maxCapacity = capacity;
		this.list = new ArrayList<>(maxCapacity);
	}
	
	public void put(K key, V value) {
		Entry<K, V> entry = bucketEntryExists(key, value);
		this.list.add(new Entry<K, V>(key, value, entry));
	}
	
	private Entry<K, V> bucketEntryExists(K key, V value) {
		Entry<K, V> entry = null;
		int hashCode = getHash(key);
		try {
			entry = list.get(hashCode);
		} catch(Exception ex) {
			entry = null;
		}
		return entry;
	}
	
	private int getHash(K key) {
		int hashCode = (int)key % maxCapacity;
		return hashCode;
	}
	
	public V get(K key) {
		int hashCode = getHash(key);
		Entry<K, V> entry = list.get(hashCode);
		V value = entry.get();
		return value;
	}
	
	class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public V get() {
			return value;
		}
	}
	
	public static void main(String[] args) {
		int capacity = 4;
		CustomHashMap<Integer, Integer> customHashMap = new CustomHashMap<Integer, Integer>(capacity);
		customHashMap.put(new Integer(0), new Integer(5));
		customHashMap.put(new Integer(1), new Integer(2));
		customHashMap.put(new Integer(4), new Integer(2));
		
		Integer value = customHashMap.get(new Integer(4));
		System.out.println(value);
	}
}
