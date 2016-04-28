package com.icode.misc;
/*
 * @Author Sugandha
 * 
 * Perform operations: Insert, Delete, Search and getRandom in constant time
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedSet<T> {
	
	HashMap<T, Integer> map;
	ArrayList<T> list;
	Random rand;
	
	public RandomizedSet() {
		map = new HashMap<T, Integer>();
		list = new ArrayList<T>();
		rand = new Random(System.currentTimeMillis());
	}

	public static void main(String[] args) {
		
		RandomizedSet container = new RandomizedSet();
		container.add('1');
		String value = container.delete('1').toString();
		System.out.println("Deleted value: "+value);
	}
	
	public void add(T value) {
		if(!contains(value)) {
			int lastIndex = list.size();
			map.put(value, lastIndex);
			list.add(value);
		}
	}
	
	public boolean contains(T val) {
		if(val == null) {
			throw new NullPointerException();
		}
		else {
			return map.containsKey(val);
		}
	}
	
	public T delete(T val) {
		if(!contains(val)) {
			throw new NoSuchElementException();
		}
		int index = map.get(val);
		return deleteValue(index);
	}
	
	private T deleteValue(int currentIndex) {
		T currentValue = list.get(currentIndex);
		int lastIndex = list.size() - 1;
		T lastValue = list.get(lastIndex);
		Collections.swap(list, currentIndex, lastIndex);
		list.remove(lastIndex);
		map.put(lastValue, currentIndex);
		map.remove(currentValue);
		return currentValue;
	}

}
