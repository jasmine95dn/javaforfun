package example1;

import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;

//public class Counter<T> extends HashMap<T, Integer> {
public class Counter<T> {
	
	/** 
	 * hat auch Open-Close verletzt (sind Einheiten nicht geschlossen für Veränderung??)
	 */
	private HashMap<T, Integer> counter = new HashMap<T, Integer>();
	private static final long serialVersionUID = 1L;
	
	//void updateFromCollection(Collection<T> items) {
	public void updateFromCollection(Collection<T> items) {
		for (T item : items) {
			this.countItem(item);
		}
	}
	
	//void countItem(T item) {
	public void countItem(T item) {
		//Integer prevCount = this.getOrDefault(item, 0);		
		//this.put(item, prevCount + 1);
		Integer prevCount = this.counter.getOrDefault(item, 0);		
		this.counter.put(item, prevCount + 1);
	}
	
	//T getMostCommon() {
	public T getMostCommon() {
		//if (this.size() == 0) {
		if (this.counter.size() == 0) {
			return null;
		}
		
		int bestCount = 0;
		T bestItem = null;
		//for (Entry<T, Integer> e : this.entrySet()) {
		for (Entry<T, Integer> e : this.counter.entrySet()) {
			if (e.getValue() > bestCount) {
				bestItem = e.getKey();
			}
		}
		
		return bestItem;
	}
}
