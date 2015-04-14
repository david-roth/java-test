package com.davidroth.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


/**
 * The Class SimpleInvertedIndex.
 */
public class SimpleInvertedIndex extends InvertedIndex {

	/**
	 * Instantiates a new simple inverted index.
	 */
	public SimpleInvertedIndex() {
		super();
	}

	/**
	 * Implementation of the intersection for a simple inverted index
	 */
	protected Collection<String> intersection(String[] split) {
		HashSet<Integer> result = new HashSet<Integer>();
		HashSet<Integer> aux = (HashSet<Integer>) super.getIndex().get(split[0].toUpperCase());
		boolean emptyResult = false;
		if(aux!=null){
			result.addAll(aux);
			int i = 1;
			while (aux!=null && i < split.length) {
				aux = (HashSet<Integer>) super.getIndex().get(split[i].toUpperCase());
				if (aux!=null){
					result.retainAll(aux);
				} else{
					emptyResult = true;
				}
				i++;
			}
		}
		if (!emptyResult){
			Collection<String> resultArray = new ArrayList<String>();
			for (Integer i : result) {
				resultArray.add(super.getData()[i]);
			}
			return resultArray;
		}
		else return new ArrayList<String>();
		
	}

	/**
	 * Implementation of the add item method for a simple inverted index
	 */
	protected void addItemToIndex(String word, int line, int position) {
		HashSet<Integer> set = (HashSet<Integer>) super.getIndex().get(word);
		if (set==null) {
			set = new HashSet<Integer>();
		}
		set.add(line);
		super.getIndex().put(word, set);
	}
}
