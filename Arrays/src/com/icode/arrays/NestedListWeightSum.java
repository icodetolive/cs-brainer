package com.icode.arrays;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum implements NestedList{

	public static void main(String[] args) {
		
		//{1,{2,{3}}} => 1*1 + 2*2 + 3*3 => 14
		LinkedList<Object> nestedList = new LinkedList<Object>();
		nestedList.add(1);
		LinkedList<Object> list1 = new LinkedList<Object>();
		list1.add(2);
		LinkedList<Object> list2 = new LinkedList<Object>();
		list2.add(3);
		list1.add(list2);
		nestedList.add(list1);
		
		
		System.out.println("Given list: "+nestedList);
		
		
		NestedListWeightSum list = new NestedListWeightSum();
		//int result = list.getSumI(nestedList);
		int result = list.getSumRec(nestedList);
		System.out.println(result);
	}
	
	public int getSumRec(LinkedList<Object> list) {
		if(list == null || list.size() == 0) {
			return -1;
		}
		
		int level = 1;
		int sum = 0;
		return getSumRec(list, sum, level);
	}
	
	public int getSumRec(LinkedList<Object> list, int sum, int depth) {
		
		Iterator<Object> it = list.iterator();
		while(it.hasNext()) {
			Object item = it.next();
			if(item.getClass() == Integer.class) {
				sum += (Integer) item * depth;
			}
			else {
				LinkedList<Object> subList = (LinkedList<Object>) item;
				return getSumRec(subList, sum, depth+1);
			}
		}
		return sum;
	}
	
	public int getSumI(List<Object> list) {
		
		if(list == null || list.size() == 0) {
			return -1;
		}
		
		int sum = 0;
		int level = 1;
		Queue<Object> q = new LinkedList<Object>(list);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i< size; i++) {
				Object item = q.poll();
				if(item.getClass() == Integer.class) {
					sum += (Integer)item * level;
				}
				else {
					LinkedList<Object> subList = (LinkedList<Object>) item;
					q.addAll(subList);
				}
			}
			level++;
		}
		return sum;
	}

	@Override
	public boolean isInteger() {
		return false;
	}

	@Override
	public int getInteger() {
		return 0;
	}

	@Override
	public List getList() {
		return null;
	}

}

interface NestedList {

	public boolean isInteger();
	public int getInteger();
	public List getList();
}
