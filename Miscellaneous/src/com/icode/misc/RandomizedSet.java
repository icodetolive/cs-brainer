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
		
		RandomizedSet<Integer> container = new RandomizedSet<Integer>();
		container.add(1);
		container.add(3);
		container.add(6);
		container.add(8);
		String value = container.delete(6).toString();
		System.out.println("Deleted value: "+value);
		System.out.println("Random value: "+container.getRandom());
	}
	
	public void add(T value) {
		if(!contains(value)) {
			int lastIndex = list.size() - 1;
			map.put(value, lastIndex);
			list.add(value);
		}
	}
	
	public boolean contains(T value) {
		if(value == null) {
			throw new NullPointerException();
		}
		return map.containsKey(value);
	}
	
	public T delete(T value) {
		if(!contains(value)) {
			throw new NoSuchElementException();
		}
		int index = map.get(value);
		return deleteValue(index);
	}
	
	public T deleteValue(int currentIndex) {
		T currentValue = list.get(currentIndex);
		int lastIndex = list.size() - 1;
		T lastValue = list.get(lastIndex);
		Collections.swap(list, currentIndex, lastIndex);
		list.remove(lastIndex);
		map.remove(currentValue);
		map.put(lastValue, currentIndex);
		return currentValue;
	}
	
	public T getRandom() {
		if(map.isEmpty()) {
			throw new NoSuchElementException();
		}
		int randomIndex = rand.nextInt(list.size());
		return list.get(randomIndex);
	}
	
	public T deleteRandom() {
		if(map.isEmpty()) {
			throw new NoSuchElementException();
		}
		int randomIndex = rand.nextInt(list.size());
		return deleteValue(randomIndex);
	}
}
